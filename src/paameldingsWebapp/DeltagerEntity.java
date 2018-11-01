package paameldingsWebapp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "dat108obl3", name = "deltagerliste")
public class DeltagerEntity {

	@Id
    private int mobil;
	
	private String etternavn;
	private String fornavn;
	private boolean kjonn;
	private String passord;
	
	public DeltagerEntity() {
	}
	
	public int getMobil() {
		return mobil;
	}
	public void setMobil(int mobil) {
		this.mobil = mobil;
	}
	public String getPassord() {
		return passord;
	}
	public void setPassord(String passord) {
		this.passord = passord;
	}
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public boolean getKjonn() {
		return kjonn;
	}
	public void setKjonn(boolean kjonn) {
		this.kjonn = kjonn;
	}
	
	
}
