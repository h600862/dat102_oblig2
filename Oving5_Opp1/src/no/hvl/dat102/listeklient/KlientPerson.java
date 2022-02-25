package no.hvl.dat102.listeklient;

import java.util.Scanner;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPerson {

	public static void main(String[] args) {

		OrdnetListeADT<Integer> liste1 = new KjedetOrdnetListe<Integer>();
		OrdnetListeADT<Integer> liste2 = new TabellOrdnetListe<Integer>();

		Scanner in = new Scanner(System.in);
		int foedselsaar;
		String svar;
		
		do {
			System.out.println("Oppgi foedselsaar på person?:");
			foedselsaar = in.nextInt();

			liste1.leggTil(foedselsaar);
			liste2.leggTil(foedselsaar);
			svar = in.nextLine();
			System.out.print("Oppgi flere foedselsaar [J/N]?:");
			svar = in.nextLine();

		} while (svar.equals("j") || svar.equals("J"));

		System.out.println("\nPersoners alder fra eldst til yngst:");

		while(!liste1.erTom()) {
			foedselsaar = liste1.fjernFoerste();
			System.out.println(foedselsaar);
		}

		System.out.println("\nPersoners alder fra yngst til eldst:");

		while(!liste2.erTom()) {
			foedselsaar = liste2.fjernSiste();
			System.out.println(foedselsaar);
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
