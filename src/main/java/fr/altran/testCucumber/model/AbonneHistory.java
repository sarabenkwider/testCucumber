package fr.altran.testCucumber.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import fr.altran.testCucumber.auditing.Action;
import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class AbonneHistory {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	@Id
	@GeneratedValue
	private Long id;
	private String abonneName;
	private String abonneContent;

	@CreatedBy
	private String modifiedBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	@Enumerated(EnumType.STRING)
	private Action action;

	public AbonneHistory() {
	}

	public AbonneHistory(String abonne, Action action) {
		this.abonneName = abonne;
		this.action = action;
		this.abonneContent = abonne.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getabonneName() {
		return abonneName;
	}

	public void setabonneName(String abonneName) {
		this.abonneName = abonneName;
	}

	public String getabonneContent() {
		return abonneContent;
	}

	public void setabonneContent(String abonneContent) {
		this.abonneContent = abonneContent;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}
}