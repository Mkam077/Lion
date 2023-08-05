package Service;

import java.util.List;

import DTO.CatalogueDto;
import DTO.DemandeDto;
import DTO.DetailDemandeDto;

public interface DemandeServiceInterface {
	
	DemandeDto ajouter (DemandeDto demandeDto);
	DemandeDto rechercheParId ( Long id);
	List<DemandeDto> rechercherParNom (String nom);
	void  supprimer ( Long id);
	List <DemandeDto> afficherTout ();
    void Modifier ( DemandeDto demandeDto);
    public void ajoutDemande ( DemandeDto demandeDto);
    
}
