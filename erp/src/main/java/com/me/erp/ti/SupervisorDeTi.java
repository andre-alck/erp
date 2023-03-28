package com.me.erp.ti;

import com.me.erp.Funcionario;
import com.me.erp.Supervisor;

public class SupervisorDeTi extends Supervisor implements TiSenior{
    @Override
    public void participarDeReuniao() {
        // TODO: 📚
    }

    @Override
    public String documentar(String documentacao) {
        return "Documentação Nível SR.";
    }

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
        if(relatorio.length() < 10) {
            return "Por favor, acrescente detalhes ao seu relatório.";
        }

        String relatorioGerado = this.getId() + ": " + relatorio;
        return relatorioGerado;
    }

    @Override
    public int resolverChamados(int quantidadeDeChamados) {
        int quantidadeDeChamadosResolvidos;

        if(quantidadeDeChamados <= 0) {
            quantidadeDeChamadosResolvidos = 0;
            return quantidadeDeChamadosResolvidos;
        }

        if(quantidadeDeChamados >= 20) {
            quantidadeDeChamadosResolvidos = 20;
            quantidadeDeChamadosResolvidos = 20;
            return quantidadeDeChamadosResolvidos;
        }

        quantidadeDeChamadosResolvidos = quantidadeDeChamados;
        return quantidadeDeChamadosResolvidos;
    }
}
