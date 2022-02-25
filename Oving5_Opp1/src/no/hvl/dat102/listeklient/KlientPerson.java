package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPerson {

	public static void main(String[] args) {

		OrdnetListeADT<String> liste1 = new KjedetOrdnetListe<String>();
		OrdnetListeADT<String> liste2 = new TabellOrdnetListe<String>();

		Scanner in = new Scanner(System.in);
		String person;
		String svar;

		do {
			System.out.println("Oppgi person?:");
			person = in.nextLine();

			liste1.leggTil(person);
			liste2.leggTil(person);
			
			System.out.print("Oppgi flere personer [J/N]?:");
			svar = in.nextLine();

		} while (svar.equals("j") || svar.equals("J"));

		System.out.println("\nperson i stigende ordning:");

		while(!liste1.erTom()) {
			person = liste1.fjernFoerste();
			System.out.println(person);
		}

		System.out.println("\nperson i synkende ordning:");

		while (liste2.antall() > 0) {
			System.out.print(liste2.fjernSiste() + " ");
		}
		Person anne = new Person("Anne", "Iversen", 1996);
		Person ole = new Person("Ole", "Vik", 1995);
		Person bendik = new Person("Bendik", "Ness", 1997);
		Person jarle = new Person("Jarle", "Sivertsen", 1992);
		Person trygve = new Person("Trygve", "Jenssen", 1999);
		Person harald = new Person("Harald", "Nilsen", 1997);
//		
//		OrdnetListeADT<Person> liste = new TabellOrdnetListe<Person>();
//		
//		liste.leggTil(anne);
//		liste.leggTil(ole);
//		liste.leggTil(bendik);
//		
//		Person person = null;
//		
//		while(!liste.erTom()) {
//			person = liste.fjernFoerste();
//			System.out.println(person);
//	}
	}
}
