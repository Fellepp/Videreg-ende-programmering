import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Bonusmedlem{
	private final int medNr;
	private final Personalia pers;
	private final LocalDate innmeldtDato;
	private int poeng = 0;

	public Bonusmedlem(int medNr, Personalia pers, LocalDate innmeldtDato, int poeng){
		this.medNr = medNr;
		this.pers = pers;
		this.innmeldtDato = innmeldtDato;
		this.poeng = poeng;
	}

	public Bonusmedlem(int medNr, Personalia pers, LocalDate innmeldtDato){
		this.medNr = medNr;
		this.pers = pers;
		this.innmeldtDato = innmeldtDato;
	}

	public int getMedNr(){
		return medNr;
	}

	public Personalia getPers(){
		return pers;
	}

	public LocalDate getInnmeldtDato(){
		return innmeldtDato;
	}

	public int getPoeng(){
		return poeng;
	}

	public int finnKvalPoeng(LocalDate date){
		int dagerMellom = (int)DAYS.between(innmeldtDato, date);
		if(dagerMellom < 365) return poeng;
		else return 0;
	}

	public void setPoeng(int poeng){
		this.poeng = poeng;
	}

	public boolean okPassord(String passord){
		return pers.okPassord(passord);
	}

	public void regPoeng(int poeng){
		setPoeng(this.getPoeng() + poeng);
	}


	public String toString(){
		return "Medlemsnummer: " + medNr + ", " + pers.toString() + ", dato innmeldt: " + innmeldtDato + ", Medlemstype: " + getClass().toString() + ", Poeng: " + getPoeng() +  "\n";
	}
}


