package com.me.erp.participante.interno.funcionario.estagiario;

import com.me.erp.builders.EstagiarioMockBuilder;
import com.me.erp.mocks.EstagiarioMock;
import com.me.erp.participante.interno.Credenciais;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static com.me.erp.builders.DocumentacaoBuilder.umDocumentacao;
import static com.me.erp.builders.EstagiarioMockBuilder.umEstagiarioMock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EstagiarioTest {
    EstagiarioMockBuilder builder;

    @BeforeEach
    void setup() {
        builder = umEstagiarioMock().comOcupacao("Ocupação").comVencimento(1000).comTarefasConcluidas(new ArrayList<>()).comCredenciais(new Credenciais()).comPerfil(new Credenciais()).comCargaHorariaSemanal(1950).comPausa(30);
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComIdNuloDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        EstagiarioMock estagiario = builder.comId(null).agora();

        String doEstagiario = estagiario.getId();
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(5).comCriacao(agora).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        assertEquals("Id é nulo.", exception.getMessage());
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComIdEmBrancoDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String emBranco = "";
        EstagiarioMock estagiario = builder.comId(emBranco).agora();

        String doEstagiario = estagiario.getId();
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(5).comCriacao(agora).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        assertEquals("Id está em branco.", exception.getMessage());
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComIdSomenteComEspacosDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String sendoSomenteEspacos = "     ";
        EstagiarioMock estagiario = builder.comId(sendoSomenteEspacos).agora();

        String doEstagiario = estagiario.getId();
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(5).comCriacao(agora).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        assertEquals("Id está em branco.", exception.getMessage());
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComQuantidadeDePaginasMenorDoQueUmDeveDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String regular = "408.529.908-55";
        EstagiarioMock estagiario = builder.comId(regular).agora();

        String doEstagiario = estagiario.getId();
        int nenhuma = 0;
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(nenhuma).comCriacao(agora).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        assertEquals("Quantidade de páginas é menor do que uma.", exception.getMessage());
    }

    @Test
    void dadoEstagiarioQuandoTestadoMetodoDocumentarComDataPosteriorAAgoraDeveLancarExcecaoDocumentacaoInvalidaException() {
        // preparacao
        String regular = "69.534.723/0001-77";
        EstagiarioMock estagiario = builder.comId(regular).agora();

        String doEstagiario = estagiario.getId();
        LocalDateTime daquiAPouco = LocalDateTime.now().plusMinutes(1);
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(5).comCriacao(daquiAPouco).agora();

        // acao
        DocumentacaoInvalidaException exception = assertThrows(DocumentacaoInvalidaException.class, () -> estagiario.documentar(documentacao));

        // verificacao
        assertEquals("Data de criação é futura.", exception.getMessage());
    }
}