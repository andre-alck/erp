package com.me.erp.dao.participante.daotesthelper.criaregistrohelper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TarefasConcluidasDaoTestHelperJdbcImpl
    implements CriaRegistroDaoTestHelper<TarefasConcluidasDto> {

  @Autowired JdbcTemplate jdbcTemplate;

  @Override
  public void cria(TarefasConcluidasDto tarefasConcluidasDto) {
    String id = tarefasConcluidasDto.id();
    List<String> tarefas = tarefasConcluidasDto.tarefas();

    for (String tarefa : tarefas) {
      String sql =
          "insert into erptaref (c_idparti, c_desctaref) values ('" + id + "', '" + tarefa + "');";
      jdbcTemplate.update(sql);
    }
  }
}
