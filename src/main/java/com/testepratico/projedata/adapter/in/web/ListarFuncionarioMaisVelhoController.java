package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.adapter.in.web.response.ListarFuncionarioMaisVelhoResponse;
import com.testepratico.projedata.application.ListarFuncionarioMaiorIdadeUseCase;
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

import java.util.Optional;
@Tag(name = "Funcionario Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/funcionario")
public class ListarFuncionarioMaisVelhoController {
    private final ListarFuncionarioMaiorIdadeUseCase listarFuncionarioMaiorIdadeUseCase;

    @Operation(summary = "Lista o funcionário com a maior idade, exibindo os atributos: nome e idade.")
    @GetMapping(path = "/mais-velho")
    public ResponseEntity<ListarFuncionarioMaisVelhoResponse> execute(){
        Funcionario funcionario = listarFuncionarioMaiorIdadeUseCase.execute();
        ListarFuncionarioMaisVelhoResponse response = ListarFuncionarioMaisVelhoResponse.of(funcionario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
