package com.me.erp.participante.interno.funcionario.supervisor;

public class DemissaoInvalidaException extends RuntimeException {
    public DemissaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
