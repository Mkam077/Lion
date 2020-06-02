package Service;

import java.util.List;

import DTO.PersonneDto;

public interface PersonneServiceInterface {
	
	
	void ajouter(PersonneDto personneDto);
	
	void supprimer ( Long id);
	
	void modifier ( PersonneDto personneDto );
	
	List<PersonneDto> Afficher ();
	
	PersonneDto rechercherParId (Long id);
	
	List<PersonneDto> RechercherParNom (String nom);
	

}
