package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries ({ @NamedQuery(name = "Personne.AfficherTout", query = "SELECT p FROM Personne p" ),
	@NamedQuery(name = "Personne.FindBy", query = "SELECT p FROM Personne p WHERE p.nom =:nomf")})

@Entity
@Table (name="Personne")
public class Personne {

	// jointure Personne a CompteUser
	@OneToOne
	@JoinColumn(name = "idCompteUser")
	private CompteUser compteUser;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long idPersonne;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "sexe")
	private String sexe;

	@Column(name = "identifiant")
	private String identifiant;

	@Column(name = "avatar")
	private String avatar;

	// Getter et Setter
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

	public String getavatar() {
		return avatar;
	}

	public void setavatar(String avatar) {
		this.avatar = avatar;
	}

	public String getidentifiant() {
		return identifiant;
	}

	public void setidentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public CompteUser getCompteUser() {
		return compteUser;
	}

	public void setCompteUser(CompteUser compteUser) {
		this.compteUser = compteUser;
	}





}
