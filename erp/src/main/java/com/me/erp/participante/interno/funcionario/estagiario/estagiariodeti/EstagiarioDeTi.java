package com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti;

import com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTiDaoJdbcImpl;
import com.me.erp.participante.interno.funcionario.estagiario.Documentacao;
import com.me.erp.participante.interno.funcionario.estagiario.Estagiario;
import com.me.erp.participante.interno.funcionario.ti.atividadestiniveljunior.AtividadesTiNivelJunior;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstagiarioDeTi extends Estagiario {

  private AtividadesTiNivelJunior atividadesTiNivelJunior;


  @Autowired
  private EstagiarioDeTiDaoJdbcImpl dao;

  public EstagiarioDeTi() {}

  public void setAtividadesTiNivelJunior(AtividadesTiNivelJunior atividadesTiNivelJunior) {
    this.atividadesTiNivelJunior = atividadesTiNivelJunior;
  }

  public String programar() {
    return this.atividadesTiNivelJunior.programar();
  }

  public void documentar(Documentacao documentacao) {
    super.documentar(documentacao);
    dao.registraNovaTarefa(this.getId(), documentacao.toString());
  }

  public Optional<EstagiarioDeTi> resgataPorId(String id) {
    return dao.resgataPorId(id);
  }

  public void registraNovaTarefa(String idDoParticipanteExistente, String tarefa) {
    dao.registraNovaTarefa(idDoParticipanteExistente, tarefa);
  }
}
