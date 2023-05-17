package com.me.erp.factories.participante.interno.funcionario.estagiario;

import com.me.erp.participante.interno.Credenciais;
import com.me.erp.participante.interno.funcionario.ti.EstagiarioDeTi;

import java.util.List;

public class EstagiarioDeTiFactory {

    private EstagiarioDeTiFactory() {
    }

    public static EstagiarioDeTi daBaseDeDados(String id, String ocupacao, double vencimento, List<String> tarefasConcluidas, String senha, double cargaHorariaSemanal, double pausa) {
        EstagiarioDeTi estagiarioDeTi = new EstagiarioDeTi();
        estagiarioDeTi.setId(id);
        estagiarioDeTi.setOcupacao(ocupacao);
        estagiarioDeTi.setVencimento(vencimento);
        estagiarioDeTi.setTarefasConcluidas(tarefasConcluidas);
        estagiarioDeTi.setCredenciais(new Credenciais(id, senha));
        estagiarioDeTi.setCargaHorariaSemanal(cargaHorariaSemanal);
        estagiarioDeTi.setPausa(pausa);

        return estagiarioDeTi;
    }
}
