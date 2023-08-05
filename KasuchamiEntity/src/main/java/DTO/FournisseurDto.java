package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import Entity.Catalogue;
import Entity.Demande;
import Entity.DetailDemande;

public class FournisseurDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1977012470764035348L;
	
	
	// variable de la cardinalité
	private List<Demande> demandes = new ArrayList<>();
	private List<Catalogue> catalogues = new ArrayList<>();
	
	//Variable de la classe
	
	private Long idFournisseur;
	
	
	private String c_Fournisseur ;

	
	private String l_Fournisseur;

	
	private String Num_TelFour;

	
	private String Adresse_Fournisseur;	
	
	// Constructeur 
	public FournisseurDto () {}
	
	// Getter et Setter

	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public List<Catalogue> getCatalogues() {
		return catalogues;
	}

	public void setCatalogues(List<Catalogue> catalogues) {
		this.catalogues = catalogues;
	}

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

	@Override
	public String toString() {
		return "FournisseurDto [idFournisseur=" + idFournisseur + ", c_Fournisseur=" + c_Fournisseur
				+ ", l_Fournisseur=" + l_Fournisseur + ", Num_TelFour=" + Num_TelFour + ", Adresse_Fournisseur="
				+ Adresse_Fournisseur + "]";
	};
	
		
}
