class Restaurant{
	Bord bord;
	String navn;
	final int ETABLERINGSÅR;

	public Restaurant(Bord bord, String navn, int etableringsår){
		this.bord = bord;
		this.navn = navn;
		this.ETABLERINGSÅR = etableringsår;
	}

	public String getNavn(){
		return navn;
	}

	public void setNavn(String navn){
		this.navn = navn;
	}

	public int getEtableringsår(){
		return ETABLERINGSÅR;
	}

	public int getAlder(){
		return 2017-ETABLERINGSÅR;
	}

	public int reserverBord(String navn, int[] plasser, int antPlass){
		return bord.reserverBord(navn, plasser, antPlass);
	}

	public int[] reservertPåNavn(String navn){
		return bord.reservertNavn(navn);
	}

	public int frigiBord(int bordplass){
		return bord.frigiBord(bordplass);
	}
}