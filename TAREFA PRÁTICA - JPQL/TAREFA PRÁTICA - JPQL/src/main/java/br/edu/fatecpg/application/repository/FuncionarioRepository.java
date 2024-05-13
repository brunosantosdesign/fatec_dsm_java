package br.edu.fatecpg.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecpg.application.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
