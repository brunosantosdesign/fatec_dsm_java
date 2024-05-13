package br.edu.fatecpg.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.fatecpg.application.model.Departamento;
import br.edu.fatecpg.application.model.Funcionario;
import br.edu.fatecpg.application.repository.FuncionarioRepository;
import br.edu.fatecpg.application.repository.DepartamentoRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	FuncionarioRepository funcionarioRepository;

	@Autowired
	DepartamentoRepository departamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Departamento departamento1 = new Departamento("Departamento de Vendas", "Vende");
		Departamento departamento2 = new Departamento("Departamento de TI", "Coisas de TI");
		// departamentoRepository.deleteAll();

		/*
		 * Funcionario funcionario1 = new Funcionario("Dutrette", 1.0);
		 * departamento1.setFuncionarios(funcionario1);
		 * departamentoRepository.save(departamento1);
		 * 
		 * Funcionario funcionario2 = new Funcionario("Artur", 3000);
		 * departamento1.setFuncionarios(funcionario2);
		 * departamentoRepository.save(departamento1);
		 * 
		 * Funcionario funcionario3 = new Funcionario("Luccas", 4000);
		 * departamento2.setFuncionarios(funcionario3);
		 * departamentoRepository.save(departamento2);
		 * 
		 * Funcionario funcionario4 = new Funcionario("Java 28", 8001);
		 * departamento2.setFuncionarios(funcionario4);
		 * departamentoRepository.save(departamento2);
		 */

		List<Funcionario> departamentos = departamentoRepository.findByNomeMaiorSalario(2000, "Departamento de TI");
		departamentos.forEach(System.out::println);
	}
}
