package com.me.erp.dao;

import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.ti.EstagiarioDeTi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.Optional;

import static com.me.erp.builders.EstagiarioDeTiBuilder.umEstagiarioDeTi;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EstagiarioDeTiJdbcDaoTest {

    @Autowired
    EstagiarioDeTiDaoJdbcImpl estagiarioDeTiJdbcDao;

    @Autowired
    EstagiarioDeTiDaoTestAuxJdbcImpl estagiarioDeTiDaoTestAuxJdbc;

    EstagiarioDeTiBuilder builder;

    @BeforeEach
    void setup() {
        String cpf = "53576485768";
        builder = umEstagiarioDeTi().comId(cpf).comOcupacao("Ocupação").comVencimento(0).comTarefasConcluidas(new ArrayList<>()).comCredenciais(new Credenciais(cpf, "123")).comCargaHorariaSemanal(1950).comPausa(0);

        estagiarioDeTiDaoTestAuxJdbc.deletaRegistrosDeEstagiarioDeTi();
    }

    @Test
    void dadoEstagiarioDeTiJdbcDaoQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveLancarExcecaoContribuicaoInvalidaException() {
        // preparacao
        EstagiarioDeTi estagiarioDeTi = builder.agora();

        // acao
        EmptyResultDataAccessException exception = assertThrows(EmptyResultDataAccessException.class, () -> estagiarioDeTiJdbcDao.resgataPorId("id"));

        // verificacao
        String mensagemEsperada = "Incorrect result size: expected 1, actual 0";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    void dadoEstagiarioDeTiJdbcDaoQuandoTestadoMetodoResgataPorIdComUmRegistroNoBancoDeDadosEntaoDeveExistirUmEstagiarioDeTi() {
        // preparacao
        EstagiarioDeTi estagiarioDeTi = builder.agora();

        // acao
        estagiarioDeTiDaoTestAuxJdbc.criaRegistroDeEstagiarioDeTi(estagiarioDeTi);
        Optional<EstagiarioDeTi> possivelEstagiarioDeTi = estagiarioDeTiJdbcDao.resgataPorId(estagiarioDeTi.getId());

        // verificacao
        assertTrue(possivelEstagiarioDeTi.isPresent());
    }

}