package com.me.erp.participante.interno.funcionario.clt.desenvolvedor;

import com.me.erp.participante.interno.Credenciais;
import java.util.List;

public class DesenvolvedorFactory {
  private DesenvolvedorFactory() {}

  public static Desenvolvedor daBaseDeDados(
      String id,
      String ocupacao,
      double vencimento,
      List<String> tarefasConcluidas,
      String senha,
      double cargaHorariaSemanal,
      double pausa) {
    Desenvolvedor desenvolvedor = new Desenvolvedor();
    desenvolvedor.setId(id);
    desenvolvedor.setOcupacao(ocupacao);
    desenvolvedor.setVencimento(vencimento);
    desenvolvedor.setTarefasConcluidas(tarefasConcluidas);
    desenvolvedor.setCredenciais(new Credenciais(id, senha));
    desenvolvedor.setCargaHorariaSemanal(cargaHorariaSemanal);
    desenvolvedor.setPausa(pausa);

    return desenvolvedor;
  }
}
