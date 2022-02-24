package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.kjedet.KjedetOrdnetListe;

public class PersonMain {

	public static void main(String[] args) {
		KjedetOrdnetListe<String> Liste = new KjedetOrdnetListe<String>();
		KjedetOrdnetListe<String> Liste2 = new KjedetOrdnetListe<String>();

		Scanner in = new Scanner(System.in);
		String navn, svar;

		do {
			System.out.println("Skriv navn: ");
			navn = in.nextLine();
			// Legger navnene sortert inn i navnelistene
			Liste.leggTil(navn);
			Liste2.leggTil(navn);

			System.out.print("Fleire navn? [J/N]: ");
			svar = in.nextLine();

		} while (svar.equals("j") || svar.equals("J"));

		// Skriver navnene ut i stigende ordning
		System.out.println("\n\nNavnelisten i stigende ordning:");

		while (Liste.antall() > 0) {
			System.out.print(Liste.fjernFoerste() + " ");
		}

		// Skriver ut navnen i avtagende ordning
		System.out.println("\n\nNavnelisten i fallende ordning:");

		while (Liste2.antall() > 0) {
			System.out.print(Liste2.fjernSiste() + " ");
		}

	}

}
