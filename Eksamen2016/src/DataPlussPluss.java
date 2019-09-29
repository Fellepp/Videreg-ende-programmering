/**
 * Created by Fellepp on 18.05.2017.
 */
public class DataPlussPluss extends MerData{
    public static final int GRENSE_DATA = 10;
    public static final double PRIS_MND = 379;

    public DataPlussPluss(Kunde betaler, int tlfNr, double rabatt) {
        super(betaler, tlfNr, rabatt);
    }

    @Override
    public double beregnBeløp() {
        double pris = PRIS_MND + beregnPrisGB(GRENSE_DATA, PRIS_EKSTRA_DATA) + beregnPrisMMS(ANT_MMS_GRATIS, PRIS_MMS);
        return pris - getRabatt();
    }
}
