package com.me.erp.ti;

import com.me.erp.Estagiario;

public class EstagiarioDeTi extends Estagiario implements TiJunior {

    @Override
    public String documentar(String documentacao) {
        return "Documentação Nível JR.";
    }



    @Override
    public String programar() {
        return "Programação Nível JR.";
    }
}
