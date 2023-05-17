package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.participante.interno.funcionario.estagiario.Estagiario;
import com.me.erp.participante.interno.funcionario.ti.atividadestiniveljunior.AtividadesTiNivelJunior;

import java.util.List;

public class EstagiarioDeTi extends Estagiario {

    private AtividadesTiNivelJunior atividadesTiNivelJunior;

    public EstagiarioDeTi() {
    }

    public EstagiarioDeTi(AtividadesTiNivelJunior atividadesTiNivelJunior) {
        this.atividadesTiNivelJunior = atividadesTiNivelJunior;
    }

    public EstagiarioDeTi(String id, String ocupacao, double vencimento, List<String> tarefasConcluidas, String senha, double cargaHorariaSemanal, double pausa) {
        super(id, ocupacao, vencimento, tarefasConcluidas, senha, cargaHorariaSemanal, pausa);
    }

    public void setAtividadesTiNivelJunior(AtividadesTiNivelJunior atividadesTiNivelJunior) {
        this.atividadesTiNivelJunior = atividadesTiNivelJunior;
    }

    public String programar() {
        return this.atividadesTiNivelJunior.programar();
    }
}
