package com.me.erp.participante.interno.funcionario.ti;


import com.me.erp.participante.interno.funcionario.clt.Clt;
import com.me.erp.participante.interno.funcionario.ti.atividadestinivelpleno.AtividadesTiNivelPleno;

public class Desenvolvedor extends Clt {

    private AtividadesTiNivelPleno atividadesTiNivelPleno;

    public Desenvolvedor() {};

    public Desenvolvedor(AtividadesTiNivelPleno atividadesTiNivelPleno) {
        this.atividadesTiNivelPleno = atividadesTiNivelPleno;
    }

    public void setResolverChamadosService(AtividadesTiNivelPleno tiPleno) {
        this.atividadesTiNivelPleno = tiPleno;
    }

    public String programar() {
        String programacao = this.atividadesTiNivelPleno.programar();
        return programacao;
    }

    public int resolverChamados(int quantidadeDeChamados) {
        int quantidadeDeChamadosResolvidos = this.atividadesTiNivelPleno.resolverChamados(quantidadeDeChamados);
        return quantidadeDeChamadosResolvidos;
    }
}
