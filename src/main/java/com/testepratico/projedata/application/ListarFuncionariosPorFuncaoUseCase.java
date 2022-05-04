package com.testepratico.projedata.application;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListarFuncionariosPorFuncaoUseCase {
    private final FuncionarioPort funcionarioPort;

    public Map<String, List<Funcionario>> execute(){
        List<Funcionario> funcionario = funcionarioPort.listAll();
       // List<String> funcoes = funcionario.stream().map(Funcionario::getFuncao).collect(Collectors.toList());
       // Map<List<String>, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();
      //  funcionariosPorFuncao.put(funcoes, funcionario);

        Map<String, List<Funcionario>> f = funcionario.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        return f;
    }
}
