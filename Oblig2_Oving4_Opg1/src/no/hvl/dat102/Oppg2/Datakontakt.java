package no.hvl.dat102.Oppg2;

public class Datakontakt {
	private Medlem[] medlemstabell;
	private int antallMedlemmer;
	private static int STDK = 100;

	public Datakontakt(Medlem[] medlem, int antall) {

		medlemstabell = new Medlem[STDK];
		medlemstabell = medlem;
		antallMedlemmer = antall;

	}

	public static int getSTDK() {
		return STDK;
	}

	public static void setSTDK(int stdk) {
		STDK = stdk;
	}

	public Medlem[] getMedlemstabell() {
		return medlemstabell;
	}

	public void setMedlemstabell(Medlem[] medlemstabell) {
		this.medlemstabell = medlemstabell;
	}

	public int getAntall() {
		return antallMedlemmer;
	}

	public void setAntall(int antall) {
		this.antallMedlemmer = antall;
	}

	public void leggTilMedlem(Medlem person) {

		if (antallMedlemmer == medlemstabell.length) {
			utvid();
		}
		medlemstabell[antallMedlemmer] = person;
		antallMedlemmer++;

	
	}

	private void utvid() {
		Medlem[] utvid = new Medlem[medlemstabell.length * 2];
		for (int i = 0; i < medlemstabell.length; i++) {
			utvid[i] = medlemstabell[i];
		}
		medlemstabell = utvid;
	}

	public boolean erTom() {
		return (antallMedlemmer == 0);
	}

	public int finnMedlemsIndeks(String medlemsnavn) {

		int indeks = 0;
		for (int i = 0; i < medlemstabell.length && indeks == 0; i++) {
			if (medlemsnavn.equals(medlemstabell[i].getNavn())) {
				indeks = i;
			}

		}
		return indeks;
		
	}

	public int finnPartnerFor(String medlemsnavn) {

		int indeks = finnMedlemsIndeks(medlemsnavn);
		int par = -1;
		for (int i = 0; i < medlemstabell.length && par < 0; i++) {
			if (medlemstabell[indeks].passerTil(medlemstabell[i])) {
				indeks = i;
				medlemstabell[indeks].setStatusIndeks(par);
				medlemstabell[par].setStatusIndeks(indeks);
			}
		}
		return par;

	
	}

	public void tilbakesillStatusIndeks(String medlemsnavn) {

		int indeks = finnMedlemsIndeks(medlemsnavn);
		int par = finnPartnerFor(medlemsnavn);

		if (par > -1 && indeks > -1) {
			medlemstabell[indeks].setStatusIndeks(-1);
			medlemstabell[par].setStatusIndeks(-1);
		}

	}
	
}
