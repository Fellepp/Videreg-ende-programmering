/**
 * Created by Fellepp on 18.05.2017.
 */
class GratisMMS extends Abonnement {
    public static final double PRIS_MND = 199;

    public GratisMMS(Kunde betaler, int tlfNr, double rabatt) {
        super(betaler, tlfNr, rabatt);
    }

    @Override
    public double beregnBeløp() {
        double pris = PRIS_MND + beregnPrisGB(0, PRIS_GB) + beregnPrisMMS(ANT_MMS_GRATIS, 0);
        return pris - getRabatt();
    }
}
