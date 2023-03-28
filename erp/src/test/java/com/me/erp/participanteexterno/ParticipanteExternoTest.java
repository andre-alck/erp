package com.me.erp.participanteexterno;


import com.me.erp.participanteexterno.ParticipanteExterno;
import com.me.erp.participanteexterno.StatusDaDocumentacaoDoParticipanteExterno;
import com.me.erp.participanteexterno.StatusDoTrabalhoDoParticipanteExterno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipanteExternoTest {

    @Test
    public void dadoParticipanteExternoComStatusDaDocumentacaoRegularQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoRegular() {
        // preparacao
        ParticipanteExterno participanteExterno = new ParticipanteExterno.ParticipanteExternoBuilder().comStatusDaDocumentacaoDoParticipanteExterno(StatusDaDocumentacaoDoParticipanteExterno.REGULAR).agora();

        // acao
        StatusDoTrabalhoDoParticipanteExterno statusDoTrabalhoDoParticipanteExterno =  participanteExterno.trabalhar();

        // verificacao
        assertEquals(statusDoTrabalhoDoParticipanteExterno, StatusDoTrabalhoDoParticipanteExterno.REGULAR);
    }

    @Test
    public void dadoParticipanteExternoComStatusDaDocumentacaoEmAguardoDoEnvioDaDocumentacaoQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        ParticipanteExterno participanteExterno = new ParticipanteExterno.ParticipanteExternoBuilder().comStatusDaDocumentacaoDoParticipanteExterno(StatusDaDocumentacaoDoParticipanteExterno.EM_AGUARDO_DO_ENVIO_DA_DOCUMENTACAO).agora();

        // acao
        StatusDoTrabalhoDoParticipanteExterno statusDoTrabalhoDoParticipanteExterno =  participanteExterno.trabalhar();

        // verificacao
        assertEquals(statusDoTrabalhoDoParticipanteExterno, StatusDoTrabalhoDoParticipanteExterno.IRREGULAR);
    }

    @Test
    public void dadoParticipanteExternoComStatusDaDocumentacaoEmAnaliseInternaQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        ParticipanteExterno participanteExterno = new ParticipanteExterno.ParticipanteExternoBuilder().comStatusDaDocumentacaoDoParticipanteExterno(StatusDaDocumentacaoDoParticipanteExterno.EM_ANALISE_INTERNA).agora();

        // acao
        StatusDoTrabalhoDoParticipanteExterno statusDoTrabalhoDoParticipanteExterno =  participanteExterno.trabalhar();

        // verificacao
        assertEquals(statusDoTrabalhoDoParticipanteExterno, StatusDoTrabalhoDoParticipanteExterno.IRREGULAR);
    }
}