package Service;

import java.util.List;

import DTO.SocieteDto;


public interface  SocieteServiceInterface {
	
	SocieteDto ajouter (SocieteDto societeDto);
	SocieteDto rechercheParId ( Long id);
	List<SocieteDto> rechercherParNom (String nom);
	void  supprimer ( long societe);
	List <SocieteDto> afficherTout ();
    void Modifier ( SocieteDto societeDto);

}
