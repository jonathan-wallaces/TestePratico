package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.adapter.in.web.response.ListarFuncionariosResponse;
import com.testepratico.projedata.application.ListarFuncionariosComAumentoUseCase;
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
public class ListarFuncionariosComAumentoController {
    private final ListarFuncionariosComAumentoUseCase listarFuncionariosComAumentoUseCase;

    @Operation(summary = "Lista os funcionários após receberem aumento de 10% no salário")
    @GetMapping(path = "/salario-reajustado")
    public ResponseEntity<List<ListarFuncionariosResponse>> execute(){
        List<Funcionario> funcionarios = listarFuncionariosComAumentoUseCase.execute();
        List<ListarFuncionariosResponse> response = ListarFuncionariosResponse.of(funcionarios);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
