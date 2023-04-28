package com.me.erp.participante.interno.funcionario.ti.atividadestinivelsenior;

public class AtividadesTiNivelSeniorImpl implements AtividadesTiNivelSenior {

    @Override
    public String gerarRelatorio(Relatorio relatorio) {
        String autor = relatorio.getId();
        String conteudo = relatorio.getConteudo();

        boolean isTamanhoDoConteudoMenorDoQueDez = conteudo.length() < 10;
        if (isTamanhoDoConteudoMenorDoQueDez) {
            return "Por favor, acrescente detalhes ao seu relatório.";
        }

        String relatorioGerado = autor + ": " + conteudo;
        return relatorioGerado;
    }

    @Override
    public String programar() {
        return "Programação Nível SR.";
    }

    @Override
    public int resolverChamados(int quantidadeDeChamados) {
        int quantidadeDeChamadosResolvidos;

        if (quantidadeDeChamados <= 0) {
            quantidadeDeChamadosResolvidos = 0;
            return quantidadeDeChamadosResolvidos;
        }

        if (quantidadeDeChamados >= 20) {
            quantidadeDeChamadosResolvidos = 20;
            quantidadeDeChamadosResolvidos = 20;
            return quantidadeDeChamadosResolvidos;
        }

        quantidadeDeChamadosResolvidos = quantidadeDeChamados;
        return quantidadeDeChamadosResolvidos;
    }
}
