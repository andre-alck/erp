package com.me.erp.participante.interno.funcionario.ti;

import com.me.erp.participante.StatusDoTrabalho;
import com.me.erp.participante.interno.funcionario.Funcionario;
import com.me.erp.participante.interno.funcionario.estagiario.Documentacao;
import com.me.erp.participante.interno.funcionario.supervisor.Supervisor;

public class SupervisorDeTi extends Supervisor implements TiSenior {


    @Override
    public boolean promover(Funcionario funcionarioASerPromovido) {
        return false;
    }

    @Override
    public boolean demitirFuncionario(Funcionario funcionarioASerDemitido) {
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

    @Override
    public StatusDoTrabalho documentar(Documentacao documentacao) {
        return null;
    }


}