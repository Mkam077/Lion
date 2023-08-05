package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DTO.ArticleStockDto;
import Service.ArticleStockServiceInterface;

@Named
@ViewScoped
public class ArticleStockMB  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7690536477406198688L;


	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


	ArticleStockServiceInterface articleStockService = (ArticleStockServiceInterface)context.getBean("articleStockService");

	private ArticleStockDto articleStockDto = new ArticleStockDto();

	public ArticleStockMB() {

	}



	public ArticleStockMB(ArticleStockDto articleStockDto) {

		this.articleStockDto = new ArticleStockDto();
	}



	//pour l' initialisation
	private List<ArticleStockDto> articleStockDtolist = new ArrayList<ArticleStockDto>();
	private   List<ArticleStockDto> listarticleStockDtoreherché = new ArrayList<ArticleStockDto>();

	@PostConstruct
	public void init() {
		resetArticleStockDto();
		articleStockService.calculIndicateurs();
		this.articleStockDtolist = articleStockService.Affichertout();
		ArticleStockDto articleStockDto = new ArticleStockDto();

	}

	public void afficherTout () {

		this.articleStockDtolist = articleStockService.Affichertout();
	}


	public void ajouterUnArticle () { 

		ArticleStockDto newarticleStockDto = articleStockService.ajouterUnArticle(articleStockDto);
		articleStockDto.setArticleDesignation(newarticleStockDto.getArticleDesignation());
		articleStockDto.setArticleUtilisationLibre(newarticleStockDto.getArticleUtilisationLibre());
		articleStockDto.setArticleBloque(newarticleStockDto.getArticleBloque());
		articleStockDto.setArticleControleQualite(newarticleStockDto.getArticleControleQualite());
		articleStockDto.setArticleEnRetour(newarticleStockDto.getArticleEnRetour());
		articleStockDto.setArticleEnTransit(newarticleStockDto.getArticleEnTransit());
		articleStockDto.setArticleStockNonLibre(newarticleStockDto.getArticleStockNonLibre());
		articleStockDto.setConsommationJournaliere(newarticleStockDto.getconsommationJournaliere());
		articleStockDto.setArticleStockNonLibre(newarticleStockDto.getArticleStockNonLibre());
		this.articleStockDtolist = articleStockService.Affichertout();

		resetArticleStockDto();

	}

	public void rechercheParId ( Long id) {

		articleStockService.rechercheParId(id);

	}


	public void rechercheParDesignation( ) {

		String nom = articleStockDto.getArticleDesignation();

		this.listarticleStockDtoreherché = articleStockService.rechercherParNom(nom);


	}

	public void supprimerUnArticle( ArticleStockDto articleStockDto) {

		Long id = articleStockDto.getIdArticleStock();


		articleStockService.supprimerUnArticle(id);

	}


	public void  modifier ( ArticleStockDto articleStockDto) {

		articleStockService.modifier(articleStockDto);


	}

	private void resetArticleStockDto() {

		this.articleStockDto = new ArticleStockDto();
	}


	public ArticleStockDto getArticleStockDto() {
		return articleStockDto;
	}

	public void setArticleStockDto(ArticleStockDto articleStockDto) {
		this.articleStockDto = articleStockDto;
	}

	public List<ArticleStockDto> getArticleStockDtolist() {
		return articleStockDtolist;
	}

	public void setArticleStockDtolist(List<ArticleStockDto> articleStockDtolist) {
		this.articleStockDtolist = articleStockDtolist;
	}

	public ArticleStockServiceInterface getService() {
		return articleStockService;
	}
	public ArticleStockServiceInterface getArticleStockService() {
		return articleStockService;
	}

	public void setArticleStockService(ArticleStockServiceInterface articleStockService) {
		this.articleStockService = articleStockService;
	}

	public List<ArticleStockDto> getListarticleStockDtoreherché() {
		return listarticleStockDtoreherché;
	}

	public void setListarticleStockDtoreherché(List<ArticleStockDto> listarticleStockDtoreherché) {
		this.listarticleStockDtoreherché = listarticleStockDtoreherché;
	}

}
