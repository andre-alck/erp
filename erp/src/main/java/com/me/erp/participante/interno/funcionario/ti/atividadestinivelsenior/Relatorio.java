package com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior;

public class Relatorio {
    private final String id;
    private final String conteudo;

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
