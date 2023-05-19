package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import com.me.erp.participante.interno.funcionario.ti.atividadestiniveljunior.AtividadesTiNivelJuniorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.me.erp.builders.EstagiarioDeTiBuilder.umEstagiarioDeTi;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EstagiarioDeTiTest {
    EstagiarioDeTiBuilder builder;

    @BeforeEach
    void setup() {
        AtividadesTiNivelJuniorImpl service = new AtividadesTiNivelJuniorImpl();
        builder = umEstagiarioDeTi().comAtividadesTiNivelJunior(service);
    }

    @Test
    void dadoEstagiarioDeTiQuandoTestadoMetodoProgramarEntaoDeveRetornarJuninho() {
        // preparacao
        EstagiarioDeTi estagiarioDeTi = builder.agora();

        // acao
        String programacaoRecebida = estagiarioDeTi.programar();

        // verificacao
        String programacaoEsperada = "Juninho";
        assertEquals(programacaoEsperada, programacaoRecebida);
    }
}