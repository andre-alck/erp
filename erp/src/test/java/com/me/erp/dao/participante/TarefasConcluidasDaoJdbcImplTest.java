package com.me.erp.dao.participante;

import static org.junit.jupiter.api.Assertions.*;

import com.me.erp.dao.participante.daotesthelper.DeletaRegistrosDaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.tarefasconcluidashelper.TarefasConcluidasDaoTestHelperJdbcImpl;
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

  @Autowired
  DeletaRegistrosDaoTestHelperJdbcImpl daoTestHelperJdbc;

  @BeforeEach
  void setup() {
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
    String queExisteNoBancoDeDados = "757.857.8475-98";
    tarefasConcluidasDaoTestHelperJdbc.criaRegistroDeTarefaConcluidaRegistrandoParticipante(
        queExisteNoBancoDeDados, "T1");

    // acao
    Optional<List<String>> possivelListaDeTarefas =
        tarefasConcluidasDaoJdbc.resgataPorId(queExisteNoBancoDeDados);

    // verificacao
    int quantidadeDeTarefasConcluidasEsperada = 2;
    int quantidadeDeTarefasConcluidasRecebida = possivelListaDeTarefas.get().size();
    assertEquals(quantidadeDeTarefasConcluidasEsperada, quantidadeDeTarefasConcluidasRecebida);
  }

  @Test
  void dadoTarefasConcluidasDaoJdbcImplQuandoTestadoMetodoRegistraNovaTarefaEntaoDeveExistirUmaTarefa() {
    // preparacao
    String id = "participante";
    tarefasConcluidasDaoTestHelperJdbc.criaRegistroDeParticipante(id);

    // acao
    tarefasConcluidasDaoJdbc.registraNovaTarefa(id, "T1");

    // verificacao
    Optional<List<String>> opt = tarefasConcluidasDaoJdbc.resgataPorId(id);
    List<String> result = opt.get();
    assertFalse(result.isEmpty());
  }
}
