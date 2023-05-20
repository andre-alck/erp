package com.me.erp.participante.interno.funcionario.clt.desenvolvedor;

import com.me.erp.participante.interno.funcionario.clt.Clt;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelpleno.AtividadesTiNivelPleno;

public class Desenvolvedor extends Clt {

  private AtividadesTiNivelPleno atividadesTiNivelPleno;

  public Desenvolvedor() {}

  public Desenvolvedor(AtividadesTiNivelPleno atividadesTiNivelPleno) {
    this.atividadesTiNivelPleno = atividadesTiNivelPleno;
  }

  public void setAtividadesTiNivelPleno(AtividadesTiNivelPleno tiPleno) {
    this.atividadesTiNivelPleno = tiPleno;
  }

  public String programar() {
    return this.atividadesTiNivelPleno.programar();
  }

  public int resolverChamados(int quantidadeDeChamados) {
    return this.atividadesTiNivelPleno.resolverChamados(quantidadeDeChamados);
  }
}
