package paameldingsWebapp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerlisteEAO {

	@PersistenceContext(name = "Gr7PU")
    private EntityManager em;

	public List<DeltagerEntity> hentAlleDeltagere() {
		@SuppressWarnings("unchecked")
		List<DeltagerEntity> liste = (List<DeltagerEntity>) em.createQuery("SELECT * FROM dat108Obl3.deltagerliste;");
		return liste;
	}

	public synchronized void tilfojDeltager(String fornavn, String etternavn, int mobil, String passord, boolean kjonn) {
		DeltagerEntity ny = new DeltagerEntity();
		ny.setFornavn(fornavn);
		ny.setEtternavn(etternavn);
		ny.setMobil(mobil);
		ny.setPassord(passord);
		ny.setKjonn(kjonn);
		em.persist(ny);
	}
	
	//TODO metoder som håndterer db kobling
	
}
