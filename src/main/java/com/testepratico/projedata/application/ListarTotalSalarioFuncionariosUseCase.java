package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListarTotalSalarioFuncionariosUseCase {
    private final FuncionarioPort funcionarioPort;

    public BigDecimal execute(){
        List<Funcionario> funcionarios = funcionarioPort.listAll();
        BigDecimal valorDosSalarios = funcionarios.stream()
                .map(f -> f.getSalario())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return valorDosSalarios;
    }
}
