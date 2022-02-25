package no.hvl.dat102.Oppg2;

import java.util.Iterator;

import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.kjedet.KjedetMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;
	// … Konstruktør
	public Object Tekstgrensesnitt;

	public Medlem() {

	}

	public Medlem(String navn, int statusIndeks) {
		this.navn = navn;
		this.statusIndeks = statusIndeks;
		//this.hobbyer = new KjedetMengde<Hobby>();
		
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

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
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
			passer = false;
		}
		if (midler.getClass() != midler2.getClass()) {
			passer = false;
		}
		return passer;
		// return hobbyer.equals(medlem2.getHobbyer());
	}

	// … Andre metoder

	public void skrivUt() {
		Iterator<Hobby> t = hobbyer.iterator();
		System.out.println("Navn: " + navn);
		while (t.hasNext()) {
			System.out.println(t.next().toString());
		}
		System.out.println("Status: " + statusIndeks);

	}

	public static void leggTilMedlem(Medlem medlem) {
		// TODO Auto-generated method stub
		
	}
}
