package com.me.erp.participante.interno.funcionario.dto;

import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.estagiario.Documentacao;

public class FuncionarioDocumentacaoDto {

  private Credenciais credenciais;
  private Documentacao documentacao;

  public FuncionarioDocumentacaoDto(Credenciais credenciais, Documentacao documentacao) {
    this.credenciais = credenciais;
    this.documentacao = documentacao;
  }

  public Credenciais getCredenciais() {
    return credenciais;
  }

  public void setCredenciais(Credenciais credenciais) {
    this.credenciais = credenciais;
  }

  public Documentacao getDocumentacao() {
    return documentacao;
  }

  public void setDocumentacao(Documentacao documentacao) {
    this.documentacao = documentacao;
  }
}
