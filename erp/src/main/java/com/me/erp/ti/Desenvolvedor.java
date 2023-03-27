package com.me.erp.ti;

import com.me.erp.Clt;

public class Desenvolvedor extends Clt implements TiPleno {

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
    public String programar() {
        return null;
    }

    @Override
    public void resolverChamados() {

    }
}
