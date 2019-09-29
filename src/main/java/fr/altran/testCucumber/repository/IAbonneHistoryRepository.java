package fr.altran.testCucumber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.altran.testCucumber.model.AbonneHistory;

@Repository
public interface IAbonneHistoryRepository extends JpaRepository<AbonneHistory, Long> {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

}
