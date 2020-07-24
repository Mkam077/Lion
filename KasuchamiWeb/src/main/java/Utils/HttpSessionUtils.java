package Utils;
//  Pour permettre des mise à jour dans la même session et ne pas avoir à redémarer le serveur.
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public final class HttpSessionUtils {

	public static final String COMPTE_USER_IDENTIFIANT = "compteUserIdentifiant";
	public static final String FICHE_EMPLOYE_IDENTIFIANT = "ficheEmployeIdentifiant";
	
	
	private HttpSessionUtils() {
	}

	public static void setAttributDansLaHttpSession(String nomAttribut, Object valeurAttribut) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute(nomAttribut, valeurAttribut);
	}
	
	public static Object getAttributDansLaHttpSession(String nomAttribut) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute(nomAttribut);
	}
	
	public static String getCompteUserIdentifiantInHttpSession() {
		return (String) HttpSessionUtils.getAttributDansLaHttpSession(HttpSessionUtils.COMPTE_USER_IDENTIFIANT);
	}
	
	public static void setCompteUserIdentifiantInHttpSession(String compteUserIdentifiant) {
		HttpSessionUtils.setAttributDansLaHttpSession(HttpSessionUtils.FICHE_EMPLOYE_IDENTIFIANT, compteUserIdentifiant);
	}
	
	public static void getFicheCandidatMailInHttpSession() {
		HttpSessionUtils.getAttributDansLaHttpSession(HttpSessionUtils.FICHE_EMPLOYE_IDENTIFIANT);
	}
	public static void setFicheCandidatMailInHttpSession(String ficheEmployeIdentifiant) {
		HttpSessionUtils.setAttributDansLaHttpSession(HttpSessionUtils.FICHE_EMPLOYE_IDENTIFIANT, ficheEmployeIdentifiant);
	}
}
