package com.me.erp.participante.interno.funcionario.ti.atividadestinivelpleno;

public class AtividadesTiNivelPlenoImpl implements AtividadesTiNivelPleno {

  @Override
  public String programar() {
    return "Programação Nível PL.";
  }

  @Override
  public int resolverChamados(int quantidadeDeChamados) {
    int quantidadeDeChamadosResolvidos;

    if (quantidadeDeChamados <= 0) {
      quantidadeDeChamadosResolvidos = 0;
      return quantidadeDeChamadosResolvidos;
    }

    if (quantidadeDeChamados >= 10) {
      quantidadeDeChamadosResolvidos = 10;
      return quantidadeDeChamadosResolvidos;
    }

    quantidadeDeChamadosResolvidos = quantidadeDeChamados;
    return quantidadeDeChamadosResolvidos;
  }
}
