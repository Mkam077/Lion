package BuilderEntity;

import DTO.SocieteDto;
import Entity.Societe;

public class SocieteBuilder {
		
	public static Societe fromuser ( SocieteDto societeDto ) {
		  Societe societe = new Societe ();
	    
		  societe.setIdSociete(societeDto.getIdSociete());		  
		  societe.setC_SOCIETE(societeDto.getC_SOCIETE());
		  societe.setL_SOCIETE(societeDto.getL_SOCIETE ());
		  societe.setC_REGION(societeDto.getC_REGION ());
		  
		 	  
		 return societe;
		
	}
	
	public static SocieteDto fromEntity ( Societe societe) {
		    SocieteDto societeDto = new SocieteDto();
		    
		    societeDto.setIdSociete( societe.getIdSociete());
		    societeDto.setC_SOCIETE( societe.getC_SOCIETE());
		    societeDto.setL_SOCIETE( societe.getL_SOCIETE ());
		    societeDto.setC_REGION(societe.getC_REGION());
		    
		    return societeDto;
		
	}

}
