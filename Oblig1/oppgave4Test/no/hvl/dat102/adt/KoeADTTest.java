package no.hvl.dat102.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.adt.KoeADT;

public abstract class KoeADTTest {
	private KoeADT<Integer> koe;
	
	private Integer e0 = 3;
	private Integer e1 = 1;
	private Integer e2 = 4;
	private Integer e3 = 5;
	private Integer e4 = 2;
	
	protected abstract KoeADT<Integer> reset();

	@BeforeEach
	void setup() {
		koe = reset();
	}
	
	@Test
	void nyKoeErTom() {
		assertTrue(koe.erTom());
	}
	
	@Test
	void testInnUt() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
			assertEquals(e4, koe.utKoe());
		}
		catch (EmptyCollectionException e) {
			fail("Test feilet" + e.getMessage());
		}
	}
	
	@Test
	void nyErTom() {
		assertTrue(koe.erTom());
	}

	@Test
	void leggTilIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}
	
	@Test
	void innUtTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.utKoe();
		koe.utKoe();
		assertTrue(koe.erTom());
	}
}
