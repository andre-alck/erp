package com.me.erp.participante.interno.funcionario.ti;


import com.me.erp.participante.interno.funcionario.clt.Clt;

public class Desenvolvedor extends Clt implements TiPleno {
    @Override
    public String programar() {
        return "Programação Nível PL.";
    }

    @Override
    public int resolverChamados(int quantidadeDeChamados) {
        int quantidadeDeChamadosResolvidos;

        if (quantidadeDeChamados <= 0) {
            quantidadeDeChamadosResolvidos = 0;
            return quantidadeDeChamadosResolvidos;
        }

        if (quantidadeDeChamados >= 10) {
            quantidadeDeChamadosResolvidos = 10;
            quantidadeDeChamadosResolvidos = 10;
            return quantidadeDeChamadosResolvidos;
        }

        quantidadeDeChamadosResolvidos = quantidadeDeChamados;
        return quantidadeDeChamadosResolvidos;
    }
}
