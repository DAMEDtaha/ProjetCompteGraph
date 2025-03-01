package ma.projet.graph;

import ma.projet.graph.entities.Compte;
import ma.projet.graph.entities.TypeCompte;
import ma.projet.graph.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			// Initialisation des comptes sans passer 'id' (le 'id' sera généré automatiquement)
			compteRepository.save(new Compte(0, Math.random()*9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(0, Math.random()*9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(0, Math.random()*9000, new Date(), TypeCompte.EPARGNE));
		};
	}
}
