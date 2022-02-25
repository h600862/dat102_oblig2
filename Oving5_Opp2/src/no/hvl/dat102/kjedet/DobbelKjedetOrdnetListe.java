package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.DobbelKjedetOrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public class DobbelKjedetOrdnetListe<T extends Comparable<T>> implements DobbelKjedetOrdnetListeADT<T> {
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
		// Første node
		DobbelNode<T> start= new DobbelNode<T>(minVerdi);
		foerste = start;
		
		// Siste node
		antall = 0;
		DobbelNode<T> slutt = new DobbelNode<T>(maksVerdi);
		
		// Kjeding
		start.setNeste(slutt);
		slutt.setForrige(start);
		siste= slutt;
		
	}

	@Override
	public void leggTil(T el) {
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		DobbelNode<T> aktuell = foerste.getNeste();
		while ((el.compareTo(aktuell.getElement()) > 0)) {
			aktuell = aktuell.getNeste();
		}
		// Legg inn foran aktuell
		DobbelNode<T> neste = aktuell;
		DobbelNode<T> forige = aktuell.getForrige();
		
		nyNode.setForrige(forige);
		nyNode.setNeste(neste);
		forige.setNeste(nyNode);
		neste.setForrige(nyNode);
		
//		nyNode.setNeste(aktuell);
//		nyNode.setForrige(aktuell.getForrige());
//		aktuell.getForrige().setNeste(nyNode);
//		aktuell.setForrige(nyNode);
		antall++;

	}

	@Override
	public T fjern(T el) {
		
	/**	if (erTom())
			throw new EmptyCollectionException("dobbelkjedet ordnet liste er tom");*/
		DobbelNode<T> aktuell = finn(el);
		if (aktuell == null) {// returner og slett
			return null;
		}
		
		aktuell.getForrige().setNeste(aktuell.getNeste());
		aktuell.getNeste().setForrige(aktuell.getForrige());
		antall--;
		return aktuell.getElement();
		//return resultat;

	}
	public boolean fins(T el) {
		return finn(el) != null ? true:false;
	}
	/*
	 * Returnerer referansen til noden hvis el fins, ellers returneres
	 * null-referansen
	 */
	private DobbelNode<T> finn(T el) {
		
		//TODO
		DobbelNode<T> temp = null;
		DobbelNode<T> aktuell = foerste.getNeste();
		
		if(el.compareTo(foerste.getElement()) <= 0 || el.compareTo(siste.getElement()) >= 0) {
			System.out.println("Ugyldig verdi");
		}
		while(el.compareTo(aktuell.getElement()) > 0) {
			aktuell = aktuell.getNeste();
		}
		if(el.compareTo(aktuell.getElement()) == 0) {
			temp = aktuell;
		}return temp;
		
	}
	
	public void visListe(){
		DobbelNode<T> aktuell = foerste;
		while(aktuell != null) {
			aktuell = aktuell.getNeste();
		}
		System.out.println();
		System.out.println(foerste.getElement());
		System.out.println(siste.getElement());
		System.out.println();
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	public String toString() {
		String resultat = "";
		DobbelNode<T> aktuell = foerste.getNeste();
		while (aktuell != siste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}

		return resultat;
	}

	public String tilStrengBaklengs() {
		String resultat = "";
		DobbelNode<T> aktuell = siste.getForrige();
		while (aktuell != foerste) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getForrige();
		}

		return resultat;

	}

}