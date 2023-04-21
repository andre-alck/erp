package com.me.erp.participante.interno.funcionario.clt;

import com.me.erp.participante.interno.funcionario.estagiario.Estagiario;

import java.util.Arrays;
import java.util.List;

public abstract class Clt extends Estagiario {
    public void participarDeReuniao(Contribuicao contribuicao) throws ContribuicaoInvalidaException {
        isContribuicaoValida(contribuicao);
    }

    private void isContribuicaoValida(Contribuicao contribuicao) {
        if (contribuicao.getQuantidadeDePerguntas() < 1) {
            throw new ContribuicaoInvalidaException("Quantidade de perguntas é menor do que uma.");
        }

        if (contribuicao.getQuantidadeDeRespostas() < 1) {
            throw new ContribuicaoInvalidaException("Quantidade de respostas é menor do que uma.");
        }

        if (contribuicao.getPontuacao() < 5) {
            throw new ContribuicaoInvalidaException("Pontuação é menor do que cinco.");
        }

        atribuiContribuicaoATarefaConcluida(contribuicao);
    }

    private void atribuiContribuicaoATarefaConcluida(Contribuicao contribuicao) {
        List<String> tarefas = Arrays.asList(contribuicao.toString());
        this.setTarefasConcluidas(tarefas);
    }
}