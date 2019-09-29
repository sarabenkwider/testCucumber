package fr.altran.testCucumber.auditing;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import fr.altran.testCucumber.model.Abonne;
import fr.altran.testCucumber.model.AbonneHistory;
import static fr.altran.testCucumber.auditing.Action.DELETED;
import static fr.altran.testCucumber.auditing.Action.INSERTED;
import static fr.altran.testCucumber.auditing.Action.UPDATED;

public class AbonneEntityListener {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	@PrePersist
	public void prePersist(Abonne abonne) {
		perform(abonne, INSERTED);
	}

	@PreUpdate
	public void preUpdate(Abonne abonne) {
		perform(abonne, UPDATED);
	}

	@PreRemove
	public void preRemove(Abonne abonne) {
		perform(abonne, DELETED);
	}

	@Transactional(Transactional.TxType.MANDATORY)
	private void perform(Abonne abonne, Action action) {
		EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
		entityManager.persist(new AbonneHistory(abonne.getNom(), action));
	}
}
