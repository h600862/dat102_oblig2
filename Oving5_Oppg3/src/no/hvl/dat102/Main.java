package no.hvl.dat102;

import no.hvl.dat102.Parantessjekker;

public class Main {

	public static void main(String[] args) {
		String s1 = "[test[test{test}test]test]";
		String s2 = "(((())))";
		String s3 = "{test[test(test)test]test}";
		String s4 = "{{{]]]";
		String s5 = "{{{}}}}";
		String s6 = "((()])";
		
		Parantessjekker test = new Parantessjekker();
		
		System.out.println("s1 skal bli true. Resultat = " + test.erBalansert(s1));
		System.out.println("s2 skal bli true. Resultat = " + test.erBalansert(s2));
		System.out.println("s3 skal bli true. Resultat = " + test.erBalansert(s3));
		System.out.println("s4 skal bli false. Resultat = " + test.erBalansert(s4));
		System.out.println("s5 skal bli true. Resultat = " + test.erBalansert(s5));
		System.out.println("s6 skal bli false. Resultat = " + test.erBalansert(s6));
		
	}

}
