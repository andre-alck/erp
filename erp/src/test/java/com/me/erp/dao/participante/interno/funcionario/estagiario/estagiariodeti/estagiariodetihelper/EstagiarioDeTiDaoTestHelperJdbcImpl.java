package com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti.estagiariodetihelper;

import com.me.erp.dao.participante.daotesthelper.CriaRegistroDaoTestHelper;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EstagiarioDeTiDaoTestHelperJdbcImpl
    implements CriaRegistroDaoTestHelper<EstagiarioDeTi> {

  @Autowired private JdbcTemplate jdbcTemplate;

  @Override
  public void cria(EstagiarioDeTi estagiarioDeTi) {
    String sqlParaCriarRegistroNaTabelaDeParticipantes =
        "insert into erpparti (c_idparti, c_ocupparti, n_vencparti) values (?, ?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeParticipantes,
        estagiarioDeTi.getId(),
        estagiarioDeTi.getOcupacao(),
        estagiarioDeTi.getVencimento());

    String sqlParaCriarRegistroNaTabelaDeParticipantesInternos =
        "insert into erpinter (c_idparti, c_senhinter) values (?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeParticipantesInternos,
        estagiarioDeTi.getId(),
        estagiarioDeTi.getCredenciais().getSenha());

    String sqlParaCriarRegistroNaTabelaDeFuncionarios =
        "insert into erpfunci (c_idparti, n_cargfunci, n_pausfunci, c_tipofunci) values (?, ?, ?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeFuncionarios,
        estagiarioDeTi.getId(),
        estagiarioDeTi.getCargaHorariaSemanal(),
        estagiarioDeTi.getPausa(),
        "Estagiário de Ti");

    String sqlParaCriarRegistroNaTabelaDeTarefasConcluidas =
        "insert into erptaref (c_idparti, c_desctaref) values (?, ?)";
    for (String tarefa : estagiarioDeTi.getTarefasConcluidas()) {
      jdbcTemplate.update(
          sqlParaCriarRegistroNaTabelaDeTarefasConcluidas, estagiarioDeTi.getId(), tarefa);
    }
  }
}
