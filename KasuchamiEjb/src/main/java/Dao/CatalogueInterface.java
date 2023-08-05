package Dao;

import java.util.List;

import DTO.CatalogueDto;
import Entity.Catalogue;

public interface CatalogueInterface {
	
	CatalogueDto ajouter ( CatalogueDto catalogueDto);
	
	public void supprimer (Long id);
	
	Catalogue modifier (CatalogueDto catalogueDto);
	
	List<CatalogueDto> afficher ();
	
	CatalogueDto  rechercher (long id);
	
	List<CatalogueDto>  rechercher (String nom);

}
