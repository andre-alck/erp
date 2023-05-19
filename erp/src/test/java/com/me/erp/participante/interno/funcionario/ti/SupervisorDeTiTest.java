package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.builders.DesenvolvedorBuilder;
import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.builders.SupervisorDeTiBuilder;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.clt.desenvolvedor.Desenvolvedor;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import com.me.erp.participante.interno.funcionario.supervisor.DemissaoInvalidaException;
import com.me.erp.participante.interno.funcionario.supervisor.PromocaoInvalidaException;
import com.me.erp.participante.interno.funcionario.supervisor.supervisordeti.SupervisorDeTi;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.AtividadesTiNivelSenior;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.AtividadesTiNivelSeniorImpl;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.Relatorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.me.erp.builders.DesenvolvedorBuilder.umDesenvolvedor;
import static com.me.erp.builders.EstagiarioDeTiBuilder.umEstagiarioDeTi;
import static com.me.erp.builders.SupervisorDeTiBuilder.umSupervisorDeTi;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SupervisorDeTiTest {
    EstagiarioDeTiBuilder estagiarioDeTiBuilder;
    DesenvolvedorBuilder desenvolvedorBuilder;
    SupervisorDeTiBuilder supervisorDeTiBuilder;


    @BeforeEach
    void setup() {
        estagiarioDeTiBuilder = umEstagiarioDeTi().comId("358.692.570-00").comOcupacao("Ocupação").comVencimento(1000).comTarefasConcluidas(new ArrayList<>()).comCredenciais(new Credenciais()).comCargaHorariaSemanal(1950).comPausa(30);
        desenvolvedorBuilder = umDesenvolvedor().comId("314.986.890-43").comOcupacao("Ocupação").comVencimento(2500).comTarefasConcluidas(new ArrayList<>()).comCredenciais(new Credenciais()).comCargaHorariaSemanal(1950).comPausa(90);

        AtividadesTiNivelSenior atividadesTiNivelSenior = new AtividadesTiNivelSeniorImpl();
        supervisorDeTiBuilder = umSupervisorDeTi().comId("408.529.908-55").comOcupacao("Ocupação").comVencimento(5000).comTarefasConcluidas(new ArrayList<>()).comCredenciais(new Credenciais()).comPerfil(new Credenciais()).comCargaHorariaSemanal(1950).comPausa(90).comAtividadesTiNivelSenior(atividadesTiNivelSenior);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoPromoverComEstagiarioDeTiEntaoDeveAtribuirPromocaoAsTarefasConcluidas() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
        EstagiarioDeTi estagiarioDeTi = estagiarioDeTiBuilder.agora();

        // acao
        supervisorDeTi.promover(estagiarioDeTi);

        // verificacao
        List<String> tarefasConcluidas = List.of(estagiarioDeTi.getId() + " promovido.");
        assertEquals(tarefasConcluidas, supervisorDeTi.getTarefasConcluidas());
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoPromoverComDesenvolvedorEntaoDeveLancarExcecaoPromocaoInvalidaException() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
        Desenvolvedor desenvolvedor = desenvolvedorBuilder.agora();

        // acao
        PromocaoInvalidaException exception = assertThrows(PromocaoInvalidaException.class, () -> supervisorDeTi.promover(desenvolvedor));

        // verificacao

        assertEquals("Funcionário não é Estagiário de TI.", exception.getMessage());
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoPromoverComSupervisorDeTiEntaoDeveLancarExcecaoPromocaoInvalidaException() {
        // preparacao
        SupervisorDeTi supervisorDeTi1 = supervisorDeTiBuilder.agora();
        SupervisorDeTi supervisorDeTi2 = supervisorDeTiBuilder.agora();

        // acao
        PromocaoInvalidaException exception = assertThrows(PromocaoInvalidaException.class, () -> supervisorDeTi1.promover(supervisorDeTi2));

        // verificacao
        assertEquals("Funcionário não é Estagiário de TI.", exception.getMessage());
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoDemitirComEstagiarioDeTiEntaoDeveAtribuirDemissaoAsTarefasConcluidas() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
        EstagiarioDeTi estagiarioDeTi = estagiarioDeTiBuilder.agora();

        // acao
        supervisorDeTi.demitir(estagiarioDeTi);

        // verificacao
        List<String> tarefasConcluidas = List.of(estagiarioDeTi.getId() + " demitido.");
        assertEquals(tarefasConcluidas, supervisorDeTi.getTarefasConcluidas());
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoDemitirComDesenvolvedorEntaoDeveAtribuirDemissaoAsTarefasConcluidas() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
        Desenvolvedor desenvolvedor = desenvolvedorBuilder.agora();

        // acao
        supervisorDeTi.demitir(desenvolvedor);

        // verificacao
        List<String> tarefasConcluidas = List.of(desenvolvedor.getId() + " demitido.");
        assertEquals(tarefasConcluidas, supervisorDeTi.getTarefasConcluidas());
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoDemitirComSupervisorDeTiEntaoDeveLancarExcecaoDemissaoInvalidaException() {
        // preparacao
        SupervisorDeTi supervisorDeTi1 = supervisorDeTiBuilder.agora();
        SupervisorDeTi supervisorDeTi2 = supervisorDeTiBuilder.agora();

        // acao
        DemissaoInvalidaException exception = assertThrows(DemissaoInvalidaException.class, () -> supervisorDeTi1.demitir(supervisorDeTi2));

        // verificacao
        assertEquals("Funcionário não é Estagiário de TI ou Desenvolvedor.", exception.getMessage());
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

        final String comId = supervisorDeTi.getId();
        final String somenteComPontoFinal = ".";
        Relatorio relatorio = new Relatorio(comId, somenteComPontoFinal);
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

        final String comId = supervisorDeTi.getId();
        final String comDezPontosFinais = "..........";
        Relatorio relatorio = new Relatorio(comId, comDezPontosFinais);
        final String resultadoEsperado = supervisorDeTi.getId() + ": " + comDezPontosFinais;

        // acao
        String resultado = supervisorDeTi.gerarRelatorio(relatorio);

        // verificacao
        assertEquals(resultado, resultadoEsperado);
    }

    @Test
    void dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComOnzeLetrasDeveRetornarRelatorio() {
        // preparacao
        SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

        final String comId = supervisorDeTi.getId();
        final String comOnzePontosFinais = "...........";
        Relatorio relatorio = new Relatorio(comId, comOnzePontosFinais);
        final String resultadoEsperado = supervisorDeTi.getId() + ": " + comOnzePontosFinais;

        // acao
        String resultado = supervisorDeTi.gerarRelatorio(relatorio);

        // verificacao
        assertEquals(resultado, resultadoEsperado);
    }
}