package Service;

import java.util.List;

import DTO.ArticleStockDto;
import Entity.ArticleStock;

public interface ArticleStockServiceInterface {

	ArticleStockDto ajouterUnArticle(ArticleStockDto articleStockDto);

	void rechercheParId(Long id);

	void supprimerUnArticle(Long id);

	void modifier(ArticleStockDto articleStockDto);

	List<ArticleStockDto> Affichertout();

	List<ArticleStockDto> rechercherParNom(String nom);

	void calculIndicateurs ();

}
