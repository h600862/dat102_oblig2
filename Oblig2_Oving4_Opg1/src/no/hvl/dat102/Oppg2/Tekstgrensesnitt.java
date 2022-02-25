package no.hvl.dat102.Oppg2;

import java.util.Scanner;

import no.hvl.dat102.kjedet.KjedetMengde;

public class Tekstgrensesnitt {
	public static Medlem lesMedlem() {

		Scanner inskriv = new Scanner(System.in);

		System.out.println("Skriv inn navn: ");
		String navn = inskriv.nextLine();

		System.out.println("Skriv inn hobbyer avskilt med mellomrom: ");
		String hobbyInn = inskriv.nextLine();
		// MengdeADT<Hobby> hobbyer= getHobbyNavn(hobbyInn);
		String[] hobbyListe = hobbyInn.split(" ");
		KjedetMengde<Hobby> mengde = new KjedetMengde<>();
		
		for(String s : hobbyListe) {
			mengde.leggTil(new Hobby(s));
		}
		
		return new Medlem(navn, mengde);

	//	System.out.println("Skriv inn statusindeks: ");
	//	int statusIndeks = Integer.parseInt(inskriv.nextLine());

	//	Medlem medlem = new Medlem();
	//	return medlem;

		// f.eks. bruke Scanner.
	}
	// Skriver ut hobbylisten for et medlem

	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		Medlem[] listen = arkiv.getMedlemstabell();
		int antallPar = 0;
		
		System.out.format("%-20s %s%n", "PARNAVN", "HOBBYER");
		for(int i = 0; i < arkiv.getAntall(); i++) {
			if(listen[i].getStatusIndeks() != -1 && listen[i].getStatusIndeks() > i) {
				int partnerIndex = listen[i].getStatusIndeks();
				System.out.format("%-20s", listen[i].getNavn() + " og " + listen[partnerIndex].getNavn());
				System.out.format(" %s%n", "<" + listen[i].getHobbyer().toString() + ">");
				antallPar++;
			}
		}
		System.out.println("Antall par funnet: " + antallPar);
	}

	
	}

