package dyrehage;

/**
 * Created by johan on 15.03.2017.
 */
public class Fugleflokk extends Dyregruppe{
    private final double gjennomsnittligVekt;
    private final boolean svømmer;

    public Fugleflokk(String norskNavn, String latNavn, String latFamilie, String ankommetDato, String adresse, String gruppenavn, double gjennomsnittligVekt, boolean svømmer) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, gruppenavn);
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svømmer = svømmer;
    }

    public double getGjennomsnittligVekt() {
        return gjennomsnittligVekt;
    }

    public boolean isSvømmer() {
        return svømmer;
    }

    @Override
    public String toString(){
        String ut = "Gjennomsnittlig vekt: " + gjennomsnittligVekt;
        if (svømmer) ut += ", svømmer\n";
        else ut += ", ikke-svømmer";
        return super.toString() + ut;
    }
}
