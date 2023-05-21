package com.me.erp.dao.participante.interno.funcionario.supervisor.supervisordeti.supervisordetihelper;

import com.me.erp.participante.interno.funcionario.supervisor.supervisordeti.SupervisorDeTi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SupervisorDeTiDaoTestHelperJdbcImpl implements SupervisorDeTiDaoTestHelper {

  @Autowired private JdbcTemplate jdbcTemplate;

  @Override
  public void criaRegistroDeSupervisorDeTi(SupervisorDeTi supervisorDeTi) {
    String sqlParaCriarRegistroNaTabelaDeParticipantes =
        "insert into erpparti (c_idparti, c_ocupparti, n_vencparti) values (?, ?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeParticipantes,
        supervisorDeTi.getId(),
        supervisorDeTi.getOcupacao(),
        supervisorDeTi.getVencimento());

    String sqlParaCriarRegistroNaTabelaDeParticipantesInternos =
        "insert into erpinter (c_idparti, c_senhinter) values (?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeParticipantesInternos,
        supervisorDeTi.getId(),
        supervisorDeTi.getCredenciais().getSenha());

    String sqlParaCriarRegistroNaTabelaDeFuncionarios =
        "insert into erpfunci (c_idparti, n_cargfunci, n_pausfunci, c_tipofunci) values (?, ?, ?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeFuncionarios,
        supervisorDeTi.getId(),
        supervisorDeTi.getCargaHorariaSemanal(),
        supervisorDeTi.getPausa(),
        "Supervisor de Ti");

    String sqlParaCriarRegistroNaTabelaDeTarefasConcluidas =
        "insert into erptaref (c_idparti, c_desctaref) values (?, ?)";
    for (String tarefa : supervisorDeTi.getTarefasConcluidas()) {
      jdbcTemplate.update(
          sqlParaCriarRegistroNaTabelaDeTarefasConcluidas, supervisorDeTi.getId(), tarefa);
    }
  }
}
