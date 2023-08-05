package Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;


import DTO.CatalogueDto;
import DTO.DetailDemandeDto;
import Dao.DetailDemandeDao;
import Entity.Catalogue;

@Service
public class DetailDemandeService implements DetailDemandeServiceInterface {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private DetailDemandeDao detailDemandeDao;
	
	
	@Override
	public void rechercheParId(Long id) {
		detailDemandeDao.Rechercher(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DetailDemandeDto> rechercherParNom(String nom) {
		// TODO Auto-generated method stub
		return detailDemandeDao.RechercherParNom(nom);
	}

	
	public void supprimer(Long id) {
		detailDemandeDao.supprimer(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DetailDemandeDto> afficherTout() {
		// TODO Auto-generated method stub
		return detailDemandeDao.afficherTout();
	}

	@Override
	public List<DetailDemandeDto> afficherDerniereDemande() {
		// TODO Auto-generated method stub
		return detailDemandeDao.afficherDerniereDemande();
	}
	
	@Transactional
	public void Modifier(DetailDemandeDto detailDemandeDto) {
		
		detailDemandeDao.modifier(detailDemandeDto);
		// TODO Auto-generated method stub
		
	}

	
	@Override
	@Transactional
	public void ajouterLigneDeDemande(DetailDemandeDto detailDemandeDto) {
	
	 
		
		// TODO Auto-generated method stub
		//detailDemandeDto.getQuantite()
		
		detailDemandeDao.ajouterLigneDeDemande(detailDemandeDto);;
	}

	@Override
	public List<CatalogueDto> AfficherCatalogueparid(long catalogueid) {
		// TODO Auto-generated method stub
		return detailDemandeDao.AfficherCatalogueparid(catalogueid);
	}

	@Override
	public CatalogueDto afficherUnPrix(DetailDemandeDto detailDemandeDto) {
	    
	   return detailDemandeDao.RechercherAttributCatalogue(detailDemandeDto );
	    
	}
	
	@Transactional
	public void supprimer(Long demandeid, Long catalogueid) {
		// TODO Auto-generated method stub
		detailDemandeDao.supprimer(demandeid, catalogueid);
	}

	@Override
	public long afficherIDDerniereDemande() {
		// TODO Auto-generated method stub
		return detailDemandeDao.afficherIDDerniereDemande();
	}

	@Override
	public long afficherMtsDerniereDemande() {
		// TODO Auto-generated method stub
		return detailDemandeDao.afficherMtsDerniereDemande();
	}

	@Override
	public long afficherFraisDePortTotal() {
		// TODO Auto-generated method stub
		return detailDemandeDao.afficherFraisDePortTotal();
	}

	

	
	
}
