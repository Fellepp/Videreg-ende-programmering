class OppgaveOversikt{
	private Student[] studenter = new Student[5];
	private int antStud = 0;

	public boolean regNyStudent(String navn){
		if(navn == null) return false;
		for(int i = 0; i<studenter.length; i++){
			if(studenter[i] == null) continue;
			if(studenter[i].getNavn().toUpperCase().equals(navn.trim().toUpperCase())) return false;
		}
		if(antStud >= studenter.length){
			Student[] nyTab = new Student[studenter.length + 5];
			for(int i = 0; i<antStud; i++){
				nyTab[i] = studenter[i];
			}
			studenter = nyTab;
		}
		Student s = new Student(navn);
		studenter[antStud] = s;
		antStud++;
		return true;
	}

	public int finnAntStud(){
		return antStud;
	}

	public int finnAntOppgaver(String navn){
		if(navn == null) return -1;
		for(int i = 0; i<studenter.length; i++){
			if(studenter[i] == null) continue;
			if(studenter[i].getNavn().toUpperCase().equals(navn.trim().toUpperCase())) return studenter[i].getAntOppg();
		}
		return -1;
	}

	public boolean økAntOppg(String navn, int økning){
		if(navn == null) return false;
		for(int i = 0; i<studenter.length; i++){
			if(studenter[i] == null) continue;
			if(studenter[i].getNavn().toUpperCase().equals(navn.trim().toUpperCase())){
				studenter[i].setAntOppg(studenter[i].getAntOppg() + økning);
				return true;
			}
		}
		return false;
	}

	public String[] finnAlleNavn(){
		int plass = 0;
		String[] studentNavn = new String[antStud];
		for(int i = 0; i<studenter.length; i++){
			if(studenter[i] == null) continue;
			studentNavn[plass] = studenter[i].getNavn();
			plass++;
		}
		return studentNavn;
	}

	public String toString(){
		String ut = "";
		for(int i = 0; i<studenter.length; i++){
			if(studenter[i] == null) continue;
			ut += studenter[i].toString();
		}
		return ut;
	}
}