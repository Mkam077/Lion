package Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.DemandeDto;
import Dao.DemandeDao;


@Service
public class DemandeService implements DemandeServiceInterface {
	
// @Autowired permet d'activer l'injection automatique de dépendance. evite dans de faire le cablage en xml 
	// permet d' injecter les données
	@Autowired
	private DemandeDao demandeDao;

	@Override
	public DemandeDto ajouter(DemandeDto demandeDto) {
		// TODO Auto-generated method stub
		return demandeDao.ajouter(demandeDto);
	}

	@Override
	public DemandeDto rechercheParId(Long id) {
	  	
	return	demandeDao.rechercher(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DemandeDto> rechercherParNom(String nom) {
		// TODO Auto-generated method stub
		return demandeDao.rechercher(nom);
	}

	@Override
	public void supprimer(Long id) {
		
		demandeDao.supprimer(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DemandeDto> afficherTout() {
		// TODO Auto-generated method stub
		return demandeDao.Afficher();
	}

	@Override
	public void Modifier(DemandeDto demandeDto) {
		demandeDao.modifier(demandeDto);
		// TODO Auto-generated method stub
		
	}
//Ajouter le @transactional pour que l' ajout pour la persistence puisse etre réalisé
	@Override
	@Transactional
	public void ajoutDemande(DemandeDto demandeDto) {
		// TODO Auto-generated method stub
		 demandeDao.ajoutDemande(demandeDto);
	}

}
