package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.participante.interno.funcionario.Funcionario;
import com.me.erp.participante.interno.funcionario.supervisor.PromocaoInvalidaException;
import com.me.erp.participante.interno.funcionario.supervisor.Supervisor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SupervisorDeTi extends Supervisor implements TiSenior {

    @Override
    public void promover(Funcionario funcionarioASerPromovido) throws PromocaoInvalidaException {
        if(isNivelDoFuncionarioIgualATiJunior(funcionarioASerPromovido)) {
            this.setTarefasConcluidas(Arrays.asList(funcionarioASerPromovido.getId() + " promovido."));
        } else {
            throw new PromocaoInvalidaException("Funcionário não é Estagiário de TI.");
        }
    }

    private boolean isNivelDoFuncionarioIgualATiJunior(Funcionario funcionarioASerPromovido) {
        List<Class<?>> interfacesImplementadas = Arrays.asList(funcionarioASerPromovido.getClass().getInterfaces());
        boolean isPromovivel = interfacesImplementadas.contains(TiJunior.class);
        return isPromovivel;
    }

    @Override
    public boolean demitir(Funcionario funcionarioASerDemitido) {
        return false;
    }

    @Override
    public String programar() {
        return "Programação Nível SR.";
    }

    @Override
    public String gerarRelatorio(String relatorio) {
        if (relatorio.length() < 10) {
            return "Por favor, acrescente detalhes ao seu relatório.";
        }

        String relatorioGerado = this.getId() + ": " + relatorio;
        return relatorioGerado;
    }

    @Override
    public int resolverChamados(int quantidadeDeChamados) {
        int quantidadeDeChamadosResolvidos;

        if (quantidadeDeChamados <= 0) {
            quantidadeDeChamadosResolvidos = 0;
            return quantidadeDeChamadosResolvidos;
        }

        if (quantidadeDeChamados >= 20) {
            quantidadeDeChamadosResolvidos = 20;
            quantidadeDeChamadosResolvidos = 20;
            return quantidadeDeChamadosResolvidos;
        }

        quantidadeDeChamadosResolvidos = quantidadeDeChamados;
        return quantidadeDeChamadosResolvidos;
    }
}
