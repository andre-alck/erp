package com.me.erp.participante.interno.funcionario;

import com.me.erp.participante.interno.ParticipanteInterno;

import java.util.List;

public abstract class Funcionario extends ParticipanteInterno {
    private double cargaHorariaSemanal;
    private double pausa;

    public Funcionario() {
    }

    public Funcionario(String id, String ocupacao, double vencimento, List<String> tarefasConcluidas, String senha, double cargaHorariaSemanal, double pausa) {
        super(id, ocupacao, vencimento, tarefasConcluidas, senha);
        this.cargaHorariaSemanal = cargaHorariaSemanal;
        this.pausa = pausa;
    }

    public double getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(double cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public double getPausa() {
        return pausa;
    }

    public void setPausa(double pausa) {
        this.pausa = pausa;
    }
}
