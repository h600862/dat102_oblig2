package no.hvl.dat102;

import no.hvl.dat102.adt.ParantessjekkerADT;
import no.hvl.dat102.kjedet.KjedetStabel;

public class Parantessjekker implements ParantessjekkerADT {

	char[] vpar = {'{','[','('};
	char[] hpar = {'}',']',')'};

	@Override
	public boolean erVenstreparentes(char p) {
		return p == vpar[0] || p == vpar[1] || p == vpar[2];
	}

	@Override
	public boolean erHogreparentes(char p) {
		return p == hpar[0] || p == hpar[1] || p == hpar[2];
	}

	@Override
	public boolean erParentes(char p) {
		boolean resultat = false;
		if (erVenstreparentes(p) || erHogreparentes(p)) {
			resultat = true;
		}
		return resultat;
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		boolean resultat = false;
		
		if (venstre == '{' && hogre == '}') {
			resultat = true;
		} else if (venstre == '(' && hogre == ')') {
			resultat = true;
		} else if (venstre == '[' && hogre == ']') {
			resultat = true;
		} else {
			resultat = false;
		}
		
		return resultat;
	}

	@Override
	public boolean erBalansert(String s) {
		boolean resultat = true;
		KjedetStabel<Character> parenteser = new KjedetStabel();
		
		// looper gjennom hver char i string
		for (int i = 0; i < s.length(); i++) {
			
			// variabel for char på s[i]
			char elem = s.charAt(i);
			
			// hvis elem == parentes
			if (erParentes(elem)) {
				
				// legger til i stabel, hvis åpen parentes
				if (erVenstreparentes(elem)) {
					parenteser.push(elem);
				} else {
					char sisteAapne;
					// sjekker om det er flere elementer igjen i stabel
					// 		-> returner false hvis ikke 
					try {
						sisteAapne = parenteser.pop();
					} catch (Exception e) {
						return false;
					}
					
					// sjekker lukke-parentes med siste åpne
					if (!erPar(sisteAapne, elem)) {
						return false;
					}
				}
			}
		}
		
		return resultat;
		
	}

}
