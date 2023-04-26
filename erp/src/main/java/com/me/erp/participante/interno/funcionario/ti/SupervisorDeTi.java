package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.participante.interno.funcionario.Funcionario;
import com.me.erp.participante.interno.funcionario.clt.Clt;
import com.me.erp.participante.interno.funcionario.estagiario.Estagiario;
import com.me.erp.participante.interno.funcionario.supervisor.DemissaoInvalidaException;
import com.me.erp.participante.interno.funcionario.supervisor.PromocaoInvalidaException;
import com.me.erp.participante.interno.funcionario.supervisor.Supervisor;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.AtividadesTiNivelSenior;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior.Relatorio;
import org.springframework.cglib.core.ClassTransformer;

import java.util.Arrays;
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
        String programacao = this.atividadesTiNivelSenior.programar();
        return programacao;
    }

    public int resolverChamados(int quantidadeDeChamados) {
        int quantidadeDeChamadosResolvidos = this.atividadesTiNivelSenior.resolverChamados(quantidadeDeChamados);
        return quantidadeDeChamadosResolvidos;
    }

    public String gerarRelatorio(Relatorio relatorio) {
        String relatoriogerado = this.atividadesTiNivelSenior.gerarRelatorio(relatorio);
        return relatoriogerado;
    }

    @Override
    public void promover(Funcionario funcionarioASerPromovido) throws PromocaoInvalidaException {
        if (isNivelDoFuncionarioIgualATiJunior(funcionarioASerPromovido)) {
            this.setTarefasConcluidas(Arrays.asList(funcionarioASerPromovido.getId() + " promovido."));
        } else {
            throw new PromocaoInvalidaException("Funcionário não é Estagiário de TI.");
        }
    }

    private boolean isNivelDoFuncionarioIgualATiJunior(Funcionario funcionarioASerPromovido) {
        boolean isEstagiarioDeTi = funcionarioASerPromovido.getClass().equals(EstagiarioDeTi.class);
        return isEstagiarioDeTi;
    }

    @Override
    public void demitir(Funcionario funcionarioASerDemitido) throws DemissaoInvalidaException {
        if (isNivelDoFuncionarioIgualATiJuniorOuTiPleno(funcionarioASerDemitido)) {
            this.setTarefasConcluidas(Arrays.asList(funcionarioASerDemitido.getId() + " demitido."));
        } else {
            throw new DemissaoInvalidaException("Funcionário não é Estagiário de TI ou Desenvolvedor.");
        }
    }

    private boolean isNivelDoFuncionarioIgualATiJuniorOuTiPleno(Funcionario funcionarioASerPromovido) {
        boolean isEstagiarioDeTiOuDesenvolvedor = funcionarioASerPromovido.getClass().equals(EstagiarioDeTi.class) || funcionarioASerPromovido.getClass().equals(Desenvolvedor.class);
        return isEstagiarioDeTiOuDesenvolvedor;
    }
}
