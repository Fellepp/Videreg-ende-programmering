/**
 * Created by Fellepp on 18.05.2017.
 */
public class DataPluss extends MerData {
    public static final int GRENSE_DATA = 3;
    public static final double PRIS_MND = 249;

    public DataPluss(Kunde betaler, int tlfNr, double rabatt) {
        super(betaler, tlfNr, rabatt);
    }

    @Override
    public double beregnBeløp() {
        double pris = PRIS_MND + beregnPrisGB(GRENSE_DATA, PRIS_EKSTRA_DATA) + beregnPrisMMS(ANT_MMS_GRATIS, PRIS_MMS);
        return pris - getRabatt();
    }
}
