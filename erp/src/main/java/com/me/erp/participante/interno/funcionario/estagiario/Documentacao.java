package com.me.erp.participante.interno.funcionario.estagiario;

import java.time.LocalDateTime;

public class Documentacao {
    private String id;
    private int quantidadeDePaginas;
    private LocalDateTime criacao;

    public Documentacao(String id, int quantidadeDePaginas, LocalDateTime criacao) {
        this.id = id;
        this.quantidadeDePaginas = quantidadeDePaginas;
        this.criacao = criacao;
    }

    public Documentacao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidadeDePaginas() {
        return quantidadeDePaginas;
    }

    public void setQuantidadeDePaginas(int quantidadeDePaginas) {
        this.quantidadeDePaginas = quantidadeDePaginas;
    }

    public LocalDateTime getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDateTime criacao) {
        this.criacao = criacao;
    }
}
