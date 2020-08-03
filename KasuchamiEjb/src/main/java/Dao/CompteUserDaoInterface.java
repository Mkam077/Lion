package Dao;

import java.util.List;

import DTO.CompteUserDto;

public interface CompteUserDaoInterface {


	public void ajouterUnCompteUser ( CompteUserDto compteUserdto );

	public void supprimerUnCompteUser (Long id ) ;

	public void modifierUnCompteUser (CompteUserDto compteUserdto);

	List< CompteUserDto > afficherTout( );

	List<CompteUserDto>rechercherParNom( String identifiant );

	CompteUserDto rechercheParId(Long id);

	CompteUserDto rechercherParNomUnique( String identifiant );
}