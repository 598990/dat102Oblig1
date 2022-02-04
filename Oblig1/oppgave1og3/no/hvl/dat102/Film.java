package no.hvl.dat102;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public class Film {
	private int filmnr;
	private String produsent;
	private String tittel;
	private int lanseringsaar;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film() {
		filmnr = -1;
		produsent = null;
		tittel = null;
		lanseringsaar = -1;
		sjanger = null;
		filmselskap = null;
	}
	
	public Film(int filmnr, String produsent, String tittel, int lanseringsaar, Sjanger sjanger, String filmselskap) {
		this.filmnr = filmnr;
		this.tittel = tittel;
		this.produsent = produsent;
		this.lanseringsaar = lanseringsaar;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}
	
	public int getFilmnr() {
		return filmnr;
	}
	
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	
	public String getProdusent() {
		return produsent;
	}
	
	public void setFilmnr(String produsent) {
		this.produsent = produsent;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public int getLanseringsaar() {
		return lanseringsaar;
	}
	
	public void setLanseringsaar(int lanseringsaar) {
		this.lanseringsaar = lanseringsaar;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	public String getFilmselskap() {
		return filmselskap;
	}
	
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this)
			return true;
		
		if(!(o instanceof Film))
			return false;
		
		Film f = (Film) o;
		
		return f.getFilmnr() == filmnr;
	}
	
	@Override
	public int hashCode() {
		Integer temp = filmnr;
		return temp.hashCode();
	}
	
	@Override
	public String toString() {
		return "Filmnr: " + filmnr + "\n" + "Produsent: " + produsent + "\n" + "Tittel: " + tittel + "\n" + "Lanseringsår: " + 
				lanseringsaar + "\n" + "Sjanger: " + sjanger.toString() + "\n" + "Filmselskap: " + filmselskap;
	}
}
