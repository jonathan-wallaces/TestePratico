package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeletarFuncionarioUseCase {
    private final FuncionarioPort funcionarioPort;

    public void execute(){
        List<Funcionario> funcionarios = funcionarioPort.listAll();
        String nome = "João";
        Funcionario func = funcionarios.stream().filter(f -> f.getNome().equals(nome)).findFirst().get();
        funcionarioPort.delete(func);
    }
}
