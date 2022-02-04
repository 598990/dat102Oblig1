package no.hvl.dat102;

public enum Sjanger {
	ACTION, DRAMA, HISTORY, SCIFI, UNKNOWN;
	
	public static Sjanger finnSjanger(String navn) {
		Sjanger sjanger = null;
		for(Sjanger sj : Sjanger.values()) {
			if(sj.toString().equalsIgnoreCase(navn)) {
				sjanger = sj;
				break;
			}
		}
		return sjanger;
	}
}
