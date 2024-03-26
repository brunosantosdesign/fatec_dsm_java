package br.edu.fatecpg.todolist.todolist;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Connection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Jedis jedis = new Jedis("redis://default:geFu3Q3qUCgpuhNYP8mzjULv1M1rXtMe@redis-19830.c308.sa-east-1-1.ec2.cloud.redislabs.com:19830");
		Connection connection = jedis.getConnection();

		System.out.println(jedis.ping());

		String tarefa = "{id:01, descricao:comprar pão, status:pendente}";
		String tarefa2 = "{id:02, descricao:comprar pizza, status:pendente}";
		jedis.set("tarefa:01",tarefa);
		jedis.set("tarefa:02",tarefa2);
		System.out.println("Mostrando Tarefas");
		System.out.println(jedis.get("tarefa:01"));
		System.out.println(jedis.get("tarefa:02"));

		String tarefa_concluida = "{id:01, descricao:comprar pão, status:concluido}";
		jedis.set("tarefa:01",tarefa_concluida);

		System.out.println("Mostrando Tarefas");
		System.out.println(jedis.get("tarefa:01"));
		System.out.println(jedis.get("tarefa:02"));

		jedis.del("tarefa:01");

		System.out.println("Mostrando Tarefas");
		System.out.println(jedis.get("tarefa:01"));
		System.out.println(jedis.get("tarefa:02"));
	}
}
