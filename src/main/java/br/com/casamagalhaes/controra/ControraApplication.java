package br.com.casamagalhaes.controra;

import br.com.casamagalhaes.controra.starter.ConfigurationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ControraApplication {

	public static void main(String[] args) {
		ConfigurationInitializer.executeMigrations();
		SpringApplication.run(ControraApplication.class, args);
	}

}
