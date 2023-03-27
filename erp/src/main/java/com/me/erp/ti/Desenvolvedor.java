package com.me.erp.ti;

import com.me.erp.Clt;

public class Desenvolvedor extends Clt implements TiPleno {

    @Override
    public void participarDeReuniao() {
        // TODO: 📚
    }

    @Override
    public String documentar(String documentacao) {
        return "Documentação Nível PL.";
    }

    @Override
    public boolean participar() {
        return false;
        // TODO: 📚
    }

    @Override
    public String programar() {
        return "Programação Nível PL.";
    }

    @Override
    public int resolverChamados(int quantidadeDeChamados) {
        int quantidadeDeChamadosResolvidos;

        if(quantidadeDeChamados <= 0) {
            quantidadeDeChamadosResolvidos = 0;
            return quantidadeDeChamadosResolvidos;
        }

        if(quantidadeDeChamados >= 10) {
            quantidadeDeChamadosResolvidos = 10;
            quantidadeDeChamadosResolvidos = 10;
            return quantidadeDeChamadosResolvidos;
        }

        quantidadeDeChamadosResolvidos = quantidadeDeChamados;
        return quantidadeDeChamadosResolvidos;
    }
}
