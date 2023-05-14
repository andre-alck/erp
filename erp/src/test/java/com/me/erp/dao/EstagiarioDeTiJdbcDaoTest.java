package com.me.erp.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class EstagiarioDeTiJdbcDaoTest {

    @Autowired
    EstagiarioDeTiJdbcDao estagiarioDeTiJdbcDao;

    @Test
    void dadoEstagiarioDeTiJdbcDaoQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
        // acao
        EmptyResultDataAccessException exception = assertThrows(EmptyResultDataAccessException.class, () -> estagiarioDeTiJdbcDao.resgataPorId("id"));

        // verificacao
        String mensagemEsperada = "Incorrect result size: expected 1, actual 0";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

}