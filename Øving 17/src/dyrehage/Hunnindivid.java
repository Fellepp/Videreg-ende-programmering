package dyrehage;

import java.util.Date;

/**
 * Created by Fellepp on 13.05.2017.
 */
public class Hunnindivid extends Individ{
    private int antKull;

    public Hunnindivid(String norskNavn, String latNavn, String latFamilie, String ankommetDato, String adresse, String navn, Date fDato, boolean farlig, int antKull) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, farlig);
        this.antKull = antKull;
    }

    @Override
    public int getAntKull() {
        return antKull;
    }

    @Override
    public void leggTilKull(int antall) {
        antKull += antall;
    }

    @Override
    public void leggTilNyttKull() {
        antKull++;
    }
    public String toString(){
        return super.toString() + ", hunndyr" + " antall kull: " + antKull;
    }
}
