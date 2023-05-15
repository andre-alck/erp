package com.me.erp.dao.estagiarioDeTi;

import com.me.erp.dao.Dao;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.ti.EstagiarioDeTi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EstagiarioDeTiDaoJdbcImpl implements Dao<EstagiarioDeTi> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<EstagiarioDeTi> rowMapper = (rs, rowNum) -> {
        String bdid = rs.getString("c_idparti");
        String bdocup = rs.getString("c_ocupparti");
        double bdvenc = rs.getDouble("n_vencparti");
        String bdsenha = rs.getString("c_senhinter");
        double bdcargfunc = rs.getDouble("n_cargfunc");
        double n_pausfunc = rs.getDouble("n_pausfunc");

        EstagiarioDeTi estagiarioDeTi = new EstagiarioDeTi();
        estagiarioDeTi.setId(bdid);
        estagiarioDeTi.setOcupacao(bdocup);
        estagiarioDeTi.setVencimento(bdvenc);
        estagiarioDeTi.setCredenciais(new Credenciais(bdid, bdsenha));
        estagiarioDeTi.setCargaHorariaSemanal(bdcargfunc);
        estagiarioDeTi.setPausa(n_pausfunc);

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
