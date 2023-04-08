package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.builders.SupervisorDeTiBuilder;
import com.me.erp.participante.interno.Perfil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.me.erp.builders.SupervisorDeTiBuilder.umSupervisorDeTi;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SupervisorDeTiTest {
    SupervisorDeTiBuilder builder;

    @BeforeEach
    void setup() {
        builder = umSupervisorDeTi().comId("408.529.908-55").comOcupacao("Ocupação").comVencimento(1000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(30);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoResolverChamadosComVinteChamadosDeveRetornarVinte() {
        // preparacao
        SupervisorDeTi supervisorDeTi = builder.agora();

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
        SupervisorDeTi supervisorDeTi = builder.agora();

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
        SupervisorDeTi supervisorDeTi = builder.agora();

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
    void dadoSupervisorDeTiQuandoTestadoMetodoProgramarDeveRetornarDocumentacaoNivelSr() {
        // preparacao
        SupervisorDeTi supervisorDeTi = builder.agora();

        final String PROGRAMACAO = "Programação Nível SR.";

        // acao
        String programacao = supervisorDeTi.programar();

        // verificacao
        assertEquals(PROGRAMACAO, programacao);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComMenosDeDezLetrasDeveRetornarAviso() {
        // preparacao
        SupervisorDeTi supervisorDeTi = builder.agora();

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
        SupervisorDeTi supervisorDeTi = builder.agora();

        final String relatorio = "..........";
        final String resultadoEsperado = supervisorDeTi.getId() + ": " + relatorio;

        // acao
        String resultado = supervisorDeTi.gerarRelatorio(relatorio);

        // verificacao
        assertEquals(resultado, resultadoEsperado);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComOnzeLetrasDeveRetornarRelatorio() {
        // preparacao
        SupervisorDeTi supervisorDeTi = builder.agora();

        final String relatorio = "...........";
        final String resultadoEsperado = supervisorDeTi.getId() + ": " + relatorio;

        // acao
        String resultado = supervisorDeTi.gerarRelatorio(relatorio);

        // verificacao
        assertEquals(resultado, resultadoEsperado);
    }
}