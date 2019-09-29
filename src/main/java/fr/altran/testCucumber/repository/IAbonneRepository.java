package fr.altran.testCucumber.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.altran.testCucumber.model.Abonne;

@Repository
public interface IAbonneRepository extends JpaRepository<Abonne, Long> {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	Optional<Abonne> findById(int id);

}
