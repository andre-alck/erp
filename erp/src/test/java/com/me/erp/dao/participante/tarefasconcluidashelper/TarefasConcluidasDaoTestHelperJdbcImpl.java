package com.me.erp.dao.participante.tarefasconcluidashelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TarefasConcluidasDaoTestHelperJdbcImpl implements TarefasConcluidasDaoTestHelper {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void criaRegistroDeTarefasConcluida(String descricao) {
        String sqlParaCriarRegistroNaTabelaDeParticipantes = "insert into erpparti (c_idparti, c_ocupparti, n_vencparti) values ('participante', 'ocupacao', 0);";
        jdbcTemplate.update(sqlParaCriarRegistroNaTabelaDeParticipantes);

        String sqlParaCriarPrimeiroRegistroNaTabelaDeTarefas = "insert into erptaref (c_idparti, c_desctaref) values ('participante', 'descricao da tarefa 1');";
        jdbcTemplate.update(sqlParaCriarPrimeiroRegistroNaTabelaDeTarefas);

        String sqlParaCriarSegundoRegistroNaTabelaDeTarefas = "insert into erptaref (c_idparti, c_desctaref) values ('participante', 'descricao da tarefa 2');";
        jdbcTemplate.update(sqlParaCriarSegundoRegistroNaTabelaDeTarefas);
    }
}
