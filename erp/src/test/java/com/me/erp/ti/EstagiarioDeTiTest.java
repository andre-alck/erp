package com.me.erp.ti;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EstagiarioDeTiTest {
    EstagiarioDeTi estagiarioDeTi;

    @BeforeEach
    void setUp() {
        estagiarioDeTi = new EstagiarioDeTi();
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoDocumentarDeveRetornarDocumentacaoNivelJr() {
        // preparacao
        final String DOCUMENTACAO = "Documentação Nível JR.";

        // acao
        String documentacao = estagiarioDeTi.documentar(DOCUMENTACAO);

        // verificacao
        assertEquals(DOCUMENTACAO, documentacao);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoProgramarDeveRetornarProgramacaoNivelJr() {
        // preparacao
        final String PROGRAMACAO = "Programação Nível JR.";

        // acao
        String programacao = estagiarioDeTi.programar();

        // verificacao
        assertEquals(PROGRAMACAO, programacao);
    }
}