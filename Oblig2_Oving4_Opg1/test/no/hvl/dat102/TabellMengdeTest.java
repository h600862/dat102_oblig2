package no.hvl.dat102;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.MengdeADT;
import no.hvl.dat102.kjedet.KjedetMengde;
import no.hvl.dat102.tabell.TabellMengde;

class TabellMengdeTest {

	// Referanse til kjedetMengde
	private MengdeADT<Integer> testM = new TabellMengde();
	private MengdeADT<Integer> testM2 = new TabellMengde();


	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	private Integer e5 = 6;
	
	
	public void setupLike() {
		testM.leggTil(e0);
		testM.leggTil(e1);
		testM.leggTil(e2);
		
		testM2.leggTil(e0);
		testM2.leggTil(e1);
		testM2.leggTil(e2);
	}
	
	public void setupDisjunkt() {
		testM.leggTil(e0);
		testM.leggTil(e1);
		testM.leggTil(e2);
		
		testM2.leggTil(e3);
		testM2.leggTil(e4);
		testM2.leggTil(e5);
	}
	
	@Test
	public void unionDisjunkt() {
		setupDisjunkt();
		MengdeADT<Integer> testUnion = new TabellMengde();
		testUnion = testM.union(testM2);
		
		assertEquals(6, testUnion.antall());
		assertEquals(true, testM.undermengde(testUnion));
		assertEquals(true, testM2.undermengde(testUnion));
	}
	
	@Test
	public void unionLik() {
		setupLike();
		MengdeADT<Integer> testUnion = new TabellMengde();
		testUnion = testM.union(testM2);
		
		assertEquals(3, testUnion.antall());
		assertEquals(true, testM.undermengde(testUnion));
		assertEquals(true, testM2.undermengde(testUnion));
	}
	
	@Test
	public void snittDisjunkt() {
		setupDisjunkt();
		MengdeADT<Integer> testSnitt = new TabellMengde();
		testSnitt = testM.snitt(testM2);
		
		assertEquals(false, testSnitt.inneholder(e2));
		assertEquals(0, testSnitt.antall());
	}
	
	@Test
	public void snittLike() {
		setupLike();
		MengdeADT<Integer> testSnitt = new TabellMengde();
		testSnitt = testM.snitt(testM2);
		
		assertEquals(true, testSnitt.inneholder(e2));
		assertEquals(3, testSnitt.antall());
	}
	
	@Test
	public void differensLike() {
		setupLike();
		MengdeADT<Integer> testDiff = new TabellMengde();
		testDiff = testM.differens(testM2);
		
		assertEquals(0, testDiff.antall());
		assertEquals(false, testDiff.inneholder(e2));
	}
	
	@Test
	public void differensDisjunkt() {
		setupDisjunkt();
		MengdeADT<Integer> testDiff = new TabellMengde();
		testDiff = testM.differens(testM2);
		
		assertEquals(6, testDiff.antall());
		assertEquals(true, testDiff.inneholder(e2));
	}
}
