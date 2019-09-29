class Student{
	private final String navn;
	private int antOppg;

	public Student(String navn){
		this.navn = navn.trim();
	}

	public String getNavn(){
		return navn;
	}

	public int getAntOppg(){
		return antOppg;
	}

	public void setAntOppg(int antOppg){
		if(antOppg<0) throw new IllegalArgumentException("Ugyldig verdi");
		this.antOppg = antOppg;
	}

	public String toString(){
		return "Navn: " + navn + ", antall oppgaver løst: " + antOppg + ".\n";
	}
}