package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table (name="Fournisseur")
@NamedQueries( {@NamedQuery(name = "Fournisseur.afficherTout", query = "SELECT f FROM Fournisseur f "),
	@NamedQuery(name = "Fournisseur.findName", query = "SELECT f FROM Fournisseur f where f.c_Fournisseur = :c_Fournisseur")
})
public class Fournisseur {
	
	
	// Variable pour mapping	
    // type fetch Eager pour les @One ToMany et Many ToMany
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL , orphanRemoval = true , mappedBy = "fournisseur")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Demande> demandes = new ArrayList<Demande>();
	
	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL , orphanRemoval = true , mappedBy = "fournisseur")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Catalogue> catalogues = new ArrayList<Catalogue>();
	
	public List<Catalogue> getCatalogues() {
		return catalogues;
	}

	public void setCatalogues(List<Catalogue> catalogues) {
		this.catalogues = catalogues;
	}
	
	// Variable
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "idFournisseur", unique = true)
	private Long idFournisseur;
	
	@Column(name = "c_Fournisseur" )
	private String c_Fournisseur ;

	@Column(name = "l_Fournisseur")
	private String l_Fournisseur;

	@Column(name = "Num_TelFour")
	private String Num_TelFour;

	@Column(name = "Adresse_Fournisseur")
	private String Adresse_Fournisseur;	
	
	@Column(name = "Mailfournisseur")
	private String Mailfournisseur;
	
	@Column(name = "NumeroKbis")
	private String NumeroKbis;
	// Getter et Setter
	
	public Long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getC_Fournisseur() {
		return c_Fournisseur;
	}

	public void setC_Fournisseur(String c_Fournisseur) {
		this.c_Fournisseur = c_Fournisseur;
	}

	public String getL_Fournisseur() {
		return l_Fournisseur;
	}

	public void setL_Fournisseur(String l_Fournisseur) {
		this.l_Fournisseur = l_Fournisseur;
	}

	public String getNum_TelFour() {
		return Num_TelFour;
	}

	public void setNum_TelFour(String num_TelFour) {
		Num_TelFour = num_TelFour;
	}

	public String getAdresse_Fournisseur() {
		return Adresse_Fournisseur;
	}

	public void setAdresse_Fournisseur(String adresse_Fournisseur) {
		Adresse_Fournisseur = adresse_Fournisseur;
	}
	
	public String getMailfournisseur() {
		return Mailfournisseur;
	}

	public void setMailfournisseur(String Mailfournisseur) {
		Mailfournisseur = Mailfournisseur;
	}
	
	public String getNumeroKbis() {
		return NumeroKbis;
	}

	public void setNumeroKbis(String NumeroKbis) {
		NumeroKbis = NumeroKbis;
	}
	
}
