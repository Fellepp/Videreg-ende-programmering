import java.util.ArrayList;

class OppgaveOversikt{
	private ArrayList<Student> studenter = new ArrayList<Student>();

	public boolean regNyStudent(String navn){
		if(navn == null) return false;
		for(int i = 0; i<studenter.size(); i++){
			if(studenter.get(i).getNavn().toUpperCase().equals(navn.trim().toUpperCase())) return false;
		}
		Student s = new Student(navn);
		studenter.add(s);
		return true;
	}

	public int finnAntStud(){
		return studenter.size();
	}

	public int finnAntOppgaver(String navn){
		if(navn == null) return -1;
		for(int i = 0; i<studenter.size(); i++){
			if(studenter.get(i).getNavn().toUpperCase().equals(navn.trim().toUpperCase())) return studenter.get(i).getAntOppg();
		}
		return -1;
	}

	public boolean økAntOppg(String navn, int økning){
		if(navn == null) return false;
		for(int i = 0; i<studenter.size(); i++){
			if(studenter.get(i).getNavn().toUpperCase().equals(navn.trim().toUpperCase())){
				studenter.get(i).setAntOppg(studenter.get(i).getAntOppg() + økning);
				return true;
			}
		}
		return false;
	}

	public String[] finnAlleNavn(){
		int plass = 0;
		String[] studentNavn = new String[studenter.size()];
		for(int i = 0; i<studenter.size(); i++){
			studentNavn[plass] = studenter.get(i).getNavn();
			plass++;
		}
		return studentNavn;
	}

	public String toString(){
		String ut = "";
		for(int i = 0; i<studenter.size(); i++){
			ut += studenter.get(i).toString();
		}
		return ut;
	}
}