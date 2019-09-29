package fr.altran.testCucumber.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contrat implements Serializable {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contenue;
	private Date dateEffet;
	@ManyToOne
	@JoinColumn(name = "ID_ABONNE")
	private Abonne abonne;

	public Contrat() {
		super();
	}

	public Contrat(String contenue, Date dateEffet, Abonne abonne) {
		super();
		this.contenue = contenue;
		this.dateEffet = dateEffet;
		this.abonne = abonne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContenue() {
		return contenue;
	}

	public void setContenue(String contenue) {
		this.contenue = contenue;
	}

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", contenue=" + contenue + ", dateEffet=" + dateEffet + ", abonne=" + abonne + "]";
	}
}
