package com.me.erp.dao.participante.tarefasconcluidashelper;

public interface TarefasConcluidasDaoTestHelper {
  void criaRegistroDeTarefaConcluidaRegistrandoParticipante(String id, String descricao);

  void criaRegistroDeTarefaConcluidaComParticipanteExistente(String id, String descricao);
}
