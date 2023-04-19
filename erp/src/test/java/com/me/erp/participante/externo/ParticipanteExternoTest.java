package com.me.erp.participante.externo;

import com.me.erp.builders.ParticipanteExternoBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.me.erp.builders.ParticipanteExternoBuilder.umParticipanteExterno;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipanteExternoTest {
    ParticipanteExternoBuilder builder;

    @BeforeEach
    public void setup() {
        builder = umParticipanteExterno().comId("54323212123").comOcupacao("Pintor").comVencimento(2500).comTarefasConcluidas(new ArrayList<>());
    }

    @Test
    public void dadoParticipanteExternoComStatusDaRegulamentacaoRegularQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoRegular() throws StatusDoTrabalhoIrregularException {
        // preparacao
        ParticipanteExterno participanteExterno = builder.comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.REGULAR).agora();
        List<String> tarefasConcluidas = Arrays.asList("T1", "T2", "T3", "T4", "T5");

        // acao
        participanteExterno.trabalhar(tarefasConcluidas);

        // verificacao
        assertEquals(participanteExterno.getTarefasConcluidas(), tarefasConcluidas);
    }

    @Test()
    public void dadoParticipanteExternoComStatusDaRegulamentacaoEmAguardoDoEnvioDaDocumentacaoQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoIrregular() throws StatusDoTrabalhoIrregularException {
        // preparacao
        ParticipanteExterno participanteExterno = builder.comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.EM_AGUARDO_DO_ENVIO_DA_DOCUMENTACAO).agora();
        List<String> tarefasConcluidas = Arrays.asList("T1", "T2", "T3", "T4", "T5");

        // acao
        StatusDoTrabalhoIrregularException exception = assertThrows(StatusDoTrabalhoIrregularException.class, () -> participanteExterno.trabalhar(tarefasConcluidas));

        // verificacao
        assertEquals("Status da Regulamentação do Participante Externo é diferente de Regular.", exception.getMessage());
    }

    @Test()
    public void dadoParticipanteExternoComStatusDaRegulamentacaoEmAnaliseInternaQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoIrregular() throws StatusDoTrabalhoIrregularException {
        // preparacao
        ParticipanteExterno participanteExterno = builder.comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.EM_ANALISE_INTERNA).agora();
        List<String> tarefasConcluidas = Arrays.asList("T1", "T2", "T3", "T4", "T5");

        // acao
        StatusDoTrabalhoIrregularException exception = assertThrows(StatusDoTrabalhoIrregularException.class, () -> participanteExterno.trabalhar(tarefasConcluidas));

        // verificacao
        assertEquals("Status da Regulamentação do Participante Externo é diferente de Regular.", exception.getMessage());
    }

    @Test()
    public void dadoParticipanteExternoComStatusDaRegulamentacaoRegularEZeroTarefasConcluidasQuandoTrabalharEntaoDeveRetornarStatusDoTrabalhoIrregular() throws StatusDoTrabalhoIrregularException {
        // preparacao
        ParticipanteExterno participanteExterno = builder.comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.REGULAR).agora();
        List<String> tarefasConcluidas = new ArrayList<>();

        // acao
        StatusDoTrabalhoIrregularException exception = assertThrows(StatusDoTrabalhoIrregularException.class, () -> participanteExterno.trabalhar(tarefasConcluidas));

        // verificacao
        assertEquals("Quantidade de tarefas concluídas é zero.", exception.getMessage());
    }
}