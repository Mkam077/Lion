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

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table (name="Societe")
@NamedQueries( {@NamedQuery(name = "Societe.afficherTout", query = "SELECT s FROM Societe s "),
	@NamedQuery(name = "Societe.findName", query = "SELECT s FROM Societe s where s.c_SOCIETE = :c_SOCIETE")
})
public class Societe {
	
	
	// Variable pour mapping	
    // type fetch Eager pour les @One ToMany et Many ToMany
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL , orphanRemoval = true , mappedBy = "societe")
	private List<Demande> demandes = new ArrayList<Demande>();
	
	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	
	// Variable
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "idSociete", unique = true)
	private Long idSociete;
	
	@Column(name = "c_SOCIETE" )
	private String c_SOCIETE ;

	@Column(name = "l_SOCIETE")
	private String l_SOCIETE;
	
	@Column(name = "Adresse_SOCIETE")
	private String Adresse_SOCIETE;
	
	@Column(name = "Num_TelSoc")
	private String Num_TelSoc;
	
	@Column(name = "Mail_Societe")
	private String Mail_Societe;

	@Column(name = "c_REGION")
	private String c_REGION;

	@Column(name = "nUM_AXE",nullable = true)
	private String nUM_AXE;
	
	
	// Getter et Setter
	
	public Long getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(Long idSociete) {
		this.idSociete = idSociete;
	}


	public String getC_SOCIETE() {
		return c_SOCIETE;
	}

	public void setC_SOCIETE(String c_SOCIETE) {
		this.c_SOCIETE = c_SOCIETE;
	}

	public String getL_SOCIETE() {
		return l_SOCIETE;
	}

	public void setL_SOCIETE(String l_SOCIETE) {
		this.l_SOCIETE = l_SOCIETE;
	}

	public String getC_REGION() {
		return c_REGION;
	}

	public void setC_REGION(String c_REGION) {
		this.c_REGION = c_REGION;
	}

	public String getNUM_AXE() {
		return nUM_AXE;
	}

	public void setNUM_AXE(String nUM_AXE) {
		this.nUM_AXE = nUM_AXE;
	}

	
	
}
