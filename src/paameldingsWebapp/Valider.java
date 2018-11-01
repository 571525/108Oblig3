package paameldingsWebapp;

public class Valider {
	public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$";
	public static final String ANY_LETTER_OR_SPACE = "[a-zA-ZÊ¯Â∆ÿ≈ ]";
	public static final String ANY_DIGIT = "[0-9]";

	public static boolean validert(String fornavn, String etternavn, String mobil, String passord, String passordRep,
			String kjonn) {
		return gyldigtPassord(passord) && passordLike(passord, passordRep) && gyldigtNavn(fornavn)
				&& gyldigtNavn(etternavn) && gyldigMobil(mobil) && gyldigtKjonn(kjonn);
	}
	
	public static boolean gyldigtKjonn(String kjonn) {
		if(kjonn == null) {
			return false;
		}
		return kjonn.equals("mann") || kjonn.equals("kvinne");
	}

	public static boolean gyldigtPassord(String passord) {
		if(passord==null) {
			return false;
		}
		return passord.matches(PASSWORD);
	}

	public static boolean passordLike(String p, String rep) {
		if(p==null || rep==null) {
			return false;
		}
		return p.equals(rep);
	}

	public static boolean gyldigtNavn(String navn) {
		if (navn == null) {
			return false;
		}
		return navn.matches("^" + ANY_LETTER_OR_SPACE + "+$");
	}

	public static boolean gyldigMobil(String mobil) {
		if(mobil==null) {
			return false;
		}
		return mobil.matches("^"+ANY_DIGIT+"+$") && mobil.length() == 8;
	}
}
