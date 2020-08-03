package Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.CompteUserDto;
import Dao.DaoCompteUser;


@Service
public class CompteUserService implements CompteUserServiceInterface {

	@Autowired
	private DaoCompteUser dao;



	@Transactional
	public void ajouter(CompteUserDto compteUserDto) {

		dao.ajouterUnCompteUser(compteUserDto);
		// TODO Auto-generated method stub

	}

	@Transactional
	public void supprimer(Long id) {

		dao.supprimerUnCompteUser(id);
		// TODO Auto-generated method stub

	}

	@Transactional
	public void modifier(CompteUserDto compteUserDto) {

		dao.modifierUnCompteUser(compteUserDto);
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompteUserDto> afficher() {

		return	dao.afficherTout();
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompteUserDto> rechercherParNom(String identifiant) {

		return	dao.rechercherParNom(identifiant);
		// TODO Auto-generated method stub

	}

	@Transactional
	public void rechercherParId(Long id) {

		dao.rechercheParId(id);
		// TODO Auto-generated method stub

	}

	@Override
	public CompteUserDto rechercherParNomUnique(String identifiantUnique) {
		// TODO Auto-generated method stub
		return dao.rechercherParNomUnique(identifiantUnique);
	}


	public CompteUserDto findconnexion (CompteUserDto compteUserDto) {
		// TODO Auto-generated method stub
		return dao.rechercherPourConnexion(compteUserDto.getidentifiant(), compteUserDto.getmotDePasse());
	}

	@Override
	public CompteUserDto connexion(String identifiant, String mdp) {
		// TODO Auto-generated method stub
		return null;
	}


	public CompteUserDto connexionAdm( CompteUserDto compteUserDto) {
		// TODO Auto-generated method stub
		return dao.rechercherPourConnexionAdministrateur(compteUserDto.getidentifiant(), 
				compteUserDto.getmotDePasse(),
				compteUserDto.getadministrateur());
	}

}
