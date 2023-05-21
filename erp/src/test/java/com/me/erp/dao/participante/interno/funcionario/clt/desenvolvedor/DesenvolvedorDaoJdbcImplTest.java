package com.me.erp.dao.participante.interno.funcionario.clt.desenvolvedor;

import static com.me.erp.builders.DesenvolvedorBuilder.umDesenvolvedor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.me.erp.builders.DesenvolvedorBuilder;
import com.me.erp.dao.participante.daotesthelper.DaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.interno.funcionario.clt.desenvolvedor.desenvolvedorhelper.DesenvolvedorDaoTestHelperJdbcImpl;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.clt.desenvolvedor.Desenvolvedor;
import java.util.ArrayList;
import java.util.Arrays;
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

  @Autowired DaoTestHelperJdbcImpl daoTestHelperJdbc;

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
      dadoDesenvolvedorDaoTestHelperJdbcImplQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveLancarEmptyResultDataAccessException() {
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
      dadoDesenvolvedorDaoTestHelperJdbcImplQuandoTestadoMetodoResgataPorIdComUmRegistroNoBancoDeDadosEntaoDeveExistirUmEstagiarioDeTi() {
    // preparacao
    Desenvolvedor desenvolvedor = builder.comTarefasConcluidas(Arrays.asList("T1", "T2")).agora();

    String queExisteNoBancoDeDados = desenvolvedor.getId();

    // acao
    desenvolvedorDaoTestHelperJdbc.criaRegistroDeDesenvolvedor(desenvolvedor);
    Optional<Desenvolvedor> possivelDesenvolvedor =
        desenvolvedorDaoJdbc.resgataPorId(queExisteNoBancoDeDados);

    // verificacao
    Desenvolvedor desenvolvedorDaBaseDeDados = possivelDesenvolvedor.get();
    int quantidadeDeTarefasConcluidasEsperada = 2;
    int quantidadeDeTarefasConcluidaRecebida =
        desenvolvedorDaBaseDeDados.getTarefasConcluidas().size();
    assertEquals(quantidadeDeTarefasConcluidasEsperada, quantidadeDeTarefasConcluidaRecebida);
  }
}
