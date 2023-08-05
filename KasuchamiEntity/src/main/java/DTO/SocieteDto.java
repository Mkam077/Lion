package DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





import Entity.Demande;

public class SocieteDto  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2899529587198806033L;

	// variable Mapping cardinalité
	private List<Demande> demandes = new ArrayList<Demande>();
	
	// variable de la classe société
	private Long idSociete;
	private String c_SOCIETE ;
	private String l_SOCIETE;
	private String c_REGION;
	private String nUM_DEMANDE;
	private int id_ADRESSE_LIVRAISON;
	private String nUM_AXE;
	
	
	// constructeur
	public SocieteDto() {};
	
	
  

//Getter et Setter
public List<Demande> getDemandes() {
	return demandes;
}


public void setDemandes(List<Demande> demandes) {
	this.demandes = demandes;
}


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


public String getnUM_DEMANDE() {
	return nUM_DEMANDE;
}


public void setnUM_DEMANDE(String nUM_DEMANDE) {
	this.nUM_DEMANDE = nUM_DEMANDE;
}


public int getId_ADRESSE_LIVRAISON() {
	return id_ADRESSE_LIVRAISON;
}


public void setId_ADRESSE_LIVRAISON(int id_ADRESSE_LIVRAISON) {
	this.id_ADRESSE_LIVRAISON = id_ADRESSE_LIVRAISON;
}


public String getnUM_AXE() {
	return nUM_AXE;
}


public void setnUM_AXE(String nUM_AXE) {
	this.nUM_AXE = nUM_AXE;
}


@Override
public String toString() {
	return "SocieteDto [idSociete=" + idSociete + ", c_SOCIETE=" + c_SOCIETE + ", l_SOCIETE=" + l_SOCIETE
			+ ", c_REGION=" + c_REGION + ", nUM_DEMANDE=" + nUM_DEMANDE + ", id_ADRESSE_LIVRAISON="
			+ id_ADRESSE_LIVRAISON + ", nUM_AXE=" + nUM_AXE + "]";
}


  
}

