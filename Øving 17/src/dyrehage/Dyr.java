package dyrehage;

/**
 * Created by johan on 15.03.2017.
 */
abstract class Dyr {
    private final String norskNavn; // "vanlig" navn på dyret
    private final String latNavn;  // latinsk artsnavn
    private final String latFamilie;  // artsfamilie
    private final String ankommetDato;  // dato ankommet dyrehagen
    private String adresse; // innhegning, bur, akvarium el.l. (unikt innad i dyrehagen)

    /* Enkel konstruktør, ingen datakontroll */
    public Dyr(String norskNavn, String latNavn, String latFamilie,
               String ankommetDato, String adresse) {
        this.norskNavn = norskNavn;
        this.latNavn = latNavn;
        this.latFamilie = latFamilie;
        this.ankommetDato = ankommetDato;
        this.adresse = adresse;
    }

    public String getNorskNavn(){
        return norskNavn;
    }

    public String getLatNavn() {
        return latNavn;
    }

    public String getLatFamilie() {
        return latFamilie;
    }

    public String getAnkommetDato() {
        return ankommetDato;
    }

    public String getAdresse(){
        return adresse;
    }

    public void setAdresse(String nyAdresse){
        adresse = nyAdresse;
    }

    public String toString() {
        return "Norsk navn: " + norskNavn + "\nLatinsk navn og familie: " + latNavn
                + ", " + latFamilie + "\nAdresse: "+adresse + "\n";
    }
}
