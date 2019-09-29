package fr.altran.testCucumber.stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.altran.testCucumber.model.Abonne;
import fr.altran.testCucumber.model.Contrat;
import fr.altran.testCucumber.service.IAbonneService;

@ContextConfiguration
@SpringBootTest
public class Steps {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	@Autowired
	IAbonneService abonneService;
	private Abonne abonne;

	@Given("^Un abonne de nom \"([^\"]*)\" et adresse \"([^\"]*)\" avec une adresse principale active en France$")
	public void Un_abonne_de_nom_et_adresse_avec_une_adresse_principale_active_en_France(String nom, String adress)
			throws Throwable {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		// Ajouter un abonne
		abonne = abonneService.addAbonne(new Abonne(nom, adress));
		System.out.println("________________L'abonne est bien enregistrer : " + abonne);

		// Ajouter des contrats à l'abonné abonne
		for (int i = 0; i < 4; i++)
			abonneService.addContrat(new Contrat("Contrat " + i + " d'abonnement avec canal +", new Date(), abonne));

		abonneService.findContratByAbonne(abonne).forEach(contrat -> {
			System.out.println("________________Le contrat est bien enregistrer : " + contrat);
		});
	}

	@When("^Le conseiller connecte à canal modifie l'adresse \"([^\"]*)\" de l'abonne (\\d+) sans date d'effet$")
	public void Le_conseiller_connecte_à_canal_modifie_l_adresse_de_l_abonne_sans_date_d_effet(String adress, Long id)
			throws Throwable {

		// Verifier que l'abonne n'est pas null
		Assert.assertNotNull(abonneService.getAbonneById(id));
		// Modifier l'adresse de l'abonné
		abonne = abonneService.updateAdress(id, adress);
		System.out.println("________________L'abonné est bien modifie sont adresse : " + abonne);
	}

	@Then("^L'adresse \"([^\"]*)\" de l'abonne (\\d+) modifiee est enregistree sur l'ensemble des contrats de l'abonne$")
	public void L_adresse_de_l_abonne_modifiee_est_enregistree_sur_l_ensemble_des_contrats_de_l_abonne(String adress,
			Long id) throws Throwable {

		// Verifier que l'abonne n'est pas null
		abonne = abonneService.getAbonneById(id);
		Assert.assertNotNull(abonne);
		// Verifier que l'adress d'abonné est bien modifié
		Assert.assertEquals(adress, abonne.getAdress());
		System.out.println("________________La nouvelle adresse est : " + adress);

		// Verifier que la nouvelle adresse d'abonne modifiee est enregistree
		// sur l'ensemble des contrats
		abonneService.findContratByAbonne(abonne).forEach(contrat -> {
			Assert.assertEquals(adress, contrat.getAbonne().getAdress());
			System.out.println("________________L'adresse est bien modifie dans ce contrat: " + contrat);
		});
	}

	@Then("^Un mouvement de modification d'adresse est cree le \"([^\"]*)\" par \"([^\"]*)\"$")
	public void Un_mouvement_de_modification_d_adresse_est_cree_le_par(String date, String nom) throws Throwable {
		Assert.assertEquals(nom, abonne.getLastUpdateBy());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		Assert.assertEquals(date, sdf.format(abonne.getLastUpdateAt()));
		System.out.println("________________Ce mouvement de modification est cree le " + date + " par " + nom);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
