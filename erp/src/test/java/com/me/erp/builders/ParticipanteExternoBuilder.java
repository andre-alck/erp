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

    public ParticipanteExternoBuilder comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno statusDaRegulamentacaoDoParticipanteExterno) {
        participanteExterno.setStatusDaDocumentacaoDoParticipanteExterno(statusDaRegulamentacaoDoParticipanteExterno);
        return this;
    }

    public ParticipanteExterno agora() {
        return participanteExterno;
    }
}
