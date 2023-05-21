package com.me.erp.participante.interno;

public class Credenciais {
  private String id;
  private String senha;

  public Credenciais() {}

  public Credenciais(String id, String senha) {
    this.id = id;
    this.senha = senha;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
