package Dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import BuilderEntity.CompteUserBuilder;
import DTO.CompteUserDto;
import Entity.CompteUser;


@Repository
public class DaoCompteUser  implements CompteUserDaoInterface {



	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ajouterUnCompteUser(CompteUserDto compteUserdto) {

		CompteUser compteuser = CompteUserBuilder.fromUser(compteUserdto);
		this.entityManager.persist(compteuser);
		this.entityManager.flush();
	
	}

	@Override
	public void supprimerUnCompteUser(Long id) {

		CompteUser compteuseraSupprimer = entityManager.find(CompteUser.class, id);

		this.entityManager.remove(compteuseraSupprimer);


	}

	@Override
	public void modifierUnCompteUser(CompteUserDto compteUserdto) {

		CompteUser compteuser = CompteUserBuilder.fromUser(compteUserdto);
		this.entityManager.merge(compteuser);

	}

	@Override
	public List<CompteUserDto> afficherTout() {
		List<CompteUser> resultList = entityManager.createNamedQuery("CompteUser.AfficherTout",CompteUser.class).getResultList();	
		return resultList.stream().map(compteUser -> CompteUserBuilder.fromEntity(compteUser)).collect(Collectors.toList());
	}

	@Override
	public  List<CompteUserDto>  rechercherParNom(String Identifiant) {
		List<CompteUser> resultList = this.entityManager.createNamedQuery("CompteUser.findName", CompteUser.class)
				.setParameter("nomf", Identifiant)
				.getResultList();
		return resultList
				.stream()
				.map(compteUser -> CompteUserBuilder.fromEntity(compteUser))
				.collect(Collectors.toList());
	}

	@Override
	public CompteUserDto rechercheParId(Long id) {
		return CompteUserBuilder.fromEntity(entityManager.find(CompteUser.class,id));
	}

	@Override
	public CompteUserDto rechercherParNomUnique(String identifiantUnique) {
		List<CompteUser> resultList = this.entityManager.createNamedQuery("CompteUser.findName", CompteUser.class)
				.setParameter("nomf", identifiantUnique)
				.getResultList();
		Optional<CompteUserDto> optional = resultList
				.stream()
				.map(compteUser -> CompteUserBuilder.fromEntity(compteUser))
				.findAny();
		return optional.isPresent() ? optional.get() : null;
	}

	public CompteUserDto rechercherPourConnexion ( String identifiant, String mdp) {
		List<CompteUser> resultList = this.entityManager.createNamedQuery("CompteUser.connexion",CompteUser.class)
				.setParameter("nomf" , identifiant)
				.setParameter("nomg", mdp)
				.getResultList();
		Optional<CompteUserDto> optional = resultList
				.stream()
				.map(compteUser -> CompteUserBuilder.fromEntity(compteUser))
				.findAny();
		return optional.isPresent() ? optional.get() : null;


	}

	public CompteUserDto rechercherPourConnexionAdministrateur ( String identifiant, String mdp,String administrateur) {
		List<CompteUser> resultList = this.entityManager.createNamedQuery("CompteUser.connexionAdm",CompteUser.class)
				.setParameter("nomf" , identifiant)
				.setParameter("nomg", mdp)
				.setParameter("adm", administrateur)
				.getResultList();
		Optional<CompteUserDto> optional = resultList
				.stream()
				.map(compteUser -> CompteUserBuilder.fromEntity(compteUser))
				.findAny();
		return optional.isPresent() ? optional.get() : null;

	}
}
