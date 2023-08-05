package Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import DTO.FournisseurDto;
import Dao.CatalogueDao;
import Dao.FournisseurDao;

@Service
public class FournisseurService implements FournisseurServiceInterface {
	
	// pour appeller les méthodes de DaoCatalogue

	@Autowired
	private FournisseurDao fournisseurDao  ;

	@Override
	@Transactional
	public FournisseurDto ajouter(FournisseurDto fournisseurDto) {
      
		return  fournisseurDao.ajouter(fournisseurDto);
	}

	@Override
	public FournisseurDto rechercheParId(Long id) {
		return fournisseurDao.rechercher(id);
		
	}

	@Override
	public List<FournisseurDto> rechercherParNom(String nom) {
		// TODO Auto-generated method stub
		return fournisseurDao.rechercher(nom);
	}

	@Transactional
	public void supprimer(Long id) {
		
		fournisseurDao.supprimer(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FournisseurDto> afficherTout() {
		// TODO Auto-generated method stub
		return fournisseurDao.afficher();
	}

	@Transactional
	public void Modifier(FournisseurDto fournisseurDto) {
		fournisseurDao.modifier(fournisseurDto);
		
	}
	


}
