package fr.altran.testCucumber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import fr.altran.testCucumber.model.Abonne;
import fr.altran.testCucumber.model.Contrat;
import fr.altran.testCucumber.service.IAbonneService;
import java.util.Date;

@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
public class TestCucumberApplication implements CommandLineRunner {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	@Autowired
	IAbonneService abonneService;

	public static void main(String[] args) {
		SpringApplication.run(TestCucumberApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Ajouter un abonne

		Abonne a = new Abonne("Sara", "Paris");
		a = abonneService.addAbonne(a);
		System.out.println("___________" + a);

		System.out.println("___________a.getCreatedBy() : " + a.getCreatedBy());
		System.out.println("___________a.getCreatedAt() : " + a.getCreatedAt());

		// Modifier l'adressed'un abonne
		a = abonneService.updateAdress(a.getId(), "Lion");
		System.out.println("___________" + a);

		// Ajouter des contrats
		abonneService.getAllAbonnes().forEach(abonne -> {
			for (int i = 0; i < 4; i++)
				abonneService
						.addContrat(new Contrat("Contrat " + i + " d'abonnement avec canal +", new Date(), abonne));
		});

		// La liste des contrat pour d'un abonne
		abonneService.findContratByAbonne(a).forEach(contrat -> {
			System.out.println("___________" + contrat);
		});
	}
}