package com.me.erp.builders;

import com.me.erp.participante.interno.Perfil;
import com.me.erp.participante.interno.funcionario.ti.EstagiarioDeTi;

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

    public EstagiarioDeTiBuilder comSenha(String senha) {
        estagiarioDeTi.setSenha(senha);
        return this;
    }

    public EstagiarioDeTiBuilder comPerfil(Perfil perfil) {
        estagiarioDeTi.setPerfil(perfil);
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

    public EstagiarioDeTi agora() {
        return estagiarioDeTi;
    }
}
