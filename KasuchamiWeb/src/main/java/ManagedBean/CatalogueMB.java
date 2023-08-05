package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DTO.CatalogueDto;


import Service.CatalogueServiceInterface;

@Named
@SessionScoped
public class CatalogueMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8916889583222658408L;
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	CatalogueServiceInterface catalogueService = (CatalogueServiceInterface)context.getBean("catalogueService");
	
	
	
	//Attribut
	
	
	// Constructeurs
	
	
	public CatalogueMB  () {}
	
	public CatalogueMB  (CatalogueDto catalogueDto ) {
		this.catalogueDto = catalogueDto;
		
	}
	
	// pour l' initialisation
	
	private List<CatalogueDto> catalogueDtoListe = new ArrayList <CatalogueDto>();
	
    CatalogueDto catalogueDtoRech = new CatalogueDto();
	
	// pour le traitement des méthodes
	private List<CatalogueDto> ListedeProduitDuCatalogueDtoRecherche = new ArrayList <CatalogueDto>();
	
	private CatalogueDto catalogueDto = new CatalogueDto();
	//Post Construct
	
	@PostConstruct
     public void init () {
    	 resetChampGestionProduitDuCatalogue();
		this.catalogueDtoListe = catalogueService.afficherTout();
		
	}
     
     
     ///////////////////////////Getter et Setter ///////////////////
     
        public CatalogueDto getCatalogueDto() {
			return catalogueDto;
		}

		public void setCatalogueDto(CatalogueDto catalogueDto) {
			this.catalogueDto = catalogueDto;
		}

		

		public List<CatalogueDto> getListedeProduitDuCatalogueDtoRecherche() {
			return ListedeProduitDuCatalogueDtoRecherche;
		}

		public void setListedeProduitDuCatalogueDtoRecherche(List<CatalogueDto> listedeProduitDuCatalogueDtoRecherche) {
			ListedeProduitDuCatalogueDtoRecherche = listedeProduitDuCatalogueDtoRecherche;
		}

		public CatalogueDto getCatalogueDtoRech() {
			return catalogueDtoRech;
		}

		public void setCatalogueDtoRech(CatalogueDto catalogueDtoRech) {
			this.catalogueDtoRech = catalogueDtoRech;
		}
	
		public List<CatalogueDto> getCatalogueDtoListe() {
			return catalogueDtoListe;
		}

		public void setCatalogueDtoListe(List<CatalogueDto> catalogueDtoListe) {
			this.catalogueDtoListe = catalogueDtoListe;
		}
	////////////////////////////Methode//////////////////////
     
     

		
		

		//Methode Supprimer/////////////////////
	    public void supprimerUnProduitDuCatalogue ( CatalogueDto  ProduitASupprimerDuCatalogue) {
	    	
	    	long  IdProduitASupprimerDuCatalogue =  ProduitASupprimerDuCatalogue.getCatalogueid();
	    	
	    	catalogueService.supprimer(IdProduitASupprimerDuCatalogue);
	    	
	    	this.catalogueDtoListe.remove(ProduitASupprimerDuCatalogue);
	    		    	
	    }
	    
	  //Methode   RechercherParNom /////////////////////////////
	    
	    

		

		public void RechercherParnumeroduProduit () {
	    	
	    	String numeroDuProduitARechercher =  catalogueDto.getnUM_REF_PROD();
	    	
	    	this.ListedeProduitDuCatalogueDtoRecherche = catalogueService.rechercherParNom(numeroDuProduitARechercher);
	    	
	    }
	    
		//Rechercher par ID
       public void RechercherParIDnumeroduProduit () {
	    	
	    	long IdDuProduitARechercher =  catalogueDto.getCatalogueid();
	    	
	    	this.catalogueDtoRech = catalogueService.rechercheParId(IdDuProduitARechercher);
	    	
	    }
	   // Methode  Modifier
	    
	    public void ModifierUnProduitDuCatalogue (    ) {
	    	
	    	catalogueService.Modifier(catalogueDto);
	    	
	    	
	    }
	    
	  ////////////// Methode Ajouter ///////  
	    
	    public void AjouterUnNouveauProduit ( ) {
	    	
	    	
	    	catalogueService.ajouter(catalogueDto);
	    	
	    	this.catalogueDtoListe = catalogueService.afficherTout();
	    	
	    	this.catalogueDto = new CatalogueDto();
	    	
	    	resetChampGestionProduitDuCatalogue();
	    	
	    	
	    }
	    
	   /////////////// Methode Reset //////////////////
	    
	    private void resetChampGestionProduitDuCatalogue() {

			this.catalogueDto = new CatalogueDto();
		}	
	    
	    
	    
	    
	    
	
}
