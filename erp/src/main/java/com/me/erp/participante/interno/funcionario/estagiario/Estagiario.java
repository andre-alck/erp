package com.me.erp.participante.interno.funcionario.estagiario;

import com.me.erp.participante.StatusDoTrabalho;
import com.me.erp.participante.interno.funcionario.Funcionario;

import java.time.LocalDateTime;

public abstract class Estagiario extends Funcionario {
    public StatusDoTrabalho documentar(Documentacao documentacao) {
        StatusDoTrabalho statusDoTrabalho = isDocumentacaoValida(documentacao);
        return statusDoTrabalho;
    }

    private StatusDoTrabalho isDocumentacaoValida(Documentacao documentacao) {
        StatusDoTrabalho statusDoTrabalho;

        if (documentacao.getId() == null) {
            statusDoTrabalho = StatusDoTrabalho.IRREGULAR;
            return statusDoTrabalho;
        }

        if (documentacao.getId().isBlank()) {
            statusDoTrabalho = StatusDoTrabalho.IRREGULAR;
            return statusDoTrabalho;
        }

        if (documentacao.getQuantidadeDePaginas() < 1) {
            statusDoTrabalho = StatusDoTrabalho.IRREGULAR;
            return statusDoTrabalho;
        }

        if (documentacao.getCriacao() == null) {
            statusDoTrabalho = StatusDoTrabalho.IRREGULAR;
            return statusDoTrabalho;
        }

        if (documentacao.getCriacao().isAfter(LocalDateTime.now())) {
            statusDoTrabalho = StatusDoTrabalho.IRREGULAR;
            return statusDoTrabalho;
        }

        statusDoTrabalho = StatusDoTrabalho.REGULAR;
        return statusDoTrabalho;
    }
}
