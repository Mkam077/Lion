package Service;

import java.util.List;

import DTO.CatalogueDto;
import DTO.DetailDemandeDto;

public interface DetailDemandeServiceInterface {
	
	
	void rechercheParId ( Long id);
	List<DetailDemandeDto> rechercherParNom (String nom);
	void  supprimer ( Long id);
	List <DetailDemandeDto> afficherTout ();
	List <DetailDemandeDto> afficherDerniereDemande();
    void Modifier ( DetailDemandeDto detailDemandeDto);
    public void ajouterLigneDeDemande(DetailDemandeDto detailDemandeDto);
    public List<CatalogueDto> AfficherCatalogueparid(long catalogueid );
	CatalogueDto afficherUnPrix(DetailDemandeDto detaildemandeDto);
	void supprimer(Long demandeid, Long catalogueid);
	long  afficherIDDerniereDemande();
	long afficherMtsDerniereDemande();
    long  afficherFraisDePortTotal() ;
}
