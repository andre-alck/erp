package com.me.erp.participante.interno.funcionario.clt;

public class Contribuicao {
  private int quantidadeDePerguntas;
  private int quantidadeDeRespostas;

  public Contribuicao() {}

  public Contribuicao(int quantidadeDePerguntas, int quantidadeDeRespostas) {
    this.quantidadeDePerguntas = quantidadeDePerguntas;
    this.quantidadeDeRespostas = quantidadeDeRespostas;
  }

  public int getQuantidadeDePerguntas() {
    return quantidadeDePerguntas;
  }

  public void setQuantidadeDePerguntas(int quantidadeDePerguntas) {
    this.quantidadeDePerguntas = quantidadeDePerguntas;
  }

  public int getQuantidadeDeRespostas() {
    return quantidadeDeRespostas;
  }

  public void setQuantidadeDeRespostas(int quantidadeDeRespostas) {
    this.quantidadeDeRespostas = quantidadeDeRespostas;
  }

  public int getPontuacao() {
    return quantidadeDePerguntas + quantidadeDeRespostas;
  }
}
