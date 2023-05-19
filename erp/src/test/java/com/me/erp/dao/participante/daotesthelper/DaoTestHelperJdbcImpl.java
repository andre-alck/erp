package com.me.erp.dao.participante.daotesthelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoTestHelperJdbcImpl implements DaoTestHelper {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void cleanUp() {
        List<String> queries = List.of("delete from erpfunci", "delete from erptaref", "delete from erpinter", "delete from erpexter", "delete from erpparti");
        for (String query : queries) {
            jdbcTemplate.update(query);
        }
    }
}
