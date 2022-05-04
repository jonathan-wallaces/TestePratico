package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListarFuncionarioMaiorIdadeUseCase {
    private final FuncionarioPort funcionarioPort;

    public Funcionario execute(){
        List<Funcionario> funcionarios = funcionarioPort.listAll();
        List<LocalDate> datasDeNascimento = funcionarios.stream().map(f -> f.getDataNascimento()).collect(Collectors.toList());
        LocalDate menorData = Collections.min(datasDeNascimento);
        Optional<Funcionario> funcionarioMaisVelho = Optional.ofNullable(funcionarios.stream()
                .filter(f -> f.getDataNascimento().equals(menorData))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Lista Vazia")));
        return funcionarioMaisVelho.get();
    }
}
