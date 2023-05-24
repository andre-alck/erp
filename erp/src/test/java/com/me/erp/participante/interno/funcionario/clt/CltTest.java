package com.me.erp.participante.interno.funcionario.clt;

import static com.me.erp.builders.CltMockBuilder.umClt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.me.erp.builders.CltMockBuilder;
import com.me.erp.participante.interno.Credenciais;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CltTest {
  CltMockBuilder builder;

  @BeforeEach
  void setup() {
    builder =
        umClt()
            .comId("408.529.908-55")
            .comOcupacao("Ocupação")
            .comVencimento(2000)
            .comTarefasConcluidas(new ArrayList<>())
            .comCredenciais(new Credenciais())
            .comPerfil(new Credenciais())
            .comCargaHorariaSemanal(2400)
            .comPausa(90);
  }

  @Test
  void
      dadoCltQuandoTestadoMetodoParticiparDeReuniaoComNenhumaPerguntaENenhumaRespostaEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
    // preparacao
    Clt clt = builder.agora();

    int comNenhumaPergunta = 0;
    int eNenhumaResposta = 0;
    Contribuicao contribuicao = new Contribuicao(comNenhumaPergunta, eNenhumaResposta);

    // acao
    ContribuicaoInvalidaException exception =
        assertThrows(
            ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

    // verificacao
    String mensagemEsperada = "Quantidade de perguntas é menor do que uma.";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoCltQuandoTestadoMetodoParticiparDeReuniaoComUmaPerguntaEUmaRespostaEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
    // preparacao
    Clt clt = builder.agora();

    int comUmaPergunta = 1;
    int eUmaResposta = 1;
    Contribuicao contribuicao = new Contribuicao(comUmaPergunta, eUmaResposta);

    // acao
    ContribuicaoInvalidaException exception =
        assertThrows(
            ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

    // verificacao
    String mensagemEsperada = "Pontuação é menor do que cinco.";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoCltQuandoTestadoMetodoParticiparDeReuniaoComComCincoPerguntasENenhumaRespostaEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
    // preparacao
    Clt clt = builder.agora();

    int comCincoPerguntas = 5;
    int masComNenhumaResposta = 0;
    Contribuicao contribuicao = new Contribuicao(comCincoPerguntas, masComNenhumaResposta);

    // acao
    ContribuicaoInvalidaException exception =
        assertThrows(
            ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

    // verificacao
    String mensagemEsperada = "Quantidade de respostas é menor do que uma.";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoCltQuandoTestadoMetodoParticiparDeReuniaoComComNenhumaPerguntaECincoRespostasEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
    // preparacao
    Clt clt = builder.agora();

    int comNenhumaPergunta = 0;
    int masComCincoRespostas = 5;
    Contribuicao contribuicao = new Contribuicao(comNenhumaPergunta, masComCincoRespostas);

    // acao
    ContribuicaoInvalidaException exception =
        assertThrows(
            ContribuicaoInvalidaException.class, () -> clt.participarDeReuniao(contribuicao));

    // verificacao
    String mensagemEsperada = "Quantidade de perguntas é menor do que uma.";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoCltQuandoTestadoMetodoParticiparDeReuniaoComQuatroPerguntasEUmaRespostaEntaoDeveAtribuirContribuicaoAsTarefasConcluidas() {
    // preparacao
    Clt clt = builder.agora();

    int comQuatroPerguntas = 4;
    int eUmaResposta = 1;
    Contribuicao contribuicao = new Contribuicao(comQuatroPerguntas, eUmaResposta);

    // acao
    clt.participarDeReuniao(contribuicao);

    // verificacao
    String contribuicaoEsperada = contribuicao.toString();
    List<String> tarefasConcluidas = clt.getTarefasConcluidas();
    String contribuicaoRecebida = tarefasConcluidas.get(0);
    assertEquals(contribuicaoEsperada, contribuicaoRecebida);
  }

  @Test
  void
      dadoCltQuandoTestadoMetodoParticiparDeReuniaoComCincoPerguntasECincoRespostasEPontuacaoMaiorDoQueCincoEntaoDeveAtribuirContribuicaoAsTarefasConcluidas() {
    // preparacao
    Clt clt = builder.agora();

    int comCincoPerguntas = 5;
    int eCincoRespostas = 5;
    Contribuicao contribuicao = new Contribuicao(comCincoPerguntas, eCincoRespostas);

    // acao
    clt.participarDeReuniao(contribuicao);

    // verificacao
    String contribuicaoEsperada = contribuicao.toString();
    List<String> tarefasConcluidas = clt.getTarefasConcluidas();
    String contribuicaoRecebida = tarefasConcluidas.get(0);
    assertEquals(contribuicaoEsperada, contribuicaoRecebida);
  }
}
