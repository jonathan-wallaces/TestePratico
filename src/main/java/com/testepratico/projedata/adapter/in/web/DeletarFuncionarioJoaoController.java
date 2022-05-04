package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.application.DeletarFuncionarioUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Funcionario Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/funcionario")
public class DeletarFuncionarioJoaoController {
    private final DeletarFuncionarioUseCase deletarFuncionarioUseCase;

    @Operation(summary = "Deleta o funcionário João")
    @DeleteMapping(path = "/deleta-joao")
    public void execute(){
        deletarFuncionarioUseCase.execute();
    }
}
