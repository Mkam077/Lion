package Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import DTO.CatalogueDto;
import Dao.CatalogueDao;

@Service
public class CatalogueService implements CatalogueServiceInterface {
	
	// pour appeller les méthodes de DaoCatalogue

	@Autowired
	private CatalogueDao catalogueDao  ;

	@Override
	@Transactional
	public CatalogueDto ajouter(CatalogueDto catalogueDto) {
      
		return  catalogueDao.ajouter(catalogueDto);
	}

	@Override
	public CatalogueDto rechercheParId(Long id) {
		return catalogueDao.rechercher(id);
		
	}

	@Override
	public List<CatalogueDto> rechercherParNom(String nom) {
		// TODO Auto-generated method stub
		return catalogueDao.rechercher(nom);
	}

	@Transactional
	public void supprimer(Long id) {
		
		catalogueDao.supprimer(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CatalogueDto> afficherTout() {
		// TODO Auto-generated method stub
		return catalogueDao.afficher();
	}

	@Transactional
	public void Modifier(CatalogueDto catalogueDto) {
		catalogueDao.modifier(catalogueDto);
		
	}
	


}
