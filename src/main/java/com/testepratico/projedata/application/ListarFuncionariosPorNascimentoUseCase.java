package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListarFuncionariosPorNascimentoUseCase {
    private final FuncionarioPort funcionarioPort;

    public List<Funcionario> execute(){
        List<Funcionario> funcionarios = funcionarioPort.listAll();
        List<Funcionario> funcFiltrados = funcionarios.stream()
                .filter(f -> f.mesNacimento() == (10) || f.mesNacimento()==12)
                .collect(Collectors.toList());
        return funcFiltrados;
    }
}
