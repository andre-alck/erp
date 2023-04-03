package com.me.erp.participante.interno.funcionario.clt;

import com.me.erp.mocks.CltMock;
import com.me.erp.participante.interno.Perfil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.me.erp.builders.CltMockBuilder.umClt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CltTest {
    CltMock clt;

    @BeforeEach
    public void setup() {
        clt = umClt().comId("408.529.908-55").comOcupacao("Ocupação").comVencimento(2000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(2400).comPausa(90).agora();
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComZeroPerguntasDeveRetornarStatusDaContribuicaoInsuficiente() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(0);
        contribuicao.setQuantidadeDeRespostas(10);

        // acao
        StatusDaContribuicao status = clt.participarDeReuniao(contribuicao);

        // verificacao
        assertEquals(StatusDaContribuicao.INSUFICIENTE, status);
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComZeroRespostasDeveRetornarStatusDaContribuicaoInsuficiente() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(10);
        contribuicao.setQuantidadeDeRespostas(0);

        // acao
        StatusDaContribuicao status = clt.participarDeReuniao(contribuicao);

        // verificacao
        assertEquals(StatusDaContribuicao.INSUFICIENTE, status);
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComUmaPerguntaEUmaRespostaEPontuacaoMenorDoQueCincoDeveRetornarStatusDaContribuicaoInsuficiente() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(1);
        contribuicao.setQuantidadeDeRespostas(1);

        // acao
        StatusDaContribuicao status = clt.participarDeReuniao(contribuicao);

        // verificacao
        assertEquals(StatusDaContribuicao.INSUFICIENTE, status);
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComUmaPerguntaEUmaRespostaEPontuacaoIgualACincoDeveRetornarStatusDaContribuicaoInsuficiente() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(4);
        contribuicao.setQuantidadeDeRespostas(1);

        // acao
        StatusDaContribuicao status = clt.participarDeReuniao(contribuicao);

        // verificacao
        assertEquals(StatusDaContribuicao.SUFICIENTE, status);
    }

    @Test
    public void dadoCltQuandoTestadoMetodoParticiparDeReuniaoComUmaPerguntaEUmaRespostaEPontuacaoMaiorDoQueCincoDeveRetornarStatusDaContribuicaoInsuficiente() {
        // preparacao
        Contribuicao contribuicao = new Contribuicao();
        contribuicao.setQuantidadeDePerguntas(5);
        contribuicao.setQuantidadeDeRespostas(5);

        // acao
        StatusDaContribuicao status = clt.participarDeReuniao(contribuicao);

        // verificacao
        assertEquals(StatusDaContribuicao.SUFICIENTE, status);
    }
}