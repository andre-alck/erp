package com.me.erp.dao.participante;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.me.erp.dao.participante.daotesthelper.DaoTestHelperJdbcImpl;
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

  @Autowired DaoTestHelperJdbcImpl daoTestHelperJdbc;

  @BeforeEach
  void setup() {
    daoTestHelperJdbc.cleanUp();
  }

  @Test
  void
      dadoTarefasConcluidasDaoJdbcImplQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveVerificarSeQuantidadeDeTarefasEZero() {
    // acao
    Optional<List<String>> possivelListaDeTarefas =
        tarefasConcluidasDaoJdbc.resgataPorId("inexistente");

    // verificacao
    assertTrue(possivelListaDeTarefas.get().isEmpty());
  }

  @Test
  void
      dadoTarefasConcluidasDaoJdbcImplQuandoTestadoMetodoResgataPorIdComDoisRegistrosNoBancoDeDadosEntaoDeveExistirDuasTarefas() {
    // preparacao
    String id = "757.857.8475-98";
    tarefasConcluidasDaoTestHelperJdbc.criaRegistroDeTarefaConcluidaRegistrandoParticipante(
        id, "descricao");

    // acao
    Optional<List<String>> possivelListaDeTarefas = tarefasConcluidasDaoJdbc.resgataPorId(id);

    // verificacao
    int quantidadeEsperada = 2;
    int quantidadeRecebida = possivelListaDeTarefas.get().size();
    assertEquals(quantidadeEsperada, quantidadeRecebida);
  }
}
