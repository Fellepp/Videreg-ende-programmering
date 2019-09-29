class Bord{
	String[] navn;
	int antBord;
	final static int FEIL_NAVN = -1;
	final static int IKKE_NOK_BORD = -2;
	final static int BORD_FINNES_IKKE = -3;
	final static int OPPTATT = -4;
	final static int REGISTRERT = 1;
	int antLedige;
	int antOpptatt;

	public Bord(int antBord){
		navn = new String[antBord];
		this.antBord = antBord;
		antLedige = antBord;
		antOpptatt = antBord-antLedige;
	}

	public int getAntBord(){
		return antBord;
	}

	public int reserverBord(String resNavn, int[] plasser, int antPlass){
		if(resNavn.equals(null)) return FEIL_NAVN;
		if(antPlass>antLedige) return IKKE_NOK_BORD;
		for(int i = 0; i<antPlass; i++){
			if(plasser[i]>antBord && plasser[i]<0) return BORD_FINNES_IKKE;
		}
		for(int i = 0; i<antPlass; i++){
			int plass = plasser[i];
			if(ledig(plass)){
				navn[plass] = resNavn;
			}
			else return OPPTATT;
		}
		antLedige -= antPlass;
		antOpptatt += antPlass;
		return REGISTRERT;
	}

	public boolean ledig(int plass){
		if(navn[plass] == null) return true;
		return false;
	}

	public int getAntLedige(){
		return antLedige;
	}

	public int getAntOpptatt(){
		return antOpptatt;
	}

	public int[] reservertNavn(String sjekkNavn){
		int antPlass = 0;
		for(int i = 0; i<getAntBord(); i++){
			if(navn[i] == null) continue;
			if(navn[i].equals(sjekkNavn)) antPlass++;
		}
		int[] reserverteBord = new int[antPlass];
		int bordPlass = 0;
		for(int i = 0; i<getAntBord(); i++){
			if(navn[i] == null) continue;
			if(navn[i].equals(sjekkNavn)){
				reserverteBord[bordPlass] = i;
				bordPlass++;
			}
		}
		return reserverteBord;
	}

	public int frigiBord(int bord){
		if(navn[bord] != null){
			navn[bord] = null;
			antOpptatt--;
			antLedige++;
			return 1;
		}
		return -1;
	}

	public String toString(){
		String ut = "";
		for(int i = 0; i<antBord; i++){
			if(navn[i] == null) ut += "Bord nr. " + i + " er ledig.\n";
			else ut += "Bord nr. " + i + " er reservert av " + navn[i] + ".\n";
		}
		return ut;
	}
}