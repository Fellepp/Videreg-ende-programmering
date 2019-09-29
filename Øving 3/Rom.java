import java.util.ArrayList;

class Rom{
	private ArrayList<Reservasjon> reservasjonsobjekter = new ArrayList<Reservasjon>();
	private int størrelse;
	private int romnr;

	public Rom(int størrelse, int romnr){
		this.størrelse = størrelse;
		this.romnr = romnr;
	}

	public int registrerReservasjon(Reservasjon reservasjon){
		if(reservasjon == null) return -1;
		for(int i = 0; i<reservasjonsobjekter.size(); i++){
			if(reservasjon.overlapp(reservasjonsobjekter.get(i).getFraTid(), reservasjonsobjekter.get(i).getTilTid())) return -2;
		}
		reservasjonsobjekter.add(reservasjon);
		return 1;
	}

	public int getStørrelse(){
		return størrelse;
	}

	public int getRomnr(){
		return romnr;
	}


	public String toString(){
		String ut = "Romnr: " + romnr + ", romstørrelse: " + størrelse + "\nReservasjoner: \n";
		for(int i = 0; i<reservasjonsobjekter.size(); i++){
			ut += reservasjonsobjekter.get(i).toString() + "\n";
		}
		return ut;
	}
	//Tester klassen Rom
	public static void main(String[]args){
		System.out.println("Totalt antall tester: 3");
		Rom r1 = new Rom(5,1);
		Rom r2 = new Rom(3,2);
		if(r1.registrerReservasjon(new Reservasjon(new Tidspunkt(201701201400L), new Tidspunkt(201701201500L), new Kunde("Filip", "93889729"))) == 1){
			System.out.println("Rom: Test 1 vellykket.");
		}
		if (r1.getStørrelse() == 5 && r1.getRomnr() == 1 && r2.getStørrelse() == 3 && r2.getRomnr() == 2){
			System.out.println("Rom: Test 2 vellykket.");
		}
		if(r1.toString().equals("Romnr: 1, romstørrelse: 5") && r2.toString().equals("Romnr: 2, romstørrelse: 3")){
			System.out.println("Rom: Test 3 vellykket.");
		}
	}
}