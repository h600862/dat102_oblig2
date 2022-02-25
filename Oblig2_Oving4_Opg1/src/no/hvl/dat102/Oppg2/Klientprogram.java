package no.hvl.dat102.Oppg2;

import java.util.Scanner;

import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.kjedet.KjedetMengde;
import no.hvl.dat102.tabell.TabellMengde;

public class Klientprogram {
	
public static void main(String[] args) {
		
		MengdeADT<Hobby> male = new KjedetMengde<Hobby>() ;
		MengdeADT<Hobby> danse = new KjedetMengde<Hobby>();
		MengdeADT<Hobby> sprint = new KjedetMengde<Hobby>();
		MengdeADT<Hobby> spille = new KjedetMengde<Hobby>();
		
//		Datakontakt b1 = new Medlem("Trygve Jenssen", male);
//		Medlem b2 = new Medlem("Trygve Jenssen", danse);
//		Medlem b3 = new Medlem("Trygve Jenssen", sprint);
//		Medlem b4 = new Medlem("Trygve Jenssen", spille);
		
//		b1.setHobbyer(spille);
//		b1.setHobbyer(danse);
//		b1.setHobbyer(sprint);
//		b2.setHobbyer(spille);
//		b2.setHobbyer(male);
//		b3.setHobbyer(male);
//		b3.setHobbyer(spille);
//		
//		b1.toString();
//		b2.toString();
//		b3.toString();
//		b4.toString();
//	KjedetMengde<Hobby> p1 = new KjedetMengde<>();
//	KjedetMengde<Hobby> p2 = new KjedetMengde<>();
//	KjedetMengde<Hobby> p3 = new KjedetMengde<>();
//	KjedetMengde<Hobby> p4 = new KjedetMengde<>();
//	KjedetMengde<Hobby> p5 = new KjedetMengde<>();
		
		//  Skriv inn data og legger til i arkiv
	// Medlem Trygve | Sprint Spill
	// Medlem2 Jarle | Sprint
	// Medlem3 Harrald | Spill
	//Medlem4 Per | Spill Sprint
	//Medlem5 Anne | Sprint Male
	//Medlem6 Joar | Male Sprint
	//Medlem7 Rune | Sprint Male Spill
	
	Medlem m1 = new Medlem("Trygve Jenssen",-1);
	m1.setHobbyer(male);
	
	Medlem m2 = new Medlem("Trygve Jenssen",-1);
	m2.setHobbyer(male);
	Medlem m3 = new Medlem("Trygve Jenssen",-1);
	m3.setHobbyer(male);
	Medlem m4 = new Medlem("Trygve Jenssen",-1);
	m4.setHobbyer(male);
	Medlem m5 = new Medlem("Trygve Jenssen",-1);
	m5.setHobbyer(male);
	Medlem m6 = new Medlem("Trygve Jenssen",-1);
	m6.setHobbyer(male);
	Medlem m7 = new Medlem("Trygve Jenssen",-1);
	m7.setHobbyer(male);

	
	
		Datakontakt arkiv = new Datakontakt();
		Medlem medlem = Tekstgrensesnitt.lesMedlem();
		arkiv.leggTilMedlem(medlem);
		Medlem medlem2 = Tekstgrensesnitt.lesMedlem();
		arkiv.leggTilMedlem(medlem2);
		Medlem medlem3 = Tekstgrensesnitt.lesMedlem();
		arkiv.leggTilMedlem(medlem3);
		Medlem medlem4 = Tekstgrensesnitt.lesMedlem();
		arkiv.leggTilMedlem(medlem4);
		Medlem medlem5 = Tekstgrensesnitt.lesMedlem();
		arkiv.leggTilMedlem(medlem5);
		Medlem medlem6 = Tekstgrensesnitt.lesMedlem();
		arkiv.leggTilMedlem(medlem6);
		Medlem medlem7 = Tekstgrensesnitt.lesMedlem();
		arkiv.leggTilMedlem(medlem7);
		
		
		
		Tekstgrensesnitt.skrivParListe(arkiv);
		// Skriver ut HobbyListe til bruker
		String Navn = medlem.getNavn();
		int pos = arkiv.finnMedlemsIndeks(Navn);
		Medlem[] liste = arkiv.getMedlemstabell();
		Tekstgrensesnitt.skrivHobbyListe(liste[pos]);
		Tekstgrensesnitt.skrivParListe(arkiv);
		// Skriv ut par
		Tekstgrensesnitt.skrivParListe(arkiv);
		
		// Finne partneren til ein person
		String navn = medlem.getNavn();
		int pos2 = arkiv.finnPartnerFor(navn);
		if(pos2 == -1) {
			System.out.println(navn + " matchet ikke med noen");
		}
		else {
			Medlem[] liste2 = arkiv.getMedlemstabell();
			System.out.println(navn + " matchet med " + liste2[pos].getNavn());
		}
		// Nullstille partner
		String medlemsnavn = medlem.getNavn();
		arkiv.tilbakestillStausIndeks(medlemsnavn);
		
		// Skriver ut parliste
		Tekstgrensesnitt.skrivParListe(arkiv);
	}
}
