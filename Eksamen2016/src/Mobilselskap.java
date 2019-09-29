/**
 * Created by Fellepp on 18.05.2017.
 */
public class Mobilselskap {
    private java.util.ArrayList<Abonnement> abonnementer = new java.util.ArrayList<Abonnement>();
    private java.util.ArrayList<Kunde> kunder = new java.util.ArrayList<Kunde>();
    private final static double VENNE_RABATT = 30.0;

    public Abonnement regNyAb(Kunde betaler, String abType) {
        double rabatt = 0.0;
        if (kunder.indexOf(betaler) < 0) {
            kunder.add(betaler);
        }else {
            rabatt = sjekkVennerabatt(betaler);
        }
        return lagNyttAbObjekt(betaler, rabatt, finnNyttTlfNr(), abType);
    }

    private double sjekkVennerabatt(Kunde betaler) {
        Abonnement ab = betalerRegistrert(betaler);
        if(ab != null) {
            ab.setRabatt(VENNE_RABATT);
            return VENNE_RABATT;
        }else {
            return 0.0;
        }
    }

    private Abonnement betalerRegistrert(Kunde betaler) {
        for(int i = 0; i<abonnementer.size(); i++) {
            if(abonnementer.get(i).getKunde().equals(betaler)) return abonnementer.get(i);
        }
        return null;
    }

    private Abonnement lagNyttAbObjekt(Kunde betaler, double rabatt, int tlfNr, String abType) {
        Abonnement nyAb = null;
        switch(abType) {
            case "Abonnement":
                nyAb = new Abonnement(betaler, tlfNr, rabatt);
                break;
            case "GratisMMS":
                nyAb = new GratisMMS(betaler, tlfNr, rabatt);
                break;
            case "DataPluss":
                nyAb = new DataPluss(betaler, tlfNr, rabatt);
                break;
            case "DataPlussPluss":
                nyAb = new DataPlussPluss(betaler, tlfNr, rabatt);
                break;
            default:
                return null;
        }
        return nyAb;
    }

    private int finnNyttTlfNr() {
        return 123;
    }

    public Abonnement endreAb(Abonnement ab, String tilType){
        Kunde deltaker = ab.getKunde();
        int tlfNr = ab.getTlfNr();
        double rabatt = ab.getRabatt();
        int pos = abonnementer.indexOf(ab);
        Abonnement nyAb = lagNyttAbObjekt(deltaker, rabatt, tlfNr, tilType);
        abonnementer.set(pos, nyAb);
        return nyAb;
    }
}
