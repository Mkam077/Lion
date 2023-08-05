package Dao;

import java.util.List;

import javax.persistence.Query;

import DTO.CatalogueDto;
import DTO.DetailDemandeDto;
import Entity.DetailDemande;

public interface DetailDemandeInterface {
	
	DetailDemandeDto ajouter ( DetailDemandeDto detailDemandeDto);
	 
	public void supprimer(Long id);
	
	DetailDemande modifier(DetailDemandeDto detailDemandeDto);
	
    DetailDemandeDto Rechercher (Long id);
	
	List<DetailDemandeDto> RechercherParNom (String nom);
	
	List <DetailDemandeDto> afficherTout();
	
	List <DetailDemandeDto> afficherDerniereDemande();
	
    public void ajouterLigneDeDemande(DetailDemandeDto detailDemandeDto);
    
    public List<CatalogueDto> AfficherCatalogueparid(long catalogueid );
    
	CatalogueDto RechercherAttributCatalogue(long id);

	CatalogueDto RechercherAttributCatalogue(DetailDemandeDto detailDemandeDto);

	void supprimer(Long demandeid, Long catalogueid);
	long  afficherIDDerniereDemande(); 
	
	long afficherMtsDerniereDemande();
    long  afficherFraisDePortTotal();
	
}
