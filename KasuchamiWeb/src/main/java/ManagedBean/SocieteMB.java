package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import DTO.SocieteDto;
import Service.SocieteServiceInterface;

@Named
@SessionScoped
public class SocieteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8089354024463355226L;
	
	
	
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


	SocieteServiceInterface societeService = (SocieteServiceInterface) context.getBean("societeService");
	
	
		
		
	
	//Attribut
		private SocieteDto societeDto = new SocieteDto();
		

	// Constructeur	
		public SocieteMB () { }
			
		public SocieteMB ( SocieteDto societeDto) {

				this.societeDto = new SocieteDto();

			}	
		
		
		
	// pour l' initialisation
		private List<SocieteDto> societeDtoList = new ArrayList<SocieteDto>();
		private SocieteDto societeDtoRech = new SocieteDto();
	// pour le traitement
	     private List<SocieteDto> societeDtoListrech = new ArrayList<SocieteDto>();
	
	    @PostConstruct
	 	public void init() {

	 		resetSocieteDto();
	 		this.societeDtoList = societeService.afficherTout();

	 	}
		
		public void supprimer(SocieteDto SocieteASupprimer) {

			long societe = SocieteASupprimer.getIdSociete();

			societeService.supprimer(societe);

			societeDtoList.remove(SocieteASupprimer);
			// TODO Auto-generated method stub

		}
		
		public void rechercherParNom() {
			// TODO Auto-generated method stub
			String libelléSociété = societeDto.getL_SOCIETE();
			this.societeDtoListrech = societeService.rechercherParNom(libelléSociété );
		}
		
		public void rechercherParId() {
			// TODO Auto-generated method stub
			long IdSociété = societeDto.getIdSociete();
			this.societeDtoRech = societeService.rechercheParId(IdSociété);;
		}
		
		public void modifier(SocieteDto societeDto) {

			societeService.Modifier(societeDto);
			// TODO Auto-generated method stub

		}
		
		public void ajouter() {
			societeService.ajouter(societeDto);

			this.societeDtoList = societeService.afficherTout();
			this.societeDto = new SocieteDto();
			resetSocieteDto();

		}
		private void resetSocieteDto() {

			this.societeDto = new SocieteDto();
		}	
				
		/////Getter Setter////////////////////////////////////

		public SocieteDto getSocieteDto() {
			return societeDto;
		}

		public void setSocieteDto(SocieteDto societeDto) {
			this.societeDto = societeDto;
		}

		public List<SocieteDto> getSocieteDtoList() {
			return societeDtoList;
		}

		public void setSocieteDtoList(List<SocieteDto> societeDtoList) {
			this.societeDtoList = societeDtoList;
		}

		public List<SocieteDto> getSocieteDtoListrech() {
			return societeDtoListrech;
		}

		public  void setSocieteDtoListrech(List<SocieteDto> societeDtoListrech) {
			this.societeDtoListrech = societeDtoListrech;
		}

		public SocieteDto getSocieteDtoRech() {
			return societeDtoRech;
		}

		public void setSocieteDtoRech(SocieteDto societeDtoRech) {
			this.societeDtoRech = societeDtoRech;
		}	
				
}


