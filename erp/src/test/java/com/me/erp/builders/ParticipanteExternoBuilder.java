package com.me.erp.builders;

import com.me.erp.participanteexterno.ParticipanteExterno;
import com.me.erp.participanteexterno.StatusDaRegulamentacaoDoParticipanteExterno;

public class ParticipanteExternoBuilder {
    private ParticipanteExterno participanteExterno;

    private ParticipanteExternoBuilder() {};

    public static ParticipanteExternoBuilder umParticipanteExterno() {
        ParticipanteExternoBuilder participanteExternoBuilder = new ParticipanteExternoBuilder();
        participanteExternoBuilder.participanteExterno = new ParticipanteExterno();
        return participanteExternoBuilder;
    }

    public ParticipanteExternoBuilder comId(String id) {
        participanteExterno.setId(id);
        return this;
    }
    public ParticipanteExternoBuilder comOcupacao(String ocupacao) {
        participanteExterno.setOcupacao(ocupacao);
        return this;
    }
    public ParticipanteExternoBuilder comVencimento(double vencimento) {
        participanteExterno.setVencimento(vencimento);
        return this;
    }
    public ParticipanteExternoBuilder comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno statusDaRegulamentacaoDoParticipanteExterno) {
        participanteExterno.setStatusDaRegulamentacaoDoParticipanteExterno(statusDaRegulamentacaoDoParticipanteExterno);
        return this;
    }

    public ParticipanteExterno agora() {
        return participanteExterno;
    }
}
