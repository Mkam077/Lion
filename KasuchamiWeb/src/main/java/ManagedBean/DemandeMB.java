package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import DTO.DemandeDto;
import Service.DemandeServiceInterface;


@Named
@SessionScoped
public class DemandeMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2774565907663883804L;
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


	DemandeServiceInterface demandeService = (DemandeServiceInterface) context.getBean("demandeService");
	
	
	
	
	    //Attribut
			private DemandeDto demandeDto = new DemandeDto();
			

		// Constructeur	
			public DemandeMB () { }
				
			public DemandeMB ( DemandeDto demandeDto) {

					this.demandeDto = new DemandeDto();

				}	
			
			
		// pour l' initialisation
	private List<DemandeDto> demandeDtoList = new ArrayList<DemandeDto>();

	private List<DemandeDto> demandeDtoListrech = new ArrayList<DemandeDto>();	
			
	private DemandeDto demandeDtoRecherche = new DemandeDto () ;
	
	
	
	
	@PostConstruct
	public void init() {

	resetDemandeDto();
		this.demandeDtoList = demandeService.afficherTout();

		 	}
						
		//////////////////////////////:METHODES///////////////////////////////////	
			
			public void supprimer(DemandeDto demandeASupprimer) {

				long demande = demandeASupprimer.getIdDemande();

				demandeService.supprimer(demande);

				
				// TODO Auto-generated method stub

			}
			
			public DemandeDto rechercherPariD() {
				// TODO Auto-generated method stub
				long idDemande = demandeDto.getIdDemande();
				return demandeService.rechercheParId(idDemande);
			}
			
			
			public void modifier(DemandeDto demandeDto) {

				demandeService.Modifier(demandeDto);
				// TODO Auto-generated method stub

			}
			
			public void ajouterDemande() {
				demandeService.ajoutDemande(demandeDto);

				this.demandeDtoList = demandeService.afficherTout();
				this.demandeDto= new DemandeDto();
				resetDemandeDto();

			}
			private void resetDemandeDto() {

				this.demandeDto = new DemandeDto();
			}

			public DemandeDto getDemandeDto() {
				return demandeDto;
			}

			public void setDemandeDto(DemandeDto demandeDto) {
				this.demandeDto = demandeDto;
			}

			public List<DemandeDto> getDemandeDtoList() {
				return demandeDtoList;
			}

			public void setDemandeDtoList(List<DemandeDto> demandeDtoList) {
				this.demandeDtoList = demandeDtoList;
			}

			public List<DemandeDto> getDemandeDtoListrech() {
				return demandeDtoListrech;
			}

			public void setDemandeDtoListrech(List<DemandeDto> demandeDtoListrech) {
				this.demandeDtoListrech = demandeDtoListrech;
			}

			public DemandeDto getDemandeDtoRecherche() {
				return demandeDtoRecherche;
			}

			public void setDemandeDtoRecherche(DemandeDto demandeDtoRecherche) {
				this.demandeDtoRecherche = demandeDtoRecherche;
			}	
			
			
			
				

}
