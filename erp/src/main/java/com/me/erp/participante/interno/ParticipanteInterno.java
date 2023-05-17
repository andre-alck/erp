package com.me.erp.participante.interno;

import com.me.erp.participante.Participante;

import java.util.List;

public abstract class ParticipanteInterno extends Participante {
    private Credenciais credenciais;

    public ParticipanteInterno() {
    }

    public ParticipanteInterno(String id, String ocupacao, double vencimento, List<String> tarefasConcluidas, String senha) {
        super(id, ocupacao, vencimento, tarefasConcluidas);
        this.credenciais = new Credenciais(id, senha);
    }

    public Credenciais getCredenciais() {
        return credenciais;
    }

    public void setCredenciais(Credenciais credenciais) {
        this.credenciais = credenciais;
    }
}
