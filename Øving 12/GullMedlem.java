import java.time.LocalDate;
import java.time.Period;

class GullMedlem extends Bonusmedlem {
	private final double bonus = 1.5;

	public GullMedlem(int medNr, Personalia pers, LocalDate innmeldtDato, int poeng){
		super(medNr, pers, innmeldtDato, poeng);
	}

	@Override
	public void regPoeng(int poeng){
		super.regPoeng((int)(poeng * bonus));
	}
}