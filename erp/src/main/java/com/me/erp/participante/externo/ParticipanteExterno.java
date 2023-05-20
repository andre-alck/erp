package com.me.erp.participante.externo;

import com.me.erp.participante.Participante;
import java.util.List;

public class ParticipanteExterno extends Participante {
    private StatusDaRegulamentacaoDoParticipanteExterno statusDaRegulamentacaoDoParticipanteExterno;

    public StatusDaRegulamentacaoDoParticipanteExterno getStatusDaDocumentacaoDoParticipanteExterno() {
        return statusDaRegulamentacaoDoParticipanteExterno;
    }

    public void setStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno statusDaRegulamentacaoDoParticipanteExterno) {
        this.statusDaRegulamentacaoDoParticipanteExterno = statusDaRegulamentacaoDoParticipanteExterno;
    }

    public void trabalhar(List<String> tarefasConcluidas) throws StatusDoTrabalhoIrregularException {
        if (statusDaRegulamentacaoDoParticipanteExterno != StatusDaRegulamentacaoDoParticipanteExterno.REGULAR) {
            throw new StatusDoTrabalhoIrregularException("Status da Regulamentação do Participante Externo é diferente de Regular.");
        }

        if (tarefasConcluidas.isEmpty()) {
            throw new StatusDoTrabalhoIrregularException("Quantidade de tarefas concluídas é zero.");
        }

        this.setTarefasConcluidas(tarefasConcluidas);
    }
}

