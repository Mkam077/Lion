package BuilderEntity;

import DTO.CatalogueDto;
import Entity.Catalogue;


public class CatalogueBuilder {
	
	public static Catalogue fromuser ( CatalogueDto catalogueDto ) {
		  Catalogue catalogue = new Catalogue ();
	    
		  catalogue.setCatalogueid(catalogueDto.getCatalogueid());
		  catalogue.setL_REF_PROD(catalogueDto.getL_REF_PROD());
		  catalogue.setMontant(catalogueDto.getMontant());
		  catalogue.setnUM_FOURNISSEUR(catalogueDto.getnUM_FOURNISSEUR());
		  catalogue.setnUM_REF_PROD(catalogueDto.getnUM_REF_PROD());
		  catalogue.setUnite(catalogueDto.getUnite());
		 	 	  
		 return catalogue;
		
	}
	
	public static CatalogueDto fromEntity ( Catalogue catalogue) {
		    CatalogueDto catalogueDto = new CatalogueDto();
		    
		    catalogueDto.setCatalogueid(catalogue.getCatalogueid());
		    catalogueDto.setL_REF_PROD(catalogue.getL_REF_PROD());
		    catalogueDto.setMontant(catalogue.getMontant());
		    catalogueDto.setnUM_FOURNISSEUR(catalogue.getnUM_FOURNISSEUR());
		    catalogueDto.setnUM_REF_PROD(catalogue.getnUM_REF_PROD());
			catalogueDto.setUnite(catalogue.getUnite());
		    
		    return catalogueDto;
		
	}
	
	

}
