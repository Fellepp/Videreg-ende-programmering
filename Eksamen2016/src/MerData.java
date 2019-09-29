/**
 * Created by Fellepp on 18.05.2017.
 */
abstract class MerData extends Abonnement {
    public static final double PRIS_EKSTRA_DATA = 29;

    public MerData(Kunde betaler, int tlfNr, double rabatt) {
        super(betaler, tlfNr, rabatt);
    }
}
