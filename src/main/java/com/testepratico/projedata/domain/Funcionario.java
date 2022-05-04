package com.testepratico.projedata.domain;

import lombok.*;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "tb_funcionario")
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Pessoa implements Comparable<Funcionario>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }


    public int mesNacimento() {
        return this.getDataNascimento().getMonthValue();
    }

    public int getIdade() {
        return Period.between(this.getDataNascimento(), LocalDate.now()).getYears();
    }

    public BigDecimal atualizaSalario(){
        return this.salario= this.getSalario().multiply(BigDecimal.valueOf(1.1)).setScale(2, RoundingMode.CEILING);
    }

    @Override
    public int compareTo(Funcionario o) {
        return this.getNome().compareTo(o.getNome());
    }
}

