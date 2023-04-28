package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.builders.DesenvolvedorBuilder;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelpleno.AtividadesTiNivelPlenoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.me.erp.builders.DesenvolvedorBuilder.umDesenvolvedor;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DesenvolvedorTest {
    DesenvolvedorBuilder builder;

    @BeforeEach
    void setup() {
        AtividadesTiNivelPlenoImpl service = new AtividadesTiNivelPlenoImpl();
        builder = umDesenvolvedor().comAtividadesTiNivelPleno(service);
    }

    @Test
    void dadoDesenvolvedorQuandoTestadoMetodoResolverChamadosComDezChamadosDeveRetornarDez() {
        // preparacao
        Desenvolvedor desenvolvedor = builder.agora();

        final int quantidadeDeChamados = 10;
        final int quantidadeEsperada = quantidadeDeChamados;

        // acao
        int quantidadeDeChamadosResolvidos = desenvolvedor.resolverChamados(quantidadeDeChamados);

        // verificacao
        assertEquals(quantidadeEsperada, quantidadeDeChamadosResolvidos);
    }

    @Test
    void dadoDesenvolvedorQuandoTestadoMetodoResolverChamadosComMenosUmChamadoDeveRetornarZero() {
        // preparacao
        Desenvolvedor desenvolvedor = builder.agora();

        final int quantidadeDeChamados = -1;
        final int quantidadeEsperada = 0;

        // acao
        int quantidadeDeChamadosResolvidos = desenvolvedor.resolverChamados(quantidadeDeChamados);

        // verificacao
        assertEquals(quantidadeEsperada, quantidadeDeChamadosResolvidos);
    }

    @Test
    void dadoDesenvolvedorQuandoTestadoMetodoResolverChamadosComQuantidadesAceitaveisDeveRetornarTalQuantidade() {
        // preparacao
        Desenvolvedor desenvolvedor = builder.agora();

        List<Integer> quantidadeDeChamados = List.of(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10);
        List<Integer> quantidadeDeChamadosResolvidosIndividualmente = new ArrayList<>();

        // acao
        for (int quantidade : quantidadeDeChamados) {
            int quantidadeDeChamadosResolvidos = desenvolvedor.resolverChamados(quantidade);
            quantidadeDeChamadosResolvidosIndividualmente.add(quantidadeDeChamadosResolvidos);
        }

        // verificacao
        assertEquals(quantidadeDeChamadosResolvidosIndividualmente, quantidadeDeChamados);
    }

    @Test
    void dadoDesenvolvedorQuandoTestadoMetodoProgramarDeveRetornarProgramacaoNivelPl() {
        // preparacao
        Desenvolvedor desenvolvedor = builder.agora();

        final String PROGRAMACAO = "Programação Nível PL.";

        // acao
        String programacao = desenvolvedor.programar();

        // verificacao
        assertEquals(PROGRAMACAO, programacao);
    }
}