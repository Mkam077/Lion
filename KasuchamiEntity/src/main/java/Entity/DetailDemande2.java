package Entity;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;



@Entity
@Table (name="DetailDemande2")
@NamedQueries( {@NamedQuery (name = "DetailDemande2.findName", query = "select k from DetailDemande2 k where k.nUM_DEMANDE = nomf"),
	  @NamedQuery (name = "DetailDemande2.afficherTout", query = "SELECT k FROM DetailDemande2 k" ),
	 
	})
public  class DetailDemande2 {
		  
				
	///////Lien vers  les tables demande et catalogue au niveau mapping////
	// Lien vers la table Demande////
	
	@ManyToOne ( fetch = FetchType.LAZY)
	private Demande demande;
	
	// Lien vers la table Catalogue//
	
	@ManyToOne ( fetch = FetchType.LAZY)
	private Catalogue catalogue;
    

		
	///////// Variable de la table DétailsDemande///////
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "LigneDetaiDemandeid")
	private Long LigneDetaiDemandeid;
	
	
	@Column(name = "demandeid")
	private Long demandeid;
	
	
	@Column(name = "catalogueid")
	private Long catalogueid;
		
	@Column(name = "nUM_DEMANDE")
	private String nUM_DEMANDE;
	
	@Column(name = "nUM_REF_PROD")
	private String nUM_REF_PROD;

	@Column(name = "description")
	private String description;

	@Column(name = "date_BESOIN")
	private LocalDate  date_BESOIN;

	@Column(name = "c_CLASSIF_ACHAT")
	private String c_CLASSIF_ACHAT;

	@Column(name = "frais_PORT")
	private Integer frais_PORT;
	
	@Column(name = "montant_TOTAL")
	private Integer montant_TOTAL;
	
	@Column(name = "quantite")
	private Integer quantite;
	
	@Column(name = "lieuLIVRAISON")
	private String lieu_LIVRAISON;
	
	
	///////////////////Getter et Setter de la Table DétailDeamande/////////////////////////////////

	public String getnUM_DEMANDE() {
		return nUM_DEMANDE;
	}

	public void setnUM_DEMANDE(String nUM_DEMANDE) {
		this.nUM_DEMANDE = nUM_DEMANDE;
	}

	public String getnUM_REF_PROD() {
		return nUM_REF_PROD;
	}

	public void setnUM_REF_PROD(String nUM_REF_PROD) {
		this.nUM_REF_PROD = nUM_REF_PROD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate_BESOIN() {
		return date_BESOIN;
	}

	public void setDate_BESOIN(LocalDate date_BESOIN) {
		this.date_BESOIN = date_BESOIN;
	}

	public String getC_CLASSIF_ACHAT() {
		return c_CLASSIF_ACHAT;
	}

	public void setC_CLASSIF_ACHAT(String c_CLASSIF_ACHAT) {
		this.c_CLASSIF_ACHAT = c_CLASSIF_ACHAT;
	}

	public Integer getFrais_PORT() {
		return frais_PORT;
	}

	public void setFrais_PORT(Integer frais_PORT) {
		this.frais_PORT = frais_PORT;
	}

	public Integer getMontant_TOTAL() {
		return montant_TOTAL;
	}

	public void setMontant_TOTAL(Integer montant_TOTAL) {
		this.montant_TOTAL = montant_TOTAL;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getLieu_LIVRAISON() {
		return lieu_LIVRAISON;
	}

	public void setLieu_LIVRAISON(String lieu_LIVRAISON) {
		this.lieu_LIVRAISON = lieu_LIVRAISON;
	}

	
	
	public Long getDemandeid() {
		return demandeid;
	}

	public void setDemandeid(Long demandeid) {
		this.demandeid = demandeid;
	}

	public Long getCatalogueid() {
		return catalogueid;
	}

	public void setCatalogueid(Long catalogueid) {
		this.catalogueid = catalogueid;
	}

	
	
	
	public Long getLigneDetaiDemandeid() {
		return LigneDetaiDemandeid;
	}

	public void setLigneDetaiDemandeid(Long ligneDetaiDemandeid) {
		LigneDetaiDemandeid = ligneDetaiDemandeid;
	}
    
	
	
	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	/////////////////////////////To String////////////////////////////////
	@Override
	public String toString() {
		return "DetailDemande [ nUM_DEMANDE=" + nUM_DEMANDE + ", nUM_REF_PROD=" + nUM_REF_PROD
				+ ", description=" + description + ", date_BESOIN=" + date_BESOIN + ", c_CLASSIF_ACHAT="
				+ c_CLASSIF_ACHAT + ", frais_PORT=" + frais_PORT + ", montant_TOTAL=" + montant_TOTAL + ", quantite="
				+ quantite + ", lieu_LIVRAISON=" + lieu_LIVRAISON + "]";
	}
	
}
	
	
	

	