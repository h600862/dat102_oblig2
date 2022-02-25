package no.hvl.dat102.Oppg2;

import java.util.Scanner;

import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.kjedet.KjedetMengde;
import no.hvl.dat102.tabell.TabellMengde;

public class Klientprogram {
	
public static void main(String[] args) {
	Medlem medlem1 = new Medlem("Harald Nilsen");
	Medlem trygve = new Medlem("Trygve Jenssen");
	Medlem allan = new Medlem("Allan Saint Maximin");
	Medlem medlem2 = Tekstgrensesnitt.lesMedlem();
	
	Hobby fotball = new Hobby("Fotball");
	Hobby klatring = new Hobby("Klatring");
	Hobby lesing = new Hobby("Lesing");
	
	// ----------
	
	medlem1.setNyHobby(fotball);
	medlem1.setNyHobby(klatring);
	medlem1.setNyHobby(lesing);
	
	trygve.setNyHobby(fotball);
	
	allan.setNyHobby(fotball);
	allan.setNyHobby(lesing);
	
	Datakontakt medlemsliste = new Datakontakt();
	medlemsliste.leggTilMedlem(medlem1);
	medlemsliste.leggTilMedlem(trygve);
	medlemsliste.leggTilMedlem(allan);
	medlemsliste.leggTilMedlem(medlem2);
	
	Tekstgrensesnitt.skrivHobbyListe(medlem1);
	Tekstgrensesnitt.skrivHobbyListe(medlem2);
	
	medlemsliste.finnPartnerFor(medlem2.getNavn());
	Tekstgrensesnitt.skrivParListe(medlemsliste);
	
	
	}
}
