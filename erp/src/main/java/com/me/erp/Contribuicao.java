package com.me.erp;

public class Contribuicao {
    private int quantidadeDePerguntas;
    private int quantidadeDeRespostas;
    private int pontuacao;

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
        int pontuacao = quantidadeDePerguntas + quantidadeDeRespostas;
        return pontuacao;
    }
}
