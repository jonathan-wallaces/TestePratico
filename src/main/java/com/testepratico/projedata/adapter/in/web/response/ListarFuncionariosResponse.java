package com.testepratico.projedata.adapter.in.web.response;

import com.testepratico.projedata.domain.Funcionario;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Value
public class ListarFuncionariosResponse {

    String nome;
    String dataNascimento;
    String salario;
    String funcao;

    public static List<ListarFuncionariosResponse> of(List<Funcionario> funcionarioList){
        return funcionarioList.stream()
                .map(ListarFuncionariosResponse::of)
                .collect(Collectors.toList());
    }

    public static ListarFuncionariosResponse of(Funcionario funcionario){
        return new ListarFuncionariosResponse(
                funcionario.getNome(),
                funcionario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                NumberFormat.getNumberInstance(Locale.forLanguageTag("pt")).format(funcionario.getSalario()),
                funcionario.getFuncao()
        );
    }
}
