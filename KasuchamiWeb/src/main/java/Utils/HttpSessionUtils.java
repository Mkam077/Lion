package Utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public final class HttpSessionUtils {

	public static final String COMPTE_USER_MAIL = "compteUserMail";
	public static final String FICHE_CANDIDAT_MAIL = "ficheCandidatMail";
	
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
	
	public static String getCompteUserMailInHttpSession() {
		return (String) HttpSessionUtils.getAttributDansLaHttpSession(HttpSessionUtils.FICHE_CANDIDAT_MAIL);
	}
	
	public static void setCompteUserMailInHttpSession(String compteUserMail) {
		HttpSessionUtils.setAttributDansLaHttpSession(HttpSessionUtils.FICHE_CANDIDAT_MAIL, compteUserMail);
	}
	
	public static void getFicheCandidatMailInHttpSession() {
		HttpSessionUtils.getAttributDansLaHttpSession(HttpSessionUtils.FICHE_CANDIDAT_MAIL);
	}
	public static void setFicheCandidatMailInHttpSession(String ficheCandidatMail) {
		HttpSessionUtils.setAttributDansLaHttpSession(HttpSessionUtils.FICHE_CANDIDAT_MAIL, ficheCandidatMail);
	}
}
