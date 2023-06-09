package com.me.erp.dao.participante.interno.funcionario.clt.desenvolvedor;

import static com.me.erp.builders.DesenvolvedorBuilder.umDesenvolvedor;
import static org.junit.jupiter.api.Assertions.*;

import com.me.erp.builders.DesenvolvedorBuilder;
import com.me.erp.dao.participante.TarefasConcluidasDaoJdbcImpl;
import com.me.erp.dao.participante.daotesthelper.criaregistrohelper.DesenvolvedorDaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.daotesthelper.deletaregistroshelper.DeletaRegistrosDaoTestHelperJdbcImpl;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.clt.desenvolvedor.Desenvolvedor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

@SpringBootTest
public class DesenvolvedorDaoJdbcImplTest {

  @Autowired DesenvolvedorDaoJdbcImpl desenvolvedorDaoJdbc;

  @Autowired DesenvolvedorDaoTestHelperJdbcImpl desenvolvedorDaoTestHelperJdbc;

  @Autowired TarefasConcluidasDaoJdbcImpl tarefasConcluidasDaoJdbc;

  @Autowired DeletaRegistrosDaoTestHelperJdbcImpl daoTestHelperJdbc;

  DesenvolvedorBuilder builder;

  @BeforeEach
  void setup() {
    String cpf = "53576485768";
    builder =
        umDesenvolvedor()
            .comId(cpf)
            .comOcupacao("Ocupação")
            .comVencimento(0)
            .comTarefasConcluidas(new ArrayList<>())
            .comCredenciais(new Credenciais(cpf, "123"))
            .comCargaHorariaSemanal(1950)
            .comPausa(0);

    daoTestHelperJdbc.cleanUp();
  }

  @Test
  void
      dadoDesenvolvedorDaoJdbcImplQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveLancarEmptyResultDataAccessException() {
    // preparacao
    String queNaoExisteNoBancoDeDados = "inexistente";

    // acao
    EmptyResultDataAccessException exception =
        assertThrows(
            EmptyResultDataAccessException.class,
            () -> desenvolvedorDaoJdbc.resgataPorId(queNaoExisteNoBancoDeDados));

    // verificacao
    String mensagemEsperada = "Incorrect result size: expected 1, actual 0";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoDesenvolvedorDaoJdbcImplQuandoTestadoMetodoResgataPorIdComUmRegistroNoBancoDeDadosEntaoDeveExistirUmEstagiarioDeTi() {
    // preparacao
    Desenvolvedor desenvolvedor = builder.comTarefasConcluidas(Arrays.asList("T1", "T2")).agora();

    String queExisteNoBancoDeDados = desenvolvedor.getId();

    // acao
    desenvolvedorDaoTestHelperJdbc.cria(desenvolvedor);
    Optional<Desenvolvedor> possivelDesenvolvedor =
        desenvolvedorDaoJdbc.resgataPorId(queExisteNoBancoDeDados);

    // verificacao
    Desenvolvedor desenvolvedorDaBaseDeDados = possivelDesenvolvedor.get();
    int quantidadeDeTarefasConcluidasEsperada = 2;
    int quantidadeDeTarefasConcluidaRecebida =
        desenvolvedorDaBaseDeDados.getTarefasConcluidas().size();
    assertEquals(quantidadeDeTarefasConcluidasEsperada, quantidadeDeTarefasConcluidaRecebida);
  }

  @Test
  void
  dadoDesenvolvedorDaoJdbcImplQuandoTestadoMetodoRegistraNovaTarefaEntaoDeveExistirUmaTarefa() {
    // preparacao
    Desenvolvedor registroDeDesenvolvedor = builder.agora();
    desenvolvedorDaoTestHelperJdbc.cria(registroDeDesenvolvedor);

    String idDoDesenvolvedor = registroDeDesenvolvedor.getId();
    String tarefa = "T1";

    // acao
    desenvolvedorDaoJdbc.registraNovaTarefa(idDoDesenvolvedor, tarefa);
    Optional<List<String>> possivelListaDeTarefasConcluidas =
            tarefasConcluidasDaoJdbc.resgataPorId(idDoDesenvolvedor);

    // verificacao
    boolean isPossivelListaDeTarefasConcluidasVazia = possivelListaDeTarefasConcluidas.isEmpty();
    assertFalse(isPossivelListaDeTarefasConcluidasVazia);
  }
}
