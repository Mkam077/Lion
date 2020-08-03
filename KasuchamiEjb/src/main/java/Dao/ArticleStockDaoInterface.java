package Dao;


import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import DTO.ArticleStockDto;
import Entity.ArticleStock;

public interface ArticleStockDaoInterface  {

	ArticleStockDto ajouterUnArticle (ArticleStockDto articleStockDto);

	ArticleStockDto rechercheParId ( Long id);

	List<ArticleStockDto> rechercherParNom(String nom);

	public void supprimerUnArticle( Long id);

	ArticleStock modifier ( ArticleStockDto articleStockDto);

	List<ArticleStockDto> afficherTout();

	public void  calcul ();

	public void importer (List<ArticleStock> ListarticleStocks);

	List<ArticleStock> exporter();

}
