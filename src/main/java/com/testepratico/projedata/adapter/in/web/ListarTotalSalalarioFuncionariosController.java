package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.application.ListarTotalSalarioFuncionariosUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@Tag(name = "Funcionario Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/funcionario")
public class ListarTotalSalalarioFuncionariosController {
    private final ListarTotalSalarioFuncionariosUseCase listarTotalSalarioFuncionariosUseCase;

    @Operation(summary = "Lista o total dos salários dos funcionários.")
    @GetMapping(path = "/total-salario")
    public ResponseEntity<BigDecimal> execute(){
        BigDecimal salarioTotal = listarTotalSalarioFuncionariosUseCase.execute();
        return new ResponseEntity<>(salarioTotal, HttpStatus.OK);
    }
}
