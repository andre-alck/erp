package com.me.erp.participante.interno.funcionario.estagiario;

import static com.me.erp.builders.DocumentacaoBuilder.umDocumentacao;
import static com.me.erp.builders.EstagiarioMockBuilder.umEstagiarioMock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.me.erp.builders.EstagiarioMockBuilder;
import com.me.erp.mocks.EstagiarioMock;
import com.me.erp.participante.interno.Credenciais;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstagiarioTest {
    EstagiarioMockBuilder builder;

    @BeforeEach
    void setup() {
        builder = umEstagiarioMock().comOcupacao("Ocupação").comVencimento(1000).comTarefasConcluidas(new ArrayList<>()).comCredenciais(new Credenciais()).comPerfil(new Credenciais()).comCargaHorariaSemanal(1950).comPausa(30);
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComIdNuloEntaoDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String nulo = null;
        EstagiarioMock estagiario = builder.comId(nulo).agora();

        String nuloDoEstagiario = estagiario.getId();
        Documentacao documentacao = umDocumentacao().comId(nuloDoEstagiario).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        String mensagemEsperada = "Id é nulo.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComIdEmBrancoEntaoDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String emBranco = "";
        EstagiarioMock estagiario = builder.comId(emBranco).agora();

        String emBrancoDoEstagiario = estagiario.getId();
        Documentacao documentacao = umDocumentacao().comId(emBrancoDoEstagiario).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        String mensagemEsperada = "Id está em branco.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComIdSomenteComEspacosEntaoDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String sendoSomenteEspacos = "     ";
        EstagiarioMock estagiario = builder.comId(sendoSomenteEspacos).agora();

        String sendoSomenteEspacosDoEstagiario = estagiario.getId();
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(sendoSomenteEspacosDoEstagiario).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        String mensagemEsperada = "Id está em branco.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComQuantidadeDePaginasMenorDoQueUmaDeveEntaoDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String regular = "408.529.908-55";
        EstagiarioMock estagiario = builder.comId(regular).agora();

        String regularDoEstagiario = estagiario.getId();
        int zerada = 0;
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(regularDoEstagiario).comQuantidadeDePaginas(zerada).comCriacao(agora).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        String mensagemEsperada = "Quantidade de páginas é menor do que uma.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComDataPosteriorAAgoraEntaoDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String regular = "69.534.723/0001-77";
        EstagiarioMock estagiario = builder.comId(regular).agora();

        String regularDoEstagiario = estagiario.getId();
        int aceitavel = 5;
        LocalDateTime daquiUmMinutinho = LocalDateTime.now().plusMinutes(1);
        Documentacao documentacao = umDocumentacao().comId(regularDoEstagiario).comQuantidadeDePaginas(aceitavel).comCriacao(daquiUmMinutinho).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        String mensagemEsperada = "Data de criação é futura.";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }
}