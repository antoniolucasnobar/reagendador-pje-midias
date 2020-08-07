package br.jus.trt4.pje.midias.reagendador;

import br.jus.trt4.pje.midias.reagendador.repository.AudienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.swing.*;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("br.jus.trt4.pje.midias.reagendador.repository")
public class ReagendadorApplication implements CommandLineRunner {

	@Autowired
	ReagendadorService reagendadorService;

	public static void main(String[] args) {
		SpringApplication.run(ReagendadorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		reagendadorService.reagendar();
		System.exit(0);
	}
}
