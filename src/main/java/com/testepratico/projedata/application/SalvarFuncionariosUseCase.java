package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SalvarFuncionariosUseCase {
    private final FuncionarioPort funcionarioPort;

    public void execute(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        Funcionario funcionario = new Funcionario(nome, dataNascimento, salario, funcao);
        funcionarioPort.saveFuncionario(funcionario);
    }


}
