package no.hvl.dat102.klient;

import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.kjedet.KjedetMengde;

public class Ordliste3 {

	public static void main(String[] args) {

		MengdeADT<String> ordListe1 = new KjedetMengde<String>();

		String[] ord1 = { "God", "dag", "Hans", "Hansen", "Hansaby", "Olsen", "Ole", "buss", "rute", "Bergen" };

		String[] ord2 = { "God", "Hei", "Eva", "Oslo", "Foerde", "Olsen", };

		for (int i = 0; i < ord1.length; i++) {
			ordListe1.leggTil(ord1[i]);
		}
		int ant = ordListe1.antall();

		MengdeADT<String> ordListe2 = new KjedetMengde<String>();

		for (int i = 0; i < ord2.length; i++) {
			ordListe2.leggTil(ord2[i]);
		}

		// Lager unionen av de to ordlistene
		MengdeADT<String> ordListeBegge = new KjedetMengde<String>();

		ordListeBegge = ordListe1.union(ordListe2);

		System.out.println("Utskrift av unionen av begge ordlistene");
		String hentStreng = "";
		while (!ordListeBegge.erTom()) {
			hentStreng = ordListeBegge.fjernTilfeldig();
			System.out.println(hentStreng);

		}
	}

}
