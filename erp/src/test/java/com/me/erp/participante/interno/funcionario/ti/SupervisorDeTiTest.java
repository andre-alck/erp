package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.builders.DesenvolvedorBuilder;
import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.builders.SupervisorDeTiBuilder;
import com.me.erp.participante.interno.Perfil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.me.erp.builders.DesenvolvedorBuilder.umDesenvolvedor;
import static com.me.erp.builders.EstagiarioDeTiBuilder.umEstagiarioDeTi;
import static com.me.erp.builders.SupervisorDeTiBuilder.umSupervisorDeTi;
import static org.junit.jupiter.api.Assertions.*;

class SupervisorDeTiTest {
    EstagiarioDeTiBuilder estagiarioDeTiBuilder;
    DesenvolvedorBuilder desenvolvedorBuilder;
    SupervisorDeTiBuilder supervisorDeTiBuilder;


    @BeforeEach
    void setup() {
        estagiarioDeTiBuilder = umEstagiarioDeTi().comId("358.692.570-00").comOcupacao("Ocupação").comVencimento(1000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(30);
        desenvolvedorBuilder = umDesenvolvedor().comId("314.986.890-43").comOcupacao("Ocupação").comVencimento(2500).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(90);
        supervisorDeTiBuilder = umSupervisorDeTi().comId("408.529.908-55").comOcupacao("Ocupação").comVencimento(5000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(1950).comPausa(90);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoPromoverComEstagiarioDeTiDeveRetornarTrue() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
        EstagiarioDeTi estagiarioDeTi = estagiarioDeTiBuilder.agora();

        // acao
        boolean promoveu = supervisorDeTi.promover(estagiarioDeTi);

        // verificacao
        assertTrue(promoveu);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoPromoverComDesenvolvedorDeveRetornarFalse() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
        Desenvolvedor desenvolvedor = desenvolvedorBuilder.agora();

        // acao
        boolean promoveu = supervisorDeTi.promover(desenvolvedor);

        // verificacao
        assertFalse(promoveu);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoPromoverComSupervisorDeTiDeveRetornarTrue() {
        // preparacao
        SupervisorDeTi supervisorDeTi1 = supervisorDeTiBuilder.agora();
        SupervisorDeTi supervisorDeTi2 = supervisorDeTiBuilder.agora();

        // acao
        boolean promoveu = supervisorDeTi1.promover(supervisorDeTi2);

        // verificacao
        assertFalse(promoveu);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoResolverChamadosComVinteChamadosDeveRetornarVinte() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

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
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

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
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

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
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

        final String PROGRAMACAO = "Programação Nível SR.";

        // acao
        String programacao = supervisorDeTi.programar();

        // verificacao
        assertEquals(PROGRAMACAO, programacao);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComMenosDeDezLetrasDeveRetornarAviso() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

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
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

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
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

        final String relatorio = "...........";
        final String resultadoEsperado = supervisorDeTi.getId() + ": " + relatorio;

        // acao
        String resultado = supervisorDeTi.gerarRelatorio(relatorio);

        // verificacao
        assertEquals(resultado, resultadoEsperado);
    }
}