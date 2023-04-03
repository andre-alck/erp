package com.me.erp;

import com.me.erp.builders.EstagiarioMockBuilder;
import com.me.erp.mocks.EstagiarioMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.me.erp.builders.DocumentacaoBuilder.umDocumentacao;
import static com.me.erp.builders.EstagiarioMockBuilder.umEstagiarioMock;
import static org.junit.jupiter.api.Assertions.*;

class EstagiarioTest {
    EstagiarioMockBuilder builder;

    @BeforeEach
    void setup() {
        builder = umEstagiarioMock().comOcupacao("Ocupação").comVencimento(1000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(30);
    }

    @Test
    void dadoEstagiarioMockQuandoTestadoMetodoDocumentarComIdNuloDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        EstagiarioMock estagiario = builder.comId(null).agora();

        String doEstagiario = estagiario.getId();
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(5).comCriacao(agora).agora();

        // acao
        StatusDoTrabalho status = estagiario.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, status);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarComIdEmBrancoDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        String emBranco = "";
        EstagiarioMock estagiario = builder.comId(emBranco).agora();

        String doEstagiario = estagiario.getId();
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(5).comCriacao(agora).agora();

        // acao
        StatusDoTrabalho status = estagiario.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, status);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarComIdSomenteComEspacosDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        String sendoSomenteEspacos = "     ";
        EstagiarioMock estagiario = builder.comId(sendoSomenteEspacos).agora();

        String doEstagiario = estagiario.getId();
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(5).comCriacao(agora).agora();

        // acao
        StatusDoTrabalho status = estagiario.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, status);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarComQuantidadeDePaginasMenorDoQueUmDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        String regular = "408.529.908-55";
        EstagiarioMock estagiario = builder.comId(regular).agora();

        String doEstagiario = estagiario.getId();
        int nenhuma = 0;
        LocalDateTime agora = LocalDateTime.now();
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(nenhuma).comCriacao(agora).agora();

        // acao
        StatusDoTrabalho status = estagiario.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, status);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarComDataPosteriorAAgoraDeveRetornarStatusDoTrabalhoIrregular() {
        // preparacao
        String regular = "69.534.723/0001-77";
        EstagiarioMock estagiario = builder.comId(regular).agora();

        String doEstagiario = estagiario.getId();
        LocalDateTime daquiAPouco = LocalDateTime.now().plusMinutes(1);
        Documentacao documentacao = umDocumentacao().comId(doEstagiario).comQuantidadeDePaginas(5).comCriacao(daquiAPouco).agora();

        // acao
        StatusDoTrabalho status = estagiario.documentar(documentacao);

        // verificacao
        assertEquals(StatusDoTrabalho.IRREGULAR, status);
    }
}