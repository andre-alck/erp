package com.me.erp.participante.interno.funcionario.supervisor;

import com.me.erp.participante.interno.funcionario.Funcionario;
import com.me.erp.participante.interno.funcionario.clt.Clt;

public abstract class Supervisor extends Clt {
    public abstract boolean promover(Funcionario funcionarioASerPromovido);

    public abstract boolean demitir(Funcionario funcionarioASerDemitido);
}
