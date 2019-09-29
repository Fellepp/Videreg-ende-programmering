import java.time.LocalDate;
import java.time.Period;

class SoelvMedlem extends Bonusmedlem {
	private final double bonus = 1.2;

	public SoelvMedlem(int medNr, Personalia pers, LocalDate innmeldtDato, int poeng){
		super(medNr, pers, innmeldtDato, poeng);
	}

	@Override
	public void regPoeng(int poeng){
		super.regPoeng((int)(poeng * bonus));
	}
}
