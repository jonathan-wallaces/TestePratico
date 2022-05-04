package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.application.ListarFuncionariosPorFuncaoUseCase;
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
import java.util.Map;
@Tag(name = "Funcionario Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/funcionario")
public class ListarFuncionarioPorFuncaoController {
    private final ListarFuncionariosPorFuncaoUseCase listarFuncionariosPorFuncaoUseCase;

    @Operation(summary = "Lista os funcionários, agrupados por função.")
    @GetMapping(path = "/por-funcao")
    public ResponseEntity<Map<String, List<Funcionario>>> execute(){
        Map<String, List<Funcionario>> funcPorFuncao = listarFuncionariosPorFuncaoUseCase.execute();
        return new ResponseEntity<>(funcPorFuncao, HttpStatus.OK);
    }
}
