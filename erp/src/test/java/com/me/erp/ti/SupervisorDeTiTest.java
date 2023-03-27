package com.me.erp.ti;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SupervisorDeTiTest {
    SupervisorDeTi supervisorDeTi;

    @BeforeEach
    void setup() {
        supervisorDeTi = new SupervisorDeTi();
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoResolverChamadosComVinteChamadosDeveRetornarVinte() {
        // preparacao
        final int quantidadeDeChamados = 20;
        final int quantidadeEsperada = quantidadeDeChamados;

        // acao
        int quantidadeDeChamadosResolvidos = supervisorDeTi.resolverChamados(quantidadeDeChamados);

        // verificacao
        assertEquals(quantidadeEsperada, quantidadeDeChamadosResolvidos);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoResolverChamadosComMenosUmChamadoDeveRetornarZero() {
        // preparacao
        final int quantidadeDeChamados = -1;
        final int quantidadeEsperada = 0;

        // acao
        int quantidadeDeChamadosResolvidos = supervisorDeTi.resolverChamados(quantidadeDeChamados);

        // verificacao
        assertEquals(quantidadeEsperada, quantidadeDeChamadosResolvidos);
    }
//
    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoResolverChamadosComQuantidadesAceitaveisDeveRetornarTalQuantidade() {
        // preparacao
        List<Integer> quantidadeDeChamados = List.of(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<Integer> quantidadeDeChamadosResolvidosIndividualmente = new ArrayList<>();

        // acao
        for (int quantidade : quantidadeDeChamados) {
            int quantidadeDeChamadosResolvidos = supervisorDeTi.resolverChamados(quantidade);
            quantidadeDeChamadosResolvidosIndividualmente.add(quantidadeDeChamadosResolvidos);
        }

        // verificacao
        assertEquals(quantidadeDeChamadosResolvidosIndividualmente, quantidadeDeChamados);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoDocumentarDeveRetornarDocumentacaoNivelSr() {
        // preparacao
        final String DOCUMENTACAO = "Documentação Nível SR.";

        // acao
        String documentacao = supervisorDeTi.documentar(DOCUMENTACAO);

        // verificacao
        assertEquals(DOCUMENTACAO, documentacao);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoProgramarDeveRetornarDocumentacaoNivelSr() {
        // preparacao
        final String PROGRAMACAO = "Programação Nível SR.";

        // acao
        String programacao = supervisorDeTi.programar();

        // verificacao
        assertEquals(PROGRAMACAO, programacao);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComMenosDeDezLetrasDeveRetornarAviso() {
        // preparacao
        final String relatorio = ".";
        final String resultadoEsperado = "Por favor, acrescente detalhes ao seu relatório.";

        // acao
        String resultado = supervisorDeTi.gerarRelatorio(relatorio);

        // verificacao
        assertEquals(resultado, resultadoEsperado);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComDezLetrasDeveRetornarRelatorio() {
        // preparacao
        final String relatorio = "..........";
        final String resultadoEsperado = supervisorDeTi.getId() + ": " +  relatorio;

        // acao
        String resultado = supervisorDeTi.gerarRelatorio(relatorio);

        // verificacao
        assertEquals(resultado, resultadoEsperado);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComOnzeLetrasDeveRetornarRelatorio() {
        // preparacao
        final String relatorio = "...........";
        final String resultadoEsperado = supervisorDeTi.getId() + ": " +  relatorio;

        // acao
        String resultado = supervisorDeTi.gerarRelatorio(relatorio);

        // verificacao
        assertEquals(resultado, resultadoEsperado);
    }
}