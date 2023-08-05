package BuilderEntity;


import DTO.FournisseurDto;

import Entity.Fournisseur;


public class FournisseurBuilder {
	
	public static Fournisseur fromuser ( FournisseurDto fournisseurDto ) {
		  Fournisseur fournisseur = new Fournisseur ();
	    
		  fournisseur.setIdFournisseur(fournisseurDto.getIdFournisseur());
		  fournisseur.setAdresse_Fournisseur(fournisseurDto.getAdresse_Fournisseur());
		  fournisseur.setC_Fournisseur(fournisseurDto.getC_Fournisseur());
		  fournisseur.setL_Fournisseur(fournisseurDto.getL_Fournisseur());
		  fournisseur.setNum_TelFour(fournisseurDto.getNum_TelFour());
		  
		 	 	  
		 return fournisseur;
		
	}
	
	public static FournisseurDto fromEntity ( Fournisseur fournisseur) {
		    FournisseurDto fournisseurDto = new FournisseurDto();
		    
		      fournisseurDto.setIdFournisseur(fournisseur.getIdFournisseur());
			  fournisseurDto.setAdresse_Fournisseur(fournisseur.getAdresse_Fournisseur());
			  fournisseurDto.setC_Fournisseur(fournisseur.getC_Fournisseur());
			  fournisseurDto.setL_Fournisseur(fournisseur.getL_Fournisseur());
			  fournisseurDto.setNum_TelFour(fournisseur.getNum_TelFour());
		    	        
		    return fournisseurDto;
		
	}
	
	

}
