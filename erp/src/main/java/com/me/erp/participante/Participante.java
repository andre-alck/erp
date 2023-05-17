package com.me.erp.participante;

import java.util.List;

public abstract class Participante {
    private String id;
    private String ocupacao;
    private double vencimento;
    private List<String> tarefasConcluidas;

    public Participante() {
    }

    public Participante(String id, String ocupacao, double vencimento, List<String> tarefasConcluidas) {
        this.id = id;
        this.ocupacao = ocupacao;
        this.vencimento = vencimento;
        this.tarefasConcluidas = tarefasConcluidas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double getVencimento() {
        return vencimento;
    }

    public void setVencimento(double vencimento) {
        this.vencimento = vencimento;
    }

    public List<String> getTarefasConcluidas() {
        return tarefasConcluidas;
    }

    public void setTarefasConcluidas(List<String> tarefasConcluidas) {
        this.tarefasConcluidas = tarefasConcluidas;
    }
}
