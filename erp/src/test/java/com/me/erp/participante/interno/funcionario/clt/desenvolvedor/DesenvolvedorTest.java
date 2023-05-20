package com.me.erp.participante.interno.funcionario.clt.desenvolvedor;

import static com.me.erp.builders.DesenvolvedorBuilder.umDesenvolvedor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.me.erp.builders.DesenvolvedorBuilder;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelpleno.AtividadesTiNivelPlenoImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DesenvolvedorTest {
    DesenvolvedorBuilder builder;

    @BeforeEach
    void setup() {
        AtividadesTiNivelPlenoImpl atividadesTiNivelPleno = new AtividadesTiNivelPlenoImpl();
        builder = umDesenvolvedor().comAtividadesTiNivelPleno(atividadesTiNivelPleno);
    }

    @Test
    void dadoDesenvolvedorQuandoTestadoMetodoResolverChamadosComMenosUmChamadoEntaoDeveRetornarZero() {
        // preparacao
        Desenvolvedor desenvolvedor = builder.agora();

        int quantidadeInvalida = -1;

        // acao
        int result = desenvolvedor.resolverChamados(quantidadeInvalida);

        // verificacao
        int quantidadeDeChamadosResolvidosEsperada = 0;
        int quantidadeDeChamadosResolvidosRecebida = result;
        assertEquals(quantidadeDeChamadosResolvidosEsperada, quantidadeDeChamadosResolvidosRecebida);
    }

    @Test
    void dadoDesenvolvedorQuandoTestadoMetodoResolverChamadosComDezChamadosEntaoDeveResolverDezChamados() {
        // preparacao
        Desenvolvedor desenvolvedor = builder.agora();

        int quantidadeValida = 10;

        // acao
        int result = desenvolvedor.resolverChamados(quantidadeValida);

        // verificacao
        int quantidadeDeChamadosResolvidosEsperada = 10;
        int quantidadeDeChamadosResolvidosRecebida = result;
        assertEquals(quantidadeDeChamadosResolvidosEsperada, quantidadeDeChamadosResolvidosRecebida);
    }

    @Test
    void dadoDesenvolvedorQuandoTestadoMetodoResolverChamadosComQuantidadesAceitaveisEntaoDeveResolverQuantidadeFornecida() {
        // preparacao
        Desenvolvedor desenvolvedor = builder.agora();

        List<Integer> umMonteDeQuantidadeDeChamados = List.of(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10);
        List<Integer> umMonteDeQuantidadeDeChamadosResolvidos = new ArrayList<>();

        // acao
        for (int certaQuantidadeDeChamados : umMonteDeQuantidadeDeChamados) {
            int quantidadeDeChamadosResolvidos = desenvolvedor.resolverChamados(certaQuantidadeDeChamados);
            umMonteDeQuantidadeDeChamadosResolvidos.add(quantidadeDeChamadosResolvidos);
        }

        // verificacao
        List<Integer> quantidadeDeChamadosResolvidosEsperada = umMonteDeQuantidadeDeChamados;
        List<Integer> quantidadeDeChamadosResolvidosRecebida = umMonteDeQuantidadeDeChamadosResolvidos;
        assertEquals(quantidadeDeChamadosResolvidosEsperada, quantidadeDeChamadosResolvidosRecebida);
    }

    @Test
    void dadoDesenvolvedorQuandoTestadoMetodoProgramarEntaoDeveRetornarProgramacaoNivelPl() {
        // preparacao
        Desenvolvedor desenvolvedor = builder.agora();

        // acao
        String result = desenvolvedor.programar();

        // verificacao
        String programacaoEsperada = "Programação Nível PL.";
        String programacaoRecebida = result;
        assertEquals(programacaoEsperada, programacaoRecebida);
    }
}