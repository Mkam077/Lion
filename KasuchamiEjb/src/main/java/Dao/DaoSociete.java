package Dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import BuilderEntity.SocieteBuilder;

import DTO.SocieteDto;


import Entity.Societe;

@Repository
public class DaoSociete implements SocieteDaoInterface {

    	
	@PersistenceContext
	private EntityManager entitymanager;
	
	@Override
	public SocieteDto rechercheParId(Long id) {
		
		// En fonction de l' id de l' entity, on retourne l objet Dto qui est lié 
		return SocieteBuilder.fromEntity(entitymanager.find(Societe.class, id));
	}

	@Override
	public List<SocieteDto> rechercherParNom(String nom) {
		// Rechercher le nom dans la liste en fonction du paramétre rentrer en argument
		List<Societe> resultList = this.entitymanager.createNamedQuery("Societe.findName", Societe.class)
				.setParameter("nomf", nom)
				.getResultList();
		// Transformer l' objet entity en objet Dto
		return resultList
				.stream()
				.map(societe -> SocieteBuilder.fromEntity(societe))
				.collect(Collectors.toList());		
	}

	@Override
	public void supprimer(Long id) {
		// je vais chercher l' objet a supprimer
		Societe societeASupprimer = entitymanager.find(Societe.class, id);
		// je supprimer l' objet  et l' enléve de la table
		this.entitymanager.remove(societeASupprimer);
		// TODO Auto-generated method stub	
	}

	@Override
	public List<SocieteDto> afficherTout() {
		
		// Rechercher la liste de société en BD 
		List< Societe> resultListedeSocieteEnBD  = entitymanager.createNamedQuery("Societe.afficherTout", Societe.class).getResultList();
		 // Transformer la liste d' entity en listeDto
		return resultListedeSocieteEnBD.stream().map(societe -> SocieteBuilder.fromEntity(societe)).collect(Collectors.toList());
	}

	@Override
	public Societe Modifier(SocieteDto societeDto) {
		//Récupérer l objet a modifier et transmettre les donnée à l' objet entity
		   Societe societeAModifier =  SocieteBuilder.fromuser(societeDto);
		   // Modifier les données au niveau de la base de donnée
		return this.entitymanager.merge(societeAModifier)  ;
	}

	@Override
	public SocieteDto ajouter(SocieteDto societeDto) {
		
	// récupérer les donnnée renseigné dans le DTO au niveau de l' inferface graphique en interface et les modifier dans une entité société	
		  Societe societe = SocieteBuilder.fromuser( societeDto );
    // Ecrire les données dans la BD
		  this.entitymanager.persist(societe);
		  this.entitymanager.flush();
    // Construire un objet DTO a partir de l' entité
		  return SocieteBuilder.fromEntity(societe);
				
	}

	
	
	
	
	
	
}
