package com.testepratico.projedata.application.port.out;

import com.testepratico.projedata.domain.Funcionario;

import java.util.List;

public interface FuncionarioPort {
    void saveFuncionario(Funcionario funcionario);
    List<Funcionario> listAll();

    void saveTodosFuncionarios(List<Funcionario> funcionarioList);
}
