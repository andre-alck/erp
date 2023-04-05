package com.me.erp.participante.interno.funcionario.supervisor;

import com.me.erp.mocks.SupervisorMock;
import com.me.erp.participante.interno.Perfil;
import org.junit.jupiter.api.BeforeEach;

import static com.me.erp.builders.SupervisorMockBuilder.umSupervisorMock;

class SupervisorTest {
    SupervisorMock supervisor;

    @BeforeEach
    void setup() {
        supervisor = umSupervisorMock().comId("408.529.908-55").comOcupacao("Ocupação").comVencimento(5000).comSenha("Senha").comPerfil(new Perfil()).comCargaHorariaSemanal(2400).comPausa(90).agora();
    }

}