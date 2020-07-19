package BuilderEntity;

import DTO.CompteUserDto;
import DTO.PersonneDto;
import Entity.CompteUser;
import Entity.Personne;

public class CompteUserBuilder {
	
	public  CompteUser Build ( String identifiant, String motDePasse, String administrateur ) {
		CompteUser compteUser = new CompteUser();
		compteUser.setIdentifiant(identifiant);
		compteUser.setMotDePasse(motDePasse);
		compteUser.setAdministrateur(administrateur);
		return compteUser;
		
	}
	
	
	
	
	public static  CompteUser fromUser (CompteUserDto compteUserDto ) {
		CompteUser compteUser = new CompteUser();
		
		compteUser.setIdCompteUser(compteUserDto.getidCompteUser());
		compteUser.setIdentifiant(compteUserDto.getidentifiant());
		compteUser.setMotDePasse(compteUserDto.getmotDePasse());
		compteUser.setAdministrateur(compteUserDto.getadministrateur());
	
		//Contrainte one to one car personneDto n' est pas nul
	if(compteUserDto.getPersonneDto() != null){
			// on travaille avec une entity personne on la crée
			Personne personne = new Personne();
			// on  donne à l' entity personne créé l' id du personne DTO.
			personne.setidPersonne(compteUserDto.getPersonneDto().getidPersonne());
			// on donne une personne à l' attribut personne du compteUser
			compteUser.setPersonne(personne);
			}
		
		return compteUser;
		
		
	}

	public static CompteUserDto fromEntity ( CompteUser compteUser) {
		CompteUserDto compteUserDto = new CompteUserDto();
		
		compteUserDto.setidCompteUser(compteUser.getIdCompteUser());
		compteUserDto.setidentifiant(compteUser.getIdentifiant());
		compteUserDto.setmotDePasse(compteUser.getMotDePasse());
		compteUserDto.setadministrateur(compteUser.getAdministrateur());
		//Contrainte one to one car personneDto n' est pas nul	
	if(compteUserDto.getPersonneDto() != null) {
			// on travaille avec une personne DTO, on la crée
			PersonneDto personneDto = new PersonneDto();
			// on donne à personneDTO le id de l' entité personne
			personneDto.setidPersonne(compteUser.getPersonne().getidPersonne());
			// on donne une personneDTO au compteUserDto	
			compteUserDto.setPersonneDto(personneDto);
			}	
		return compteUserDto;
		
	}
	
	
	
	
	
}
