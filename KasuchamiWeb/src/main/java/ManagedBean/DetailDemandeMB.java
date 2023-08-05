package ManagedBean;

import java.io.Serializable;
import java.sql.Date;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DTO.CatalogueDto;
import DTO.DetailDemandeDto;
import Entity.DetailDemandeId;
import Service.DetailDemandeService;
import Service.DetailDemandeServiceInterface;


@Named
@ViewScoped
public class DetailDemandeMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6506061481460089043L;
	
	// Appeller le Bean 
	ApplicationContext context = new ClassPathXmlApplicationContext ("applicationContext.xml");
	
	DetailDemandeServiceInterface detailDemandeService = (DetailDemandeServiceInterface) context.getBean("detailDemandeService");
	
	//Les Variables ou attributs qui vont servir pour faire le manage Bean
	
	private DetailDemandeDto detaildemandeDto = new DetailDemandeDto();
	
	// Création des constructeurs
	
	public DetailDemandeMB() {};
	
	public DetailDemandeMB( DetailDemandeDto detaildemandeDto ) {
		
		this.detaildemandeDto = new DetailDemandeDto();
		
	}
	
	// Pour l' initialisation
	
	private List<DetailDemandeDto> listeDetailDemandeDto = new ArrayList <DetailDemandeDto> () ;
	private List<DetailDemandeDto> listeDetailDemandeDtoDerniereDemande = new ArrayList <DetailDemandeDto> () ;
	
	private List<DetailDemandeDto> listeDetailDemandeDtoRech = new ArrayList <DetailDemandeDto> () ;
	
	private DetailDemandeDto detailDemandeDtoRech = new DetailDemandeDto();
	private DetailDemandeDto detailDemandeDtoASupprimer = new DetailDemandeDto();
	private CatalogueDto cataloguedto = new CatalogueDto();
	private LocalDate localDate;
	
	private CatalogueDto catalogueDtoRech = new CatalogueDto();
	
	private DetailDemandeDto detailDemandeDtoPrixAafficher = new DetailDemandeDto() ;
	long dernierid;
	long MontantTotalDemande;
	long fraisDePort;
	long coutTotalDemandeHT;
	DetailDemandeId detailDemandid = new DetailDemandeId();
	
	// Methode pour initialiser la page
	
	
    @PostConstruct
	public void init () {
		reset ();
		this.listeDetailDemandeDto = detailDemandeService.afficherTout();
		this.listeDetailDemandeDtoDerniereDemande = detailDemandeService.afficherDerniereDemande();
		dernierid =  detailDemandeService.afficherIDDerniereDemande();
		this.detaildemandeDto.setDemandeid(dernierid);
		MontantTotalDemande = detailDemandeService.afficherMtsDerniereDemande();
		this.detaildemandeDto.setMontant_Demande(MontantTotalDemande);
		fraisDePort = detailDemandeService.afficherFraisDePortTotal();
		this.detaildemandeDto.setFrais_PORT_Total(fraisDePort);
		coutTotalDemandeHT = fraisDePort + MontantTotalDemande;
		this.detaildemandeDto.setMontant_Demande_TotalHT(coutTotalDemandeHT);
	}
		
	//Les Methodes CRUD
	
