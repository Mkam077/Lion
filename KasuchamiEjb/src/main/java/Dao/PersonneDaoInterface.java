package Dao;

import java.util.List;

import DTO.PersonneDto;

public interface PersonneDaoInterface {


	void ajouter ( PersonneDto personneDto);
	void supprimer ( Long id);

	void Modifier (PersonneDto personneDto );

	List<PersonneDto> Afficher ();

	List<PersonneDto> RechercherParNom(String personne);

	PersonneDto RechercheParId (Long id);

}
