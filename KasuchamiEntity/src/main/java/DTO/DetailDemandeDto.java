package DTO;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import Entity.Catalogue;
import Entity.Demande;


public class DetailDemandeDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5360414952723387316L;
	
	
	// Variables liées à la cardinalité
	
	
	private Demande demande;
	
	private Catalogue catalogue;
	
	// variable de la classe

	
	private Long Demandeid;
	
	private Long Catalogueid;
	
	private String nUM_DEMANDE;
	
	
	private String nUM_REF_PROD;

	
	private String description;

	private String  date_BesoinString;
	
	private LocalDate  date_BESOIN;

	
	private String c_CLASSIF_ACHAT;

	
	private Integer frais_PORT;
	
	private Long frais_PORT_Total;
	
	private Integer montant_TOTAL;
	
	private Long montant_Demande;
	
	private Long montant_Demande_TotalHT;
	
	private Integer montant;
	
	private Integer quantite;
	
	
	private String lieu_LIVRAISON;
	
	// constructeur 
	public DetailDemandeDto () {}
	
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
	
	public Long getFrais_PORT_Total() {
		return frais_PORT_Total;
	}

	public void setFrais_PORT_Total(Long frais_PORT_Total) {
		this.frais_PORT_Total = frais_PORT_Total;
	}
	
	public Integer getMontant_TOTAL() {
		return montant_TOTAL;
	}

	public void setMontant_TOTAL(Integer montant_TOTAL) {
		this.montant_TOTAL = montant_TOTAL;
	}
	
	
	public Long getMontant_Demande() {
		return montant_Demande;
	}

	public void setMontant_Demande(Long montant_Demande) {
		this.montant_Demande = montant_Demande;
	}
	
	public Long getMontant_Demande_TotalHT() {
		return montant_Demande_TotalHT;
	}

	public void setMontant_Demande_TotalHT(Long montant_Demande_TotalHT) {
		this.montant_Demande_TotalHT = montant_Demande_TotalHT;
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
		return Demandeid;
	}

	public void setDemandeid(Long demandeid) {
		Demandeid = demandeid;
	}

	public Long getCatalogueid() {
		return Catalogueid;
	}

	public void setCatalogueid(Long catalogueid) {
		Catalogueid = catalogueid;
	}

	public String getDate_BesoinString() {
		return date_BesoinString;
	}

	public void setDate_BesoinString(String date_BesoinString) {
		date_BesoinString = date_BesoinString;
	}

	

	
	
}
