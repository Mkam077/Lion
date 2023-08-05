package Dao;

import java.util.List;

import DTO.CatalogueDto;
import DTO.DetailDemandeDto;
import DTO.DetailDemandeDto2;
import Entity.DetailDemande;
import Entity.DetailDemande2;

public interface DetailDemandeInterface2 {
	
	DetailDemandeDto2 ajouter ( DetailDemandeDto2 detailDemandeDto2);
	 
	public void supprimer(Long id);
	
	DetailDemande2 modifier(DetailDemandeDto2 detailDemandeDto2);
	
    DetailDemandeDto2 Rechercher (Long id);
	
	List<DetailDemandeDto2> RechercherParNom (String nom);
	
	List <DetailDemandeDto2> afficherTout();
	
    public void ajouterLigneDeDemande(DetailDemandeDto2 detailDemandeDto2);
    
    public List<CatalogueDto> AfficherCatalogueparid(long catalogueid );
}
