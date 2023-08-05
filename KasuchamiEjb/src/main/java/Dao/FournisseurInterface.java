package Dao;

import java.util.List;

import DTO.CatalogueDto;
import DTO.FournisseurDto;
import Entity.Catalogue;
import Entity.Fournisseur;

public interface FournisseurInterface {
	
	FournisseurDto ajouter ( FournisseurDto fournisseurDto);
	
	public void supprimer (Long id);
	
	Fournisseur modifier (FournisseurDto fournisseurDto);
	
	List<FournisseurDto> afficher ();
	
	FournisseurDto  rechercher (long id);
	
	List<FournisseurDto>  rechercher (String nom);

}
