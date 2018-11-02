package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import paameldingsWebapp.Valider;

class Tester {
	
	@Test
	void passordTest() {
		String gjyldigt = "Test1";
		String ugjyldigt = "tes";
		String ugjyldigt2 = "test1";

		assertTrue(Valider.gyldigtPassord(gjyldigt));
		assertFalse(Valider.gyldigtPassord(ugjyldigt2));
		assertFalse(Valider.gyldigtPassord(ugjyldigt));
	}
	
	@Test
	void fornavnTest() {
		String gjyldigt = "David-Johan";
		String ugjyldigt = "frederik";
		String ugjyldigt2 = "P3ter";
		assertTrue(Valider.gyldigtFornavn(gjyldigt));
		assertFalse(Valider.gyldigtFornavn(ugjyldigt2));
		assertFalse(Valider.gyldigtFornavn(ugjyldigt));
	}

	@Test
	void EtternavnTest() {
		String gjyldigt = "Hyld-Karl";
		String ugjyldigt = "Jarosch-von Schweder";
		String ugjyldigt2 = "eitrem";
		assertTrue(Valider.gyldigtEtternavn(gjyldigt));
		assertFalse(Valider.gyldigtEtternavn(ugjyldigt2));
		assertFalse(Valider.gyldigtEtternavn(ugjyldigt));
	}
	
	@Test
	void MobilTest() {
		String gjyldigt = "12345678";
		String ugjyldigt = "12e3498";
		String ugjyldigt2 = "l2345679";
		assertTrue(Valider.gyldigMobil(gjyldigt));
		assertFalse(Valider.gyldigMobil(ugjyldigt2));
		assertFalse(Valider.gyldigMobil(ugjyldigt));
	}

	@Test
	void kjønnTest() {
		String gjyldigt = "kvinne";
		String gjyldigt2 = "mann";
		String ugjyldigt = "Kvin";
		String ugjyldigt2 = "Man";
		assertTrue(Valider.gyldigtKjonn(gjyldigt));
		assertTrue(Valider.gyldigtKjonn(gjyldigt2));
		assertFalse(Valider.gyldigtKjonn(ugjyldigt2));
		assertFalse(Valider.gyldigtKjonn(ugjyldigt));
	}

}
