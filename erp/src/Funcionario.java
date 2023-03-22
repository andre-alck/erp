public abstract class Funcionario extends Participante {
    private double cargaHorariaSemanal;
    private double pausa;
    private Perfil perfil;

    public abstract boolean acessarSistema(Perfil perfil);
}
