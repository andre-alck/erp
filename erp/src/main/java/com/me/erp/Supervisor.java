package com.me.erp;

public abstract class Supervisor extends Clt {
    public abstract boolean promover(Funcionario funcionarioASerPromovido);

    public abstract boolean demitirFuncionario(Funcionario funcionarioASerDemitido);
}
