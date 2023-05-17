package com.me.erp.dao.estagiariodeti;

import com.me.erp.dao.Dao;
import com.me.erp.participante.interno.funcionario.ti.EstagiarioDeTi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EstagiarioDeTiDaoJdbcImpl implements Dao<EstagiarioDeTi> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<EstagiarioDeTi> rowMapper = (rs, rowNum) -> {
        String id = rs.getString("c_idparti");
        String ocupacao = rs.getString("c_ocupparti");
        double vencimento = rs.getDouble("n_vencparti");
        String senha = rs.getString("c_senhinter");
        double cargaHorariaSemanal = rs.getDouble("n_cargfunc");
        double pausa = rs.getDouble("n_pausfunc");

        List<String> mocktarefas = new ArrayList<>();

        EstagiarioDeTi estagiarioDeTi = new EstagiarioDeTi(id, ocupacao, vencimento, mocktarefas, senha, cargaHorariaSemanal, pausa);

        return estagiarioDeTi;
    };

    @Override
    public Optional<EstagiarioDeTi> resgataPorId(String id) {
        String sql = """
                        SELECT
                            erpparti.c_idparti,
                            erpparti.c_ocupparti,
                            erpparti.n_vencparti,
                            erpinter.c_senhinter,
                            erpfunci.n_cargfunc,
                            erpfunci.n_pausfunc,
                            erpfunci.c_tipofunc
                        FROM
                            erpparti
                                INNER JOIN
                            erpinter ON erpparti.c_idparti = erpinter.c_idparti
                                INNER JOIN
                            erpfunci ON erpparti.c_idparti = erpfunci.c_idparti
                        WHERE
                            erpparti.c_idparti = ?
                                AND erpfunci.c_tipofunc = ?
                """;

        EstagiarioDeTi estagiarioDeTi = jdbcTemplate.queryForObject(sql, new Object[]{id, "Estagiário de Ti"}, rowMapper);

        return Optional.ofNullable(estagiarioDeTi);
    }
}
