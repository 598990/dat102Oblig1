package no.hvl.dat102.tabell;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.exceptions.EmptyCollectionException;

class TabellSirkulaerKoeTest extends KoeADTTest{

	private KoeADT<Integer> koe;
	
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 1;
	
	@Override
	protected KoeADT<Integer> reset() {
		return new TabellSirkulaerKoe<Integer>();
	}

	@Test
	void testUtvid() {
		koe = new TabellSirkulaerKoe<Integer>(3);
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		
		try {
			koe.innKoe(e3);
		}catch(IndexOutOfBoundsException e) {
			fail("Uventet feil " + e.getMessage());
		}
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		}catch(EmptyCollectionException e) {
			fail("Uventet feil: " + e.getMessage());
		}
	}
	
}
