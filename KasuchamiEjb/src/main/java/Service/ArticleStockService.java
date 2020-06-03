package Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import DTO.ArticleStockDto;
import Dao.DaoArticleStock;
import Entity.ArticleStock;

@Service
public class ArticleStockService implements ArticleStockServiceInterface {
	

	
	// pour appeller les méthodes de DaoArticleStock
   
	@Autowired
	private DaoArticleStock daoArticleStock ;
	
	
	@Transactional
	public  ArticleStockDto ajouterUnArticle (ArticleStockDto articleStockDto) {
		
		return  daoArticleStock.ajouterUnArticle(articleStockDto);
		
		
	}
	
	public List<ArticleStockDto> Affichertout() {
	
		return daoArticleStock.afficherTout();
   }
	
	public List<ArticleStockDto> rechercherParNom(String nom) { 
		
		
		return daoArticleStock.rechercherParNom(nom);
	}
	
	@Transactional
	public void rechercheParId ( Long id) {
		
		daoArticleStock.rechercheParId(id);
		
	}
	
	
	@Transactional
	public void supprimerUnArticle( Long id) {
		
		daoArticleStock.supprimerUnArticle(id);
		
	}

	@Transactional
	public void  modifier ( ArticleStockDto articleStockDto) {
		
		daoArticleStock.modifier(articleStockDto);
		
	}

	@Scheduled(cron = "0/40 * * * * * ")
	@Override
	public void calculQteTot() {
		daoArticleStock.calculQteTot();
		
	}
	
//	//@Scheduled(cron = "* 0/1 * * * * ")
//	public void ring() {
//		System.out.println("ok");
//	}
	
}
