import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;

class Medlemsarkiv{
	private ArrayList<Bonusmedlem> medlemmer = new ArrayList<Bonusmedlem>();

	public Bonusmedlem getMedlem(int plass){
		return medlemmer.get(plass);
	}

	public int finnPlass(int medNr){
		for(int i = 0; i<medlemmer.size(); i++){
			if(medlemmer.get(i).getMedNr() == medNr) return i;
		}
		return -1;
	}

	public int finnPoeng(int medNr, String passord){
		int plass = finnPlass(medNr);
		if(plass != -1){
			if(medlemmer.get(plass).okPassord(passord)) return medlemmer.get(plass).getPoeng();
		}
		return -1;
	}

	public boolean registrerPoeng(int medNr, int poeng){
		int plass = finnPlass(medNr);
		if(plass == -1) return false;
		Bonusmedlem m = medlemmer.get(plass);
		if(m != null){
			m.regPoeng(poeng);
			return true;
		}
		return false;
	}

	private int finnLedigNr(){
		Random r = new Random();
		boolean finnes;
		int nr;
		do{
			finnes = false;
			nr =  r.nextInt(medlemmer.size() + 50);
			for(int i = 0; i<medlemmer.size(); i++){
				if(medlemmer.get(i).getMedNr() == nr) finnes = true;
			}
		}while(finnes);
		return nr;
	}

	public int nyMedlem(Personalia pers, LocalDate innmeldt){
		BasicMedlem basic = new BasicMedlem(finnLedigNr(), pers, innmeldt);
		medlemmer.add(basic);
		return basic.getMedNr();
	}

	public int nyMedlem(Personalia pers, LocalDate innmeldt, int nr){
		BasicMedlem basic = new BasicMedlem(nr, pers, innmeldt);
		medlemmer.add(basic);
		return nr;
	}

	public void sjekkMedlemmer(LocalDate date){
		int antKvalPoeng;
		Bonusmedlem m;
		for(int i = 0; i<medlemmer.size(); i++){
			m = medlemmer.get(i);
			antKvalPoeng = m.finnKvalPoeng(date);
			if(antKvalPoeng >= 75000){
				if(m instanceof GullMedlem) continue;
				else{
					GullMedlem g = new GullMedlem(m.getMedNr(), m.getPers(), m.getInnmeldtDato(), m.getPoeng());
					medlemmer.set(i, g);
				}
			}else if(antKvalPoeng >= 25000 && antKvalPoeng < 75000){
				if(m instanceof SoelvMedlem) continue;
				else{
					SoelvMedlem s = new SoelvMedlem(m.getMedNr(), m.getPers(), m.getInnmeldtDato(), m.getPoeng());
					medlemmer.set(i, s);
				}
			}else{
				if(m instanceof BasicMedlem) continue;
				else{
					BasicMedlem b = new BasicMedlem(m.getMedNr(), m.getPers(), m.getInnmeldtDato());
					medlemmer.set(i, b);
				}
			}
		}
	}

	public String toString(){
		String ut = "Medlemmer \n\n";
		for(int i = 0; i<medlemmer.size(); i++){
			ut += medlemmer.get(i).toString();
		}
		return ut;
	}
}