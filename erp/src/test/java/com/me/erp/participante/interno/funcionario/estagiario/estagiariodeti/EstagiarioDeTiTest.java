package com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti;

import static com.me.erp.builders.EstagiarioDeTiBuilder.umEstagiarioDeTi;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.participante.interno.funcionario.ti.atividadestiniveljunior.AtividadesTiNivelJuniorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstagiarioDeTiTest {
  EstagiarioDeTiBuilder builder;

  @BeforeEach
  void setup() {
    AtividadesTiNivelJuniorImpl atividadesTiNivelJunior = new AtividadesTiNivelJuniorImpl();
    builder = umEstagiarioDeTi().comAtividadesTiNivelJunior(atividadesTiNivelJunior);
  }

  @Test
  void dadoEstagiarioDeTiQuandoTestadoMetodoProgramarEntaoDeveRetornarJuninho() {
    // preparacao
    EstagiarioDeTi estagiarioDeTi = builder.agora();

    // acao
    String result = estagiarioDeTi.programar();

    // verificacao
    String programacaoEsperada = "Juninho";
    String programacaoRecebida = result;
    assertEquals(programacaoEsperada, programacaoRecebida);
  }
}
