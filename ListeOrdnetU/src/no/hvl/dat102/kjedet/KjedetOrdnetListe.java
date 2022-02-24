package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		// ...Fyll ut
		
		if (!erTom()) {
			resultat = foerste.getElement();
			if (antall == 1) {
				foerste = null;
				siste = null;
			} else {
				foerste = foerste.getNeste();
			}
			antall--;
		}
		return resultat;
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		// ...Fyll ut
		
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && siste.getElement().compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (antall > 0) {
			resultat = siste.getElement();
			if (antall == 1) {
				foerste = null;
				siste = null;
			} else {
				siste = forrige;
				forrige.setNeste(null);
			}
			antall--;
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		// ...Fyll ut
		LinearNode<T> ny = new LinearNode<T>(element);

		// Finn rett posisjon for nytt element
		LinearNode<T> denne = foerste, forrige = null;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}

		// Plasserer ny node mellom forrige og denne
		if (antall == 0) { // Hvis mengden er tom og vi skal sette inn den
							// foerste noden
			foerste = ny;
			siste = ny;
		} else if (forrige == null) { // Setter inn det foerste elementet i
										// mengden, men det er noder i mengden
			foerste = ny;
			ny.setNeste(denne);
		} else { // Generelt tilfelle
			forrige.setNeste(ny);
			ny.setNeste(denne);
		}

		if (denne == null) { // Sjekker om noden vi satt inn er den siste i
								// mengden
			siste = ny;
		}
		antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
