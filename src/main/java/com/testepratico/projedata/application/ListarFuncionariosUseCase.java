package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListarFuncionariosUseCase {
    private final FuncionarioPort funcionarioPort;

    public List<Funcionario> execute(){
        List<Funcionario> funcionarios = funcionarioPort.listAll();
        return funcionarios;
    }
}
