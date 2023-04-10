package com.me.erp.builders;

import com.me.erp.participante.interno.Perfil;
import com.me.erp.participante.interno.funcionario.ti.Desenvolvedor;

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

    public DesenvolvedorBuilder comSenha(String senha) {
        desenvolvedor.setSenha(senha);
        return this;
    }

    public DesenvolvedorBuilder comPerfil(Perfil perfil) {
        desenvolvedor.setPerfil(perfil);
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

    public Desenvolvedor agora() {
        return desenvolvedor;
    }
}