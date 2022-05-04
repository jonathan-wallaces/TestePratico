package com.testepratico.projedata.adapter.in.web.response;

import com.testepratico.projedata.domain.Funcionario;
import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ListarFuncionariosSalarioMinimoResponse {
    String nome;
    BigDecimal salariosMinimos;

    public static List<ListarFuncionariosSalarioMinimoResponse> of(List<Funcionario> funcionarioList){
        return funcionarioList.stream()
                .map(ListarFuncionariosSalarioMinimoResponse::of)
                .collect(Collectors.toList());
    }


    public static ListarFuncionariosSalarioMinimoResponse of(Funcionario funcionario){
        return new ListarFuncionariosSalarioMinimoResponse(
                funcionario.getNome(),
                funcionario.getSalario().divide(BigDecimal.valueOf(1212),2, RoundingMode.CEILING)
        );
    }
}
