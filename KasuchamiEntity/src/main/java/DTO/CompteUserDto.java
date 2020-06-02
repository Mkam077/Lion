package DTO;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompteUserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1386155735245364439L;
	
//Attributs liée au cardinalités	
	//Attribut pour le lien One To One avec personne
	private PersonneDto personneDto ;
	
	
	//Attribut de la classe	
	private Long idCompteUser;
	@NotNull(message = "Veuillez remplir ce champs")
	@NotBlank(message = "Veuillez remplir ce champs")
	private String identifiant;
	@NotNull(message = "Veuillez remplir ce champs")
	@NotBlank(message = "Veuillez remplir ce champs")
	private String motDePasse;

   // constructeur
	public CompteUserDto() {
		
	}
	
	//Getter et Setter
	public Long getidCompteUser() {
		return idCompteUser;
	}	
	public void setidCompteUser(Long idCompteUser) {
		this.idCompteUser = idCompteUser;
	}
	public String getidentifiant() {
		return identifiant;
	}
	public void setidentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getmotDePasse() {
		return motDePasse;
	}
	public void setmotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}	
	public PersonneDto getPersonneDto() {
		return personneDto;
	}
	public void setPersonneDto(PersonneDto personneDto) {
		this.personneDto = personneDto;
	}

	@Override
	public String toString() {
		return "CompteUserDto [personneDto=" + personneDto + ", idCompteUser=" + idCompteUser + ", identifiant="
				+ identifiant + ", motDePasse=" + motDePasse + "]";
	}

//to String
//	@Override
//	public String toString() {
//		
//		StringBuilder builder = new StringBuilder();
//		
//		builder.append("IdCompteUser=");
//		builder.append("IdCompteUser");
//		builder.append(", Identifiant=");
//		builder.append("Identifiant");
//		builder.append(", MotDePasse=");
//		builder.append("MotDePasse");
//		
//		return builder.toString();
//	}


	
	
	
	
	
	
	
	
	
	
	
	

}
