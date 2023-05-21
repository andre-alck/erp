package com.me.erp.dao.participante.interno.funcionario.clt.desenvolvedor.desenvolvedorhelper;

import com.me.erp.participante.interno.funcionario.clt.desenvolvedor.Desenvolvedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DesenvolvedorDaoTestHelperJdbcImpl implements DesenvolvedorDaoTestHelper {

  @Autowired private JdbcTemplate jdbcTemplate;

  @Override
  public void criaRegistroDeDesenvolvedor(Desenvolvedor desenvolvedor) {
    String sqlParaCriarRegistroNaTabelaDeParticipantes =
        "insert into erpparti (c_idparti, c_ocupparti, n_vencparti) values (?, ?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeParticipantes,
        desenvolvedor.getId(),
        desenvolvedor.getOcupacao(),
        desenvolvedor.getVencimento());

    String sqlParaCriarRegistroNaTabelaDeParticipantesInternos =
        "insert into erpinter (c_idparti, c_senhinter) values (?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeParticipantesInternos,
        desenvolvedor.getId(),
        desenvolvedor.getCredenciais().getSenha());

    String sqlParaCriarRegistroNaTabelaDeFuncionarios =
        "insert into erpfunci (c_idparti, n_cargfunci, n_pausfunci, c_tipofunci) values (?, ?, ?, ?)";
    jdbcTemplate.update(
        sqlParaCriarRegistroNaTabelaDeFuncionarios,
        desenvolvedor.getId(),
        desenvolvedor.getCargaHorariaSemanal(),
        desenvolvedor.getPausa(),
        "Desenvolvedor");

    String sqlParaCriarRegistroNaTabelaDeTarefasConcluidas =
        "insert into erptaref (c_idparti, c_desctaref) values (?, ?)";
    for (String tarefa : desenvolvedor.getTarefasConcluidas()) {
      jdbcTemplate.update(
          sqlParaCriarRegistroNaTabelaDeTarefasConcluidas, desenvolvedor.getId(), tarefa);
    }
  }
}
