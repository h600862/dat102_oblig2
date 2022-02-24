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
		return erVenstreparentes(p) || erHogreparentes(p);
	}

	@Override
	public boolean erPar(char venstre, char hogre) {

		int index = 0;

		for (int i = 0; i < vpar.length-1; i++) {
			if (vpar[i] == venstre) {
				index = i;
			}
		}

		return hpar[index] == hogre;
	}

	@Override
	public boolean erBalansert(String s) {
		boolean resultat = true;

		KjedetStabel<Character> parenteser = new KjedetStabel();
		KjedetStabel<Character> hogreparenteser = new KjedetStabel();

		for (int i = 0; i <= s.length() - 1; i++) {
			char elem = s.charAt(i);
			if (erParentes(elem)) {
				parenteser.push(elem);
			}
		}
		
		while (erHogreparentes(parenteser.peek())) {
			char elem = parenteser.pop();
			hogreparenteser.push(elem);
		}

		while (!parenteser.erTom() && !hogreparenteser.erTom()) {
			char venstre;
			char hogre;

			venstre = parenteser.pop();
			hogre = hogreparenteser.pop();
			
			if (!erPar(venstre,hogre)) {
				return false;
			}
		}
			
		return resultat;
	}

}
