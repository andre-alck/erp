package com.me.erp.participante.interno.funcionario;

import com.me.erp.participante.interno.ParticipanteInterno;

public abstract class Funcionario extends ParticipanteInterno {
    private double cargaHorariaSemanal;
    private double pausa;

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
