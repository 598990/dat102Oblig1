package no.hvl.dat102.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Filmarkiv2;
import no.hvl.dat102.adt.FilmarkivADT;

public class KlientFilmArkiv {

	public static void main(String[] args) {
		FilmarkivADT filma = new Filmarkiv(100);
		Meny meny = new Meny(filma);
		meny.start();
		
		FilmarkivADT filma2 = new Filmarkiv2();
		Meny meny2 = new Meny(filma2);
		meny.start();
	}

}
