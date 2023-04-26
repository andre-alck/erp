package com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior;

public class Relatorio {
    private String id;
    private String conteudo;

    public Relatorio(String id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public String getId() {
        return id;
    }

    public String getConteudo() {
        return conteudo;
    }
}
