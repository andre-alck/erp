package com.me.erp.dao.participante;

import com.me.erp.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TarefasConcluidasDaoJdbcImpl implements Dao<List<String>> {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private RowMapper<String> rowMapper = (rs, rowNum) -> {
        return rs.getString("c_desctaref");
    };

    @Override
    public Optional<List<String>> resgataPorId(String id) {
        String sql = "select erptaref.c_desctaref from erptaref where erptaref.c_idparti = ?";

        List<String> tarefas = null;
        try {
            tarefas = jdbcTemplate.query(sql, rowMapper, id);
        } catch (DataAccessException e) {
            //
        }

        return Optional.ofNullable(tarefas);
    }
}
