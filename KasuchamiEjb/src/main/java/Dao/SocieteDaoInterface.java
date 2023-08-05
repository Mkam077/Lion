package Dao;

import java.util.List;


import DTO.SocieteDto;

import Entity.Societe;

public interface SocieteDaoInterface {
	
	SocieteDto ajouter (SocieteDto societeDto);
	SocieteDto rechercheParId ( Long id);
	List<SocieteDto> rechercherParNom (String nom);
	public void  supprimer ( Long id);
	List <SocieteDto> afficherTout ();
    Societe Modifier ( SocieteDto societeDto);
 

}
