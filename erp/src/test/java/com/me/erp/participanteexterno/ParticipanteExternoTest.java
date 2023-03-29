package com.me.erp.participanteexterno;

import com.me.erp.StatusDoTrabalho;
import org.junit.jupiter.api.Test;

import static com.me.erp.builders.ParticipanteExternoBuilder.umParticipanteExterno;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipanteExternoTest {

    @Test
    public void dadoParticipanteExternoComStatusDaRegulamentacaoRegularQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoRegular() {
        // preparacao
       ParticipanteExterno participanteExterno = umParticipanteExterno().comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.REGULAR).agora();

        // acao
        StatusDoTrabalho statusDoTrabalho =  participanteExterno.trabalhar();

        // verificacao
        assertEquals(statusDoTrabalho, StatusDoTrabalho.REGULAR);
    }

    @Test
    public void dadoParticipanteExternoComStatusDaRegulamentacaoEmAguardoDoEnvioDaDocumentacaoQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        ParticipanteExterno participanteExterno = umParticipanteExterno().comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.EM_AGUARDO_DO_ENVIO_DA_DOCUMENTACAO).agora();

        // acao
        StatusDoTrabalho statusDoTrabalho =  participanteExterno.trabalhar();

        // verificacao
        assertEquals(statusDoTrabalho, StatusDoTrabalho.IRREGULAR);
    }

    @Test
    public void dadoParticipanteExternoComStatusDaRegulamentacaoEmAnaliseInternaQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        ParticipanteExterno participanteExterno = umParticipanteExterno().comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.EM_ANALISE_INTERNA).agora();

        // acao
        StatusDoTrabalho statusDoTrabalho =  participanteExterno.trabalhar();

        // verificacao
        assertEquals(statusDoTrabalho, StatusDoTrabalho.IRREGULAR);
    }
}