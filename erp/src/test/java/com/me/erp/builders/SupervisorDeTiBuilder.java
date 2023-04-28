package com.me.erp.builders;

import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.ti.SupervisorDeTi;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.AtividadesTiNivelSenior;

import java.util.List;

public class SupervisorDeTiBuilder {
    private SupervisorDeTi supervisorDeTi;

    public static SupervisorDeTiBuilder umSupervisorDeTi() {
        SupervisorDeTiBuilder builder = new SupervisorDeTiBuilder();
        builder.supervisorDeTi = new SupervisorDeTi();
        return builder;
    }

    public SupervisorDeTiBuilder comId(String id) {
        supervisorDeTi.setId(id);
        return this;
    }

    public SupervisorDeTiBuilder comOcupacao(String ocupacao) {
        supervisorDeTi.setOcupacao(ocupacao);
        return this;
    }

    public SupervisorDeTiBuilder comVencimento(double vencimento) {
        supervisorDeTi.setVencimento(vencimento);
        return this;
    }

    public SupervisorDeTiBuilder comTarefasConcluidas(List<String> tarefasConcluidas) {
        supervisorDeTi.setTarefasConcluidas(tarefasConcluidas);
        return this;
    }

    public SupervisorDeTiBuilder comCredenciais(Credenciais credenciais) {
        supervisorDeTi.setCredenciais(credenciais);
        return this;
    }

    public SupervisorDeTiBuilder comPerfil(Credenciais credenciais) {
        supervisorDeTi.setCredenciais(credenciais);
        return this;
    }

    public SupervisorDeTiBuilder comCargaHorariaSemanal(double cargaHorariaSemanal) {
        supervisorDeTi.setCargaHorariaSemanal(cargaHorariaSemanal);
        return this;
    }

    public SupervisorDeTiBuilder comPausa(double pausa) {
        supervisorDeTi.setPausa(pausa);
        return this;
    }

    public SupervisorDeTiBuilder comAtividadesTiNivelSenior(AtividadesTiNivelSenior atividadesTiNivelSenior) {
        supervisorDeTi.setAtividadesTiNivelSenior(atividadesTiNivelSenior);
        return this;
    }

    public SupervisorDeTi agora() {
        return supervisorDeTi;
    }
}
