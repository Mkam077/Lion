package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DTO.FournisseurDto;


import Service.CatalogueServiceInterface;
import Service.FournisseurServiceInterface;

@Named
@SessionScoped
public class FournisseurMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2136053376691659310L;

	/**
	 * 
	 */
	
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	FournisseurServiceInterface fournisseurService = (FournisseurServiceInterface)context.getBean("fournisseurService");
	
	
	
	//Attribut
	
	
	// Constructeurs
	
	
	public FournisseurMB  () {}
	
	public FournisseurMB  (FournisseurDto fournisseurDto ) {
		this.fournisseurDto = fournisseurDto;
		
	}
	
	// pour l' initialisation
	
	private List<FournisseurDto> fournisseurDtoListe = new ArrayList <FournisseurDto>();
	
    FournisseurDto fournisseurDtoRech = new FournisseurDto();
	
	// pour le traitement des méthodes
	private List<FournisseurDto> ListedeFournisseurDtoRecherche = new ArrayList <FournisseurDto>();
	
	private FournisseurDto fournisseurDto = new FournisseurDto();
	//Post Construct
	
	@PostConstruct
     public void init () {
		resetChampGestionFournisseur();
		this.fournisseurDtoListe = fournisseurService.afficherTout();
		
	}
     
     
     ///////////////////////////Getter et Setter ///////////////////
     
        public FournisseurDto getFournisseurDto() {
			return fournisseurDto;
		}

		public void setFournisseurDto(FournisseurDto fournisseurDto) {
			this.fournisseurDto = fournisseurDto;
		}

		

		public List<FournisseurDto> getListedeFournisseurDtoRecherche() {
			return ListedeFournisseurDtoRecherche;
		}

		public void setListedeFournisseurDtoRecherche(List<FournisseurDto> listedeFournisseurDtoRecherche) {
			ListedeFournisseurDtoRecherche = listedeFournisseurDtoRecherche;
		}

		public FournisseurDto getFournisseurDtoRech() {
			return fournisseurDtoRech;
		}

		public void setFournisseurDtoRech(FournisseurDto fournisseurDtoRech) {
			this.fournisseurDtoRech = fournisseurDtoRech;
		}
	
		public List<FournisseurDto> getFournisseurDtoListe() {
			return fournisseurDtoListe;
		}

		public void setFournisseurDtoListe(List<FournisseurDto> fournisseurDtoListe) {
			this.fournisseurDtoListe = fournisseurDtoListe;
		}
	////////////////////////////Methode//////////////////////
     
     

		
		

		//Methode Supprimer/////////////////////
	    public void supprimerUnFournisseur ( FournisseurDto  fournisseurASupprimer) {
	    	
	    	long  IdFournisseurASupprimer =  fournisseurASupprimer.getIdFournisseur();
	    	
	    	fournisseurService.supprimer(IdFournisseurASupprimer);
	    	
	    	this.fournisseurDtoListe.remove(fournisseurASupprimer);
	    		    	
	    }
	    
	  //Methode   RechercherParNom /////////////////////////////
	    
		public void RechercherParnumeroduFournisseur () {
	    	
	    	String nonDuFournisseur =  fournisseurDto.getL_Fournisseur();
	    	
	    	this.ListedeFournisseurDtoRecherche = fournisseurService.rechercherParNom(nonDuFournisseur);
	    	
	    }
	    
		//Rechercher par ID
       public void RechercherParIDnumeroduFournisseur () {
	    	
	    	long IdDuFournisseurARechercher =  fournisseurDto.getIdFournisseur();
	    	
	    	this.fournisseurDtoRech = fournisseurService.rechercheParId(IdDuFournisseurARechercher);
	    	
	    }
	   // Methode  Modifier
	    
	    public void modifierUnFournisseur (FournisseurDto fournisseurDto    ) {
	    	
	    	fournisseurService.Modifier(fournisseurDto);
	    	
	    	
	    }
	    
	  ////////////// Methode Ajouter ///////  
	    
	    public void AjouterUnNouveauFournisseur ( ) {
	    	
	    	
	    	fournisseurService.ajouter(fournisseurDto);
	    	
	    	this.fournisseurDtoListe = fournisseurService.afficherTout();
	    	
	    	this.fournisseurDto = new FournisseurDto();
	    	
	    	resetChampGestionFournisseur();
	    	
	    	
	    }
	    
	   /////////////// Methode Reset //////////////////
	    
	    private void resetChampGestionFournisseur() {

			this.fournisseurDto = new FournisseurDto();
		}	
	    	
}
