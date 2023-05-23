package com.me.erp.dao.participante.interno.funcionario.supervisor.supervisordeti;

import static com.me.erp.participante.interno.funcionario.supervisor.supervisordeti.SupervisorDeTiFactory.daBaseDeDados;

import com.me.erp.dao.Dao;
import com.me.erp.dao.participante.TarefasConcluidasDaoJdbcImpl;
import com.me.erp.participante.interno.funcionario.supervisor.supervisordeti.SupervisorDeTi;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class SupervisorDeTiDaoJdbcImpl implements Dao<SupervisorDeTi> {

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired private TarefasConcluidasDaoJdbcImpl tarefasConcluidasDaoJdbc;

  private RowMapper<SupervisorDeTi> rowMapper =
      (rs, rowNum) -> {
        String id = rs.getString("c_idparti");
        String ocupacao = rs.getString("c_ocupparti");
        double vencimento = rs.getDouble("n_vencparti");
        String senha = rs.getString("c_senhinter");
        double cargaHorariaSemanal = rs.getDouble("n_cargfunci");
        double pausa = rs.getDouble("n_pausfunci");

        Optional<List<String>> possivelTarefasConcluidas =
            tarefasConcluidasDaoJdbc.resgataPorId(id);
        List<String> tarefasConcluidas = possivelTarefasConcluidas.get();

        return daBaseDeDados(
            id, ocupacao, vencimento, tarefasConcluidas, senha, cargaHorariaSemanal, pausa);
      };

  @Override
  public Optional<SupervisorDeTi> resgataPorId(String id) {
    String sql =
        """
                        SELECT
                            erpparti.c_idparti,
                            erpparti.c_ocupparti,
                            erpparti.n_vencparti,
                            erpinter.c_senhinter,
                            erpfunci.n_cargfunci,
                            erpfunci.n_pausfunci,
                            erpfunci.c_tipofunci
                        FROM
                            erpparti
                                INNER JOIN
                            erpinter ON erpparti.c_idparti = erpinter.c_idparti
                                INNER JOIN
                            erpfunci ON erpparti.c_idparti = erpfunci.c_idparti
                        WHERE
                            erpparti.c_idparti = ?
                                AND erpfunci.c_tipofunci = "Supervisor de Ti"
                """;

    SupervisorDeTi supervisorDeTi = jdbcTemplate.queryForObject(sql, rowMapper, id);

    return Optional.ofNullable(supervisorDeTi);
  }

    @Override
    public void registraNovaTarefa(String id, String tarefa) {
        String sql = "insert into erptaref(c_idparti, c_desctaref) values (?, ?)";

        jdbcTemplate.update(sql, id, tarefa);
    }
}
