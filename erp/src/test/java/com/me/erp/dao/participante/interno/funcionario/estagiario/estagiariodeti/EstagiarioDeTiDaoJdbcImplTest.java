package com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti;

import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.dao.participante.daotesthelper.DaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.interno.funcionario.clt.estagiario.estagiariodeti.EstagiarioDeTiDaoJdbcImpl;
import com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti.estagiariodetihelper.EstagiarioDeTiDaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.tarefasconcluidashelper.TarefasConcluidasDaoTestHelperJdbcImpl;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
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
class EstagiarioDeTiDaoJdbcImplTest {

    @Autowired
    EstagiarioDeTiDaoJdbcImpl estagiarioDeTiJdbcDao;

    @Autowired
    EstagiarioDeTiDaoTestHelperJdbcImpl estagiarioDeTiDaoTestAuxJdbc;

    @Autowired
    TarefasConcluidasDaoTestHelperJdbcImpl tarefasConcluidasDaoTestHelperJdbc;

    @Autowired
    DaoTestHelperJdbcImpl daoTestHelperJdbc;

    EstagiarioDeTiBuilder builder;

    @BeforeEach
    void setup() {
        String cpf = "53576485768";
        builder = umEstagiarioDeTi().comId(cpf).comOcupacao("Ocupação").comVencimento(0).comTarefasConcluidas(new ArrayList<>()).comCredenciais(new Credenciais(cpf, "123")).comCargaHorariaSemanal(1950).comPausa(0);

        daoTestHelperJdbc.cleanUp();
    }

    @Test
    void dadoEstagiarioDeTiJdbcDaoQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveLancarEmptyResultDataAccessException() {
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
        tarefasConcluidasDaoTestHelperJdbc.criaRegistroDeTarefaConcluidaComParticipanteExistente(estagiarioDeTi.getId(), "descricao");
        Optional<EstagiarioDeTi> possivelEstagiarioDeTi = estagiarioDeTiJdbcDao.resgataPorId(estagiarioDeTi.getId());

        // verificacao
        assertTrue(possivelEstagiarioDeTi.isPresent());
    }
}