package com.me.erp.dao.participante.interno.funcionario.supervisor.supervisordeti;

import static com.me.erp.builders.SupervisorDeTiBuilder.umSupervisorDeTi;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.me.erp.builders.SupervisorDeTiBuilder;
import com.me.erp.dao.participante.daotesthelper.DaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.interno.funcionario.supervisor.supervisordeti.supervisordetihelper.SupervisorDeTiDaoTestHelperJdbcImpl;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.supervisor.supervisordeti.SupervisorDeTi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

@SpringBootTest
public class SupervisorDeTiDaoJdbcImplTest {

    @Autowired
    SupervisorDeTiDaoJdbcImpl supervisorDeTiDaoJdbc;

    @Autowired
    SupervisorDeTiDaoTestHelperJdbcImpl supervisorDeTiDaoTestHelperJdbc;

    @Autowired
    DaoTestHelperJdbcImpl daoTestHelperJdbc;

    SupervisorDeTiBuilder builder;

    @BeforeEach
    void setup() {
        String cpf = "53576485768";
        builder =
                umSupervisorDeTi()
                        .comId(cpf)
                        .comOcupacao("Ocupação")
                        .comVencimento(0)
                        .comTarefasConcluidas(new ArrayList<>())
                        .comCredenciais(new Credenciais(cpf, "123"))
                        .comCargaHorariaSemanal(1950)
                        .comPausa(0);

        daoTestHelperJdbc.cleanUp();
    }

    @Test
    void
    dadoSupervisorDeTiJdbcDaoQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveLancarEmptyResultDataAccessException() {
        // preparacao
        String queNaoExisteNoBancoDeDados = "inexistente";

        // acao
        EmptyResultDataAccessException exception =
                assertThrows(
                        EmptyResultDataAccessException.class,
                        () -> supervisorDeTiDaoJdbc.resgataPorId(queNaoExisteNoBancoDeDados));

        // verificacao
        String mensagemEsperada = "Incorrect result size: expected 1, actual 0";
        String mensagemRecebida = exception.getMessage();
        assertEquals(mensagemEsperada, mensagemRecebida);
    }

    @Test
    void
    dadoSupervisorDeTiJdbcDaoQuandoTestadoMetodoResgataPorIdComUmRegistroNoBancoDeDadosEntaoDeveExistirUmSupervisorDeTi() {
        // preparacao
        SupervisorDeTi supervisorDeTi = builder.comTarefasConcluidas(Arrays.asList("T1", "T2")).agora();

        String queExisteNoBancoDeDados = supervisorDeTi.getId();

        // acao
        supervisorDeTiDaoTestHelperJdbc.criaRegistroDeSupervisorDeTi(supervisorDeTi);
        Optional<SupervisorDeTi> possivelSupervisorDeTi =
                supervisorDeTiDaoJdbc.resgataPorId(queExisteNoBancoDeDados);

        // verificacao
        SupervisorDeTi supervisorDeTiDaBaseDeDados = possivelSupervisorDeTi.get();
        int quantidadeDeTarefasConcluidasEsperada = 2;
        int quantidadeDeTarefasConcluidaRecebida =
                supervisorDeTiDaBaseDeDados.getTarefasConcluidas().size();
        assertEquals(quantidadeDeTarefasConcluidasEsperada, quantidadeDeTarefasConcluidaRecebida);
    }
}
