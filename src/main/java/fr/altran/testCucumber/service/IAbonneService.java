package fr.altran.testCucumber.service;

import java.util.List;

import fr.altran.testCucumber.model.Abonne;
import fr.altran.testCucumber.model.Contrat;

public interface IAbonneService {

	public List<Abonne> getAllAbonnes();

	public Abonne addAbonne(Abonne abonne);

	public Abonne getAbonneById(Long id);

	public Abonne updateAdress(Long id,String adress);

	public Contrat addContrat(Contrat contrat);

	public List<Contrat> findContratByAbonne(Abonne abonne);
}
