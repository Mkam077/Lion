package DTO;


import java.io.Serializable;
import java.time.LocalDate;
import Entity.Catalogue;
import Entity.Demande;


public class DetailDemandeDto2 implements Serializable{

	
	
	
	
	// Variables liées à la cardinalité
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8494487788496362448L;


	private Demande demande;
	
	private Catalogue catalogue;
	
	// variable de la classe

	
	private Long LigneDetaiDemandeid;
	
	private Long demandeid;
	
	private Long catalogueid;
	
	private String nUM_DEMANDE;
	
	
	private String nUM_REF_PROD;

	
	private String description;

	
	private LocalDate  date_BESOIN;

	
	private String c_CLASSIF_ACHAT;

	
	private Integer frais_PORT;
	
	
	private Integer montant_TOTAL;
	
	
	private Integer quantite;
	
	
	private String lieu_LIVRAISON;
	
	// constructeur 
	public DetailDemandeDto2 () {}
	
	// Getter Setter

	
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

	

	public Long getDemandeid() {
		return demandeid;
	}

	public void setDemandeid(Long demandeid) {
		this.demandeid = demandeid;
	}



	public Long getLigneDetaiDemandeid() {
		return LigneDetaiDemandeid;
	}

	public void setLigneDetaiDemandeid(Long ligneDetaiDemandeid) {
		LigneDetaiDemandeid = ligneDetaiDemandeid;
	}

	public Long getCatalogueid() {
		return catalogueid;
	}

	public void setCatalogueid(Long catalogueid) {
		this.catalogueid = catalogueid;
	}

	public String getLieu_LIVRAISON() {
		return lieu_LIVRAISON;
	}

	public void setLieu_LIVRAISON(String lieu_LIVRAISON) {
		this.lieu_LIVRAISON = lieu_LIVRAISON;
	}

	
	
}
