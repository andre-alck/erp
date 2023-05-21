package com.me.erp.participante.interno;

import com.me.erp.participante.Participante;

public abstract class ParticipanteInterno extends Participante {
  private Credenciais credenciais;

  protected ParticipanteInterno() {}

  public Credenciais getCredenciais() {
    return credenciais;
  }

  public void setCredenciais(Credenciais credenciais) {
    this.credenciais = credenciais;
  }
}
