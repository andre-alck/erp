package com.me.erp.participante.interno.funcionario.supervisor.supervisordeti;

import static com.me.erp.builders.DesenvolvedorBuilder.umDesenvolvedor;
import static com.me.erp.builders.EstagiarioDeTiBuilder.umEstagiarioDeTi;
import static com.me.erp.builders.SupervisorDeTiBuilder.umSupervisorDeTi;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.me.erp.builders.DesenvolvedorBuilder;
import com.me.erp.builders.EstagiarioDeTiBuilder;
import com.me.erp.builders.SupervisorDeTiBuilder;
import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.clt.desenvolvedor.Desenvolvedor;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import com.me.erp.participante.interno.funcionario.supervisor.DemissaoInvalidaException;
import com.me.erp.participante.interno.funcionario.supervisor.PromocaoInvalidaException;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.AtividadesTiNivelSenior;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.AtividadesTiNivelSeniorImpl;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.Relatorio;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SupervisorDeTiTest {
  EstagiarioDeTiBuilder estagiarioDeTiBuilder;
  DesenvolvedorBuilder desenvolvedorBuilder;
  SupervisorDeTiBuilder supervisorDeTiBuilder;

  @BeforeEach
  void setup() {
    estagiarioDeTiBuilder =
        umEstagiarioDeTi()
            .comId("358.692.570-00")
            .comOcupacao("Ocupação")
            .comVencimento(1000)
            .comTarefasConcluidas(new ArrayList<>())
            .comCredenciais(new Credenciais())
            .comCargaHorariaSemanal(1950)
            .comPausa(30);
    desenvolvedorBuilder =
        umDesenvolvedor()
            .comId("314.986.890-43")
            .comOcupacao("Ocupação")
            .comVencimento(2500)
            .comTarefasConcluidas(new ArrayList<>())
            .comCredenciais(new Credenciais())
            .comCargaHorariaSemanal(1950)
            .comPausa(90);

    AtividadesTiNivelSenior atividadesTiNivelSenior = new AtividadesTiNivelSeniorImpl();
    supervisorDeTiBuilder =
        umSupervisorDeTi()
            .comId("408.529.908-55")
            .comOcupacao("Ocupação")
            .comVencimento(5000)
            .comTarefasConcluidas(new ArrayList<>())
            .comCredenciais(new Credenciais())
            .comPerfil(new Credenciais())
            .comCargaHorariaSemanal(1950)
            .comPausa(90)
            .comAtividadesTiNivelSenior(atividadesTiNivelSenior);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoPromoverComSupervisorDeTiEntaoDeveLancarExcecaoPromocaoInvalidaException() {
    // preparacao
    SupervisorDeTi supervisorDeTi1 = supervisorDeTiBuilder.agora();
    SupervisorDeTi supervisorDeTi2 = supervisorDeTiBuilder.agora();

    // acao
    PromocaoInvalidaException exception =
        assertThrows(
            PromocaoInvalidaException.class, () -> supervisorDeTi1.promover(supervisorDeTi2));

    // verificacao
    String mensagemEsperada = "Funcionário não é Estagiário de TI.";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoPromoverComDesenvolvedorEntaoDeveLancarExcecaoPromocaoInvalidaException() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
    Desenvolvedor desenvolvedor = desenvolvedorBuilder.agora();

    // acao
    PromocaoInvalidaException exception =
        assertThrows(PromocaoInvalidaException.class, () -> supervisorDeTi.promover(desenvolvedor));

    // verificacao
    String mensagemEsperada = "Funcionário não é Estagiário de TI.";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoDemitirComSupervisorDeTiEntaoDeveLancarExcecaoDemissaoInvalidaException() {
    // preparacao
    SupervisorDeTi supervisorDeTi1 = supervisorDeTiBuilder.agora();
    SupervisorDeTi supervisorDeTi2 = supervisorDeTiBuilder.agora();

    // acao
    DemissaoInvalidaException exception =
        assertThrows(
            DemissaoInvalidaException.class, () -> supervisorDeTi1.demitir(supervisorDeTi2));

    // verificacao
    String mensagemEsperada = "Funcionário não é Estagiário de TI ou Desenvolvedor.";
    String mensagemRecebida = exception.getMessage();
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoPromoverComEstagiarioDeTiEntaoDeveAtribuirPromocaoAsTarefasConcluidas() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
    EstagiarioDeTi estagiarioDeTi = estagiarioDeTiBuilder.agora();

    // acao
    supervisorDeTi.promover(estagiarioDeTi);

    // verificacao
    List<String> tarefasConcluidasEsperadas = List.of(estagiarioDeTi.getId() + " promovido.");
    List<String> tarefasConcluidasRecebidas = supervisorDeTi.getTarefasConcluidas();
    assertEquals(tarefasConcluidasEsperadas, tarefasConcluidasRecebidas);
  }

  @Test
  void dadoSupervisorDeTiQuandoTestadoMetodoProgramarEntaoDeveRetornarDocumentacaoNivelSr() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

    // acao
    String result = supervisorDeTi.programar();

    // verificacao
    String programacaoEsperada = "Programação Nível SR.";
    String programacaoRecebida = result;
    assertEquals(programacaoEsperada, programacaoRecebida);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoResolverChamadosComMenosUmChamadoEntaoDeveRetornarZero() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

    int quantidadeInvalida = -1;

    // acao
    int result = supervisorDeTi.resolverChamados(quantidadeInvalida);

    // verificacao
    int quantidadeDeChamadosResolvidosEsperada = 0;
    int quantidadeDeChamadosResolvidosRecebida = result;
    assertEquals(quantidadeDeChamadosResolvidosEsperada, quantidadeDeChamadosResolvidosRecebida);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoResolverChamadosComVinteChamadosEntaoDeveRetornarVinte() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

    final int quantidadeDeChamados = 20;
    final int quantidadeEsperada = quantidadeDeChamados;

    // acao
    int quantidadeDeChamadosResolvidos = supervisorDeTi.resolverChamados(quantidadeDeChamados);

    // verificacao
    assertEquals(quantidadeEsperada, quantidadeDeChamadosResolvidos);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoResolverChamadosComQuantidadesAceitaveisEntaoDeveRetornarTalQuantidade() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

    List<Integer> umMonteDeQuantidadeDeChamados =
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
    List<Integer> umMonteDeQuantidadeDeChamadosResolvidos = new ArrayList<>();

    // acao
    for (int certaQuantidadeDeChamados : umMonteDeQuantidadeDeChamados) {
      int quantidadeDeChamadosResolvidos =
          supervisorDeTi.resolverChamados(certaQuantidadeDeChamados);
      umMonteDeQuantidadeDeChamadosResolvidos.add(quantidadeDeChamadosResolvidos);
    }

    // verificacao
    List<Integer> quantidadeDeChamadosResolvidosEsperada = umMonteDeQuantidadeDeChamados;
    List<Integer> quantidadeDeChamadosResolvidosRecebida = umMonteDeQuantidadeDeChamadosResolvidos;
    assertEquals(quantidadeDeChamadosResolvidosEsperada, quantidadeDeChamadosResolvidosRecebida);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoDemitirComDesenvolvedorEntaoDeveAtribuirDemissaoAsTarefasConcluidas() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
    Desenvolvedor desenvolvedor = desenvolvedorBuilder.agora();

    // acao
    supervisorDeTi.demitir(desenvolvedor);

    // verificacao
    List<String> tarefasConcluidasEsperadas = List.of(desenvolvedor.getId() + " demitido.");
    List<String> tarefasConcluidasRecebidas = supervisorDeTi.getTarefasConcluidas();
    assertEquals(tarefasConcluidasEsperadas, tarefasConcluidasRecebidas);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoDemitirComEstagiarioDeTiEntaoDeveAtribuirDemissaoAsTarefasConcluidas() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();
    EstagiarioDeTi estagiarioDeTi = estagiarioDeTiBuilder.agora();

    // acao
    supervisorDeTi.demitir(estagiarioDeTi);

    // verificacao
    List<String> tarefasConcluidasEsperadas = List.of(estagiarioDeTi.getId() + " demitido.");
    List<String> tarefasConcluidasRecebidas = supervisorDeTi.getTarefasConcluidas();
    assertEquals(tarefasConcluidasEsperadas, tarefasConcluidasRecebidas);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComMenosDeDezLetrasEntaoDeveRetornarAviso() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

    String comIdRegular = supervisorDeTi.getId();
    String sendoSomenteComPontoFinal = ".";
    Relatorio relatorio = new Relatorio(comIdRegular, sendoSomenteComPontoFinal);

    // acao
    String result = supervisorDeTi.gerarRelatorio(relatorio);

    // verificacao
    String mensagemEsperada = "Por favor, acrescente detalhes ao seu relatório.";
    String mensagemRecebida = result;
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComDezLetrasEntaoDeveRetornarRelatorio() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

    String comIdRegular = supervisorDeTi.getId();
    String comDezPontosFinais = "..........";
    Relatorio relatorio = new Relatorio(comIdRegular, comDezPontosFinais);

    // acao
    String result = supervisorDeTi.gerarRelatorio(relatorio);

    // verificacao
    String mensagemEsperada = supervisorDeTi.getId() + ": " + comDezPontosFinais;
    String mensagemRecebida = result;
    assertEquals(mensagemEsperada, mensagemRecebida);
  }

  @Test
  void
      dadoSupervisorDeTiQuandoTestadoMetodoGerarRelatorioComOnzeLetrasEntaoDeveRetornarRelatorio() {
    // preparacao
    SupervisorDeTi supervisorDeTi = supervisorDeTiBuilder.agora();

    final String comId = supervisorDeTi.getId();
    final String comOnzePontosFinais = "...........";
    Relatorio relatorio = new Relatorio(comId, comOnzePontosFinais);

    // acao
    String result = supervisorDeTi.gerarRelatorio(relatorio);

    // verificacao
    String mensagemEsperada = supervisorDeTi.getId() + ": " + comOnzePontosFinais;
    String mensagemRecebida = result;
    assertEquals(mensagemEsperada, mensagemRecebida);
  }
}
