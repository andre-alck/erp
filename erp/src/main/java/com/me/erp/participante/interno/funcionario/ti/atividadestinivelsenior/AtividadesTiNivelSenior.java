package com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior;

import com.me.erp.participante.interno.funcionario.ti.atividadestinivelpleno.AtividadesTiNivelPleno;

public interface AtividadesTiNivelSenior extends AtividadesTiNivelPleno {
  String gerarRelatorio(Relatorio relatorio);
}
