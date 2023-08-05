package Dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import BuilderEntity.BuilderDetailDemande2;
import BuilderEntity.CatalogueBuilder;
import DTO.CatalogueDto;

import DTO.DetailDemandeDto2;
import Entity.Catalogue;
import Entity.Demande;
import Entity.DetailDemande2;

@Repository
public class DetailDemande2Dao2  implements DetailDemandeInterface2{

	
	@PersistenceContext
	private EntityManager entitymanager;
	
	
	@Override
	public DetailDemandeDto2 ajouter(DetailDemandeDto2 detailDemandeDto2) {
		
		
		// récupérer les donnnée renseigné dans le DTO au niveau de l' inferface graphique en interface et les modifier dans une entité société	
		
		DetailDemande2 detailDemande2 = BuilderDetailDemande2.fromuser( detailDemandeDto2 );
		
  // Ecrire les données dans la BD
		 
		 this.entitymanager.persist(detailDemande2);
		  this.entitymanager.flush();
  // Construire un objet DTO a partir de l' entité
		  return BuilderDetailDemande2.fromEntity(detailDemande2);
		
	}

	@Override
	public void supprimer(Long id) {
		DetailDemande2 DetailDemande2 = this.entitymanager.find(DetailDemande2.class,id) ;
		  this.entitymanager.remove(DetailDemande2);	
		
	}

	public DetailDemande2 modifier( DetailDemandeDto2 detailDemande2Dto) {
		DetailDemande2 detailDemande2 = BuilderDetailDemande2.fromuser( detailDemande2Dto );

		return this.entitymanager.merge(detailDemande2);
	}

	@Override
	public DetailDemandeDto2 Rechercher(Long id) {
		// TODO Auto-generated method stub
		return BuilderDetailDemande2.fromEntity(entitymanager.find(DetailDemande2.class, id));
	}

	@Override
	public List<DetailDemandeDto2> RechercherParNom(String nom) {
		// Rechercher le nom dans la liste en fonction du paramétre rentrer en argument
				List<DetailDemande2> resultList = this.entitymanager.createNamedQuery("DetailDemande2.findName", DetailDemande2.class)
						.setParameter("nomf", nom)
						.getResultList();
				// Transformer l' objet entity en objet Dto
				return resultList
						.stream()
						.map(detailDemande2 -> BuilderDetailDemande2.fromEntity(detailDemande2))
						.collect(Collectors.toList());	
	}

	@Override
	public List<DetailDemandeDto2> afficherTout() {		
		List<DetailDemande2> ListeDetailDemande2 = this.entitymanager.createNamedQuery("DetailDemande2.afficherTout", DetailDemande2.class).getResultList();
		// TODO Auto-generated method stub
		return ListeDetailDemande2.stream().map(detailDemande2 ->BuilderDetailDemande2.fromEntity(detailDemande2)).collect(Collectors.toList());
	
	}
	@Override
	public List<CatalogueDto> AfficherCatalogueparid(long catalogueid ) {
		@SuppressWarnings("unchecked")
		List<Catalogue> ListeCatalogue = ((TypedQuery<Catalogue>) this.entitymanager.createNamedQuery("DetailDemande2.findCatalogue", DetailDemande2.class).getResultList())
		     .setParameter("catalogueidValue", catalogueid)
			 .getResultList();	 
		 // TODO Auto-generated method stub
		return ListeCatalogue.stream().map(catalogue ->CatalogueBuilder.fromEntity(catalogue)).collect(Collectors.toList())  ;
		
	}
	
	
	

	@Override
	public void ajouterLigneDeDemande(DetailDemandeDto2 detailDemandeDto2) {
	  // aller chercher l' objetentity dans la BD pour produit et demande
		
		Demande demandeEntity = this.entitymanager.createNamedQuery("Demande.findId", Demande.class)
				.setParameter("idDemandeValue",detailDemandeDto2.getDemandeid()).getSingleResult();
		
		Catalogue CatalogueEntity = this.entitymanager.createNamedQuery("Catalogue.findId", Catalogue.class)
				.setParameter("catalogueidValue",detailDemandeDto2.getCatalogueid()).getSingleResult();
		
		//Faire la clef composite
		String clefEntity = demandeEntity.getIdDemande().toString().concat(String.valueOf(CatalogueEntity.getCatalogueid()));
		//String clefObjet = DetailDemande2Dto.getIdDemande().toString().concat(DetailDemande2Dto.getIdCatalogue().toString());
		
		// Si différent de null l' enrgistrer dans la BD
		if (  clefEntity != null ) {
					
		DetailDemande2 detailDemandeDT2=BuilderDetailDemande2.fromuser(detailDemandeDto2);		
		CatalogueEntity.getDetailsDemandes2().add(detailDemandeDT2);
		detailDemandeDT2.setCatalogue(CatalogueEntity);
		demandeEntity.getDetailDemandes2().add(detailDemandeDT2);
		detailDemandeDT2.setDemande(demandeEntity);
		//DetailDemande2Id DetailDemande2Id = BuilderDetailDemande2.fromUserID( DetailDemande2Dto );	
		//this.entitymanager.persist(DetailDemande2Id);
		this.entitymanager.persist(detailDemandeDT2);
		this.entitymanager.flush();
		}
		// TODO Auto-generated method stub
		
	  }

}	
		
		



