package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListarFuncionariosComAumentoUseCase {
    private final FuncionarioPort funcionarioPort;

    public List<Funcionario> execute(){
        List<Funcionario> funcionarios = funcionarioPort.listAll();
        funcionarios.forEach(f->f.atualizaSalario());
        funcionarioPort.saveTodosFuncionarios(funcionarios);
        return funcionarios;
    }
}
