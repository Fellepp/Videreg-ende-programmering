/**
 * Created by Fellepp on 18.05.2017.
 */
public class Abonnement {
    public static final double MÅNEDSPRIS = 99;
    public static final int ANT_MMS_GRATIS = 100;
    public static final double PRIS_MMS = 2;
    public static final double PRIS_GB = 79;
    private final Kunde betaler;
    private double rabatt = 0.0;
    private final int tlfNr;
    private double taletid = 0.0;
    private int antSMS = 0;
    private int antMMS = 0;
    private double antGB = 0.0;

    public Abonnement(Kunde betaler, int tlfNr, double rabatt) {
        this.betaler = betaler;
        this.tlfNr = tlfNr;
        this.rabatt = rabatt;
    }

    public int getAntMMS() {
        return antMMS;
    }

    public double getRabatt() {
        return rabatt;
    }

    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }

    public Kunde getKunde() {
        return betaler;
    }

    public int getTlfNr() {
        return tlfNr;
    }

    protected double beregnPrisMMS(int grense, double prisMMS) {
        /*if((antMMS - grense) > 0) return (antMMS-grense)*prisMMS;
        return 0.0;*/
        return ((antMMS-grense) > 0 ? (antMMS-grense)*prisMMS : 0.0);
    }

    protected double beregnPrisGB(int grense, double prisGB) {
        return ((antGB - grense) > 0 ? (antGB-grense)*prisGB : 0.0);
    }

    public double beregnBeløp() {
        double pris = MÅNEDSPRIS + beregnPrisGB(0, PRIS_GB) + beregnPrisMMS(ANT_MMS_GRATIS, PRIS_MMS);
        return pris - getRabatt();
    }
}
