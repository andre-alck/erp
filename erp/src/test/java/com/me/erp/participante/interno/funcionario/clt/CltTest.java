package com.me.erp.participante.interno.funcionario.clt;

import com.me.erp.mocks.CltMock;
import com.me.erp.participante.interno.Perfil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.me.erp.builders.CltMockBuilder.umClt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CltTest {
    CltMock clt;

    @BeforeEach
    public void setup() {
        clt = umClt().comId("408.529.908-55").comOcupacao("Ocupação").comVencimento(2000).comTarefasConcluidas(new ArrayList<>()).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(2400).comPausa(90).agora();
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComZeroPerguntasDeveLancarExcecaoContribuicaoInvalidaException() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(0);
        contribuicao.setQuantidadeDeRespostas(10);

        // acao
        ContribuicaoInvalidaException exception = assertThrows(ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

        // verificacao
        assertEquals("Quantidade de perguntas é menor do que uma.", exception.getMessage());
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComZeroRespostasDeveRetornarStatusDaContribuicaoInsuficiente() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(10);
        contribuicao.setQuantidadeDeRespostas(0);

        // acao
        ContribuicaoInvalidaException exception = assertThrows(ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

        // verificacao
        assertEquals("Quantidade de respostas é menor do que uma.", exception.getMessage());
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComUmaPerguntaEUmaRespostaEPontuacaoMenorDoQueCincoDeveRetornarStatusDaContribuicaoInsuficiente() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(1);
        contribuicao.setQuantidadeDeRespostas(1);

        // acao
        ContribuicaoInvalidaException exception = assertThrows(ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

        // verificacao
        assertEquals("Pontuação é menor do que cinco.", exception.getMessage());
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComUmaPerguntaEUmaRespostaEPontuacaoIgualACincoDeveRetornarStatusDaContribuicaoInsuficiente() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(4);
        contribuicao.setQuantidadeDeRespostas(1);

        // acao
        clt.participarDeReuniao(contribuicao);

        List<String> tarefasConcluidas = clt.getTarefasConcluidas();
        assertEquals(tarefasConcluidas.get(0), contribuicao.toString());
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComCincoPerguntasECincoRespostasEPontuacaoMaiorDoQueCincoEntaoDeveAtribuirAsTarefasConcluidas() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(5);
        contribuicao.setQuantidadeDeRespostas(5);

        // acao
        clt.participarDeReuniao(contribuicao);

        // verificacao
        List<String> tarefasConcluidas = clt.getTarefasConcluidas();
        assertEquals(tarefasConcluidas.get(0), contribuicao.toString());
    }
}