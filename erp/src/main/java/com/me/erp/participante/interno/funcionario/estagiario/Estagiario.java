package com.me.erp.participante.interno.funcionario.estagiario;

import com.me.erp.participante.interno.funcionario.Funcionario;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public abstract class Estagiario extends Funcionario {

    protected Estagiario() {
    }

    public void documentar(Documentacao documentacao) {
        isDocumentacaoValida(documentacao);
    }

    private void isDocumentacaoValida(Documentacao documentacao) throws DocumentacaoInvalidaException {
        if (documentacao.getId() == null) {
            throw new DocumentacaoInvalidaException("Id é nulo.");
        }

        if (documentacao.getId().isBlank()) {
            throw new DocumentacaoInvalidaException("Id está em branco.");
        }

        if (documentacao.getQuantidadeDePaginas() < 1) {
            throw new DocumentacaoInvalidaException("Quantidade de páginas é menor do que uma.");
        }

        if (documentacao.getCriacao() == null) {
            throw new DocumentacaoInvalidaException("Data de criação é nula.");
        }

        if (documentacao.getCriacao().isAfter(LocalDateTime.now())) {
            throw new DocumentacaoInvalidaException("Data de criação é futura.");
        }

        atribuiDocumentacaoATarefaConcluida(documentacao);
    }

    private void atribuiDocumentacaoATarefaConcluida(Documentacao documentacao) {
        List<String> tarefas = Collections.singletonList(documentacao.toString());
        this.setTarefasConcluidas(tarefas);
    }
}
