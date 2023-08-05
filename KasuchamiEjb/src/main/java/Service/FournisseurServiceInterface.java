package Service;

import java.util.List;

import DTO.FournisseurDto;


public interface FournisseurServiceInterface {
	

	FournisseurDto ajouter (FournisseurDto fournisseurDto);
	FournisseurDto rechercheParId ( Long id);
	List<FournisseurDto> rechercherParNom (String nom);
	void  supprimer ( Long id);
	List <FournisseurDto> afficherTout ();
    void Modifier ( FournisseurDto fournisseurDto);

}
