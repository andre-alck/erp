package com.me.erp.participante.interno.funcionario.supervisor;

import com.me.erp.participante.interno.funcionario.Funcionario;
import com.me.erp.participante.interno.funcionario.clt.Clt;

public abstract class Supervisor extends Clt {
    public abstract void promover(Funcionario funcionarioASerPromovido) throws PromocaoInvalidaException;

    public abstract boolean demitir(Funcionario funcionarioASerDemitido);
}
