package com.me.erp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParticipanteExternoTest {
    ParticipanteExterno participanteExterno;

    @BeforeEach
    void setup() {
        participanteExterno = new ParticipanteExterno();
    }

    @Test
    void dadoParticipanteExternoComStatusDaDocumentacaoRegularQuandoTestadoMetodoParticiparDeveRetornarVerdadeiro() {
        // preparacao
        participanteExterno.setStatusDaDocumentacao(StatusDaDocumentacao.REGULAR);

        // acao
        boolean participou = participanteExterno.participar();

        // verificacao
        assertTrue(participou);
    }

    @Test
    void dadoParticipanteExternoComStatusDaDocumentacaoIrregularQuandoTestadoMetodoParticiparDeveRetornarFalso() {
        // preparacao
        participanteExterno.setStatusDaDocumentacao(StatusDaDocumentacao.IRREGULAR);

        // acao
        boolean participou = participanteExterno.participar();

        // verificacao
        assertFalse(participou);
    }

    @Test
    void dadoParticipanteExternoComStatusDaDocumentacaoEmAnaliseQuandoTestadoMetodoParticiparDeveRetornarFalso() {
        // preparacao
        participanteExterno.setStatusDaDocumentacao(StatusDaDocumentacao.EM_ANALISE);

        // acao
        boolean participou = participanteExterno.participar();

        // verificacao
        assertFalse(participou);
    }

    @Test
    void dadoParticipanteExternoComStatusDaDocumentacaoAguardandoEnvioQuandoTestadoMetodoParticiparDeveRetornarFalso() {
        // preparacao
        participanteExterno.setStatusDaDocumentacao(StatusDaDocumentacao.AGUARDANDO_ENVIO);

        // acao
        boolean participou = participanteExterno.participar();

        // verificacao
        assertFalse(participou);
    }
}