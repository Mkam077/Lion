package Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.SocieteDto;

import Dao.DaoSociete;

@Service
public class SocieteService implements SocieteServiceInterface {

	
	// pour appeller les méthodes de DaoSociete

		@Autowired
		private DaoSociete daoSociete  ;
		
	@Transactional
	public SocieteDto ajouter(SocieteDto societeDto) {
		// TODO Auto-generated method stub
		return daoSociete.ajouter(societeDto);
	}

	@Transactional
	public SocieteDto rechercheParId(Long id) {
		
		
		// TODO Auto-generated method stub
		return daoSociete.rechercheParId(id);
		
	}

	
	public List<SocieteDto> rechercherParNom(String nom) {
		// TODO Auto-generated method stub
		return daoSociete.rechercherParNom(nom);
	}

	
	
	
	@Transactional
	public void supprimer(Long id) {
		
		daoSociete.supprimer(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SocieteDto> afficherTout() {
		// TODO Auto-generated method stub
		return daoSociete.afficherTout();
	}

	@Transactional
	public void Modifier(SocieteDto societeDto) {
		
		daoSociete.Modifier(societeDto);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(long societe) {
		// TODO Auto-generated method stub
		
	}
	

}
