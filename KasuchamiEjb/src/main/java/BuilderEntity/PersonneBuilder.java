package BuilderEntity;

import DTO.PersonneDto;
import Entity.Personne;

public class PersonneBuilder {


	public static  Personne  fromUser ( PersonneDto  personneDto) {
		Personne  personne = new Personne();

		personne.setidPersonne(personneDto.getidPersonne());
		personne.setidentifiant(personneDto.getidentifiant());
		personne.setnom(personneDto.getnom());
		personne.setprenom(personneDto.getprenom());
		personne.setsexe(personneDto.getsexe());
		personne.setavatar(personneDto.getavatar());

		return personne;

	}

	public static PersonneDto fromEntity (Personne personne) {
		PersonneDto personneDto = new PersonneDto();

		personneDto.setidPersonne(personne.getidPersonne());
		personneDto.setidentifiant(personne.getidentifiant());
		personneDto.setnom(personne.getnom());
		personneDto.setprenom(personne.getprenom());
		personneDto.setsexe(personne.getsexe());
		personneDto.setavatar(personne.getavatar());

		return personneDto;	
	}
}
