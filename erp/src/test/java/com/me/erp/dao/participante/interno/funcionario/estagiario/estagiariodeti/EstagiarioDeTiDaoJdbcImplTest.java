package com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti;

import static com.me.erp.builders.EstagiarioDeTiBuilder.umEstagiarioDeTi;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.dao.participante.daotesthelper.DeletaRegistrosDaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti.estagiariodetihelper.EstagiarioDeTiDaoTestHelperJdbcImpl;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

@SpringBootTest
class EstagiarioDeTiDaoJdbcImplTest {

  @Autowired EstagiarioDeTiDaoJdbcImpl estagiarioDeTiJdbcDao;

  @Autowired EstagiarioDeTiDaoTestHelperJdbcImpl estagiarioDeTiDaoTestAuxJdbc;

  @Autowired DeletaRegistrosDaoTestHelperJdbcImpl daoTestHelperJdbc;

  EstagiarioDeTiBuilder builder;

  @BeforeEach
  void setup() {
    String cpf = "53576485768";
    builder =
        umEstagiarioDeTi()
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
      dadoEstagiarioDeTiJdbcDaoQuandoTestadoMetodoResgataPorIdComNenhumRegistroNoBancoDeDadosEntaoDeveLancarEmptyResultDataAccessException() {
    // preparacao
    String queNaoExisteNoBancoDeDados = "inexistente";

    // acao
    EmptyResultDataAccessException exception =
        assertThrows(
            EmptyResultDataAccessException.class,
            () -> estagiarioDeTiJdbcDao.resgataPorId(queNaoExisteNoBancoDeDados));

    // verificacao
    String mensagemEsperada = "Incorrect result size: expected 1, actual 0";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoEstagiarioDeTiJdbcDaoQuandoTestadoMetodoResgataPorIdComUmRegistroNoBancoDeDadosEntaoDeveExistirUmEstagiarioDeTi() {
    // preparacao
    EstagiarioDeTi estagiarioDeTi = builder.comTarefasConcluidas(Arrays.asList("T1", "T2")).agora();

    String queExisteNoBancoDeDados = estagiarioDeTi.getId();

    // acao
    estagiarioDeTiDaoTestAuxJdbc.cria(estagiarioDeTi);
    Optional<EstagiarioDeTi> possivelEstagiarioDeTi =
        estagiarioDeTiJdbcDao.resgataPorId(queExisteNoBancoDeDados);

    // verificacao
    EstagiarioDeTi estagiarioDeTiDaBaseDeDados = possivelEstagiarioDeTi.get();
    int quantidadeDeTarefasConcluidasEsperada = 2;
    int quantidadeDeTarefasConcluidaRecebida =
        estagiarioDeTiDaBaseDeDados.getTarefasConcluidas().size();
    assertEquals(quantidadeDeTarefasConcluidasEsperada, quantidadeDeTarefasConcluidaRecebida);
  }
}
