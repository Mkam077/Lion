package Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.CatalogueDto;
import DTO.DetailDemandeDto;
import DTO.DetailDemandeDto2;
import Dao.DetailDemande2Dao2;
import Dao.DetailDemandeDao;
import Entity.Catalogue;

@Service
public class DetailDemandeService2 implements DetailDemandeServiceInterface2 {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private DetailDemande2Dao2 detailDemande2Dao2 = new DetailDemande2Dao2();
	
	

	
	@Override
	public void rechercheParId(Long id) {
		detailDemande2Dao2.Rechercher(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DetailDemandeDto2> rechercherParNom(String nom) {
		// TODO Auto-generated method stub
		return detailDemande2Dao2.RechercherParNom(nom);
	}

	@Transactional
	public void supprimer(Long id) {
		detailDemande2Dao2.supprimer(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DetailDemandeDto2> afficherTout() {
		// TODO Auto-generated method stub
		return detailDemande2Dao2.afficherTout();
	}

	
	
	@Transactional
	public void Modifier(DetailDemandeDto2 detailDemandeDto2) {
		
		detailDemande2Dao2.modifier(detailDemandeDto2);
		// TODO Auto-generated method stub
		
	}

	
	@Override
	@Transactional
	public void ajouterLigneDeDemande(DetailDemandeDto2 detailDemandeDto2) {
	
	// calcul d'un montant total
		Catalogue catalogue = this.entityManager.createNamedQuery("Catalogue.findId", Catalogue.class)
				.setParameter("catalogueidValue", detailDemandeDto2.getCatalogueid()).getSingleResult();
		
		int totalMontant = catalogue.getMontant() * detailDemandeDto2.getQuantite();
		
		 detailDemandeDto2.setMontant_TOTAL(totalMontant);  
		
		// TODO Auto-generated method stub
		//detailDemandeDto.getQuantite()
		
		detailDemande2Dao2.ajouterLigneDeDemande(detailDemandeDto2);
	}

	@Override
	public List<CatalogueDto> AfficherCatalogueparid(long catalogueid) {
		// TODO Auto-generated method stub
		return detailDemande2Dao2.AfficherCatalogueparid(catalogueid);
	}

	
	
	
}
