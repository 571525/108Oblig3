package paameldingsWebapp;

import javax.servlet.http.HttpServletRequest;

public class Paamelding {

	private String fornavn;
	private String fornavnFeil = "";
	private String etternavn;
	private String etternavnFeil = "";
	private String mobil;
	private String mobilFeil = "";	
	private String passord;
	private String passordRepetert;
	private String passordRepetertFeil = "";
	private String passordFeil = "";
	private String kjonn;
    private String kjonnFeil = "";
    
	public Paamelding(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passordRepetert = request.getParameter("passordRepetert");
		this.kjonn = request.getParameter("kjonn");
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getFornavnFeil() {
		return fornavnFeil;
	}

	public void setFornavnFeil(String fornavnFeil) {
		this.fornavnFeil = fornavnFeil;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getEtternavnFeil() {
		return etternavnFeil;
	}

	public void setEtternavnFeil(String etternavnFeil) {
		this.etternavnFeil = etternavnFeil;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getMobilFeil() {
		return mobilFeil;
	}

	public void setMobilFeil(String mobilFeil) {
		this.mobilFeil = mobilFeil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}
	

	public String getPassordRepetert() {
		return passordRepetert;
	}

	public void setPassordRepetert(String passordRepetert) {
		this.passordRepetert = passordRepetert;
	}
	

	public String getPassordRepetertFeil() {
		return passordRepetertFeil;
	}

	public void setPassordRepetertFeil(String passordRepetertFeil) {
		this.passordRepetertFeil = passordRepetertFeil;
	}

	public String getPassordFeil() {
		return passordFeil;
	}

	public void setPassordFeil(String passordFeil) {
		this.passordFeil = passordFeil;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getKjonnFeil() {
		return kjonnFeil;
	}

	public void setKjonnFeil(String kjonnFeil) {
		this.kjonnFeil = kjonnFeil;
	}

	public void setFeilmeldinger() {
		if(!Valider.gyldigtNavn(fornavn)) {
			this.fornavn = "";
			this.fornavnFeil = "Ugyldigt fornavn";
		}
		if(!Valider.gyldigtNavn(etternavn)) {
			this.etternavn = "";
			this.etternavnFeil = "Ugyldigt etternavn";
		}
		if(!Valider.gyldigMobil(mobil)) {
			this.mobil = "";
			this.mobilFeil = "Ugyldig mobil";
		}
		if(!Valider.gyldigtPassord(passord)) {
			this.passord = "";
			this.passordRepetert="";
			this.passordFeil = "Ugyldig passord";
		}
		if(!Valider.passordLike(passord, passordRepetert)) {
			this.passordRepetert = "";
			this.passordRepetertFeil = "Passordene må være like";
		}
		if(!Valider.gyldigtKjonn(kjonn)) {
			this.kjonn = "";
			this.kjonnFeil = "Du må velge kjønn";
		}
	}

}
