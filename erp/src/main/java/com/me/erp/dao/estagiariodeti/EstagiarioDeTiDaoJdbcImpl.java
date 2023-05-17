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

import static com.me.erp.factories.participante.interno.funcionario.estagiario.EstagiarioDeTiFactory.daBaseDeDados;


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

        // TODO(🙋‍♂️): resgatar tarefas cadastradas no banco
        List<String> mocktarefas = new ArrayList<>();

        return daBaseDeDados(id, ocupacao, vencimento, mocktarefas, senha, cargaHorariaSemanal, pausa);
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
                                AND erpfunci.c_tipofunc = "Estagiário de Ti"
                """;

        EstagiarioDeTi estagiarioDeTi = jdbcTemplate.queryForObject(sql, rowMapper, id);

        return Optional.ofNullable(estagiarioDeTi);
    }
}
