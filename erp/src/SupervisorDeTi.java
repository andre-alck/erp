public class SupervisorDeTi extends Funcionario implements Supervisor {
    @Override
    public boolean acessarSistema(Perfil perfil) {
        return false;
    }

    @Override
    public boolean participar() {
        return false;
    }

    @Override
    public boolean desligarFuncionario(String id) {
        return false;
    }

    @Override
    public Perfil promoveFuncionario(String id) {
        return null;
    }
}
