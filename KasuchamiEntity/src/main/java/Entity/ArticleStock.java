package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table (name="ArticleStock")
@NamedQueries({ @NamedQuery(name = "ArticleStock.afficherTout", query = "SELECT a FROM ArticleStock a"),
	@NamedQuery(name = "ArticleStock.findName", query = "SELECT a FROM ArticleStock a where a.articleDesignation = :nomf"),

})

public class ArticleStock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idArticleStock;

	@Column (name= "articleDesignation")
	private String articleDesignation;

	@Column (name= "articleUtilisationLibre")
	private Integer articleUtilisationLibre;

	@Column (name= "articleControleQualite")
	private Integer articleControleQualite;

	@Column (name= "articleStockNonLibre")
	private Integer articleStockNonLibre;

	@Column (name= "articleBloque")
	private Integer articleBloque;

	@Column (name= "articleEnRetour")
	private Integer articleEnRetour;

	@Column (name= "articleEnTransit")
	private Integer articleEnTransit;

	@Column (name="consommationJournaliere")
	private Integer consommationJournaliere;

	@Column ( name="couverturedestock")
	private Integer couverturedestock;

	// obtenue par un traitement algo
	@Column (name="articleCalculCde")
	private Integer articleCalculCde;
	
	

	////////////////////////Constructeur//////////////////

	public ArticleStock() {


	}

	public ArticleStock( int articleCalculCde ) {

		this.articleCalculCde = articleCalculCde;

	}

	/////////////////////////Getter and Setter////////////////////////////////
	public long getIdArticleStock() {
		return idArticleStock;
	}

	public void setIdArticleStock(Long idArticleStock) {
		this.idArticleStock = idArticleStock;
	}

	public String getArticleDesignation() {
		return articleDesignation;
	}

	public void setArticleDesignation(String articleDesignation) {
		this.articleDesignation = articleDesignation;
	}

	public int getArticleUtilisationLibre() {
		return articleUtilisationLibre;
	}

	public void setArticleUtilisationLibre(Integer articleUtilisationLibre) {
		this.articleUtilisationLibre = articleUtilisationLibre;
	}

	public Integer getArticleControleQualite() {
		return articleControleQualite;
	}

	public void setArticleControleQualite(Integer articleControleQualite) {
		this.articleControleQualite = articleControleQualite;
	}

	public Integer getArticleStockNonLibre() {
		return articleStockNonLibre;
	}

	public void setArticleStockNonLibre(Integer articleStockNonLibre) {
		this.articleStockNonLibre = articleStockNonLibre;
	}

	public Integer getArticleBloque() {
		return articleBloque;
	}

	public void setArticleBloque(Integer articleBloque) {
		this.articleBloque = articleBloque;
	}

	public Integer getArticleEnRetour() {
		return articleEnRetour;
	}

	public void setArticleEnRetour(Integer articleEnRetour) {
		this.articleEnRetour = articleEnRetour;
	}

	public Integer getArticleEnTransit() {
		return articleEnTransit;
	}

	public void setArticleEnTransit(Integer articleEnTransit) {
		this.articleEnTransit = articleEnTransit;
	}

	public Integer getArticleCalculCde( ) {
		return articleCalculCde;
	}

	public void setArticleCalculCde( Integer articleCalculCde ) {
		this.articleCalculCde =  articleCalculCde;
	}

	public Integer getConsommationJournaliere() {
		return consommationJournaliere;
	}

	public void setConsommationJournaliere(Integer consommationJournaliere) {
		this.consommationJournaliere = consommationJournaliere;
	}

	public Integer getCouverturedestock() {
		return couverturedestock;
	}

	public void setCouverturedestock(Integer couverturedestock) {
		this.couverturedestock = couverturedestock;
	}

	
}
