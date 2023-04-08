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
        if (documentacao.getId() == null) {
            return StatusDoTrabalho.IRREGULAR;
        }

        if (documentacao.getId().isBlank()) {
            return StatusDoTrabalho.IRREGULAR;
        }

        if (documentacao.getQuantidadeDePaginas() < 1) {
            return StatusDoTrabalho.IRREGULAR;
        }

        if (documentacao.getCriacao() == null) {
            return StatusDoTrabalho.IRREGULAR;
        }

        if (documentacao.getCriacao().isAfter(LocalDateTime.now())) {
            return StatusDoTrabalho.IRREGULAR;
        }

        return StatusDoTrabalho.REGULAR;
    }
}
