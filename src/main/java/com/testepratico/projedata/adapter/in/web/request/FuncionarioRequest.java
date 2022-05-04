package com.testepratico.projedata.adapter.in.web.request;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class FuncionarioRequest {
    String nome;
    LocalDate dataNascimento;
    BigDecimal salario;
    String funcao;

}
