package dyrehage;

/**
 * Created by johan on 15.03.2017.
 */
abstract class Dyregruppe extends Dyr {
    private final String gruppenavn;
    private int antIndivider;

    public Dyregruppe(String norskNavn, String latNavn, String latFamilie, String ankommetDato, String adresse, String gruppenavn){
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gruppenavn = gruppenavn;
    }

    public String getGruppenavn() {
        return gruppenavn;
    }

    public void setAntIndivider(int antIndivider) {
        this.antIndivider = antIndivider;
    }

    @Override
    public final String getNorskNavn(){
        return "Gruppe av: " + super.getNorskNavn();
    }

    public int getAntIndivider() {
        return antIndivider;
    }

    @Override
    public String toString(){
        String ut = "Gruppenavn: " + gruppenavn + ", antall individer: " + antIndivider + "\n";
        return super.toString() + ut;
    }
}
