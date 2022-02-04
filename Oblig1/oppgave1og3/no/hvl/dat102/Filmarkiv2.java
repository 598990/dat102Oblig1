package no.hvl.dat102;

import no.hvl.dat102.kjedet.LinearNode; //ligger i oppgave4_KoeT
import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT{
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		antall = 0;
		start = new LinearNode<Film>();
	}
	
	//Hjelpemetode for å finne filmer
	private LinearNode<Film> finnFilm(int nr) {
		LinearNode<Film> sokNode = new LinearNode<Film>();
		boolean funnet = false;
		for(int i = 0; i < antall && !funnet; i++) {
			if(sokNode.getElement().getFilmnr() == nr) {
				funnet = true;
				return sokNode;
			}
			else {
				sokNode = sokNode.getNeste();
			}
		}
		return null;
	}
	
	@Override
	public void visFilm(int nr) {
		LinearNode<Film> film = finnFilm(nr);
		if(film != null) {
			System.out.println(film.getElement().toString());
		}
		else {
			System.out.println("Filmen finnes ikke");
		}
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> ny = new LinearNode<Film>(nyFilm);
		ny.setNeste(start);
		antall++;
		start = ny;
	}
	
	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> film = finnFilm(filmnr);
		Film forst = null;
		if(film !=  null) {
			forst = start.getElement();
			film.setElement(forst);
			start = start.getNeste();
			return true;
		}
		return false;
	}
	
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] harTittel = new Film[antall];
		int a = 0;
		LinearNode<Film> sokNode = new LinearNode<Film>();
		for(int i = 0; i < antall; i++) {
			if(sokNode.getElement().getTittel().contains(delstreng)) {
				harTittel[a++] = sokNode.getElement();
			}
			else {
				sokNode = sokNode.getNeste();
			}
		}
		Film[] harTittelTrim = Filmarkiv.trim(harTittel, a);
		return harTittelTrim;
	}
	
	@Override
	public int antall(Sjanger sjanger) {
		int a = 0; 
		LinearNode<Film> sokNode = new LinearNode<Film>();
		for(int i = 0; i < antall; i++) {
			if(sokNode.getElement().getSjanger() == sjanger) {
				a++;
			}
			else {
				sokNode = sokNode.getNeste();
			}
		}
		return a;
	}
	
	@Override
	public int antall() {
		return antall;
	}
	
}
