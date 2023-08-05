package Dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import BuilderEntity.DemandeBuilder;
import DTO.DemandeDto;
import Entity.Demande;
import Entity.Fournisseur;
import Entity.Societe;


@Repository
public class DemandeDao implements DemandeInterface
  

{
	@PersistenceContext
	private EntityManager entitymanager;

	@Override
	public DemandeDto ajouter(DemandeDto demandeDto) {
		  Demande demande = new Demande();
		  demande = DemandeBuilder.fromuser(demandeDto);
		   this.entitymanager.persist(demande);
		   this.entitymanager.flush();		
		// TODO Auto-generated method stub
		return   DemandeBuilder.fromEntity(demande);
	}

	@Override
	public void supprimer(Long id) {
		Demande demande = entitymanager.find(Demande.class, id);
		entitymanager.remove(demande);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Demande modifier(DemandeDto demandeDto) {
		Demande demande = new Demande();
		demande = DemandeBuilder.fromuser(demandeDto);
	
		return this.entitymanager.merge(demande);
	}


	@Override
		public List<DemandeDto> rechercher (String nom) {
			// Rechercher le nom dans la liste en fonction du paramétre rentrer en argument
			List<Demande> resultList = this.entitymanager.createNamedQuery("Demande.findName", Demande.class)
					.setParameter("nomf", nom)
					.getResultList();
			// Transformer l' objet entity en objet Dto
			return resultList
					.stream()
					.map(demande -> DemandeBuilder.fromEntity(demande))
					.collect(Collectors.toList());	
	
	}

	@Override
	public DemandeDto rechercher(Long id) {
		Demande demande = new Demande ();
		this.entitymanager.find(Demande.class, id);
		// TODO Auto-generated method stub
		return DemandeBuilder.fromEntity(demande);
	}

	@Override
	public List<DemandeDto> Afficher() {
	List <Demande> ListeDemande= entitymanager.createNamedQuery("Demande.afficherTout",Demande.class).getResultList();
		// TODO Auto-generated method stub
		return  ListeDemande.stream().map(demande -> DemandeBuilder.fromEntity(demande)).collect(Collectors.toList());
	}
	
	@Override
	public void  ajoutDemande(DemandeDto demandeDto) {
		
		/////////Contrainte sur la colonne C_Societe/////////
		// pour ajouter une demande il faut forcément une société.
		// on va chercher dans la colonne C_SOCIETE  de l' entité Société le C_SOCIETE qui correspond
		// au C_Societe de la DemandeDto. On récupére l' objet société qui lui correspond.
		
		
		
		Societe SocieteEntity = this.entitymanager.createNamedQuery("Societe.findName", Societe.class)
				.setParameter("c_SOCIETE",demandeDto.getC_SOCIETE()).getSingleResult();
		
		Fournisseur FournisseurEntity = this.entitymanager.createNamedQuery("Fournisseur.findName", Fournisseur.class)
				.setParameter("c_Fournisseur",demandeDto.getC_Fournisseur()).getSingleResult(); 
		
	//////////////////////Ajout et tagage des objets ////////////////////////////////////////	
		// si il existe une société on effectue l' action d' ajout en base de donnée
		//Etant donné que l' on est en one to many on ajoute la demande dans une liste.
		//  on modifie la société remonté avec la demande qui lui est lié.
		if(SocieteEntity != null & (FournisseurEntity != null) ) {
		Demande demande =  DemandeBuilder.fromuser(demandeDto);
		     demande.setSociete(SocieteEntity);     
		     SocieteEntity.getDemandes().add(demande);
		     demande.setFournisseur(FournisseurEntity);
		     FournisseurEntity.getDemandes().add(demande);
		     this.entitymanager.persist(demande);
		     this.entitymanager.flush();
		}
	//	     if(FournisseurEntity != null  ) {
	//	 		Demande demande =  DemandeBuilder.fromuser(demandeDto);
	//	 		     demande.setFournisseur(FournisseurEntity);
	//	 		     FournisseurEntity.getDemandes().add(demande);
		 		     
	//	 		     this.entitymanager.persist(demande);
	//	 		     this.entitymanager.flush();
		// TODO Auto-generated method stub
		
	//}
	
	}
}
	
