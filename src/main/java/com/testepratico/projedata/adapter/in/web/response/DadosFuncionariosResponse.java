package com.testepratico.projedata.adapter.in.web.response;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class DadosFuncionariosResponse {
    String nome;
    LocalDate dataNascimento;
    BigDecimal salario;
}
