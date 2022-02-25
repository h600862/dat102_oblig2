package no.hvl.dat102.Oppg2;

import java.util.Iterator;

import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.kjedet.KjedetMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	
	// … Konstruktør
	public Medlem(String navn) {
		this.navn = navn;
		this.statusIndeks = -1;
		hobbyer = new KjedetMengde<Hobby>();
	}

	public String getNavn() {
		return navn;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setNyHobby(Hobby nyHobby) {
		hobbyer.leggTil(nyHobby);
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	public boolean passerTil(Medlem medlem2) {
		// Har dei nøyaktig samme hobbyane.
		// (Like mengder)
		boolean passer = false;
		MengdeADT<Hobby> midler = this.getHobbyer();
		MengdeADT<Hobby> midler2 = medlem2.getHobbyer();
		
		if (midler == midler2) {
			passer = true;
		}
		if (midler2 == null) {
			return false;
		}
		if (midler.getClass() != midler2.getClass()) {
			passer = false;
		}
		
		if (midler.undermengde(midler2) && midler2.undermengde(midler)) {
			passer = true;
		}
		
		return passer;
		// return hobbyer.equals(medlem2.getHobbyer());
	}

	// … Andre metoder

	public void skrivUt() {
		Iterator<Hobby> t = hobbyer.iterator();
		System.out.println("Navn: " + navn);
		
		String medlemHobbyer = "<";
		
		while (t.hasNext()) {
			medlemHobbyer += (t.next().toString());
			if (t.hasNext()) {
				medlemHobbyer += ", ";
			}
		}
		
		medlemHobbyer += ">";
		
		System.out.println(medlemHobbyer);
		System.out.println("Status: " + statusIndeks);

	}
}
