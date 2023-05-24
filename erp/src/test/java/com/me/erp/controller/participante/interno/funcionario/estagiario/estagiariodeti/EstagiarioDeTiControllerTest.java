package com.me.erp.controller.participante.interno.funcionario.estagiario.estagiariodeti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.me.erp.dao.participante.daotesthelper.deletaregistroshelper.DeletaRegistrosDaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTiDaoJdbcImpl;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.dto.FuncionarioDocumentacaoDto;
import com.me.erp.participante.interno.funcionario.estagiario.Documentacao;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class EstagiarioDeTiControllerTest {

  @Autowired private MockMvc mvc;

  @Autowired private EstagiarioDeTiDaoJdbcImpl estagiarioDeTiDaoJdbc;

  @Autowired private DeletaRegistrosDaoTestHelperJdbcImpl daoTestHelperJdbc;

  @Disabled
  @Test
  void
      dadoEstagiarioDeTiControllerQuandoTestadoMetodoDocumentarAPartirDeUmEstagiarioDeTiEntaoDeveAtribuirAsTarefasConcluidas() {
    // preparacao
    Credenciais credenciais = new Credenciais("85796884756", "pass");
    Documentacao documentacao = new Documentacao(credenciais.getId(), 5, LocalDateTime.now());
    FuncionarioDocumentacaoDto dto = new FuncionarioDocumentacaoDto(credenciais, documentacao);

    // acao
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/documentar").content(dto.toString());
    MvcResult mvcResult = null;
    try {
      mvcResult = mvc.perform(requestBuilder).andReturn();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    // verificacao
    EstagiarioDeTi estagiarioDeTi = estagiarioDeTiDaoJdbc.resgataPorId(credenciais.getId()).get();
    assertEquals(estagiarioDeTi.getTarefasConcluidas().get(0), documentacao.getId());
  }
}
