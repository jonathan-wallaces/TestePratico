package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.adapter.in.web.response.ListarFuncionariosResponse;
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
public class ListarFuncionariosAlfabeticamenteController {
    private final ListarFuncionarioAlfabeticamenteUseCase listarFuncionarioAlfabeticamenteUseCase;

    @Operation(summary = "Lista os funcionários por ordem alfabética")
    @GetMapping(path = "/ordenado-alfabeticamente")
    public ResponseEntity<List<ListarFuncionariosResponse>> execute(){
        List<Funcionario> funcionariosOrdenados = listarFuncionarioAlfabeticamenteUseCase.execute();
        List<ListarFuncionariosResponse> response = ListarFuncionariosResponse.of(funcionariosOrdenados);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
