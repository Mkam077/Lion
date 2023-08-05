package Service;

import java.util.List;

import DTO.CatalogueDto;


public interface CatalogueServiceInterface {
	

	CatalogueDto ajouter (CatalogueDto catalogueDto);
	CatalogueDto rechercheParId ( Long id);
	List<CatalogueDto> rechercherParNom (String nom);
	void  supprimer ( Long id);
	List <CatalogueDto> afficherTout ();
    void Modifier ( CatalogueDto catalogueDto);

}
