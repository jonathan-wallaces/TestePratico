package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.adapter.in.web.request.FuncionarioRequest;
import com.testepratico.projedata.application.SalvarFuncionariosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "funcionario")
public class SaveFuncionarioController {
    private final SalvarFuncionariosUseCase salvarFuncionariosUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void execute(@RequestBody FuncionarioRequest funcionarioRequest){
        salvarFuncionariosUseCase.execute(
                funcionarioRequest.getNome(),
                funcionarioRequest.getDataNascimento(),
                funcionarioRequest.getSalario(),
                funcionarioRequest.getFuncao()
        );

    }
}
