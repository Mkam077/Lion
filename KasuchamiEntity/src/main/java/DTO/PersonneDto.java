package DTO;

import java.io.Serializable;

public class PersonneDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5843075279282453960L;

	//Attributs liée au cardinalités	
	//Attribut pour le lien One To One avec CompteUser
	private CompteUserDto compteUserDto ;

	// Attributs liée à la classe
	private Long idPersonne;
	private String nom;	
	private String prenom;
	private String sexe;
	private String identifiant;
	private String avatar;


	// constructeur
	public PersonneDto() {

	}


	//Getter et Setter
	public Long getidPersonne() {
		return idPersonne;
	}

	public void setidPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}

	public String getprenom() {
		return prenom;
	}

	public void setprenom(String prenom) {
		this.prenom = prenom;
	}

	public String getsexe() {
		return sexe;
	}

	public void setsexe(String sexe) {
		this.sexe = sexe;
	}

	public String getidentifiant() {
		return identifiant;
	}

	public void setidentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getavatar() {
		return avatar;
	}

	public void setavatar(String avatar) {
		this.avatar = avatar;
	}


	public CompteUserDto getCompteUserDto() {
		return compteUserDto;
	}

	public void setCompteUerDto(CompteUserDto compteUserDto) {
		this.compteUserDto = compteUserDto;
	}

	@Override
	public String toString() {
		return "PersonneDto [idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe
				+ ", identifiant=" + identifiant + ", avatar=" + avatar + "]";
	}

}
