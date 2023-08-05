package Service;

import java.util.List;

import DTO.CatalogueDto;

import DTO.DetailDemandeDto2;

public interface DetailDemandeServiceInterface2 {
	
	
	void rechercheParId ( Long id);
	List<DetailDemandeDto2> rechercherParNom (String nom);
	void  supprimer ( Long id);
	List <DetailDemandeDto2> afficherTout ();
    void Modifier ( DetailDemandeDto2 detailDemandeDto2);
    public void ajouterLigneDeDemande(DetailDemandeDto2 detailDemandeDto2);
    public List<CatalogueDto> AfficherCatalogueparid(long catalogueid );
   
}
