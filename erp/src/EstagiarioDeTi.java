public class EstagiarioDeTi extends Funcionario implements Estagiario {
    @Override
    public boolean acessarSistema(Perfil perfil) {
        return false;
    }

    @Override
    public boolean participar() {
        return false;
    }

    @Override
    public String documentar() {
        return "EstagiarioDeTi.java - documentar()";
    }
}
