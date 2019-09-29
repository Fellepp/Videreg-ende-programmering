package dyrehage;

/**
 * Created by johan on 15.03.2017.
 */
public class Fiskestim extends Dyregruppe{
    private final double gjennomsnittligLengde;
    private final boolean kanDeleAkvarium;

    public Fiskestim(String norskNavn, String latNavn, String latFamilie, String ankommetDato, String adresse, String gruppenavn, double gjennomsnittligLengde, boolean kanDeleAkvarium) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, gruppenavn);
        this.gjennomsnittligLengde = gjennomsnittligLengde;
        this.kanDeleAkvarium = kanDeleAkvarium;
    }

    public double getGjennomsnittligLengde() {
        return gjennomsnittligLengde;
    }

    public boolean isKanDeleAkvarium() {
        return kanDeleAkvarium;
    }

    @Override
    public String toString(){
        String ut = "Gjennomsnittslengde: " + gjennomsnittligLengde;
        if(kanDeleAkvarium) ut += ", kan dele akvarium";
        else ut += ", kan ikke dele akvarium";
        return super.toString() + ut;
    }
}
