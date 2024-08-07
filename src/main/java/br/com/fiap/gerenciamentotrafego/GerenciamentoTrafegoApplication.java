package br.com.fiap.gerenciamentotrafego;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class GerenciamentoTrafegoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(GerenciamentoTrafegoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
