class Restaurant{
	Bord bord;
	String navn;
	final int ETABLERINGS�R;

	public Restaurant(Bord bord, String navn, int etablerings�r){
		this.bord = bord;
		this.navn = navn;
		this.ETABLERINGS�R = etablerings�r;
	}

	public String getNavn(){
		return navn;
	}

	public void setNavn(String navn){
		this.navn = navn;
	}

	public int getEtablerings�r(){
		return ETABLERINGS�R;
	}

	public int getAlder(){
		return 2017-ETABLERINGS�R;
	}

	public int reserverBord(String navn, int[] plasser, int antPlass){
		return bord.reserverBord(navn, plasser, antPlass);
	}

	public int[] reservertP�Navn(String navn){
		return bord.reservertNavn(navn);
	}

	public int frigiBord(int bordplass){
		return bord.frigiBord(bordplass);
	}
}