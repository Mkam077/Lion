package Dao;

import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import BuilderEntity.BuilderDetailDemande;
import BuilderEntity.CatalogueBuilder;
import DTO.CatalogueDto;
import DTO.DetailDemandeDto;
import Entity.ArticleStock;
import Entity.Catalogue;
import Entity.Demande;
import Entity.DetailDemande;
import Entity.DetailDemandeId;

@Repository
public class DetailDemandeDao  implements DetailDemandeInterface{

	
	@PersistenceContext
	private EntityManager entitymanager;
	
	
	@Override
	public DetailDemandeDto ajouter(DetailDemandeDto detailDemandeDto) {
	
	long MaxIdDemande;
		
		// récupérer les donnnée renseigné dans le DTO au niveau de l' inferface graphique en interface et les modifier dans une entité société	
		
		DetailDemande detailDemande = BuilderDetailDemande.fromuser( detailDemandeDto );
		
  // Ecrire les données dans la BD
		 
		 this.entitymanager.persist(detailDemande);
		 this.entitymanager.flush();
  // Construire un objet DTO a partir de l' entité
		  return BuilderDetailDemande.fromEntity(detailDemande);
		
	}
	
	@Override
	 public void supprimer(Long demandeid,Long catalogueid) {
		 DetailDemandeId detailDemandeID = new DetailDemandeId (demandeid,catalogueid);
		 DetailDemande detailDemandeASupprimer=  this.entitymanager.find(DetailDemande.class, detailDemandeID);
		 entitymanager.remove(detailDemandeASupprimer);
		
		  //DetailDemande detailDemandeASupprimer = this.entitymanager.createNamedQuery("DetailDemande.supprimerLigne", DetailDemande.class)
			//	 .setParameter("IDCAT",catalogueid)
			//	 .setParameter("IDDEM",demandeid)
			//	 .getSingleResult();
	    	
		
		// DetailDemande detailDemandeASupprimer2 = this.entitymanager.merge(detailDemandeASupprimer);
	   //   this.entitymanager.remove(detailDemandeASupprimer2);
	   //   this.entitymanager.clear();
		 
		 
	           //  entitymanager.createNamedQuery("DetailDemande.supprimerLigne2")
				//	 .setParameter("IDCAT",catalogueid)
				//	 .setParameter("IDDEM",demandeid);
					 	      
		}		
		//DetailDemande detailDemande = this.entitymanager.find(DetailDemande.class,id) ;
		//  this.entitymanager.remove(detailDemande);	
	    // this.entitymanager.getTransaction().commit();
	//}

	@Override
	public DetailDemande modifier(DetailDemandeDto detailDemandeDto) {
		DetailDemande detailDemande = BuilderDetailDemande.fromuser( detailDemandeDto );

		return this.entitymanager.merge(detailDemande);
	}

	@Override
	public DetailDemandeDto Rechercher(Long id) {
		// TODO Auto-generated method stub
		return BuilderDetailDemande.fromEntity(entitymanager.find(DetailDemande.class, id));
	}

	@Override
	public List<DetailDemandeDto> RechercherParNom(String nom) {
		// Rechercher le nom dans la liste en fonction du paramétre rentrer en argument
				List<DetailDemande> resultList = this.entitymanager.createNamedQuery("DetailDemande.findName", DetailDemande.class)
						.setParameter("nomf", nom)
						.getResultList();
				// Transformer l' objet entity en objet Dto
				return resultList
						.stream()
						.map(detailDemande -> BuilderDetailDemande.fromEntity(detailDemande))
						.collect(Collectors.toList());	
	}

	@Override
	public List<DetailDemandeDto> afficherTout() {	
		List<DetailDemande> ListeDetailDemande = entitymanager.createNamedQuery("DetailDemande.afficherTout", DetailDemande.class).getResultList();
		// TODO Auto-generated method stub
		return ListeDetailDemande.stream().map(detailDemande ->BuilderDetailDemande.fromEntity(detailDemande)).collect(Collectors.toList());
	
	}
	
