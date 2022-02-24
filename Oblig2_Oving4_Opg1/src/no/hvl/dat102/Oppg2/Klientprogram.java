package no.hvl.dat102.Oppg2;

import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.tabell.TabellMengde;

public class Klientprogram {
public static void main(String[] args) {
		
		MengdeADT<Hobby> male = new TabellMengde<Hobby>() ;
		MengdeADT<Hobby> danse = new TabellMengde<Hobby>();
		MengdeADT<Hobby> sprint = new TabellMengde<Hobby>();
		MengdeADT<Hobby> spille = new TabellMengde<Hobby>();
		
		Medlem b1 = new Medlem("Trygve Jenssen", male);
		Medlem b2 = new Medlem("Trygve Jenssen", danse);
		Medlem b3 = new Medlem("Trygve Jenssen", sprint);
		Medlem b4 = new Medlem("Trygve Jenssen", spille);
		
		b1.setHobbyer(spille);
		b1.setHobbyer(danse);
		b1.setHobbyer(sprint);
		b2.setHobbyer(spille);
		b2.setHobbyer(male);
		b3.setHobbyer(male);
		b3.setHobbyer(spille);
		
		b1.toString();
		b2.toString();
		b3.toString();
		b4.toString();

	}
}
