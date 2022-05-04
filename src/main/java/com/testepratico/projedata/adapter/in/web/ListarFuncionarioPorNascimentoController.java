package com.testepratico.projedata.adapter.in.web;

import com.testepratico.projedata.adapter.in.web.response.ListarFuncionariosResponse;
import com.testepratico.projedata.application.ListarFuncionariosPorNascimentoUseCase;
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
public class ListarFuncionarioPorNascimentoController {
    private final ListarFuncionariosPorNascimentoUseCase listarFuncionariosPorNascimentoUseCase;

    @GetMapping(path = "/mes-nascimento")
    public ResponseEntity<List<ListarFuncionariosResponse>> execute(){
        List<Funcionario> funcFiltradosPorMesNascimento = listarFuncionariosPorNascimentoUseCase.execute();
        List<ListarFuncionariosResponse> response = ListarFuncionariosResponse.of(funcFiltradosPorMesNascimento);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
