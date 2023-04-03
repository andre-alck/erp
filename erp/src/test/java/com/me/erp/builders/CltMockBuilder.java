package com.me.erp.builders;

import com.me.erp.mocks.CltMock;
import com.me.erp.participante.interno.Perfil;

public class CltMockBuilder {
    private CltMock clt;

    private CltMockBuilder() {
    }

    public static CltMockBuilder umClt() {
        CltMockBuilder builder = new CltMockBuilder();
        builder.clt = new CltMock();
        return builder;
    }

    public CltMockBuilder comId(String id) {
        clt.setId(id);
        return this;
    }

    public CltMockBuilder comOcupacao(String ocupacao) {
        clt.setOcupacao(ocupacao);
        return this;
    }

    public CltMockBuilder comVencimento(double vencimento) {
        clt.setVencimento(vencimento);
        return this;
    }

    public CltMockBuilder comSenha(String senha) {
        clt.setSenha(senha);
        return this;
    }

    public CltMockBuilder comPerfil(Perfil perfil) {
        clt.setPerfil(perfil);
        return this;
    }

    public CltMockBuilder comCargaHorariaSemanal(double cargaHorariaSemanal) {
        clt.setCargaHorariaSemanal(cargaHorariaSemanal);
        return this;
    }

    public CltMockBuilder comPausa(double pausa) {
        clt.setPausa(pausa);
        return this;
    }

    public CltMock agora() {
        return clt;
    }
}