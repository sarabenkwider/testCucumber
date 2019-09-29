package fr.altran.testCucumber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.altran.testCucumber.model.Abonne;
import fr.altran.testCucumber.model.Contrat;
import fr.altran.testCucumber.repository.IAbonneRepository;
import fr.altran.testCucumber.repository.IContratRepository;

@Component
public class AbonneServiceImpl implements IAbonneService{
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	@Autowired
	private IAbonneRepository abonneRepository;
	@Autowired
	private IContratRepository contratRepository;

	public List<Abonne> getAllAbonnes() {
		return abonneRepository.findAll();
	}

	@Override
	public Abonne addAbonne(Abonne abonne) {
		if (abonne != null) {
		return abonneRepository.save(abonne);
		}else {
			throw new RuntimeException("L'abonne ne doit pas etre null ");
		}
	}

	@Override
	public Abonne getAbonneById(Long id) {
		return abonneRepository.findById(id).get();
	}

	public Abonne updateAdress(Long id,String adress) {
		Abonne abonne = abonneRepository.findById(id).get();
		abonne.setAdress(adress);
		return abonneRepository.save(abonne);
	}

	@Override
	public Contrat addContrat(Contrat contrat) {
		if (contrat != null) {
		return contratRepository.save(contrat);
		}else {
			throw new RuntimeException("Le contrat ne doit pas etre null ");
		}
	}

	@Override
	public List<Contrat> findContratByAbonne(Abonne abonne) {
		return contratRepository.findByAbonne(abonne);
	}
}
