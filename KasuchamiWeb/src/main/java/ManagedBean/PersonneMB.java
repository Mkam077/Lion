package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import DTO.CompteUserDto;
import DTO.PersonneDto;
import Service.PersonneServiceInterface;

@Named
@SessionScoped
public class PersonneMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2017277975690967399L;

	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	PersonneServiceInterface personneService = (PersonneServiceInterface) context.getBean("personneService");
	
   //Les attribut
	private List<PersonneDto>listePersonneDto = new ArrayList<PersonneDto>();
	private PersonneDto personneDto = new PersonneDto();
	private List<PersonneDto>listePersonneDtoRech = new ArrayList<PersonneDto>();
	
	 @PostConstruct
	public void init() {
		
		this.listePersonneDto = personneService.Afficher();
		
	}
	
	public void supprimerUnePersonne(PersonneDto personneDto) {
		
		Long id = personneDto.getidPersonne();
		personneService.supprimer(id);
		
	}
	
	
	public void ajouterUnePersonne() {
		
		personneService.ajouter(personneDto);
		this.personneDto = new PersonneDto();
	}
	
	public void modifierUnePersonne(PersonneDto personneDto) {
		
		personneService.modifier(personneDto);
		
	}
	
	public void rechercherUnePersonne() {
		
		String nom = personneDto.getnom();
		
	this.listePersonneDtoRech =	personneService.RechercherParNom(nom);
		
	}
	
	

	public PersonneDto getPersonneDto() {
		return personneDto;
	}

	public void setPersonneDto(PersonneDto personneDto) {
		this.personneDto = personneDto;
	}

	public List<PersonneDto> getListePersonneDtoRech() {
		return listePersonneDtoRech;
	}

	public void setListePersonneDtoRech(List<PersonneDto> listePersonneDtoRech) {
		this.listePersonneDtoRech = listePersonneDtoRech;
	}

	public PersonneServiceInterface getPersonneService() {
		return personneService;
	}

	public void setPersonneService(PersonneServiceInterface personneService) {
		this.personneService = personneService;
	}

	public List<PersonneDto> getListePersonneDto() {
		return listePersonneDto;
	}

	public void setListePersonneDto(List<PersonneDto> listePersonneDto) {
		this.listePersonneDto = listePersonneDto;
	}
	
	
	
	
}
