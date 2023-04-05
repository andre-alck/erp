package com.me.erp.builders;

import com.me.erp.mocks.SupervisorMock;
import com.me.erp.participante.interno.Perfil;

public class SupervisorMockBuilder {
    private SupervisorMock supervisorMock;

    public static SupervisorMockBuilder umSupervisorMock() {
        SupervisorMockBuilder builder = new SupervisorMockBuilder();
        builder.supervisorMock = new SupervisorMock();
        return builder;
    }

    public SupervisorMockBuilder comId(String id) {
        supervisorMock.setId(id);
        return this;
    }

    public SupervisorMockBuilder comOcupacao(String ocupacao) {
        supervisorMock.setOcupacao(ocupacao);
        return this;
    }

    public SupervisorMockBuilder comVencimento(double vencimento) {
        supervisorMock.setVencimento(vencimento);
        return this;
    }

    public SupervisorMockBuilder comSenha(String senha) {
        supervisorMock.setOcupacao(senha);
        return this;
    }

    public SupervisorMockBuilder comPerfil(Perfil perfil) {
        supervisorMock.setPerfil(perfil);
        return this;
    }

    public SupervisorMockBuilder comCargaHorariaSemanal(double cargaHorariaSemanal) {
        supervisorMock.setCargaHorariaSemanal(cargaHorariaSemanal);
        return this;
    }

    public SupervisorMockBuilder comPausa(double pausa) {
        supervisorMock.setPausa(pausa);
        return this;
    }

    public SupervisorMock agora() {
        return supervisorMock;
    }
}
