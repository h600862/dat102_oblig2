package no.hvl.dat102;

import no.hvl.dat102.Parantessjekker;

public class Main {

	public static void main(String[] args) {
		String s1 = "{{{(test)}}()[]{}}";
		String s2 = "(((())))";
		String s3 = "{test[test(test)test]test}";
		String s4 = "{{{]]]";
		String s5 = "{{{}}}}";
		String s6 = "((()])";
		
		Parantessjekker test = new Parantessjekker();
		
		System.out.println("s1:" + s1 + ".    true = " + test.erBalansert(s1));
		System.out.println("\ns2:" + s2 + ".    true = " + test.erBalansert(s2));
		System.out.println("\ns3:" + s3 + ".    true = " + test.erBalansert(s3));
		System.out.println("\ns4:" + s4 + ".    false = " + test.erBalansert(s4));
		System.out.println("\ns5:" + s5 + ".    false = " + test.erBalansert(s5));
		System.out.println("\ns6:" + s6 + ".    false = " + test.erBalansert(s6));
		
	}

}
