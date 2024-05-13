package br.edu.fatecpg.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.fatecpg.application.model.Departamento;
import br.edu.fatecpg.application.model.Funcionario;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    List<Departamento> findByNome(String nome);

    @Query("SELECT DISTINCT d FROM Departamento d JOIN d.funcionarios e WHERE e.nome = :nomeFuncionario")
    List<Departamento> findByNomeFuncionario(String nomeFuncionario);

    @Query("SELECT e FROM Departamento d JOIN d.funcionarios e WHERE d.nome = :nomeDepartamento AND e.salario > :salario")
    List<Funcionario> findByNomeMaiorSalario(
            double salario,
            String nomeDepartamento);

}
