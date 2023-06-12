package com.me.erp.controller.participante.interno.funcionario.estagiario.estagiariodeti;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.me.erp.dao.participante.daotesthelper.deletaregistroshelper.DeletaRegistrosDaoTestHelperJdbcImpl;
import com.me.erp.dao.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTiDaoJdbcImpl;
import com.me.erp.participante.interno.funcionario.estagiario.Documentacao;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class EstagiarioDeTiControllerTest {

  @Autowired private EstagiarioDeTiDaoJdbcImpl estagiarioDeTiDaoJdbc;

  @Autowired private DeletaRegistrosDaoTestHelperJdbcImpl daoTestHelperJdbc;

  @MockBean
  private EstagiarioDeTi estagiarioDeTi;

  @Autowired
  private MockMvc mockMvc;
  
  @Test
  void
      dadoEstagiarioDeTiControllerQuandoTestadoMetodoDocumentarAPartirDeUmEstagiarioDeTiEntaoDeveAtribuirAsTarefasConcluidas() throws Exception {
    // preparacao
    when(estagiarioDeTi.resgataPorId(any())).thenReturn(Optional.of(new EstagiarioDeTi()));

    EstagiarioDeTiController controller = new EstagiarioDeTiController();
    Documentacao documentacao = new Documentacao("75673547364", 10, LocalDateTime.now());

    // acao
    ResultActions response = mockMvc.perform(post("/estagiariodeti/documentar")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\": \"53567936859\", \"quantidadeDePaginas\": \"10\", \"dataDeCriacao\": \"null\"}"));

    // verificacao
    response.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
  }
}
