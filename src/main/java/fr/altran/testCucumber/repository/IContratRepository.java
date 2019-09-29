package fr.altran.testCucumber.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.altran.testCucumber.model.Abonne;
import fr.altran.testCucumber.model.Contrat;

@Repository
public interface IContratRepository extends JpaRepository<Contrat, Long> {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	List<Contrat> findByAbonne(Abonne abonne);

}
