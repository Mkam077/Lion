package Dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import BuilderEntity.CatalogueBuilder;

import DTO.CatalogueDto;
import Entity.Catalogue;


@Repository
public class CatalogueDao implements CatalogueInterface {
	
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public CatalogueDto ajouter(CatalogueDto catalogueDto) {
		
		Catalogue catalogue = CatalogueBuilder.fromuser(catalogueDto);
		this.entitymanager.persist(catalogue);      
		this.entitymanager.flush();
		return   CatalogueBuilder.fromEntity(catalogue);
	}

	@Override
	public void supprimer(Long id) {
		
	    Catalogue catalogue = entitymanager.find(Catalogue.class, id);
		
		entitymanager.remove(catalogue);	
	}

	@Override
	public Catalogue modifier(CatalogueDto catalogueDto) {
		
		Catalogue catalogue = CatalogueBuilder.fromuser(catalogueDto);
		
		return this.entitymanager.merge(catalogue);
	}

	@Override
	public List<CatalogueDto> afficher() {
		
		// Rechercher la liste de société en BD 
				List< Catalogue> resultListedeCatalogueEnBD  = entitymanager.createNamedQuery("Catalogue.afficherTout", Catalogue.class).getResultList();
				 // Transformer la liste d' entity en listeDto
				return resultListedeCatalogueEnBD.stream().map(catalogue -> CatalogueBuilder.fromEntity(catalogue)).collect(Collectors.toList());
	}

	@Override
	public CatalogueDto rechercher(long id) {
		// TODO Auto-generated method stub
		return   CatalogueBuilder.fromEntity(this.entitymanager.find(Catalogue.class, id));
	}

	@Override
	public List<CatalogueDto> rechercher(String nom) {
		// Rechercher le nom dans la liste en fonction du paramétre rentrer en argument
				List<Catalogue> resultList = this.entitymanager.createNamedQuery("Catalogue.findName", Catalogue.class)
						.setParameter("nomf", nom)
						.getResultList();
				// Transformer l' objet entity en objet Dto
				return resultList
						.stream()
						.map(catalogue -> CatalogueBuilder.fromEntity(catalogue))
						.collect(Collectors.toList());	
	}
	

}
