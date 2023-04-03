package com.me.erp.participante.externo;

import com.me.erp.participante.Participante;
import com.me.erp.participante.StatusDoTrabalho;

public class ParticipanteExterno extends Participante {
    private StatusDaRegulamentacaoDoParticipanteExterno statusDaRegulamentacaoDoParticipanteExterno;

    public StatusDaRegulamentacaoDoParticipanteExterno getStatusDaDocumentacaoDoParticipanteExterno() {
        return statusDaRegulamentacaoDoParticipanteExterno;
    }

    public void setStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno statusDaRegulamentacaoDoParticipanteExterno) {
        this.statusDaRegulamentacaoDoParticipanteExterno = statusDaRegulamentacaoDoParticipanteExterno;
    }

    public StatusDoTrabalho trabalhar() {
        StatusDoTrabalho statusDoTrabalho;

        if (statusDaRegulamentacaoDoParticipanteExterno != StatusDaRegulamentacaoDoParticipanteExterno.REGULAR) {
            statusDoTrabalho = StatusDoTrabalho.IRREGULAR;
            return statusDoTrabalho;
        }

        statusDoTrabalho = StatusDoTrabalho.REGULAR;
        return statusDoTrabalho;
    }
}

