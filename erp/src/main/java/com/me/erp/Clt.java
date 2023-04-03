package com.me.erp;

public abstract class Clt extends Estagiario {
    public StatusDaContribuicao participarDeReuniao(Contribuicao contribuicao) {
        if (contribuicao.getQuantidadeDePerguntas() < 1) {
            return StatusDaContribuicao.INSUFICIENTE;
        }

        if (contribuicao.getQuantidadeDeRespostas() < 1) {
            return StatusDaContribuicao.INSUFICIENTE;
        }

        if (contribuicao.getPontuacao() < 5) {
            return StatusDaContribuicao.INSUFICIENTE;
        }

        return StatusDaContribuicao.SUFICIENTE;
    }
}

// Necessário ter, no mínimo, uma pergunta e uma resposta. Necessário, também, pontuação maior ou igual a 5.