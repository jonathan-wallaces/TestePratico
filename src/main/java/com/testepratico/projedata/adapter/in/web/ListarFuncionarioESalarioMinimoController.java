package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.adapter.in.web.response.ListarFuncionariosSalarioMinimoResponse;
import com.testepratico.projedata.application.ListarFuncionarioAlfabeticamenteUseCase;
import com.testepratico.projedata.domain.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "Funcionario Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/funcionario")
public class ListarFuncionarioESalarioMinimoController {
    private final ListarFuncionarioAlfabeticamenteUseCase listarFuncionarioAlfabeticamenteUseCase;

    @Operation(summary = "Lista quantos salários mínimos ganha cada funcionário")
    @GetMapping(path = "/funcionario-salmin")
    public ResponseEntity<List<ListarFuncionariosSalarioMinimoResponse>> execute(){
        List<Funcionario> funcionarios = listarFuncionarioAlfabeticamenteUseCase.execute();
        List<ListarFuncionariosSalarioMinimoResponse> response = ListarFuncionariosSalarioMinimoResponse.of(funcionarios);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
