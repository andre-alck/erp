package com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti.estagiariodetihelper;

import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EstagiarioDeTiDaoTestHelperJdbcImpl implements EstagiarioDeTiDaoTestHelper {

  @Autowired private JdbcTemplate jdbcTemplate;

  @Override
  public void deletaRegistrosDeEstagiarioDeTi() {
    List<String> queries =
        List.of("delete from erpfunci", "delete from erpinter", "delete from erpparti");
    for (String query : queries) {
      jdbcTemplate.update(query);
    }
  }

  @Override
  public void criaRegistroDeEstagiarioDeTi(EstagiarioDeTi estagiarioDeTi) {
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
