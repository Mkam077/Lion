package Entity;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

//Methode 1
@IdClass(DetailDemandeId.class)


@Entity
@Table (name="DetailDemande")
@NamedQueries( {@NamedQuery (name = "DetailDemande.findName", query = "select dd from DetailDemande dd where dd.nUM_DEMANDE =: nomf"),
	  @NamedQuery (name = "DetailDemande.afficherTout", query = "SELECT dd FROM DetailDemande dd" ),
	  @NamedQuery (name = "DetailDemande.afficherDerniereDemande", query = "SELECT dd FROM DetailDemande dd WHERE dd.demandeid = ( SELECT MAX(dd.demandeid) FROM dd)"),
	  @NamedQuery (name = "DetailDemande.afficherDerniereDemandeId", query = "SELECT dd FROM DetailDemande dd WHERE dd.demandeid =: idmax"),
	  @NamedQuery (name = "DetailDemande.afficherMontTotalDrniereDemande", query = "SELECT SUM(dd.montant_TOTAL) FROM DetailDemande dd WHERE dd.demandeid = ( SELECT MAX(dd.demandeid) FROM dd)"),
	  @NamedQuery (name = "DetailDemande.afficherFraisDePortTotal", query = "SELECT SUM(dd.frais_PORT) FROM DetailDemande dd WHERE dd.demandeid = ( SELECT MAX(dd.demandeid) FROM dd)"),
	  @NamedQuery  (name = "DetailDemande.afficherPrix", query = "select c.montant from DetailDemande dd Left join Catalogue c on (dd.catalogueid = c.catalogueid ) where c.catalogueid =: IdDDCat"),
      @NamedQuery(name="DetailDemande.supprimerLigne" , query="SELECT dd FROM DetailDemande dd WHERE dd.catalogueid =: IDCAT AND dd.demandeid =: IDDEM")

	 // @NamedQuery  (name = "DetailDemande.findCatalogue", query = "select c from DetailDemande dd Left join Catalogue c on (dd.catalogueid = c.catalogueid ) where dd.catalogueid =: catalogueidValue")
	})
public  class DetailDemande {
	//Methode 2
	//@EmbeddedId
	//private DetailDemandeId detailDemandeID;	  
				
	///////Lien vers  les tables demande et catalogue au niveau mapping////
	// Lien vers la table Demande////
	
	@ManyToOne ( fetch = FetchType.EAGER)
	private Demande demande;
	
	// Lien vers la table Catalogue//
	
	@ManyToOne ( fetch = FetchType.EAGER)
	private Catalogue catalogue;
    

		
	///////// Variable de la table DétailsDemande///////
	
	@Id
	@Column(name = "demandeid")
	private Long demandeid;
	
	@Id
	@Column(name = "catalogueid")
	private Long catalogueid;
		
	@Column(name = "nUM_DEMANDE")
	private String nUM_DEMANDE;
	
	@Column(name = "nUM_REF_PROD")
	private String nUM_REF_PROD;

	@Column(name = "description")
	private String description;
    
	@DateTimeFormat(pattern = "dd-MM-yyyy")
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
	
	@Column(name = "montant")
	private Integer montant;
	
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

	public Integer getMontant() {
		return montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
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
	
	
	

	