	@Override
	public List<DetailDemandeDto> afficherDerniereDemande() {		
		Demande DemandeMaxIdDemande = entitymanager.createNamedQuery("Demande.findMAXId", Demande.class).getSingleResult();
	     Long MaxIdDemande = DemandeMaxIdDemande.getIdDemande(); 
	     
	     List<DetailDemande> resultList = this.entitymanager.createNamedQuery("DetailDemande.afficherDerniereDemandeId", DetailDemande.class)
					.setParameter("idmax", MaxIdDemande)
					.getResultList();
		
	     return resultList
					.stream()
					.map(detailDemande -> BuilderDetailDemande.fromEntity(detailDemande))
					.collect(Collectors.toList());	
	     
		//List<DetailDemande> ListeDetailDemande = entitymanager.createNamedQuery("DetailDemande.afficherDerniereDemande", DetailDemande.class).getResultList();
		// TODO Auto-generated method stub
		//return ListeDetailDemande.stream().map(detailDemande ->BuilderDetailDemande.fromEntity(detailDemande)).collect(Collectors.toList());
	
	}
	@Override
	public  long  afficherIDDerniereDemande() {	
		 long  DemandeMaxIdDemande2 = entitymanager.createNamedQuery("Demande.findMAXId", Demande.class).getSingleResult().getIdDemande();
		
		return DemandeMaxIdDemande2;
	
	}
	@Override
	public  CatalogueDto RechercherAttributCatalogue( DetailDemandeDto detailDemandeDto) {
		
		long id = detailDemandeDto.getCatalogueid();
	//	DetailDemande detaildemandeEntity = this.entitymanager.createNamedQuery("DetailDemande.afficherPrix", DetailDemande.class)
			//	.setParameter("IdDDCat",catalogueidValue);
		
		//TypedQuery<Catalogue> CatalogueEntity = this.entitymanager.createNamedQuery("Catalogue.afficherPrix", Catalogue.class)
		//		.setParameter("catalogueidValue",catalogueidValue);
		
		//Catalogue CatalogueEntity = this.entitymanager.createNamedQuery("Catalogue.findId", Catalogue.class)
		//		.setParameter("catalogueidValue",detailDemandeDto.getCatalogueid()).getSingleResult();
		
		Catalogue CatalogueEntity = this.entitymanager.find(Catalogue.class, id);
		//Catalogue CatalogueEntity =  (Catalogue) this.entitymanager.createNamedQuery("Catalogue.findId", Catalogue.class)
		//		.setParameter("catalogueidValue",catalogueidValue);
		        
		//CatalogueDto  cataloguedto;
		//long prix;
		//TypedQuery<DetailDemande> detaildemande =  this.entitymanager.createNamedQuery("DetailDemande.afficherPrix", DetailDemande.class)
		 //      .setParameter("IdDDCat", id);
		     
		// TODO Auto-generated method stub
		//     int prix2 = detaildemande;
		//return CatalogueEntity.stream().map(catalogue ->CatalogueBuilder.fromEntity(catalogue)).collect(Collectors.toList())  ;
		//return CatalogueBuilder.fromEntity(this.entitymanager.find(Catalogue.class, catalogueidValue));
		return CatalogueBuilder.fromEntity(CatalogueEntity);
	}
	
	

	@Override
	public List<CatalogueDto> AfficherCatalogueparid(long catalogueid ) {
		@SuppressWarnings("unchecked")
		List<Catalogue> ListeCatalogue = ((TypedQuery<Catalogue>) this.entitymanager.createNamedQuery("DetailDemande.findCatalogue", DetailDemande.class).getResultList())
		     .setParameter("catalogueidValue", catalogueid)
			 .getResultList();	 
		 // TODO Auto-generated method stub
		return ListeCatalogue.stream().map(catalogue ->CatalogueBuilder.fromEntity(catalogue)).collect(Collectors.toList())  ;
		
	}
	
	
	

	@Override
	public void ajouterLigneDeDemande(DetailDemandeDto detailDemandeDto) {
	  // aller chercher l' objetentity dans la BD pour produit et demande
		
		Demande demandeEntity = this.entitymanager.createNamedQuery("Demande.findId", Demande.class)
				.setParameter("idDemandeValue",detailDemandeDto.getDemandeid()).getSingleResult();
		
		Catalogue CatalogueEntity = this.entitymanager.createNamedQuery("Catalogue.findId", Catalogue.class)
				.setParameter("catalogueidValue",detailDemandeDto.getCatalogueid()).getSingleResult();
		
		//Faire la clef composite
		String clefEntity = demandeEntity.getIdDemande().toString().concat(String.valueOf(CatalogueEntity.getCatalogueid()));
		//String clefObjet = detailDemandeDto.getIdDemande().toString().concat(detailDemandeDto.getIdCatalogue().toString());
		
		// Si différent de null l' enrgistrer dans la BD
		if (  clefEntity != null ) {
					
		DetailDemande detailDemandeDT=BuilderDetailDemande.fromuser(detailDemandeDto);		
		CatalogueEntity.getDetailsDemandes().add(detailDemandeDT);
		detailDemandeDT.setCatalogue(CatalogueEntity);
		demandeEntity.getDetailDemandes().add(detailDemandeDT);
		detailDemandeDT.setDemande(demandeEntity);
		//DetailDemandeId detailDemandeId = BuilderDetailDemande.fromUserID( detailDemandeDto );	
		//this.entitymanager.persist(detailDemandeId);
		this.entitymanager.persist(detailDemandeDT);
		this.entitymanager.flush();
		}
		// TODO Auto-generated method stub
		
	  }

	@Override
	public CatalogueDto RechercherAttributCatalogue(long id) {
		
		
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void supprimer(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long  afficherMtsDerniereDemande() {
		    
	    long MtsderniereDemande =  entitymanager.createNamedQuery("DetailDemande.afficherMontTotalDrniereDemande", Long.class).getSingleResult();
	    
		return MtsderniereDemande;
		
	}
	
	@Override
	public long  afficherFraisDePortTotal() {
		    
	    long FraisdePortTotal =  entitymanager.createNamedQuery("DetailDemande.afficherFraisDePortTotal", Long.class).getSingleResult();
	    
		return FraisdePortTotal;
		
	}
	
	
	
}	
		
		



