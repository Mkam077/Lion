package DTO;

import java.io.Serializable;
import java.time.LocalDateTime;


public class ArticleStockDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private Long idArticleStock;
		
	   
		private String articleDesignation;
		
	    
		private Integer articleUtilisationLibre;
		
	    
		private Integer articleControleQualite;
		
	    
		private Integer articleStockNonLibre;
		
	    
		private Integer articleBloque;
		
	   
		private Integer articleEnRetour;
		
	   
		private Integer articleEnTransit;
		
	   
//		private  LocalDateTime    dateEnregistrement;
//		
		
		
		


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			  builder.append("ArticleStockDto [idArticleStock=");
			  builder.append(idArticleStock );
			  builder.append(", articleDesignation=");
			  builder.append(articleDesignation);
			  builder.append(", articleUtilisationLibre=");
			  builder.append(articleUtilisationLibre);
			  builder.append(", articleControleQualite=");
			  builder.append(articleControleQualite);
			  builder.append(", articleStockNonLibre=" );
			  builder.append(articleStockNonLibre );
			  builder.append(", articleBloque=" );
			  builder.append(articleBloque);
			  builder.append(", articleEnRetour=" );
			  builder.append(articleEnRetour );
			  builder.append(", articleEnTransit=");
			  builder.append(articleEnTransit);
			  builder.append(", dateEnregistrement=" );
//			  builder.append(dateEnregistrement );
			return  builder.toString();
		}


		public Long getIdArticleStock() {
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


		public Integer getArticleUtilisationLibre() {
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


//		public LocalDateTime getDateEnregistrement() {
//			return dateEnregistrement;
//		}
//
//
//		public void setDateEnregistrement(LocalDateTime dateEnregistrement) {
//			this.dateEnregistrement = dateEnregistrement;
//		}
	
	
	

}
