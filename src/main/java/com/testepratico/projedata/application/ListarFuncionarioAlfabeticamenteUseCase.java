package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListarFuncionarioAlfabeticamenteUseCase {
    private final FuncionarioPort funcionarioPort;

    public List<Funcionario> execute(){
        List<Funcionario> funcionarios = funcionarioPort.listAll();
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getNome));
        funcionarioPort.saveTodosFuncionarios(funcionarios);
        return funcionarios;
    }
}
