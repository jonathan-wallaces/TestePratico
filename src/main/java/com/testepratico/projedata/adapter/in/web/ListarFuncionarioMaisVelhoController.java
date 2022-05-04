package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.adapter.in.web.response.ListarFuncionarioMaisVelhoResponse;
import com.testepratico.projedata.application.ListarFuncionarioMaiorIdadeUseCase;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/funcionario")
public class ListarFuncionarioMaisVelhoController {
    private final ListarFuncionarioMaiorIdadeUseCase listarFuncionarioMaiorIdadeUseCase;

    @GetMapping(path = "/mais-velho")
    public ResponseEntity<ListarFuncionarioMaisVelhoResponse> execute(){
        Funcionario funcionario = listarFuncionarioMaiorIdadeUseCase.execute();
        ListarFuncionarioMaisVelhoResponse response = ListarFuncionarioMaisVelhoResponse.of(funcionario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
