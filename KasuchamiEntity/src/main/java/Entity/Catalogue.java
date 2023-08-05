package Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity
@Table (name="Catalogue")
@NamedQueries( {@NamedQuery (name = "Catalogue.findName", query = "select c from Catalogue c where c.l_REF_PROD = nomf"),
  @NamedQuery (name = "Catalogue.afficherTout", query = "SELECT c FROM Catalogue c " ),
  @NamedQuery (name = "Catalogue.findId", query = "select c from Catalogue c where c.catalogueid =: catalogueidValue"),
@NamedQuery (name = "Catalogue.afficherPrix", query = "select c from Catalogue c where c.catalogueid =: catalogueidValue")
})
public class Catalogue {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "catalogueid", unique = true)
	private Long catalogueid;
	
	@Column(name = "nUM_REF_PROD")
	private String nUM_REF_PROD ;

	@Column(name = "l_REF_PROD")
	private String l_REF_PROD;

	@Column(name = "nUM_FOURNISSEUR")
	private String nUM_FOURNISSEUR;
	
	@Column(name = "c_Fournisseur" )
	private String c_Fournisseur ;
	
	@Column(name = "l_Fournisseur")
	private String l_Fournisseur;

	@Column(name = "montant")
	private Integer montant;

	@Column(name = "unite")
	private Integer unite;
	
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
	
	
	// Mapping
	
	// Jointure a DetailsDemande
	@OneToMany(mappedBy= "catalogue", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<DetailDemande> detailsDemandes = new ArrayList<>();
	
	public List<DetailDemande> getDetailsDemandes() {
		return detailsDemandes;
	}

	public void setDetailsDemandes(List<DetailDemande> detailsDemandes) {
		this.detailsDemandes = detailsDemandes;
	}
	///////////////////////Avec seconde possibilité//////////////////
	@OneToMany( fetch = FetchType.EAGER,mappedBy= "catalogue", orphanRemoval = true, cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<DetailDemande2> detailsDemandes2 = new ArrayList<>();
	
	public List<DetailDemande2> getDetailsDemandes2() {
		return detailsDemandes2;
	}

	public void setDetailsDemandes2(List<DetailDemande2> detailsDemandes2) {
		this.detailsDemandes2 = detailsDemandes2;
	}
		
	
	
	//Jointure avec fournisseur et Getter et Setter de la cardinalité////
			@ManyToOne(fetch = FetchType.EAGER)
			@JoinColumn(name = "Fournisseur")
			private Fournisseur fournisseur;
			
			public Fournisseur getFournisseur() {
				return fournisseur;
			}

			public  void setFournisseur(Fournisseur fournisseur) {
				this.fournisseur = fournisseur;
				
			}
	
	// Getter et Setter
	
	public Long getCatalogueid() {
		return catalogueid;
	}

	public void setCatalogueid(Long catalogueid) {
		this.catalogueid = catalogueid;
	}

	public String getnUM_REF_PROD() {
		return nUM_REF_PROD;
	}

	public void setnUM_REF_PROD(String nUM_REF_PROD) {
		this.nUM_REF_PROD = nUM_REF_PROD;
	}

	public String getL_REF_PROD() {
		return l_REF_PROD;
	}

	public void setL_REF_PROD(String l_REF_PROD) {
		this.l_REF_PROD = l_REF_PROD;
	}

	public String getnUM_FOURNISSEUR() {
		return nUM_FOURNISSEUR;
	}

	public void setnUM_FOURNISSEUR(String nUM_FOURNISSEUR) {
		this.nUM_FOURNISSEUR = nUM_FOURNISSEUR;
	}

	public Integer getMontant() {
		// TODO Auto-generated method stub
		return montant;
	}
	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	public Integer getUnite() {
		return unite;
	}

	public void setUnite(Integer unite) {
		this.unite = unite;
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

	public void setConsommationJournaliére(Integer consommation) {
		this.consommationJournaliere = consommation;
	}

	public Integer getCouverturedestock() {
		return couverturedestock;
	}

	public void setCouverturedestock(Integer couverturedestock) {
		this.couverturedestock = couverturedestock;
	}

	public String getC_Fournisseur() {
		return c_Fournisseur;
	}

	public void setC_Fournisseur(String c_Fournisseur) {
		this.c_Fournisseur = c_Fournisseur;
	}

	

    
}
