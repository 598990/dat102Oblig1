package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	public void start() {
		Film film = new Film(5,"Bård", "Norsk Historie", 2015, Sjanger.HISTORY, "Nordic");
		
		filmarkiv.leggTilFilm(film);
		filmarkiv.leggTilFilm(new Film(1, "HVL", "Velkommen til Høgskulen", 2012, Sjanger.HISTORY, "HVL"));
		filmarkiv.leggTilFilm(new Film(3, "Marvel", "Avengers: End game", 2019, Sjanger.ACTION, "Marvel"));
		filmarkiv.leggTilFilm(new Film(8, "DC", "Spiderman: New Home", 2021, Sjanger.ACTION, "DC"));
		filmarkiv.leggTilFilm(new Film(14, "Nordic", "Ragnarok", 2012, Sjanger.SCIFI, "Nordic"));
		filmarkiv.leggTilFilm(new Film(12, "Steve", "Drama", 2003, Sjanger.DRAMA, "Drama Studios"));
		filmarkiv.leggTilFilm(new Film(19, "Cole", "The Future", 2014, Sjanger.SCIFI, "Man Like Cole"));
		filmarkiv.leggTilFilm(new Film(20, "Jack", "The Multiverse", 2012, Sjanger.SCIFI, "Facebook"));
		filmarkiv.leggTilFilm(new Film(22, "Jeff", "The Story About Jeff", 2012, Sjanger.HISTORY, "My Name Is Jeff"));
		filmarkiv.leggTilFilm(new Film(0, "Osama Saiden", "Matematikk for dataingeniører, fullt kurs", 2021, Sjanger.DRAMA, "HVL"));
		
		tekstgr.visFilm(film);
		
		Film[] titler;
		titler = filmarkiv.soekTittel("The");
		for(Film f : titler) {
			if(f != null) {
				tekstgr.visFilm(f);
			}
		}
	}
}
