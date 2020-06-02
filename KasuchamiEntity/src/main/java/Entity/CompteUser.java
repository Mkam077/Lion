package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="CompteUser")
@NamedQueries ( {@NamedQuery ( name = "CompteUser.AfficherTout", query = "SELECT c FROM CompteUser c"),
	@NamedQuery(name = "CompteUser.findName", query = "SELECT c FROM CompteUser c WHERE c.identifiant = :nomf"),
	@NamedQuery(name = "CompteUser.connexion", query = "SELECT c FROM CompteUser c WHERE c.identifiant =:nomf AND c.motDePasse = :nomg ")
	
})
public class CompteUser {

	// jointure CompteUser a Personne
	@OneToOne(mappedBy = "compteUser")
	private Personne personne;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCompteUser;


	@Column( name = "identifiant")
	private String identifiant;

	@Column( name = "motDePasse")
	private String motDePasse;

	
	
	//Getter et setter
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Long getIdCompteUser() {
		return idCompteUser;
	}

	public void setIdCompteUser(Long idCompteUser) {
		this.idCompteUser = idCompteUser;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	
	


}
