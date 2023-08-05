package BuilderEntity;

import DTO.DemandeDto;
import Entity.Demande;


public class DemandeBuilder {
	
	
	public static Demande fromuser ( DemandeDto demandeDto ) {
		 Demande demande = new Demande ();
	    
		 demande.setC_CLASSIF_ACHAT(demandeDto.getC_CLASSIF_ACHAT());
		 demande.setC_DOMAINE(demandeDto.getC_DOMAINE());
		 demande.setC_ETAT(demandeDto.getC_ETAT());
		 demande.setC_REGION(demandeDto.getC_REGION());
		 demande.setC_TYP_COMMANDE(demandeDto.getC_TYP_COMMANDE());
		 demande.setC_TYP_FLUX_APPRO(demandeDto.getC_TYP_FLUX_APPRO());
		 demande.setcOM_DEMANDEUR(demandeDto.getcOM_DEMANDEUR());
		 demande.setIdDemande(demandeDto.getIdDemande());
		 demande.setnOTE_APPROVISIONNEUR(demandeDto.getnOTE_APPROVISIONNEUR());
		 demande.setnOTE_FOURNISSEUR(demandeDto.getnOTE_FOURNISSEUR());
		
		 demande.setnUM_DEMANDE(demandeDto.getnUM_DEMANDE());
		 demande.setUrgent(demandeDto.getUrgent());
		 demande.setC_SOCIETE(demandeDto.getC_SOCIETE());
		 demande.setC_Fournisseur(demandeDto.getC_Fournisseur());		 	  
		 return demande;
		
	}
	
	public static DemandeDto fromEntity ( Demande demande) {
		    DemandeDto demandeDto = new DemandeDto();
		    
			 demandeDto.setC_CLASSIF_ACHAT(demande.getC_CLASSIF_ACHAT());
			 demandeDto.setC_DOMAINE(demande.getC_DOMAINE());
			 demandeDto.setC_ETAT(demande.getC_ETAT());
			 demandeDto.setC_REGION(demande.getC_REGION());
			 
			 demandeDto.setC_TYP_COMMANDE(demande.getC_TYP_COMMANDE());
			 demandeDto.setC_TYP_FLUX_APPRO(demande.getC_TYP_FLUX_APPRO());
			 demandeDto.setcOM_DEMANDEUR(demande.getcOM_DEMANDEUR());
			
			 demandeDto.setIdDemande(demande.getIdDemande());
			 demandeDto.setnOTE_APPROVISIONNEUR(demande.getnOTE_APPROVISIONNEUR());
			 demandeDto.setnOTE_FOURNISSEUR(demande.getnOTE_FOURNISSEUR());
			
			 demandeDto.setnUM_DEMANDE(demande.getnUM_DEMANDE());
			 demandeDto.setUrgent(demande.getUrgent());
			 demandeDto.setC_SOCIETE(demande.getC_SOCIETE());
			 demandeDto.setC_Fournisseur(demande.getC_Fournisseur());
		    return demandeDto;
		
	}

}

	
	
	
	
	
	
	


