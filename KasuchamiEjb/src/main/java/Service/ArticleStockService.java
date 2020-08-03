package Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import DTO.ArticleStockDto;
import Dao.DaoArticleStock;

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
	@Transactional
	@Scheduled(cron = "0/40 * * * * * ")
	@Override
	public void calculIndicateurs() {
		daoArticleStock.calcul();


	}

	@Transactional
	public void ajouterUneQuantité () {
		//variable désignation article recherché 
		ArticleStockDto articleStockRecherché = new ArticleStockDto();
		//variable quantité ajoutée
		int quantitéAjoutée = articleStockRecherché.getArticleEnTransit() ;
		//ligne de l' article recherché
		long id = articleStockRecherché.getIdArticleStock();

		//rechercher l' article concerné pour l' ajout
		articleStockRecherché = daoArticleStock.rechercheParId(id);
		//ajouter la quantité transit  aux type de stock désiré
		int nouvelleQuantitéUtilisationLibre = articleStockRecherché.getArticleUtilisationLibre() + quantitéAjoutée;
		articleStockRecherché.setArticleUtilisationLibre(nouvelleQuantitéUtilisationLibre);
		daoArticleStock.modifier(articleStockRecherché);
		//supprimer la quantité ajouté au stock désiré de la quantité transit
		int nouvelleQuantitéEnTransit = articleStockRecherché.getArticleEnTransit() - quantitéAjoutée;
		articleStockRecherché.setArticleEnTransit(nouvelleQuantitéEnTransit);
		daoArticleStock.modifier(articleStockRecherché);
	}

}
