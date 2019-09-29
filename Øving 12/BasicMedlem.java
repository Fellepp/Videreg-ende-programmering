import java.time.LocalDate;
import java.time.Period;

class BasicMedlem extends Bonusmedlem {

	public BasicMedlem(int medNr, Personalia pers, LocalDate innmeldtDato){
		super(medNr, pers, innmeldtDato);
	}

	@Override
	public void regPoeng(int poeng){
		//super.regPoeng(poeng);
		this.setPoeng(this.getPoeng() + poeng);
	}
}