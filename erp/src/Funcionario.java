public abstract class Funcionario extends ParticipanteInterno {
    private double cargaHorariaSemanal;
    private double pausa;
    private Perfil perfil;

    public double getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(double cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public double getPausa() {
        return pausa;
    }

    public void setPausa(double pausa) {
        this.pausa = pausa;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public abstract boolean acessarSistema(Perfil perfil);
}
