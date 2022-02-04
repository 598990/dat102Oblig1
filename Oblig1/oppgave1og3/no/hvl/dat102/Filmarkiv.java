package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] arkiv;
	private int a;
	
	public Filmarkiv(int n) {
		arkiv = new Film[n];
		a = 0;
	}
	
	@Override
	public void visFilm(int nr) {
		for(int i = 0; i < a; i++) {
			if(arkiv[i].getFilmnr() == nr) {
				System.out.println(arkiv[i].toString());
			}
		}
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(a == arkiv.length)
			utvid();
		
		arkiv[a] = nyFilm;
		a++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		Film[] temp = new Film[arkiv.length];
		int nyAntall = 0;
		for(int i = 0; i < a; i++) {
			if(filmnr != arkiv[i].getFilmnr()) {
				temp[nyAntall] = arkiv[i];
				nyAntall++;
			}
		}
		arkiv = temp;
		if(nyAntall == a) {
			return false;
		}
		a--;
		return true;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] filmer = new Film[a];
		int n = 0;
		for(int i = 0; i < a; i++) {
			if(arkiv[i].getTittel().contains(delstreng)) {
				filmer[n] = arkiv[i];
				n++;
			}
		}
		return trim(filmer, n);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int a = 0;
		for(int i = 0; i < a; i++) {
			if(arkiv[i].getSjanger() == sjanger) {
				a++;
			}
		}
		return a;
	}

	@Override
	public int antall() {
		return a;
	}

	private void utvid() {
		Film[] n = new Film[arkiv.length*2];
		for(int i = 0; i < a; i++) {
			n[i] = arkiv[i];
		}
		arkiv = n;
	}
	
	public static Film[] trim(Film[] f, int n) {
		Film[] temp = new Film[n];
		for(int i = 0; i < n; i++) {
			temp[i] = f[i];
		}
		return temp;
	}
}
