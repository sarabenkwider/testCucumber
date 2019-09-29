package fr.altran.testCucumber.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.altran.testCucumber.auditing.AbonneEntityListener;

import java.util.Collection;

@Entity
@EntityListeners(AbonneEntityListener.class)
public class Abonne extends Auditable<String> implements Serializable {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adress;
	@OneToMany(mappedBy = "abonne", fetch = FetchType.EAGER)
	private Collection<Contrat> contrats;

	public Abonne() {
		super();
	}

	public Abonne(String nom, String adress) {
		this.nom = nom;
		this.adress = adress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Collection<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(Collection<Contrat> contrats) {
		this.contrats = contrats;
	}

	@Override
	public String toString() {
		return "Abonne [id=" + id + ", nom=" + nom + ", adress=" + adress + "]";
	}

}
