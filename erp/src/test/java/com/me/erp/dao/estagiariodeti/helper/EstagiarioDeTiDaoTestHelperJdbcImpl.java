package com.me.erp.dao.estagiariodeti.helper;

import com.me.erp.participante.interno.funcionario.ti.EstagiarioDeTi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EstagiarioDeTiDaoTestHelperJdbcImpl implements EstagiarioDeTiDaoTestHelper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void deletaRegistrosDeEstagiarioDeTi() {
        String sqlParaDeletarRegistrosDaTabelaDeFuncionarios = "delete from erpfunci;";
        String sqlParaDeletarRegistrosDaTabelaDeParticipantesInternos = "delete from erpinter;";
        String sqlParaDeletarRegistrosDaTabelaDeParticipantes = "delete from erpparti;";

        jdbcTemplate.update(sqlParaDeletarRegistrosDaTabelaDeFuncionarios);
        jdbcTemplate.update(sqlParaDeletarRegistrosDaTabelaDeParticipantesInternos);
        jdbcTemplate.update(sqlParaDeletarRegistrosDaTabelaDeParticipantes);
    }

    @Override
    public void criaRegistroDeEstagiarioDeTi(EstagiarioDeTi estagiarioDeTi) {
        String sqlParaCriarRegistroNaTabelaDeParticipantes = "insert into erpparti (c_idparti, c_ocupparti, n_vencparti) values (?, ?, ?)";
        int insertA = jdbcTemplate.update(sqlParaCriarRegistroNaTabelaDeParticipantes, estagiarioDeTi.getId(), estagiarioDeTi.getOcupacao(), estagiarioDeTi.getVencimento());

        String sqlParaCriarRegistroNaTabelaDeParticipantesInternos = "insert into erpinter (c_idparti, c_senhinter) values (?, ?)";
        int insertB = jdbcTemplate.update(sqlParaCriarRegistroNaTabelaDeParticipantesInternos, estagiarioDeTi.getId(), estagiarioDeTi.getCredenciais().getSenha());

        String sqlParaCriarRegistroNaTabelaDeFuncionarios = "insert into erpfunci (c_idparti, n_cargfunc, n_pausfunc, c_tipofunc) values (?, ?, ?, ?)";
        int insertC = jdbcTemplate.update(sqlParaCriarRegistroNaTabelaDeFuncionarios, estagiarioDeTi.getId(), estagiarioDeTi.getCargaHorariaSemanal(), estagiarioDeTi.getPausa(), "Estagiário de Ti");
    }
}
