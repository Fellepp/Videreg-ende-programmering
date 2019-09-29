package dyrehage;

import java.util.Date;

/**
 * Created by Fellepp on 13.05.2017.
 */
public class Hannindivid extends Individ{
    public Hannindivid(String norskNavn, String latNavn, String latFamilie, String ankommetDato, String adresse, String navn, Date fDato, boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, farlig);
    }

    @Override
    public int getAntKull() {
        return 0;
    }

    @Override
    public void leggTilKull(int antall) {}

    @Override
    public void leggTilNyttKull() {}

    public String toString(){
        return super.toString() + ", hanndyr";
    }
}
