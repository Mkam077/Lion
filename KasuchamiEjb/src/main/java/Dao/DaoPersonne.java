package Dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import BuilderEntity.PersonneBuilder;
import DTO.PersonneDto;
import Entity.CompteUser;
import Entity.Personne;


@Repository
public class DaoPersonne implements PersonneDaoInterface {


	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private DaoCompteUser daocompteUser;

	@Override
	public void ajouter(PersonneDto personneDto) {
		// Rajout d' une name query pour réaliser la  contrainte one to one // 
		
		// pour ajouter une personne il faut forcément un compteUser 
		//on va chercher dans la colonne identifiant de compte User un identifiant qui correspond à la personne que l' on est
		//en train d' ajouter ou de créer. si il existe on retourne son compteUser.
		CompteUser userEntity = this.entityManager.createNamedQuery("CompteUser.findName", CompteUser.class)
				.setParameter("identifiant",personneDto.getidentifiant())
				.getSingleResult();
        
		//si il existe un compteUser on effectue l' action d' ajout
		// Enregistrement en base de donnée
		if (userEntity != null) {
			Personne  personne = PersonneBuilder.fromUser(personneDto);
			// A personne dans la clef etrangére on ajoute la contrainte ou le compteUser trouvé
			personne.setCompteUser(userEntity);
			// au compte User on lui affecte la personne.
			userEntity.setPersonne(personne);
			
			this.entityManager.persist(personne);
			this.entityManager.flush();

			// TODO Auto-generated method stub

		}

	}

	@Override
	public void supprimer(Long id) {
		Personne  personne = entityManager.find(Personne.class, id);
		this.entityManager.remove(personne);

		// TODO Auto-generated method stub

	}

	@Override
	public void Modifier(PersonneDto personneDto) {
		Personne  personne = PersonneBuilder.fromUser(personneDto);
		this.entityManager.merge(personne);

		// TODO Auto-generated method stub

	}

	@Override
	public List<PersonneDto> Afficher() {
		List<Personne> resultList = entityManager.createNamedQuery( "Personne.AfficherTout",Personne.class).getResultList();
		return resultList.stream().map(personne -> PersonneBuilder.fromEntity(personne)).collect(Collectors.toList());
	}

	@Override
	public List<PersonneDto> RechercherParNom(String nom) {
		List<Personne> resultList = this.entityManager.createNamedQuery("Personne.FindBy",Personne.class).setParameter("nomf",nom).getResultList();
		return resultList.stream().map(personne -> PersonneBuilder.fromEntity(personne)).collect(Collectors.toList());
		// TODO Auto-generated method stub

	}

	@Override
	public PersonneDto RechercheParId(Long id) {
		// TODO Auto-generated method stub
		return PersonneBuilder.fromEntity(entityManager.find(Personne.class,id));
	}

}
