public abstract class Participante {
    private String id;
    private String ocupacao;
    private double vencimento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public double getVencimento() {
        return vencimento;
    }

    public void setVencimento(double vencimento) {
        this.vencimento = vencimento;
    }

    public abstract boolean participar();
}
