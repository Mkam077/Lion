package BuilderEntity;



import DTO.DetailDemandeDto;
import Entity.DetailDemande;


public class BuilderDetailDemande {
	
	
	
	
		
	public static  DetailDemande fromuser ( DetailDemandeDto detailDemandeDto ) {
		 DetailDemande detailDemande = new DetailDemande ( );	 
		 
		 detailDemande.setDemandeid(detailDemandeDto.getDemandeid());
		 detailDemande.setCatalogueid(detailDemandeDto.getCatalogueid());
		 detailDemande.setC_CLASSIF_ACHAT(detailDemandeDto.getC_CLASSIF_ACHAT());
		 detailDemande.setDate_BESOIN(detailDemandeDto.getDate_BESOIN());
		 detailDemande.setDescription(detailDemandeDto.getDescription());
		 detailDemande.setFrais_PORT(detailDemandeDto.getFrais_PORT());
		 detailDemande.setLieu_LIVRAISON(detailDemandeDto.getLieu_LIVRAISON());
		 detailDemande.setMontant_TOTAL(detailDemandeDto.getMontant_TOTAL());
		 detailDemande.setnUM_DEMANDE(detailDemandeDto.getnUM_DEMANDE());
		 detailDemande.setQuantite(detailDemandeDto.getQuantite());
		 detailDemande.setnUM_REF_PROD(detailDemandeDto.getnUM_REF_PROD());
		 detailDemande.setMontant(detailDemandeDto.getMontant());
		 
		 return  detailDemande;
		
	}
		
	public static DetailDemandeDto fromEntity ( DetailDemande detailDemande) {
		DetailDemandeDto detailDemandeDto = new DetailDemandeDto();
		
		detailDemandeDto.setDemandeid(detailDemande.getDemandeid());
		detailDemandeDto.setCatalogueid(detailDemande.getCatalogueid());
		detailDemandeDto.setC_CLASSIF_ACHAT(detailDemande.getC_CLASSIF_ACHAT());
		detailDemandeDto.setDate_BESOIN(detailDemande.getDate_BESOIN());
		detailDemandeDto.setDescription(detailDemande.getDescription());
		detailDemandeDto.setFrais_PORT(detailDemande.getFrais_PORT());
		detailDemandeDto.setLieu_LIVRAISON(detailDemande.getLieu_LIVRAISON());
		detailDemandeDto.setMontant_TOTAL(detailDemande.getMontant_TOTAL());
		detailDemandeDto.setnUM_DEMANDE(detailDemande.getnUM_DEMANDE());
		detailDemandeDto.setQuantite(detailDemande.getQuantite());
		detailDemandeDto.setnUM_REF_PROD(detailDemande.getnUM_REF_PROD());  
		detailDemandeDto.setMontant(detailDemande.getMontant());    
		return detailDemandeDto;
		    		
	}

}
