package com.me.erp;

import com.me.erp.mocks.EstagiarioMock;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.me.erp.builders.DocumentacaoBuilder.umDocumentacao;
import static com.me.erp.builders.EstagiarioMockBuilder.umEstagiarioMock;
import static org.junit.jupiter.api.Assertions.*;

class EstagiarioTest {
    @Test
    void dadoEstagiarioMockQuandoTestadoMetodoDocumentarComIdNuloDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        EstagiarioMock estagiarioMock = umEstagiarioMock().comId(null).comOcupacao("Ocupação").comVencimento(1000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(30).agora();
        Documentacao documentacao = umDocumentacao().comId(estagiarioMock.getId()).comQuantidadeDePaginas(5).comCriacao(LocalDateTime.now()).agora();

        // acao
        StatusDoTrabalho statusDoTrabalho = estagiarioMock.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, statusDoTrabalho);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarComIdEmBrancoDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        EstagiarioMock estagiarioMock = umEstagiarioMock().comId("").comOcupacao("Ocupação").comVencimento(1000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(30).agora();
        Documentacao documentacao = umDocumentacao().comId(estagiarioMock.getId()).comQuantidadeDePaginas(5).comCriacao(LocalDateTime.now()).agora();

        // acao
        StatusDoTrabalho statusDoTrabalho = estagiarioMock.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, statusDoTrabalho);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarComIdSomenteComEspacosDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        EstagiarioMock estagiarioMock = umEstagiarioMock().comId("     ").comOcupacao("Ocupação").comVencimento(1000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(30).agora();
        Documentacao documentacao = umDocumentacao().comId(estagiarioMock.getId()).comQuantidadeDePaginas(5).comCriacao(LocalDateTime.now()).agora();

        // acao
        StatusDoTrabalho statusDoTrabalho = estagiarioMock.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, statusDoTrabalho);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarComQuantidadeDePaginasMenorDoQueUmDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        EstagiarioMock estagiarioMock = umEstagiarioMock().comId("111.222.333-44").comOcupacao("Ocupação").comVencimento(1000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(30).agora();
        Documentacao documentacao = umDocumentacao().comId(estagiarioMock.getId()).comQuantidadeDePaginas(0).comCriacao(LocalDateTime.now()).agora();

        // acao
        StatusDoTrabalho statusDoTrabalho = estagiarioMock.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, statusDoTrabalho);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarComDataPosteriorAAgoraDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        EstagiarioMock estagiarioMock = umEstagiarioMock().comId("111.222.333-44").comOcupacao("Ocupação").comVencimento(1000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(30).agora();
        Documentacao documentacao = umDocumentacao().comId(estagiarioMock.getId()).comQuantidadeDePaginas(1).comCriacao(LocalDateTime.now().plusDays(1)).agora();

        // acao
        StatusDoTrabalho statusDoTrabalho = estagiarioMock.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, statusDoTrabalho);
    }
}