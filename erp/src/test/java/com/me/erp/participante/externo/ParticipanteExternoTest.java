package com.me.erp.participante.externo;

import static com.me.erp.builders.ParticipanteExternoBuilder.umParticipanteExterno;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.me.erp.builders.ParticipanteExternoBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipanteExternoTest {
    ParticipanteExternoBuilder builder;

    @BeforeEach
    public void setup() {
        builder = umParticipanteExterno().comId("54323212123").comOcupacao("Pintor").comVencimento(2500).comTarefasConcluidas(new ArrayList<>());
    }

    @Test
    void dadoParticipanteExternoComStatusDaRegulamentacaoRegularQuandoTrabalharEntaoDeveAtribuirAsTarefasConcluidas() throws StatusDoTrabalhoIrregularException {
        // preparacao
        ParticipanteExterno participanteExterno = builder.comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.REGULAR).agora();
        List<String> tarefas = Arrays.asList("T1", "T2", "T3", "T4", "T5");

        // acao
        participanteExterno.trabalhar(tarefas);

        // verificacao
        List<String> tarefasConcluidas = participanteExterno.getTarefasConcluidas();
        assertEquals(tarefas, tarefasConcluidas);
    }

    @Test()
    void dadoParticipanteExternoComStatusDaRegulamentacaoEmAguardoDoEnvioDaDocumentacaoQuandoTrabalharEntaoDeveLancarExcecaoStatusDoTrabalhoIrregularException() throws StatusDoTrabalhoIrregularException {
        // preparacao
        ParticipanteExterno participanteExterno = builder.comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.EM_AGUARDO_DO_ENVIO_DA_DOCUMENTACAO).agora();
        List<String> tarefas = Arrays.asList("T1", "T2", "T3", "T4", "T5");

        // acao
        StatusDoTrabalhoIrregularException exception = assertThrows(StatusDoTrabalhoIrregularException.class, () -> participanteExterno.trabalhar(tarefas));

        // verificacao
        String mensagemEsperada = "Status da Regulamentação do Participante Externo é diferente de Regular.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test()
    void dadoParticipanteExternoComStatusDaRegulamentacaoEmAnaliseInternaQuandoTrabalharEntaoDeveLancarExcecaoStatusDoTrabalhoIrregularException() throws StatusDoTrabalhoIrregularException {
        // preparacao
        ParticipanteExterno participanteExterno = builder.comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.EM_ANALISE_INTERNA).agora();
        List<String> tarefas = Arrays.asList("T1", "T2", "T3", "T4", "T5");

        // acao
        StatusDoTrabalhoIrregularException exception = assertThrows(StatusDoTrabalhoIrregularException.class, () -> participanteExterno.trabalhar(tarefas));

        // verificacao
        String mensagemEsperada = "Status da Regulamentação do Participante Externo é diferente de Regular.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test()
    void dadoParticipanteExternoComStatusDaRegulamentacaoRegularEZeroTarefasConcluidasQuandoTrabalharEntaoDeveLancarExcecaoStatusDoTrabalhoIrregularException() throws StatusDoTrabalhoIrregularException {
        // preparacao
        ParticipanteExterno participanteExterno = builder.comStatusDaRegulamentacaoDoParticipanteExterno(StatusDaRegulamentacaoDoParticipanteExterno.REGULAR).agora();
        List<String> tarefasConcluidas = new ArrayList<>();

        // acao
        StatusDoTrabalhoIrregularException exception = assertThrows(StatusDoTrabalhoIrregularException.class, () -> participanteExterno.trabalhar(tarefasConcluidas));

        // verificacao
        String mensagemEsperada = "Quantidade de tarefas concluídas é zero.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }
}