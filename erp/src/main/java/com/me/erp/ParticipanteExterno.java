package com.me.erp;

public class ParticipanteExterno extends Participante {

    private StatusDaDocumentacao statusDaDocumentacao;

    public StatusDaDocumentacao getStatusDaDocumentacao() {
        return statusDaDocumentacao;
    }

    public void setStatusDaDocumentacao(StatusDaDocumentacao statusDaDocumentacao) {
        this.statusDaDocumentacao = statusDaDocumentacao;
    }

    @Override
    public boolean participar() {
        if(statusDaDocumentacao != StatusDaDocumentacao.REGULAR) {
            return false;
        }

        return true;
    }
}

