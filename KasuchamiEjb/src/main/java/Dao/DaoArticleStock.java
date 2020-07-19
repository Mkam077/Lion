package Dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import BuilderEntity.ArticleStockBuilder;
import DTO.ArticleStockDto;
import Entity.ArticleStock;


@Repository
public class DaoArticleStock    {

	@PersistenceContext
	private EntityManager entitymanager;


	public ArticleStockDto ajouterUnArticle (ArticleStockDto articleStockDto) {

		ArticleStock articleStock = ArticleStockBuilder.fromuser(articleStockDto);
		this.entitymanager.persist(articleStock);
		this.entitymanager.flush();
		return ArticleStockBuilder.fromEntity(articleStock);

	}

	
	
	public ArticleStockDto rechercheParId ( Long id) { 
		return  ArticleStockBuilder.fromEntity(entitymanager.find(ArticleStock.class,id));
	}

	public List<ArticleStockDto> rechercherParNom(String nom) {
		List<ArticleStock> resultList = this.entitymanager.createNamedQuery("ArticleStock.findName", ArticleStock.class)
				.setParameter("nomf", nom)
				.getResultList();
		return resultList
				.stream()
				.map(articleStock -> ArticleStockBuilder.fromEntity(articleStock))
				.collect(Collectors.toList());

		//		Optional<ArticleStockDto > optional = resultList
		//				.stream()
		//				.map(entity -> ArticleStockBuilder.fromEntity(entity))
		//				.findAny();
		//		return optional.isPresent() ? optional.get() : null;
	}

	public void supprimerUnArticle( Long id) {
		ArticleStock articleStockASupprimer =  entitymanager.find(ArticleStock.class,id);
		this.entitymanager.remove(articleStockASupprimer);

	}

	
	
	public ArticleStock modifier ( ArticleStockDto articleStockDto) {
		ArticleStock articlestock = ArticleStockBuilder.fromuser(articleStockDto);
		return this.entitymanager.merge(articlestock );

	}


	public List<ArticleStockDto> afficherTout() {

		List<ArticleStock> resultList = entitymanager.createNamedQuery("ArticleStock.afficherTout",ArticleStock.class).getResultList();	
		return resultList.stream().map(articleStock -> ArticleStockBuilder.fromEntity(articleStock)).collect(Collectors.toList());

	}

	
	public void  calcul (){
		
		
		List <ArticleStock> listResult =  entitymanager.createNamedQuery("ArticleStock.afficherTout",ArticleStock.class).getResultList().stream()
				.collect(Collectors.toList());
		
		for ( ArticleStock articleStock : listResult) {

			int totalcde = articleStock.getArticleUtilisationLibre() + articleStock.getArticleBloque() + articleStock.getArticleControleQualite()
			+ articleStock.getArticleEnRetour() + articleStock.getArticleEnTransit() + articleStock.getArticleStockNonLibre();
			
			int couvStock = articleStock.getArticleCalculCde() / articleStock.getConsommationJournaliére();  
			 
			articleStock.setArticleCalculCde(totalcde);
			articleStock.setCouverturedestock(couvStock);
			 System.out.println("avant merge");
			 
			entitymanager.persist(articleStock);
			this.entitymanager.flush();
			System.out.println("apres merge");
			
		}
   System.out.println("ok");

	}
    
//	public void calculCouvertureStock () {
//		
//		List<ArticleStock> listcouvStock =  entitymanager.createNamedQuery("ArticleStock.AfficherTout",ArticleStock.class).getResultList().stream()
//		           .collect(Collectors.toList());
//		
//		for (  ArticleStock articleStock : listcouvStock) {
//			
//			int couvStock = articleStock.getArticleCalculCde() / articleStock.getConsommationJournaliére();
//			
//			articleStock.setCouverturedestock(couvStock);
//			
//			entitymanager.persist(articleStock);
//			
//			entitymanager.flush();
//			System.out.println("apres mergecouv");
//		}
//		
//		  System.out.println("okcouv");       
//		
//		
//	}
	
	
	
	public void importer (List<ArticleStock> ListarticleStocks) {

		for(ArticleStock articleStock : ListarticleStocks ) {
		this.entitymanager.persist(articleStock);
		this.entitymanager.flush();
		}

	}	
	
	public List<ArticleStock> exporter() {

		 List <ArticleStock> listResult =  entitymanager.createNamedQuery("ArticleStock.afficherTout",ArticleStock.class).getResultList().stream()
				.collect(Collectors.toList());	
		return listResult;

	}
	
	
	
	

}