package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Entity.DetailDemande;



public class DemandeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -900809082978683752L;
	
	// Variables liées à la cardinalité
		
	private SocieteDto societeDto;
	
	private List<DetailDemande> detailDemandes = new ArrayList<>();
			
	
	
	// Constructeur
		public DemandeDto () {};
		
		
		//Getter et Setter
	
	private Long idDemande;

	
	private String nUM_DEMANDE;

	
	private String c_REGION;

	
	private String c_ETAT;

	
	private String urgent;

	
	private String c_DOMAINE;
	
	
	private String c_TYP_COMMANDE;
	
	
	private String c_TYP_FLUX_APPRO;
	
	
	private String nOTE_APPROVISIONNEUR;
	
	
	private String nOTE_FOURNISSEUR;
		
	private String c_SOCIETE;
	
	private String c_Fournisseur;
	
	private String cOM_DEMANDEUR;
		
	private String c_CLASSIF_ACHAT;
	
	
	

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
		this.c_Fournisseur = c_Fournisseur;
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

	
	
	public SocieteDto getSocieteDto() {
		return societeDto;
	}

	public void setSocieteDto(SocieteDto societeDto) {
		this.societeDto = societeDto;
	}

	public String getUrgent() {
		return urgent;
	}

	public void setUrgent(String urgent) {
		this.urgent = urgent;
	}

	
	
	
	
	public List<DetailDemande> getDetailDemandes() {
		return detailDemandes;
	}


	public void setDetailDemandes(List<DetailDemande> detailDemandes) {
		this.detailDemandes = detailDemandes;
	}


	@Override
	public String toString() {
		return "DemandeDto [idDemande=" + idDemande + ", nUM_DEMANDE=" + nUM_DEMANDE + ", c_REGION=" + c_REGION
				+ ", c_ETAT=" + c_ETAT + ", urgent=" + urgent + ", c_DOMAINE=" + c_DOMAINE + ", c_TYP_COMMANDE="
				+ c_TYP_COMMANDE + ", c_TYP_FLUX_APPRO=" + c_TYP_FLUX_APPRO + ", nOTE_APPROVISIONNEUR="
				+ nOTE_APPROVISIONNEUR + ", nOTE_FOURNISSEUR=" + nOTE_FOURNISSEUR + ", cOM_DEMANDEUR=" + cOM_DEMANDEUR
				+ ", c_CLASSIF_ACHAT=" + c_CLASSIF_ACHAT + ", c_SOCIETE=" + c_SOCIETE + ",c_Fournisseur=" + c_Fournisseur + ", C_CLASSIF_ACHAT="
				+ c_CLASSIF_ACHAT + "]";
	}


	

	
	
	
	
	
	
}
