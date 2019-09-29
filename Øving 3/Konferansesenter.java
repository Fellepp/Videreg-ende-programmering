import java.util.ArrayList;

class Konferansesenter{
	private ArrayList<Rom> romobjekter = new ArrayList<Rom>();

	public int reserverRom(Tidspunkt fraTid, Tidspunkt tilTid, int antPersoner, Kunde kunde){
		if(antPersoner <= 0) return -1;
		if(fraTid.compareTo(tilTid) != -1 || fraTid.getTidspunkt() < 0 || tilTid.getTidspunkt() < 0) return -2;
		Reservasjon reservasjon = new Reservasjon(fraTid, tilTid, kunde);
		for(int i = 0; i<romobjekter.size(); i++){
			if(antPersoner <= romobjekter.get(i).getStørrelse() && romobjekter.get(i).registrerReservasjon(reservasjon) == 1) return romobjekter.get(i).getRomnr();
		}
		return -3;
	}

	public int registrerRom(int størrelse, int romnr){
		if(størrelse <= 0) return -1;
		if(romnr <= 0) return -2;
		for(int i = 0; i<romobjekter.size(); i++){
			if(romobjekter.get(i).getRomnr() == romnr) return -3;
		}
		romobjekter.add(new Rom(størrelse, romnr));
		return 1;
	}

	public int getAntRom(){
		return romobjekter.size();
	}

	public Rom getRomIndeks(int indeks){
		if(indeks >= 0 && indeks<=romobjekter.size()-1){
			return romobjekter.get(indeks);
		}
		return null;
	}

	public Rom getRomNr(int romnr){
		if(romnr > 0){
			for(int i = 0; i<romobjekter.size(); i++){
				if(romobjekter.get(i).getRomnr() == romnr) return romobjekter.get(i);
			}
		}
		return null;
	}

	public int finnAntRom(){
		return romobjekter.size();
	}

	public String toString(){
		String ut = "Oversikt over rom\n";
		for(int i = 0; i<romobjekter.size(); i++){
			ut += romobjekter.get(i).toString();
		}
		return ut;
	}

	public String toString(){
		String ut = "Medlemmer \n\n";
		for(int i = 0; i<medlemmer.size(); i++){
			ut += medlemmer.get(i).toString();
		}
		return ut;
	}
}