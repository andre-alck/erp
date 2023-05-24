package com.me.erp.dao.participante.daotesthelper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeletaRegistrosDaoTestHelperJdbcImpl implements DeletaRegistrosDaoTestHelper {

  @Autowired JdbcTemplate jdbcTemplate;

  @Override
  public void cleanUp() {
    List<String> queries =
        List.of(
            "delete from erpfunci",
            "delete from erptaref",
            "delete from erpinter",
            "delete from erpexter",
            "delete from erpparti");
    for (String query : queries) {
      jdbcTemplate.update(query);
    }
  }
}
