package com.me.erp.builders;

import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.clt.desenvolvedor.Desenvolvedor;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelpleno.AtividadesTiNivelPleno;

import java.util.List;

public class DesenvolvedorBuilder {
    private Desenvolvedor desenvolvedor;

    public static DesenvolvedorBuilder umDesenvolvedor() {
        DesenvolvedorBuilder builder = new DesenvolvedorBuilder();
        builder.desenvolvedor = new Desenvolvedor();
        return builder;
    }

    public DesenvolvedorBuilder comId(String id) {
        desenvolvedor.setId(id);
        return this;
    }

    public DesenvolvedorBuilder comOcupacao(String ocupacao) {
        desenvolvedor.setOcupacao(ocupacao);
        return this;
    }

    public DesenvolvedorBuilder comVencimento(double vencimento) {
        desenvolvedor.setVencimento(vencimento);
        return this;
    }

    public DesenvolvedorBuilder comTarefasConcluidas(List<String> tarefasConcluidas) {
        desenvolvedor.setTarefasConcluidas(tarefasConcluidas);
        return this;
    }

    public DesenvolvedorBuilder comCredenciais(Credenciais credenciais) {
        desenvolvedor.setCredenciais(credenciais);
        return this;
    }

    public DesenvolvedorBuilder comPerfil(Credenciais credenciais) {
        desenvolvedor.setCredenciais(credenciais);
        return this;
    }

    public DesenvolvedorBuilder comCargaHorariaSemanal(double cargaHorariaSemanal) {
        desenvolvedor.setCargaHorariaSemanal(cargaHorariaSemanal);
        return this;
    }

    public DesenvolvedorBuilder comPausa(double pausa) {
        desenvolvedor.setPausa(pausa);
        return this;
    }

    public DesenvolvedorBuilder comAtividadesTiNivelPleno(AtividadesTiNivelPleno tiPleno) {
        desenvolvedor.setAtividadesTiNivelPleno(tiPleno);
        return this;
    }

    public Desenvolvedor agora() {
        return desenvolvedor;
    }
}
