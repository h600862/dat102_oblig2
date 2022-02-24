package no.hvl.dat102.rekursjon;

import java.util.Scanner;

public class Main {
	private static RekursjonMetode metode;

	public static void main(String[] args) {
		
//		int[] tab = { 11, 8, 4, 10, 2, 5, 7, 0, 61 };
//		int maksVerdi = metode.maks(tab, 0, tab.length - 1);
//		System.out.println(maksVerdi);
//		
		//********************************************************
	
		/**System.out.print("Oppgi et positivt heltall: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		System.out.println(n + "! = " + RekursjonMetode.fakultet(n));
		System.out.println(n + "! = " + RekursjonMetode.fakultet(n));
		System.out.println("Summen av " + n + " er " +   RekursjonMetode.sum(n));
		System.out.println("Summen av " + n + " er " +   RekursjonMetode.sum2(n)); */
		
		
		System.out.println("Oppgave 4 a)");
		//  Oppgave 4 a) Sn = Sn-1 + n, S1 = 1
		int resultat = RekursjonMetode.fakultet(100);
		System.out.println(100 + "!=" +resultat);
		System.out.println("Summen av n=100 er "+RekursjonMetode.sum(100));
		
		//  Oppgave 4 b) an = 5an-1 - 6an-2 + 2 for n > 1 og startkrav a0 = 2, a1 = 5
		
		System.out.println("Oppgave 4 b)");
		int i = 10;
		RekursjonMetode.tallfolge(i-2);//n-2 because 2 numbers are already printed
		System.out.println();
		
		
		//  Oppgave 4 c) fibrekursjon
		System.out.println("Oppgave 4 c)");
		int count=10;    
		int n1=0,n2=1,n3=0;
		System.out.print(n1+" "+n2);//printing 0 and 1    
		RekursjonMetode.printFibonacci(count-2);//n-2 because 2 numbers are already printed
		System.out.println();
		//  Oppgave 4 d)  FibSec
		System.out.println("Oppgave 4 d)");
		
		int sec = 10;
		System.out.print(n1+" "+n2);  
		RekursjonMetode.fibSec(sec-2);//n-2 because 2 numbers are already printed
		System.out.println();
	}
}
