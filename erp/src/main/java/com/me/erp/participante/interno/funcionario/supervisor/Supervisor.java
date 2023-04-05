package com.me.erp.participante.interno.funcionario.supervisor;

import com.me.erp.participante.interno.funcionario.Funcionario;
import com.me.erp.participante.interno.funcionario.clt.Clt;

public abstract class Supervisor extends Clt {
    public boolean promover(Funcionario funcionarioASerPromovido) {
        return true;
    }


    public boolean demitirFuncionario(Funcionario funcionarioASerDemitido) {
        return true;
    }
}