// il faut supprimer les ligne ou la ligne d' une commande	
    	
   public void SupprimerUneLigneDeCommande ( DetailDemandeDto detailDemandeDtoASupprimer  ) {
	   long idduCatalogue = detailDemandeDtoASupprimer.getCatalogueid();
		long iddeLaDemande = detailDemandeDtoASupprimer.getDemandeid(); 
	   
       detailDemandeService.supprimer(iddeLaDemande, idduCatalogue);
	   
       listeDetailDemandeDto.remove(detailDemandeDtoASupprimer);
       
       listeDetailDemandeDtoDerniereDemande.remove(detailDemandeDtoASupprimer);
   }
   
   public void ModifierUneLigneDeDemande ( DetailDemandeDto detailDemandeDtoAModifier){
	  // FacesContext facesContext = FacesContext.getCurrentInstance();
      // DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
       
	   //LocalDate localDate = LocalDate.parse(date, formatter);
	   int nouveauMontant = detailDemandeDtoAModifier.getMontant();
	   int nouvelleQuantitée = detailDemandeDtoAModifier.getQuantite();
	   int nouveauMontantTotal = nouveauMontant * nouvelleQuantitée;
	   detailDemandeDtoAModifier.setMontant_TOTAL(nouveauMontantTotal);
	   LocalDate date  = detailDemandeDtoAModifier.getDate_BESOIN();
	  // final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MMMM uuuu", Locale.ENGLISH);
       // String DateString = dtf.format(date);
	   
	   detailDemandeService.Modifier(detailDemandeDtoAModifier);
	   
	   
   }
	
	public void AjouterLignedeDemande () {
       long NumérodelaLigneDuCatalogue = detaildemandeDto.getCatalogueid();
       
       
       
       //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
      // String date = detaildemandeDto.getDate_BesoinString();
       
     //  try {
    //	   localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	//	} catch (IllegalArgumentException | DateTimeException e) {
	//		throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Message"), e);
	//	}
	
      // detaildemandeDto.setDate_BESOIN(LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	   detailDemandeService.ajouterLigneDeDemande(detaildemandeDto);
		
	//	return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
	//} catch (IllegalArgumentException | DateTimeException e) {
	//	throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Message"), e);
	
		
	//	this.listeDetailDemandeDto = detailDemandeService.afficherTout();
		
		 reset ();
	}
     
	public void afficherLigneCatalogue () {
		
       long NumérodelaLigneDuCatalogue = detaildemandeDto.getCatalogueid();
		
		detailDemandeService.AfficherCatalogueparid(NumérodelaLigneDuCatalogue);
		
	}

	public void afficherDeniereDemande () {
			
		this.listeDetailDemandeDtoDerniereDemande= detailDemandeService.afficherTout();	detailDemandeService.afficherDerniereDemande();
			
		}
	
	
	
	public void AfficherUnPrix() {
		long NumérodelaLigneDuCatalogue = detaildemandeDto.getCatalogueid();
		int prixAafficher;
		int quantité;
		int montant;
		int montantTotal;
		String description;
		
		
		//CatalogueDto cataloguedto = new CatalogueDto();
		// return detailDemandeService.afficherUnPrix(detailDemandeDtoPrixAafficher);
		dernierid =  detailDemandeService.afficherIDDerniereDemande();
		this.catalogueDtoRech =  detailDemandeService.afficherUnPrix(detaildemandeDto);
		quantité = detaildemandeDto.getQuantite();
		prixAafficher = catalogueDtoRech.getMontant();
		description = catalogueDtoRech.getL_REF_PROD();
		montantTotal = prixAafficher * quantité;
		//int prixAafficher = detailDemandeService.afficherUnPrix().getMontant();	
		this.detaildemandeDto.setMontant(prixAafficher);
		this.detaildemandeDto.setMontant_TOTAL(montantTotal);
		this.detaildemandeDto.setDescription(description);
		
	}
	
	
	// Methode servant a remettre a blanc les champs d' ajout
	public void reset () {
		
	   this.detaildemandeDto = new DetailDemandeDto();
	}

	
	
	//Getter et Setter
	
	
	public DetailDemandeServiceInterface getDetailDemandeService() {
		return detailDemandeService;
	}

	public void setDetailDemandeService(DetailDemandeService detailDemandeService) {
		this.detailDemandeService = detailDemandeService;
	}
 
	
	public DetailDemandeDto getDetaildemandeDto() {
		return detaildemandeDto;
	}

	public void setDetaildemandeDto(DetailDemandeDto detaildemandeDto) {
		this.detaildemandeDto = detaildemandeDto;
	}

	public List<DetailDemandeDto> getListeDetailDemandeDto() {
		return listeDetailDemandeDto;
	}

	public void setListeDetailDemandeDto(List<DetailDemandeDto> listeDetailDemandeDto) {
		this.listeDetailDemandeDto = listeDetailDemandeDto;
	}

	public List<DetailDemandeDto> getlisteDetailDemandeDtoDerniereDemande() {
		return listeDetailDemandeDtoDerniereDemande;
	}

	public void setlisteDetailDemandeDtoDerniereDemande(List<DetailDemandeDto> listeDetailDemandeDtoDerniereDemande) {
		this.listeDetailDemandeDtoDerniereDemande = listeDetailDemandeDtoDerniereDemande;
	}
	
	public List<DetailDemandeDto> getListeDetailDemandeDtoRech() {
		return listeDetailDemandeDtoRech;
	}

	public void setListeDetailDemandeDtoRech(List<DetailDemandeDto> listeDetailDemandeDtoRech) {
		this.listeDetailDemandeDtoRech = listeDetailDemandeDtoRech;
	}

	public DetailDemandeDto getDetailDemandeDtoRech() {
		return detailDemandeDtoRech;
	}

	public void setDetailDemandeDtoRech(DetailDemandeDto detailDemandeDtoRech) {
		this.detailDemandeDtoRech = detailDemandeDtoRech;
	}

	public LocalDate getLocaldate() {
		return localDate;
	}

	public void setLocaldate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public CatalogueDto getCatalogueDtoRech() {
		return catalogueDtoRech;
	}

	public void setCatalogueDtoRech(CatalogueDto catalogueDtoRech) {
		this.catalogueDtoRech = catalogueDtoRech;
	}	
}
