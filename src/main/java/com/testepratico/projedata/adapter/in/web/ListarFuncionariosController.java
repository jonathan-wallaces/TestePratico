package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.adapter.in.web.response.ListarFuncionariosResponse;
import com.testepratico.projedata.application.ListarFuncionariosUseCase;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/funcionario")
public class ListarFuncionariosController {
    private final ListarFuncionariosUseCase listarFuncionariosUseCase;

    @GetMapping
    public ResponseEntity<List<ListarFuncionariosResponse>> execute(){
        List<Funcionario> funcionarios = listarFuncionariosUseCase.execute();
        List<ListarFuncionariosResponse> response = ListarFuncionariosResponse.of(funcionarios);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}
