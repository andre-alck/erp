package com.me.erp;

public abstract class ParticipanteInterno extends Participante {
    private String senha;
    private Perfil perfil;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}

