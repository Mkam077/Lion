package Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;


//@Embeddable
public class DetailDemandeId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6094989025423031958L;

	private Long demandeid;

	private Long catalogueid;
	
	// constructeur
	public  DetailDemandeId () {};

	public  DetailDemandeId ( Long demandeid, Long catalogueid) {
		this.demandeid = demandeid;
		this.catalogueid = catalogueid;
	};
	
	
	
	
	//Getter Setter
	public Long getDemandeid() {
		return demandeid;
	}

	public void setDemandeid(Long demandeid) {
		this.demandeid = demandeid;
	}

	public long getCatalogueid() {
		return catalogueid;
	}

	public void setCatalogueid(Long catalogueid) {
		this.catalogueid = catalogueid;
	};
	
	@Override
	public boolean equals (Object o) {
		   if ( this == o) {
			   return true;
		   }
		   if ( ! (o instanceof DetailDemandeId )) {
			   return false;
		   }
		   DetailDemandeId other = (DetailDemandeId) o;
		   return Objects.equals(demandeid, other.demandeid) && Objects.equals(catalogueid, other.catalogueid);
		   
	  }
	
	public int hascode() {
		   return Objects.hash(demandeid,catalogueid);
	  }

	
}
