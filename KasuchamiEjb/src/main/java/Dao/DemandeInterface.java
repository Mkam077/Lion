package Dao;

import java.util.List;

import DTO.DemandeDto;
import Entity.Demande;

public interface DemandeInterface {
	
	DemandeDto  ajouter( DemandeDto demandeDto);
	
	public void supprimer(Long id);
	
	Demande modifier(DemandeDto demandeDto);
	
	  DemandeDto  rechercher(Long id);
	
	List<DemandeDto> rechercher(String nom);
	
	List<DemandeDto> Afficher();
	
	  void ajoutDemande ( DemandeDto demandeDto);

}
