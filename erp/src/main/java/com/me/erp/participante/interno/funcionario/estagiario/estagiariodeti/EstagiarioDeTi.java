package com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti;

import com.me.erp.dao.Dao;
import com.me.erp.participante.interno.funcionario.estagiario.Documentacao;
import com.me.erp.participante.interno.funcionario.estagiario.Estagiario;
import com.me.erp.participante.interno.funcionario.ti.atividadestiniveljunior.AtividadesTiNivelJunior;

public class EstagiarioDeTi extends Estagiario {

  private AtividadesTiNivelJunior atividadesTiNivelJunior;

  private Dao dao;

  public EstagiarioDeTi() {}

  public EstagiarioDeTi(AtividadesTiNivelJunior atividadesTiNivelJunior) {
    this.atividadesTiNivelJunior = atividadesTiNivelJunior;
  }

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
}
