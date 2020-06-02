package Service;

import java.util.List;

import DTO.CompteUserDto;

public interface CompteUserServiceInterface {
	
	
	void ajouter (CompteUserDto compteUserDto);
	
	void supprimer (Long id);
	
	void modifier (CompteUserDto compteUserDto);
	
	void rechercherParId(Long id);
	List<CompteUserDto> afficher();
	
	List<CompteUserDto> rechercherParNom( String identifiant);
	
	CompteUserDto rechercherParNomUnique( String identifiant );
	
    CompteUserDto connexion ( String identifiant, String mdp);
    
    CompteUserDto findconnexion ( CompteUserDto compteUserDto);

}
