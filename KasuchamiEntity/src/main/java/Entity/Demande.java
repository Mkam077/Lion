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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;



@Entity
@Table (name="Demande")
@NamedQueries( {@NamedQuery (name = "Demande.findName", query = "select d from Demande d where d.nUM_DEMANDE = nomf"),
	  @NamedQuery (name = "Demande.afficherTout", query = "SELECT d FROM Demande d" ),
	  @NamedQuery (name = "Demande.findId", query = "select d from Demande d where d.idDemande =: idDemandeValue"),
	  @NamedQuery (name = "Demande.findMAXId", query = "SELECT d FROM Demande d WHERE d.idDemande = ( SELECT MAX(d.idDemande) FROM d) ")
	})
public class Demande {
	
	//Jointure avec fournisseur et Getter et Setter de la cardinalité////
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Fournisseur")
	private Fournisseur fournisseur;
	
	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public  void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
		
	}
	//Jointure avec societe et Getter et Setter de la cardinalité////
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "Societe")
		private Societe societe;
		
		public Societe getSociete() {
			return societe;
		}

		public  void setSociete(Societe societe) {
			this.societe = societe;
			
		}
//jointure avec table d' association DétailDemande ///
@OneToMany ( mappedBy = "demande", cascade = CascadeType.ALL, orphanRemoval = true)
private List<DetailDemande> detailDemandes = new ArrayList<>();
public List<DetailDemande> getDetailDemandes() {
	return detailDemandes;
}

public void setDetailDemandes(List<DetailDemande> detailDemandes) {
	this.detailDemandes = detailDemandes;
}
////////////////////////////////////Avec Seconde possibilité////////	

@OneToMany ( mappedBy = "demande", cascade = CascadeType.ALL, orphanRemoval = true)
@Fetch(value = FetchMode.SUBSELECT)
private List<DetailDemande2> detailDemandes2 = new ArrayList<>();
public List<DetailDemande2> getDetailDemandes2() {
	return detailDemandes2;
}

public void setDetailDemandes2(List<DetailDemande2> detailDemandes2) {
	this.detailDemandes2 = detailDemandes2;

}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "idDemande")
	private Long idDemande;
	
	
	//Entête Demande 
	
	@Column(name = "nUM_DEMANDE")
	private String nUM_DEMANDE;
	
	  //Société
	@Column(name = "c_SOCIETE")
	private String c_SOCIETE;
	
	@Column(name = "l_SOCIETE")
	private String l_SOCIETE;
	
	@Column(name = "Num_TelSoc")
	private String Num_TelSoc;
	
	@Column(name = "Mail_Societe")
	private String Mail_Societe;
	
	@Column(name = "Adresse_SOCIETE")
	private String Adresse_SOCIETE;
	
	  //Fournisseur
	@Column(name = "c_Fournisseur")
	private String c_Fournisseur;
	
	@Column(name = "l_Fournisseur")
	private String l_Fournisseur;
	
	@Column(name = "Num_TelFour")
	private String Num_TelFour;

	@Column(name = "Adresse_Fournisseur")
	private String Adresse_Fournisseur;	
	
	@Column(name = "Mailfournisseur")
	private String Mailfournisseur;
	
	//Informations complémentaires 

	@Column(name = "Incoterm")
	private String Incoterm;
	
	@Column(name = "c_REGION")
	private String c_REGION;

	@Column(name = "c_ETAT")
	private String c_ETAT;

	@Column(name = "URGENT")
	private String urgent;

	@Column(name = "c_DOMAINE")
	private String c_DOMAINE;
	
	@Column(name = "c_TYP_COMMANDE")
	private String c_TYP_COMMANDE;
	
	@Column(name = "c_TYP_FLUX_APPRO")
	private String c_TYP_FLUX_APPRO;
	
	@Column(name = "nOTE_APPROVISIONNEUR")
	private String nOTE_APPROVISIONNEUR;
	
	@Column(name = "nOTE_FOURNISSEUR")
	private String nOTE_FOURNISSEUR;
		
	@Column(name = "cOM_DEMANDEUR")
	private String cOM_DEMANDEUR;
	
	@Column(name = "c_CLASSIF_ACHAT")
	private String c_CLASSIF_ACHAT;
	
	///////// Variables pour mapping ////////
		
	// Getter et Setter
	public Long getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(Long idDemande) {
		this.idDemande = idDemande;
	}

	public String getnUM_DEMANDE() {
		return nUM_DEMANDE;
	}

	public void setnUM_DEMANDE(String nUM_DEMANDE) {
		this.nUM_DEMANDE = nUM_DEMANDE;
	}

	public String getC_REGION() {
		return c_REGION;
	}

	public void setC_REGION(String c_REGION) {
		this.c_REGION = c_REGION;
	}

	public String getC_ETAT() {
		return c_ETAT;
	}

	public void setC_ETAT(String c_ETAT) {
		this.c_ETAT = c_ETAT;
	}

	public String getUrgent() {
		return urgent;
	}

	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}

	public String getC_DOMAINE() {
		return c_DOMAINE;
	}

	public void setC_DOMAINE(String c_DOMAINE) {
		this.c_DOMAINE = c_DOMAINE;
	}

	public String getC_TYP_COMMANDE() {
		return c_TYP_COMMANDE;
	}

	public void setC_TYP_COMMANDE(String c_TYP_COMMANDE) {
		this.c_TYP_COMMANDE = c_TYP_COMMANDE;
	}

	public String getC_TYP_FLUX_APPRO() {
		return c_TYP_FLUX_APPRO;
	}

	public void setC_TYP_FLUX_APPRO(String c_TYP_FLUX_APPRO) {
		this.c_TYP_FLUX_APPRO = c_TYP_FLUX_APPRO;
	}

	public String getnOTE_APPROVISIONNEUR() {
		return nOTE_APPROVISIONNEUR;
	}

	public void setnOTE_APPROVISIONNEUR(String nOTE_APPROVISIONNEUR) {
		this.nOTE_APPROVISIONNEUR = nOTE_APPROVISIONNEUR;
	}

	public String getnOTE_FOURNISSEUR() {
		return nOTE_FOURNISSEUR;
	}

	public void setnOTE_FOURNISSEUR(String nOTE_FOURNISSEUR) {
		this.nOTE_FOURNISSEUR = nOTE_FOURNISSEUR;
	}

	public String getcOM_DEMANDEUR() {
		return cOM_DEMANDEUR;
	}

	public void setcOM_DEMANDEUR(String cOM_DEMANDEUR) {
		this.cOM_DEMANDEUR = cOM_DEMANDEUR;
	}

	

	public String getC_CLASSIF_ACHAT() {
		return c_CLASSIF_ACHAT;
	}

	public void setC_CLASSIF_ACHAT(String c_CLASSIF_ACHAT) {
		this.c_CLASSIF_ACHAT = c_CLASSIF_ACHAT;
	}

	public String getC_SOCIETE() {
		return c_SOCIETE;
	}

	public void setC_SOCIETE(String c_SOCIETE) {
		this.c_SOCIETE = c_SOCIETE;
	}
	
	
	public String getC_Fournisseur() {
		return c_Fournisseur;
	}

	public void setC_Fournisseur(String c_Fournisseur) {
		this.c_Fournisseur= c_Fournisseur;
	}
	
	public String getIncoterm() {
		return Incoterm;
	}

	public void setIncoterm(String Incoterm) {
		this.Incoterm= Incoterm;
	}
	
	
	
	
	
}
