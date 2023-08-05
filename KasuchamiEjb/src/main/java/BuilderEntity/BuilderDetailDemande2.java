package BuilderEntity;

import DTO.DetailDemandeDto2;
import Entity.DetailDemande2;

public class BuilderDetailDemande2 {
	
	
	
	
		
	public static  DetailDemande2 fromuser ( DetailDemandeDto2 detailDemandeDto2 ) {
		 DetailDemande2 detailDemande2 = new DetailDemande2 ( );	 
		 
		 detailDemande2.setLigneDetaiDemandeid(detailDemandeDto2.getLigneDetaiDemandeid());
		 detailDemande2.setDemandeid(detailDemandeDto2.getDemandeid());
		 detailDemande2.setCatalogueid(detailDemandeDto2.getCatalogueid());
		 detailDemande2.setC_CLASSIF_ACHAT(detailDemandeDto2.getC_CLASSIF_ACHAT());
		 detailDemande2.setDate_BESOIN(detailDemandeDto2.getDate_BESOIN());
		 detailDemande2.setDescription(detailDemandeDto2.getDescription());
		 detailDemande2.setFrais_PORT(detailDemandeDto2.getFrais_PORT());
		 detailDemande2.setLieu_LIVRAISON(detailDemandeDto2.getLieu_LIVRAISON());
		 detailDemande2.setMontant_TOTAL(detailDemandeDto2.getMontant_TOTAL());
		 detailDemande2.setnUM_DEMANDE(detailDemandeDto2.getnUM_DEMANDE());
		 detailDemande2.setQuantite(detailDemandeDto2.getQuantite());
		 detailDemande2.setnUM_REF_PROD(detailDemandeDto2.getnUM_REF_PROD());
	     
		 
		 return  detailDemande2;
		
	}
		
	public static DetailDemandeDto2 fromEntity ( DetailDemande2 detailDemande2) {
		DetailDemandeDto2 detailDemandeDto2 = new DetailDemandeDto2();
		
		detailDemandeDto2.setLigneDetaiDemandeid(detailDemande2.getLigneDetaiDemandeid());
		detailDemandeDto2.setDemandeid(detailDemande2.getDemandeid());
		detailDemandeDto2.setCatalogueid(detailDemande2.getCatalogueid());
		detailDemandeDto2.setC_CLASSIF_ACHAT(detailDemande2.getC_CLASSIF_ACHAT());
		detailDemandeDto2.setDate_BESOIN(detailDemande2.getDate_BESOIN());
		detailDemandeDto2.setDescription(detailDemande2.getDescription());
		detailDemandeDto2.setFrais_PORT(detailDemande2.getFrais_PORT());
		detailDemandeDto2.setLieu_LIVRAISON(detailDemande2.getLieu_LIVRAISON());
		detailDemandeDto2.setMontant_TOTAL(detailDemande2.getMontant_TOTAL());
		detailDemandeDto2.setnUM_DEMANDE(detailDemande2.getnUM_DEMANDE());
		detailDemandeDto2.setQuantite(detailDemande2.getQuantite());
		detailDemandeDto2.setnUM_REF_PROD(detailDemande2.getnUM_REF_PROD());  
		    
		    return detailDemandeDto2;
		
	}

	

}
