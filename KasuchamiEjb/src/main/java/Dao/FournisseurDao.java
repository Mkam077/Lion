package Dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import BuilderEntity.FournisseurBuilder;

import DTO.FournisseurDto;
import Entity.Fournisseur;


@Repository
public class FournisseurDao implements FournisseurInterface {
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public FournisseurDto ajouter(FournisseurDto fournisseurDto) {
		
		Fournisseur fournisseur = FournisseurBuilder.fromuser(fournisseurDto);
		this.entitymanager.persist(fournisseur);      
		this.entitymanager.flush();
		return   FournisseurBuilder.fromEntity(fournisseur);
	}

	@Override
	public void supprimer(Long id) {
		
	    Fournisseur fournisseur = entitymanager.find(Fournisseur.class, id);
		
		entitymanager.remove(fournisseur);	
	}

	@Override
	public Fournisseur modifier(FournisseurDto fournisseurDto) {
		
		Fournisseur fournisseur = FournisseurBuilder.fromuser(fournisseurDto);
		
		return this.entitymanager.merge(fournisseur);
	}

	@Override
	public List<FournisseurDto> afficher() {
		
		// Rechercher la liste de société en BD 
				List< Fournisseur> resultListedeFournisseurEnBD  = entitymanager.createNamedQuery("Fournisseur.afficherTout", Fournisseur.class).getResultList();
				 // Transformer la liste d' entity en listeDto
				return resultListedeFournisseurEnBD.stream().map(fournisseur -> FournisseurBuilder.fromEntity(fournisseur)).collect(Collectors.toList());
	}

	@Override
	public FournisseurDto rechercher(long id) {
		// TODO Auto-generated method stub
		return   FournisseurBuilder.fromEntity(this.entitymanager.find(Fournisseur.class, id));
	}

	@Override
	public List<FournisseurDto> rechercher(String nom) {
		// Rechercher le nom dans la liste en fonction du paramétre rentrer en argument
				List<Fournisseur> resultList = this.entitymanager.createNamedQuery("Fournisseur.findName", Fournisseur.class)
						.setParameter("nomf", nom)
						.getResultList();
				// Transformer l' objet entity en objet Dto
				return resultList
						.stream()
						.map(Fournisseur -> FournisseurBuilder.fromEntity(Fournisseur))
						.collect(Collectors.toList());	
	}
	

}
