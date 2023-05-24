package com.me.erp.dao.participante;

import static com.me.erp.builders.EstagiarioDeTiBuilder.umEstagiarioDeTi;
import static org.junit.jupiter.api.Assertions.*;

import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.dao.participante.daotesthelper.criaregistrohelper.EstagiarioDeTiDaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.daotesthelper.criaregistrohelper.TarefasConcluidasDaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.daotesthelper.criaregistrohelper.TarefasConcluidasDto;
import com.me.erp.dao.participante.daotesthelper.deletaregistroshelper.DeletaRegistrosDaoTestHelperJdbcImpl;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TarefasConcluidasDaoJdbcImplTest {

  @Autowired TarefasConcluidasDaoJdbcImpl tarefasConcluidasDaoJdbc;

  @Autowired TarefasConcluidasDaoTestHelperJdbcImpl tarefasConcluidasDaoTestHelperJdbc;

  @Autowired EstagiarioDeTiDaoTestHelperJdbcImpl estagiarioDeTiDaoTestHelperJdbc;

  @Autowired DeletaRegistrosDaoTestHelperJdbcImpl daoTestHelperJdbc;

  EstagiarioDeTiBuilder builder;

  @BeforeEach
  void setup() {
    String cpf = "53576485768";
    builder =
        umEstagiarioDeTi()
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
      dadoTarefasConcluidasDaoJdbcImplQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveExistirZeroTarefas() {
    // preparacao
    String queNaoExisteNoBancoDeDados = "inexistente";

    // acao
    Optional<List<String>> possivelListaDeTarefas =
        tarefasConcluidasDaoJdbc.resgataPorId(queNaoExisteNoBancoDeDados);

    // verificacao
    boolean isPossivelListaDeTarefasVazia = possivelListaDeTarefas.get().isEmpty();
    assertTrue(isPossivelListaDeTarefasVazia);
  }

  @Test
  void
      dadoTarefasConcluidasDaoJdbcImplQuandoTestadoMetodoResgataPorIdComDoisRegistrosNoBancoDeDadosEntaoDeveExistirDuasTarefas() {
    // preparacao
    EstagiarioDeTi estagiarioDeTi = builder.agora();
    estagiarioDeTiDaoTestHelperJdbc.cria(estagiarioDeTi);

    TarefasConcluidasDto tarefasConcluidasDto =
        new TarefasConcluidasDto(estagiarioDeTi.getId(), List.of("T1"));
    tarefasConcluidasDaoTestHelperJdbc.cria(tarefasConcluidasDto);

    // acao
    Optional<List<String>> possivelListaDeTarefas =
        tarefasConcluidasDaoJdbc.resgataPorId(estagiarioDeTi.getId());

    // verificacao
    int quantidadeDeTarefasConcluidasEsperada = 1;
    int quantidadeDeTarefasConcluidasRecebida = possivelListaDeTarefas.get().size();
    assertEquals(quantidadeDeTarefasConcluidasEsperada, quantidadeDeTarefasConcluidasRecebida);
  }

  @Test
  void
      dadoTarefasConcluidasDaoJdbcImplQuandoTestadoMetodoRegistraNovaTarefaEntaoDeveExistirUmaTarefa() {
    // preparacao
    EstagiarioDeTi estagiarioDeTi = builder.agora();
    estagiarioDeTiDaoTestHelperJdbc.cria(estagiarioDeTi);

    // acao
    tarefasConcluidasDaoJdbc.registraNovaTarefa(estagiarioDeTi.getId(), "T1");

    // verificacao
    Optional<List<String>> opt = tarefasConcluidasDaoJdbc.resgataPorId(estagiarioDeTi.getId());
    List<String> result = opt.get();
    assertFalse(result.isEmpty());
  }
}
