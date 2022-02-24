package no.hvl.dat102.Oppg2;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}

	@Override
	public String toString() {
		// � returnerer hobbynavnet med �<� foran og �>� bak som
		// String (Eksempel: <tegne, male>)
		// Merk: Kan ogs� ha uten parenteser, �<� og �>�, men fors�k med..
		return "<" + hobbyNavn + ">";
	}

	@Override
	public boolean equals(Object hobby2) {
		// eventuelt fylle ut f�rst med "standard" kode
		// som vi ofte har med overkj�ring av
		// equals-metoden generert av Eclipse

		if (this == hobby2) {
			return true;
		}
		if (hobby2 == null) {
			return false;
		}
		if (getClass() != hobby2.getClass()) {
			return false;
		}

		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
}
