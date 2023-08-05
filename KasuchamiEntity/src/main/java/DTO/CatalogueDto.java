package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import Entity.DetailDemande;

public class CatalogueDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7538358243276270546L;
	
	// variable de la cardinalité
	private List<DetailDemande> detailsDemandes = new ArrayList<>();
	
	
	//Variable de la classe
    private Long catalogueid;
	
    
	private String nUM_REF_PROD ;

	
	private String l_REF_PROD;

	
	private String nUM_FOURNISSEUR;

	
	private Integer montant;

	
	private Integer unite;
	
	
	private Integer articleUtilisationLibre;
	
	
	private Integer articleControleQualite;	
	
	
	private Integer articleStockNonLibre; 
	
	
	private Integer articleBloque;	
	
	
	private Integer articleEnRetour;
	
	
	private Integer articleEnTransit;
	
	
	private Integer consommationJournaliere;
	
	
	private Integer couverturedestock;
	
	
	private Integer articleCalculCde;
	
	// Constructeur 
	public CatalogueDto () {};
	
	// Getter et Setter
	public Long getCatalogueid() {
		return catalogueid;
	}

	public void setCatalogueid(Long catalogueid) {
		this.catalogueid = catalogueid;
	}


	
	public String getnUM_REF_PROD() {
		return nUM_REF_PROD;
	}

	public void setnUM_REF_PROD(String nUM_REF_PROD) {
		this.nUM_REF_PROD = nUM_REF_PROD;
	}

	public String getL_REF_PROD() {
		return l_REF_PROD;
	}

	public void setL_REF_PROD(String l_REF_PROD) {
		this.l_REF_PROD = l_REF_PROD;
	}

	public String getnUM_FOURNISSEUR() {
		return nUM_FOURNISSEUR;
	}

	public void setnUM_FOURNISSEUR(String nUM_FOURNISSEUR) {
		this.nUM_FOURNISSEUR = nUM_FOURNISSEUR;
	}

	public Integer getMontant() {
		return montant;
	}
	public void setMontant(Integer montant) {
		this.montant = montant;
	}
	

	public Integer getUnite() {
		return unite;
	}

	public void setUnite(Integer unite) {
		this.unite = unite;
	}
	
	public Integer getArticleUtilisationLibre() {
		return articleUtilisationLibre;
	}
	public void setArticleUtilisationLibre(Integer articleUtilisationLibre) {
		this.articleUtilisationLibre = articleUtilisationLibre;
	}
	public Integer getArticleControleQualite() {
		return articleControleQualite;
	}
	public void setArticleControleQualite(Integer articleControleQualite) {
		this.articleControleQualite = articleControleQualite;
	}
	public Integer getArticleStockNonLibre() {
		return articleStockNonLibre;
	}
	public void setArticleStockNonLibre(Integer articleStockNonLibre) {
		this.articleStockNonLibre = articleStockNonLibre;
	}
	public Integer getArticleBloque() {
		return articleBloque;
	}
	public void setArticleBloque(Integer articleBloque) {
		this.articleBloque = articleBloque;
	}
	public Integer getArticleEnRetour() {
		return articleEnRetour;
	}
	public void setArticleEnRetour(Integer articleEnRetour) {
		this.articleEnRetour = articleEnRetour;
	}
	public Integer getArticleEnTransit() {
		return articleEnTransit;
	}
	public void setArticleEnTransit(Integer articleEnTransit) {
		this.articleEnTransit = articleEnTransit;
	}
	public Integer getConsommationJournaliere() {
		return consommationJournaliere;
	}
	public void setConsommationJournaliere(Integer consommationJournaliere) {
		this.consommationJournaliere = consommationJournaliere;
	}
	public Integer getCouverturedestock() {
		return couverturedestock;
	}
	public void setCouverturedestock(Integer couverturedestock) {
		this.couverturedestock = couverturedestock;
	}
	public Integer getArticleCalculCde() {
		return articleCalculCde;
	}
	public void setArticleCalculCde(Integer articleCalculCde) {
		this.articleCalculCde = articleCalculCde;
	}

	public List<DetailDemande> getDetailsDemandes() {
		return detailsDemandes;
	}

	public void setDetailsDemandes(List<DetailDemande> detailsDemandes) {
		this.detailsDemandes = detailsDemandes;
	}

	@Override
	public String toString() {
		return "CatalogueDto [catalogueid=" + catalogueid + ", nUM_REF_PROD=" + nUM_REF_PROD + ", l_REF_PROD="
				+ l_REF_PROD + ", nUM_FOURNISSEUR=" + nUM_FOURNISSEUR + ", montant=" + montant + ", unite=" + unite
				+ "]";
	}

	

	
	

	
	

	
	
}
