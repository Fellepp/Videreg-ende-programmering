/**
 * Created by johan on 02.03.2017.
 */
/**
 * Klassen Billett med subklasser - 2010-01-18
 * Denne blir delt ut sammen med øvingen
 */
public abstract class Billett {
    private final String tribunenavn;
    private final int pris;

    /**
     * Konstruktør:
     * Tribunenavn må oppgis. Ingen krav til pris.
     */
    public Billett(String tribunenavn, int pris) {
        if (tribunenavn == null || tribunenavn.trim().equals("")) {
            throw new IllegalArgumentException("Tribunenavn må oppgis.");
        }
        this.tribunenavn = tribunenavn.trim();
        this.pris = pris;
    }

    public String getTribune() {
        return tribunenavn;
    }

    public int getPris() {
        return pris;
    }

    public String toString() {
        return "Tribune: "+tribunenavn + " Pris: "+pris;
    }
}

/**
 * Ståplassbilletter.
 */
class StaaplassBillett extends Billett {
    public StaaplassBillett(String tribunenavn, int pris) {
        super(tribunenavn, pris);
    }
}

/**
 * Sitteplassbilletter. Rad og plass på raden må oppgis.
 */
class SitteplassBillett extends Billett {
    private final int rad;
    private final int plass;
    private String navn = null;

    public SitteplassBillett(String tribunenavn, int pris, int rad, int plass) {
        super(tribunenavn, pris);
        if (rad < 0 || plass < 0) {
            throw new IllegalArgumentException("Verken rad eller plass kan være negativ.\n"
                    + "Oppgitte verdier: " + rad + ", " + plass);
        }
        this.rad = rad;
        this.plass = plass;
    }

    public SitteplassBillett(String tribunenavn, int pris, int rad, int plass, String navn) {
        super(tribunenavn, pris);
        if (rad < 0 || plass < 0) {
            throw new IllegalArgumentException("Verken rad eller plass kan være negativ.\n"
                    + "Oppgitte verdier: " + rad + ", " + plass);
        }
        this.rad = rad;
        this.plass = plass;
        this.navn = navn;
    }

    public int getRad() {
        return rad;
    }

    public int getPlass() {
        return plass;
    }

    public String getNavn(){
        return navn;
    }

    public String toString() {
        String res = super.toString();
        res += " Rad: "+ rad + " Plass: " + plass + (navn == null ? "" : " Navn: " + navn); //skriver ut navn hvis navn ikke er null
        return res;
    }
}
