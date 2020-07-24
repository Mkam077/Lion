package ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import DTO.CompteUserDto;
import Service.CompteUserServiceInterface;
import Utils.HttpSessionUtils;

@Named
@SessionScoped
public class CompteUserMB  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1751021623133190068L;

	/**
	 * 
	 */
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


	CompteUserServiceInterface compteUserService = (CompteUserServiceInterface) context.getBean("compteUserService");

	// Attribut	
	private String identifiant;
	private Object p;

	// Constructeur
	private CompteUserDto compteUserDto = new CompteUserDto();



	public CompteUserMB () {


	}

	public CompteUserMB (  CompteUserDto compteUserDto) {

		this.compteUserDto = new CompteUserDto();

	}

	// pour l' initialisation
	private List<CompteUserDto> compteUserDtoList = new ArrayList<CompteUserDto>();



	// pour le traitement
	private List<CompteUserDto> compteUserDtoListrech = new ArrayList<CompteUserDto>();
	private CompteUserDto compteUserDtoConfirm =new CompteUserDto();

	@PostConstruct
	public void init() {

		resetCompteUseDto();
		this.compteUserDtoList = compteUserService.afficher();

		String identifiant = compteUserDto.getidentifiant();

		//this.compteUserDtoListrech = compteUserService.rechercherParNom(identifiant);

	}


	public void supprimer(CompteUserDto compteUserASupprimer) {

		Long compteUser = compteUserASupprimer.getidCompteUser();

		compteUserService.supprimer(compteUser);

		compteUserDtoList.remove(compteUserASupprimer);
		// TODO Auto-generated method stub

	}

	public void rechercherParNom() {
		// TODO Auto-generated method stub
		String identifiant = compteUserDto.getidentifiant();
		this.compteUserDtoListrech = compteUserService.rechercherParNom(identifiant);
	}

	public void modifier(CompteUserDto compteUserDto) {

		compteUserService.modifier(compteUserDto);
		// TODO Auto-generated method stub

	}

	public void ajouter() {
//		if( compteUserDto.getidentifiant().equalsIgnoreCase(compteUserDtoConfirm.getidentifiant())) {
//			if( compteUserDto.getmotDePasse().equals(compteUserDtoConfirm.getmotDePasse())) {
				compteUserService.ajouter(compteUserDto);
			//	HttpSessionUtils.setCompteUserIdentifiantInHTTPSession(compteUserDto.getidentifiant());
				// TODO Auto-generated method stub
				this.compteUserDtoList = compteUserService.afficher();
				this.compteUserDto = new CompteUserDto();

//			}else {
//				System.out.println("mot de passe incorrecte ");
//
//			} 
//		}else {
//			System.out.println("identifiant incorrecte ");
//		}
		resetCompteUseDto();
		//	public List<CompteUserDto> afficher() {
		//		// TODO Auto-generated method stub
		//		return null;
		//	}

	}
	private void resetCompteUseDto() {

		this.compteUserDto = new CompteUserDto();
	}

	
	
	public String connexion ( ) {	
	     try {
		CompteUserDto compteUserDtoTrouvé= compteUserService.findconnexion(compteUserDto);
		String identifiant = compteUserDto.getidentifiant();
		String motDePasse = compteUserDto.getmotDePasse();
		
		if( identifiant.equals(compteUserDtoTrouvé.getidentifiant()) 
				&& ( motDePasse.equals(compteUserDtoTrouvé.getmotDePasse()))) 
//		boolean compteUserDtoTrouvé;
//		if( compteUserDtoTrouvé = compteUserService.connexion(identifiant, motDePasse) != null   )
		{
			System.out.println( "connexion");
			HttpSessionUtils.setCompteUserIdentifiantInHttpSession(identifiant);
			this.p = compteUserDto.getPersonneDto();
			return"sucess";
		}
		else {	
			}
			System.out.println("pas de connexion");
			return"notsucess";
		
			
		} catch (NullPointerException e) {
			System.out.println("pas de connexion attrapé");
			return"notsucess";
			
		}
	}
	
	public String deconnexion( ) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "sucessdec";
	}
	
	
	public String connexionAdm ( ) {	
	     try {
		CompteUserDto compteUserDtoTrouvé= compteUserService.connexionAdm(compteUserDto);
		String identifiant = compteUserDto.getidentifiant();
		String motDePasse = compteUserDto.getmotDePasse();
		String administrateur = compteUserDto.getadministrateur();
		
		if( identifiant.equals(compteUserDtoTrouvé.getidentifiant()) 
				&& ( motDePasse.equals(compteUserDtoTrouvé.getmotDePasse())
						&& (administrateur.equals(compteUserDtoTrouvé.getadministrateur()))))
//		boolean compteUserDtoTrouvé;
//		if( compteUserDtoTrouvé = compteUserService.connexion(identifiant, motDePasse) != null   )
		{
			System.out.println( "connexion");
			
			this.p = compteUserDto.getPersonneDto();
			return"sucessadm";
		}
		else {	
			}
			System.out.println("pas de connexion");
			return"notsucessadm";
		
			
		} catch (NullPointerException e) {
			System.out.println("pas de connexion attrapé");
			return"notsucessadm";
			
		}
	}
	
	
	
	public CompteUserDto getCompteUserDto() {
		return compteUserDto;
	}

	public void setCompteUserDto(CompteUserDto compteUserDto) {
		this.compteUserDto = compteUserDto;
	}

	public List<CompteUserDto> getCompteUserDtoList() {
		return compteUserDtoList;
	}

	public void setCompteUserDtoList(List<CompteUserDto> compteUserDtoList) {
		this.compteUserDtoList = compteUserDtoList;
	}

	public List<CompteUserDto> getCompteUserDtoListrech() {
		return compteUserDtoListrech;
	}

	public void setCompteUserDtoListrech(List<CompteUserDto> compteUserDtoListrech) {
		this.compteUserDtoListrech = compteUserDtoListrech;
	}

	public CompteUserServiceInterface getCompteUserService() {
		return compteUserService;
	}

	public void setCompteUserService(CompteUserServiceInterface compteUserService) {
		this.compteUserService = compteUserService;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

};








