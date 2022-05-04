package com.testepratico.projedata.adapter.in.web.response;

import com.testepratico.projedata.domain.Funcionario;
import lombok.Value;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Value
public class ListarFuncionarioMaisVelhoResponse {
    String nome;
    int idade;

    public static ListarFuncionarioMaisVelhoResponse of(Funcionario funcionario){
        return new ListarFuncionarioMaisVelhoResponse(
                funcionario.getNome(),
                funcionario.getIdade()
        );
    }
}
