package com.me.erp.builders;

import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.ti.EstagiarioDeTi;
import com.me.erp.participante.interno.funcionario.ti.atividadestiniveljunior.AtividadesTiNivelJunior;

import java.util.List;

public class EstagiarioDeTiBuilder {
    private EstagiarioDeTi estagiarioDeTi;

    public static EstagiarioDeTiBuilder umEstagiarioDeTi() {
        EstagiarioDeTiBuilder builder = new EstagiarioDeTiBuilder();
        builder.estagiarioDeTi = new EstagiarioDeTi();
        return builder;
    }

    public EstagiarioDeTiBuilder comId(String id) {
        estagiarioDeTi.setId(id);
        return this;
    }

    public EstagiarioDeTiBuilder comOcupacao(String ocupacao) {
        estagiarioDeTi.setOcupacao(ocupacao);
        return this;
    }

    public EstagiarioDeTiBuilder comVencimento(double vencimento) {
        estagiarioDeTi.setVencimento(vencimento);
        return this;
    }

    public EstagiarioDeTiBuilder comTarefasConcluidas(List<String> tarefasConcluidas) {
        estagiarioDeTi.setTarefasConcluidas(tarefasConcluidas);
        return this;
    }

    public EstagiarioDeTiBuilder comCredenciais(Credenciais credenciais) {
        estagiarioDeTi.setCredenciais(credenciais);
        return this;
    }

    public EstagiarioDeTiBuilder comCargaHorariaSemanal(double cargaHorariaSemanal) {
        estagiarioDeTi.setCargaHorariaSemanal(cargaHorariaSemanal);
        return this;
    }

    public EstagiarioDeTiBuilder comPausa(double pausa) {
        estagiarioDeTi.setPausa(pausa);
        return this;
    }

    public EstagiarioDeTiBuilder comAtividadesTiNivelJunior(AtividadesTiNivelJunior atividadesTiNivelJunior) {
        estagiarioDeTi.setAtividadesTiNivelJunior(atividadesTiNivelJunior);
        return this;
    }

    public EstagiarioDeTi agora() {
        return estagiarioDeTi;
    }
}
