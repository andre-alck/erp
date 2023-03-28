package com.me.erp.participanteexterno;

import com.me.erp.Participante;

public class ParticipanteExterno extends Participante {

    private StatusDaDocumentacaoDoParticipanteExterno statusDaDocumentacaoDoParticipanteExterno;

    public ParticipanteExterno(StatusDaDocumentacaoDoParticipanteExterno statusDaDocumentacaoDoParticipanteExterno) {
        this.statusDaDocumentacaoDoParticipanteExterno = statusDaDocumentacaoDoParticipanteExterno;
    }

    public StatusDaDocumentacaoDoParticipanteExterno getStatusDaDocumentacaoDoParticipanteExterno() {
        return statusDaDocumentacaoDoParticipanteExterno;
    }

    public void setStatusDaDocumentacaoDoParticipanteExterno(StatusDaDocumentacaoDoParticipanteExterno statusDaDocumentacaoDoParticipanteExterno) {
        this.statusDaDocumentacaoDoParticipanteExterno = statusDaDocumentacaoDoParticipanteExterno;
    }

    public StatusDoTrabalhoDoParticipanteExterno trabalhar() {
        StatusDoTrabalhoDoParticipanteExterno statusDoTrabalhoDoParticipanteExterno;

        if(statusDaDocumentacaoDoParticipanteExterno != StatusDaDocumentacaoDoParticipanteExterno.REGULAR) {
            statusDoTrabalhoDoParticipanteExterno  = StatusDoTrabalhoDoParticipanteExterno.IRREGULAR;
            return statusDoTrabalhoDoParticipanteExterno;
        }

        statusDoTrabalhoDoParticipanteExterno  = StatusDoTrabalhoDoParticipanteExterno.REGULAR;
        return statusDoTrabalhoDoParticipanteExterno;
    }

    public static class ParticipanteExternoBuilder {
        private StatusDaDocumentacaoDoParticipanteExterno statusDaDocumentacaoDoParticipanteExterno;

        public ParticipanteExternoBuilder comStatusDaDocumentacaoDoParticipanteExterno(StatusDaDocumentacaoDoParticipanteExterno statusDaDocumentacaoDoParticipanteExterno) {
            this.statusDaDocumentacaoDoParticipanteExterno = statusDaDocumentacaoDoParticipanteExterno;
            return this;
        }

        public ParticipanteExterno agora() {
            return new ParticipanteExterno(statusDaDocumentacaoDoParticipanteExterno);
        }
    }


}

