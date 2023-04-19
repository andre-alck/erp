package com.me.erp.builders;

import com.me.erp.mocks.EstagiarioMock;
import com.me.erp.participante.interno.Perfil;

import java.util.List;

public class EstagiarioMockBuilder {
    private EstagiarioMock estagiarioMock;

    public static EstagiarioMockBuilder umEstagiarioMock() {
        EstagiarioMockBuilder builder = new EstagiarioMockBuilder();
        builder.estagiarioMock = new EstagiarioMock();
        return builder;
    }

    public EstagiarioMockBuilder comId(String id) {
        estagiarioMock.setId(id);
        return this;
    }

    public EstagiarioMockBuilder comOcupacao(String ocupacao) {
        estagiarioMock.setOcupacao(ocupacao);
        return this;
    }

    public EstagiarioMockBuilder comVencimento(double vencimento) {
        estagiarioMock.setVencimento(vencimento);
        return this;
    }

    public EstagiarioMockBuilder comTarefasConcluidas(List<String> tarefasConcluidas) {
        estagiarioMock.setTarefasConcluidas(tarefasConcluidas);
        return this;
    }

    public EstagiarioMockBuilder comSenha(String senha) {
        estagiarioMock.setSenha(senha);
        return this;
    }

    public EstagiarioMockBuilder comPerfil(Perfil perfil) {
        estagiarioMock.setPerfil(perfil);
        return this;
    }

    public EstagiarioMockBuilder comCargaHorariaSemanal(double cargaHorariaSemanal) {
        estagiarioMock.setCargaHorariaSemanal(cargaHorariaSemanal);
        return this;
    }

    public EstagiarioMockBuilder comPausa(double pausa) {
        estagiarioMock.setPausa(pausa);
        return this;
    }

    public EstagiarioMock agora() {
        return estagiarioMock;
    }
}
