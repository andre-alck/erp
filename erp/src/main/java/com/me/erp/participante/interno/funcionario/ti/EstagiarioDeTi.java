package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.participante.interno.funcionario.estagiario.Estagiario;
import com.me.erp.participante.interno.funcionario.ti.atividadestiniveljunior.AtividadesTiNivelJunior;

public class EstagiarioDeTi extends Estagiario {

    private AtividadesTiNivelJunior atividadesTiNivelJunior;

    public EstagiarioDeTi() {
    };

    public EstagiarioDeTi(AtividadesTiNivelJunior atividadesTiNivelJunior) {
        this.atividadesTiNivelJunior = atividadesTiNivelJunior;
    };

    public void setAtividadesTiNivelJunior(AtividadesTiNivelJunior atividadesTiNivelJunior) {
        this.atividadesTiNivelJunior = atividadesTiNivelJunior;
    }

    public String programar() {
        String programacao = this.atividadesTiNivelJunior.programar();
        return programacao;
    }
}
