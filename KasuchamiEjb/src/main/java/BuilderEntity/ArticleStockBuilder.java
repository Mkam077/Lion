package BuilderEntity;

import java.time.LocalDateTime;

import DTO.ArticleStockDto;
import Entity.ArticleStock;
import Factory.ArticleStockFactory;
import IFactory.IFactory;

public class ArticleStockBuilder {


	IFactory<ArticleStock> articleStockFactory = new ArticleStockFactory();


	public ArticleStockBuilder() {

		// TODO Auto-generated constructor stub
	}

	public ArticleStock Build ( String designation, Integer utilisationLibre,Integer controleQualite, Integer stockNonLibre, Integer articleBloque, 
		Integer  articleEnRetour, Integer articleEnTransit,Integer couvertureStock,  LocalDateTime dateEnregistrement, Integer consommationJournaliere) {
		ArticleStock articleStock = articleStockFactory.creer(); 
		articleStock.setArticleDesignation(designation);
		articleStock.setArticleUtilisationLibre(utilisationLibre);
		articleStock.setArticleControleQualite(controleQualite);
		articleStock.setArticleStockNonLibre(stockNonLibre);
		articleStock.setArticleBloque(articleBloque);
		articleStock.setArticleEnRetour(articleEnRetour);
		articleStock.setArticleEnTransit(articleEnTransit);
		articleStock.setConsommationJournaliere(consommationJournaliere);
		return articleStock;		
		// TODO Auto-generated constructor stub
	}

	public static ArticleStock fromuser ( ArticleStockDto  articleStockDto) {
		ArticleStock  articleStock = new ArticleStock();
		articleStock.setIdArticleStock(articleStockDto.getIdArticleStock());
		articleStock.setArticleDesignation(articleStockDto.getArticleDesignation());
		articleStock.setArticleUtilisationLibre(articleStockDto.getArticleUtilisationLibre());
		articleStock.setArticleControleQualite(articleStockDto.getArticleControleQualite());	 
		articleStock.setArticleStockNonLibre(articleStockDto.getArticleStockNonLibre());
		articleStock.setArticleBloque(articleStockDto.getArticleBloque());
		articleStock.setArticleEnRetour(articleStockDto.getArticleEnRetour());
		articleStock.setArticleEnTransit(articleStockDto.getArticleEnTransit());
		articleStock.setConsommationJournaliere(articleStockDto.getconsommationJournaliere());
		return  articleStock;
	}

	public static ArticleStockDto fromEntity ( ArticleStock articleStock) {
		ArticleStockDto articleStockDto = new ArticleStockDto();
		articleStockDto.setIdArticleStock(articleStock.getIdArticleStock());
		articleStockDto.setArticleDesignation(articleStock.getArticleDesignation());
		articleStockDto.setArticleUtilisationLibre(articleStock.getArticleUtilisationLibre());
		articleStockDto.setArticleBloque(articleStock.getArticleBloque());
		articleStockDto.setArticleControleQualite(articleStock.getArticleControleQualite());
		articleStockDto.setArticleEnRetour(articleStock.getArticleEnRetour());
		articleStockDto.setArticleEnTransit(articleStock.getArticleEnTransit());
		articleStockDto.setArticleStockNonLibre(articleStock.getArticleStockNonLibre());
		articleStockDto.setCouverturedestock(articleStock.getCouverturedestock());
		articleStockDto.setConsommationJournaliere(articleStock.getConsommationJournaliere());	
		return articleStockDto;
	}

}
