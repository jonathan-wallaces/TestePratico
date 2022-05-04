package com.testepratico.projedata.adapter.out.persistence;

import com.testepratico.projedata.application.port.out.FuncionarioPort;
import com.testepratico.projedata.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioPersistenceAdapter implements FuncionarioPort {
    private final FuncionarioRepository funcionarioRepository;
    @Override
    public void saveFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> listAll() {
        return funcionarioRepository.findAll();
    }

    @Override
    public void saveTodosFuncionarios(List<Funcionario> funcionarioList) {
        funcionarioRepository.saveAll(funcionarioList);
    }

    @Override
    public void delete(Funcionario func) {
        funcionarioRepository.delete(func);
    }

}
