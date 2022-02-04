package no.hvl.dat102.klient;

import javax.swing.JOptionPane;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Tekstgrensesnitt {

	public Film lesFilm() {
		int nr = Integer.parseInt(JOptionPane.showInputDialog("Filmnr?"));
		String produsent = JOptionPane.showInputDialog("Produsent?");
		String tittel = JOptionPane.showInputDialog("Tittel?");
		int lanseringsaar = Integer.parseInt(JOptionPane.showInputDialog("Lanseringsår?"));
		Sjanger sj = Sjanger.finnSjanger(JOptionPane.showInputDialog("Sjanger?"));
		String filmselskap = JOptionPane.showInputDialog("Filmselskap?");
		return new Film(nr, produsent, tittel, lanseringsaar, sj, filmselskap);
	}
	
	public void visFilm(Film film) {
		System.out.println(film.toString() + "\n");
	}
	
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] titler = filma.soekTittel(delstreng);
		for(Film f : titler) {
			System.out.println(f.getTittel() + "\n");
		}
	}
	
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] alle = filma.soekTittel("");
		for(Film f : alle) {
			if(f.getProdusent().equalsIgnoreCase(delstreng) && f != null) {
				System.out.println(f.getTittel() + "\n");
			}
		}
	}
	
	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println("Antall Filmer: " + filma.antall() + "\n");
		for(Sjanger sj : Sjanger.values()) {
			System.out.println("Antall per sjanger" + "+n" + sj + ": " + filma.antall(sj) + "\n");
		}
	
	}
}
