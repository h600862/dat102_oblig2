package no.hvl.dat102.rekursjon;

public class RekursjonMetode{
	
	
   /** public static int halv() {
	if (maksVenstre >= maksHøgre){
		return maksVenstre;
		} else {
		return maksHøgre;
		}
    }*/
	
	
	public static int fakultet(int n) {
		int svar;
		if (n == 1) { // Basis
		svar = 1;
		}else {
		svar = n * fakultet(n-1); // Rek. kall
		}
		return svar;
		}
	
	public static int sum(int n){
		//Summere de n første positive heltall
		int svar;
		if (n == 1){         // Basistilfelle
		svar = 1; 
		} 
		else{
		svar = n + sum(n-1); // Rek. kall
		}
		return svar;
		}
	
	public static int sum2(int n) {
		if (n == 1) { // Basis
		return 1;
		}else {
		return n + sum2(n - 1);// Rek. kall
		}
		}
	
	
	
	static int maks(int[] tab, int start, int slutt) {
		if (start == slutt) { // berre et element -> basis
		return tab[start];
		} else {
		// Deler opp
		int midten = (start + slutt) / 2;
		// Rekursive kall
		int mV = maks(tab, start, midten);
		int mH = maks(tab, midten + 1, slutt);
		// Setter sammen løsningene
		if (mV >= mH) {
		return mV;
		} else {
		return mH;
		}
		}
}
	static void fibSec(int n) {
		int n1=0,n2=1,n3,i;    
		// System.out.print(n1+" "+n2+" ");//printing 0 and 1    
		    
		 for(i=0;i<n;++i)//loop starts from 2 because 0 and 1 are already printed    
		 {    
		  n3=n1+n2;    
		  System.out.print(" "+n3);    
		  n1=n2;    
		  n2=n3;    
		  
		 }    
	}
	static int n1=0,n2=1,n3=0;    
	 static void printFibonacci(int n){    
	    if(n>0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" "+n3);   
	         printFibonacci(n-1);    
	     }    
	 }
	 static int a1=2,a2=5,a3=0;
	 static void tallfolge(int n){ 
		 
		 int tab[];
		    if(n>0){    
		         a3 = a1 + a2;    
		         a1 = a2;    
		         a2 = a3;    
		      //   tab = tab[a3];
		         System.out.print(" "+a3);   
		         tallfolge(n-1);    
		     }    
	 }
}

