package com.me.erp.participante.interno.funcionario.supervisor.supervisordeti;

import com.me.erp.participante.interno.Credenciais;
import java.util.List;

public class SupervisorDeTiFactory {

  private SupervisorDeTiFactory() {}

  public static SupervisorDeTi daBaseDeDados(
      String id,
      String ocupacao,
      double vencimento,
      List<String> tarefasConcluidas,
      String senha,
      double cargaHorariaSemanal,
      double pausa) {
    SupervisorDeTi supervisorDeTi = new SupervisorDeTi();
    supervisorDeTi.setId(id);
    supervisorDeTi.setOcupacao(ocupacao);
    supervisorDeTi.setVencimento(vencimento);
    supervisorDeTi.setTarefasConcluidas(tarefasConcluidas);
    supervisorDeTi.setCredenciais(new Credenciais(id, senha));
    supervisorDeTi.setCargaHorariaSemanal(cargaHorariaSemanal);
    supervisorDeTi.setPausa(pausa);

    return supervisorDeTi;
  }
}
