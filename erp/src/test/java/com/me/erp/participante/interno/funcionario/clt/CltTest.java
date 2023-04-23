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
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComNenhumaPerguntaENenhumaRespostaEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
        // preparacao
        int comNenhumaPergunta = 0;
        int eNenhumaResposta = 0;
        Contribuicao contribuicao = new Contribuicao(comNenhumaPergunta, eNenhumaResposta);

        // acao
        ContribuicaoInvalidaException exception = assertThrows(ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

        // verificacao
        String mensagemEsperada = "Quantidade de perguntas é menor do que uma.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComComDezPerguntasENenhumaRespostaEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
        // preparacao
        int comDezPerguntas = 10;
        int eNenhumaResposta = 0;
        Contribuicao contribuicao = new Contribuicao(comDezPerguntas, eNenhumaResposta);

        // acao
        ContribuicaoInvalidaException exception = assertThrows(ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

        // verificacao
        String mensagemEsperada = "Quantidade de respostas é menor do que uma.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComUmaPerguntaEUmaRespostaEPontuacaoMenorDoQueCincoEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
        // preparacao
        int comUmaPergunta = 1;
        int eUmaResposta = 1;
        Contribuicao contribuicao = new Contribuicao(comUmaPergunta, eUmaResposta);

        // acao
        ContribuicaoInvalidaException exception = assertThrows(ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

        // verificacao
        String mensagemEsperada = "Pontuação é menor do que cinco.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComQuatroPerguntasEUmaRespostaEPontuacaoIgualACincoEntaoDeveAtribuirContribuicaoAsTarefasConcluidas() {
        // preparacao
        int comQuatroPerguntas = 4;
        int eUmaResposta = 1;
        Contribuicao contribuicao = new Contribuicao(comQuatroPerguntas, eUmaResposta);

        // acao
        clt.participarDeReuniao(contribuicao);

        // verificacao
        List<String> tarefasConcluidas = clt.getTarefasConcluidas();
        assertEquals(tarefasConcluidas.get(0), contribuicao.toString());
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComCincoPerguntasECincoRespostasEPontuacaoMaiorDoQueCincoEntaoDeveAtribuirContribuicaoAsTarefasConcluidas() {
        // preparacao
        int comCincoPerguntas = 5;
        int eCincoRespostas = 5;
        Contribuicao contribuicao = new Contribuicao(comCincoPerguntas, eCincoRespostas);

        // acao
        clt.participarDeReuniao(contribuicao);

        // verificacao
        String contribuicaoEsperada = contribuicao.toString();

        List<String> tarefasConcluidas = clt.getTarefasConcluidas();
        String contribuicaoRecebida = tarefasConcluidas.get(0);

        assertEquals(contribuicaoRecebida, contribuicaoEsperada);
    }
}