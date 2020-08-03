package Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.PersonneDto;
import Dao.DaoPersonne;


@Service
public class PersonneService  implements PersonneServiceInterface{


	@Autowired
	private DaoPersonne daoPersonne = new DaoPersonne();

	@Transactional
	public void ajouter(PersonneDto personneDto) {

		daoPersonne.ajouter(personneDto);
		// TODO Auto-generated method stub

	}

	@Transactional
	public void supprimer(Long id) {

		daoPersonne.supprimer(id);
		// TODO Auto-generated method stub

	}

	@Transactional
	public void modifier(PersonneDto personneDto) {

		daoPersonne.Modifier(personneDto);
		// TODO Auto-generated method stub

	}

	@Override
	public List<PersonneDto> Afficher() {


		// TODO Auto-generated method stub
		return daoPersonne.Afficher();
	}

	@Transactional
	public PersonneDto rechercherParId(Long id) {


		// TODO Auto-generated method stub
		return daoPersonne.RechercheParId(id);
	}

	@Override
	public List<PersonneDto> RechercherParNom(String nom) {
		// TODO Auto-generated method stub
		return daoPersonne.RechercherParNom(nom);
	}

}
