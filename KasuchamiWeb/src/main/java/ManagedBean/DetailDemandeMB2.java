package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import DTO.DetailDemandeDto;
import DTO.DetailDemandeDto2;
import Service.DetailDemandeService;
import Service.DetailDemandeService2;
import Service.DetailDemandeServiceInterface;
import Service.DetailDemandeServiceInterface2;


@Named
@SessionScoped
public class DetailDemandeMB2 implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -150114738258394300L;

	// Appeller le Bean 
	ApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");
	
	DetailDemandeServiceInterface2 detailDemandeService2 = (DetailDemandeServiceInterface2) context.getBean("detailDemandeService2");
	
	//Les Variables ou attributs qui vont servir pour faire le manage Bean
	
	private DetailDemandeDto2 detaildemandeDto2 = new DetailDemandeDto2();
	
	// Création des constructeurs
	
	public DetailDemandeMB2() {};
	
	public DetailDemandeMB2( DetailDemandeDto2 detaildemandeDto2 ) {
		
		this.detaildemandeDto2 = new DetailDemandeDto2();
		
	}
	
	// Pour l' initialisation
	
	private List<DetailDemandeDto2> listeDetailDemandeDto2 = new ArrayList <DetailDemandeDto2> () ;
	
	private List<DetailDemandeDto2> listeDetailDemandeDtoRech2 = new ArrayList <DetailDemandeDto2> () ;
	
	private DetailDemandeDto2 detailDemandeDtoRech2 = new DetailDemandeDto2();
	
	
	// Methode pour initialiser la page
	
	
    @PostConstruct
	public void init () {
		reset ();
		this.listeDetailDemandeDto2 = detailDemandeService2.afficherTout();
		
	}
	
	
	//Les Methodes CRUD
	

// il faut supprimer les ligne ou la ligne d' une commande	
	
   public void SupprimerUneLigneDeCommande ( DetailDemandeDto2 detailDemandeDtoASupprimer2  ) {
	   
	   long idduCatalogue = detailDemandeDtoASupprimer2.getCatalogueid();
	   long iddeLaDemande = detailDemandeDtoASupprimer2.getDemandeid();
	   
   }
	
   public void ModifierUneLigneDeDemande ( DetailDemandeDto2 detailDemandeDtoAModifier2)	{
	
	   detailDemandeService2.Modifier(detailDemandeDtoAModifier2);
	   
   }
	
	public void AjouterLignedeDemande () {
       long NumérodelaLigneDuCatalogue = detaildemandeDto2.getCatalogueid();
		
		//detailDemandeService.AfficherCatalogueparid(NumérodelaLigneDuCatalogue);
		
		detailDemandeService2.ajouterLigneDeDemande(detaildemandeDto2);
		
		
		
	//	this.listeDetailDemandeDto = detailDemandeService.afficherTout();
		
		 reset ();
	}
     
	public void afficherLigneCatalogue () {
		
       long NumérodelaLigneDuCatalogue = detaildemandeDto2.getCatalogueid();
		
		detailDemandeService2.AfficherCatalogueparid(NumérodelaLigneDuCatalogue);
		
	}
	
	
	// Methode servant a remettre a blanc les champs d' ajout
	public void reset () {
		
	   this.detaildemandeDto2 = new DetailDemandeDto2();
	}

	
	//Getter et Setter
	public DetailDemandeDto2 getDetaildemandeDto2() {
		return detaildemandeDto2;
	}

	public void setDetaildemandeDto2(DetailDemandeDto2 detaildemandeDto2) {
		this.detaildemandeDto2 = detaildemandeDto2;
	}

	public List<DetailDemandeDto2> getListeDetailDemandeDto2() {
		return listeDetailDemandeDto2;
	}

	public void setListeDetailDemandeDto2(List<DetailDemandeDto2> listeDetailDemandeDto2) {
		this.listeDetailDemandeDto2 = listeDetailDemandeDto2;
	}

	public List<DetailDemandeDto2> getListeDetailDemandeDtoRech2() {
		return listeDetailDemandeDtoRech2;
	}

	public void setListeDetailDemandeDtoRech2(List<DetailDemandeDto2> listeDetailDemandeDtoRech2) {
		this.listeDetailDemandeDtoRech2 = listeDetailDemandeDtoRech2;
	}

	public DetailDemandeDto2 getDetailDemandeDtoRech2() {
		return detailDemandeDtoRech2;
	}

	public void setDetailDemandeDtoRech2(DetailDemandeDto2 detailDemandeDtoRech2) {
		this.detailDemandeDtoRech2 = detailDemandeDtoRech2;
	}

	
	
	
	
	

		
}
