package com.me.erp.ti;

import com.me.erp.Estagiario;

public class EstagiarioDeTi extends Estagiario implements TiJunior {
    @Override
    public String documentar(String documento) {
        return null;
    }

    @Override
    public boolean participar() {
        return false;
    }

    @Override
    public String programar() {
        return null;
    }
}
