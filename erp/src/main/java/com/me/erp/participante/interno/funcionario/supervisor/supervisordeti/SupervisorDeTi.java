package com.me.erp.participante.interno.funcionario.supervisor.supervisordeti;

import com.me.erp.participante.interno.funcionario.Funcionario;
import com.me.erp.participante.interno.funcionario.clt.desenvolvedor.Desenvolvedor;
import com.me.erp.participante.interno.funcionario.estagiario.estagiariodeti.EstagiarioDeTi;
import com.me.erp.participante.interno.funcionario.supervisor.DemissaoInvalidaException;
import com.me.erp.participante.interno.funcionario.supervisor.PromocaoInvalidaException;
import com.me.erp.participante.interno.funcionario.supervisor.Supervisor;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.AtividadesTiNivelSenior;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.Relatorio;
import java.util.List;

public class SupervisorDeTi extends Supervisor {

  private AtividadesTiNivelSenior atividadesTiNivelSenior;

  public SupervisorDeTi() {}

  public SupervisorDeTi(AtividadesTiNivelSenior atividadesTiNivelSenior) {
    this.atividadesTiNivelSenior = atividadesTiNivelSenior;
  }

  public void setAtividadesTiNivelSenior(AtividadesTiNivelSenior atividadesTiNivelSenior) {
    this.atividadesTiNivelSenior = atividadesTiNivelSenior;
  }

  public String programar() {
    return this.atividadesTiNivelSenior.programar();
  }

  public int resolverChamados(int quantidadeDeChamados) {
    return this.atividadesTiNivelSenior.resolverChamados(quantidadeDeChamados);
  }

  public String gerarRelatorio(Relatorio relatorio) {
    return this.atividadesTiNivelSenior.gerarRelatorio(relatorio);
  }

  @Override
  public void promover(Funcionario funcionarioASerPromovido) throws PromocaoInvalidaException {
    if (isNivelDoFuncionarioIgualATiJunior(funcionarioASerPromovido)) {
      this.setTarefasConcluidas(List.of(funcionarioASerPromovido.getId() + " promovido."));
    } else {
      throw new PromocaoInvalidaException("Funcionário não é Estagiário de TI.");
    }
  }

  private boolean isNivelDoFuncionarioIgualATiJunior(Funcionario funcionarioASerPromovido) {
    return funcionarioASerPromovido.getClass().equals(EstagiarioDeTi.class);
  }

  @Override
  public void demitir(Funcionario funcionarioASerDemitido) throws DemissaoInvalidaException {
    if (isNivelDoFuncionarioIgualATiJuniorOuTiPleno(funcionarioASerDemitido)) {
      this.setTarefasConcluidas(List.of(funcionarioASerDemitido.getId() + " demitido."));
    } else {
      throw new DemissaoInvalidaException("Funcionário não é Estagiário de TI ou Desenvolvedor.");
    }
  }

  private boolean isNivelDoFuncionarioIgualATiJuniorOuTiPleno(
      Funcionario funcionarioASerPromovido) {
    return funcionarioASerPromovido.getClass().equals(EstagiarioDeTi.class)
        || funcionarioASerPromovido.getClass().equals(Desenvolvedor.class);
  }
}
