package com.me.erp.builders;

import com.me.erp.Documentacao;

import java.time.LocalDateTime;

public class DocumentacaoBuilder {
    private Documentacao documentacao;

    private DocumentacaoBuilder() {
    }

    public static DocumentacaoBuilder umDocumentacao() {
        DocumentacaoBuilder builder = new DocumentacaoBuilder();
        builder.documentacao = new Documentacao();
        return builder;
    }

    public DocumentacaoBuilder comId(String id) {
        documentacao.setId(id);
        return this;
    }

    public DocumentacaoBuilder comQuantidadeDePaginas(int quantidadeDePaginas) {
        documentacao.setQuantidadeDePaginas(quantidadeDePaginas);
        return this;
    }

    public DocumentacaoBuilder comCriacao(LocalDateTime criacao) {
        documentacao.setCriacao(criacao);
        return this;
    }

    public Documentacao agora() {
        return documentacao;
    }
}
