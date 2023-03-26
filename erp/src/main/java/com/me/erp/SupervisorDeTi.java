package com.me.erp;

public class SupervisorDeTi extends Supervisor implements TiSenior{
    @Override
    public void participarDeReuniao() {

    }

    @Override
    public String documentar(String documento) {
        return null;
    }

    @Override
    public boolean participar() {
        return false;
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
        return null;
    }

    @Override
    public void resolverChamados() {

    }

    @Override
    public String gerarRelatorio(String relatorio) {
        return null;
    }
}
