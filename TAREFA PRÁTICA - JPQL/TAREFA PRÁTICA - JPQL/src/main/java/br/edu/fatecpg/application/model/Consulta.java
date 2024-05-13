package br.edu.fatecpg.application.model;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Consulta {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU_NAME");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Long departamentoId = 1L;

        TypedQuery<Funcionario> query1 = entityManager.createQuery(
                "SELECT f FROM Funcionario f WHERE f.departamento.id = :departamentoId",
                Funcionario.class);
        query1.setParameter("departamentoId", departamentoId);
        List<Funcionario> funcionariosDepartamento = query1.getResultList();
        System.out.println("Funcionários do Departamento:");
        for (Funcionario funcionario : funcionariosDepartamento) {
            System.out.println(funcionario.getNome());
        }

        String nomeFuncionario = "João";
        TypedQuery<Funcionario> query2 = entityManager.createQuery(
                "SELECT f FROM Funcionario f WHERE f.nome = :nomeFuncionario",
                Funcionario.class);
        query2.setParameter("nomeFuncionario", nomeFuncionario);
        List<Funcionario> funcionariosNomeEspecifico = query2.getResultList();
        System.out.println("\nFuncionários com Nome Específico:");
        for (Funcionario funcionario : funcionariosNomeEspecifico) {
            System.out.println(funcionario.getNome());
        }

        String nomeFuncionario2 = "Maria";
        TypedQuery<Departamento> query3 = entityManager.createQuery(
                "SELECT f.departamento FROM Funcionario f WHERE f.nome = :nomeFuncionario",
                Departamento.class);
        query3.setParameter("nomeFuncionario", nomeFuncionario2);
        Departamento departamentoFuncionarioEspecifico = query3.getSingleResult();
        System.out.println("\nDepartamento do Funcionário Específico:");
        System.out.println(departamentoFuncionarioEspecifico.getNome());

        TypedQuery<Funcionario> query4 = entityManager.createQuery(
                "SELECT f FROM Funcionario f WHERE f.departamento.id = :departamentoId",
                Funcionario.class);
        query4.setParameter("departamentoId", departamentoId);
        List<Funcionario> todosFuncionariosDepartamento = query4.getResultList();
        System.out.println("\nTodos os Funcionários do Departamento:");
        for (Funcionario funcionario : todosFuncionariosDepartamento) {
            System.out.println(funcionario.getNome());
        }

        double salarioMinimo = 3000.0;
        TypedQuery<Funcionario> query5 = entityManager.createQuery(
                "SELECT f FROM Funcionario f WHERE f.departamento.id = :departamentoId AND f.salario > :salarioMinimo",
                Funcionario.class);
        query5.setParameter("departamentoId", departamentoId);
        query5.setParameter("salarioMinimo", salarioMinimo);
        List<Funcionario> funcionariosSalarioDepartamento = query5.getResultList();
        System.out.println("\nFuncionários do Departamento que Ganham Mais do que " + salarioMinimo + ":");
        for (Funcionario funcionario : funcionariosSalarioDepartamento) {
            System.out.println(funcionario.getNome());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
