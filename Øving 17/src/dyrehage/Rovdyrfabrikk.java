package dyrehage;

import java.util.Date;

/**
 * Created by Fellep on 16.03.2017.
 */
public class Rovdyrfabrikk {
    public ISkandinaviskeRovdyr nyBinne(String ankommetDato, String adresse, String navn, Date fDato, int antKull){
        return new Hunnindivid("Bjørn", "Ursus arctos", "Ursidae", ankommetDato, adresse, navn, fDato, true, antKull);
    }

    public ISkandinaviskeRovdyr nyHannbjørn(String ankommetDato, String adresse, String navn, Date fDato){
        return new Hannindivid("Bjørn", "Ursus arctos", "Ursidae", ankommetDato, adresse, navn, fDato, true);
    }

    public ISkandinaviskeRovdyr nyUlvetispe(String ankommetDato, String adresse, String navn, Date fDato, int antKull){
        return new Hunnindivid("Ulv", "Canis lupus", "Canidae", ankommetDato, adresse, navn, fDato, true, antKull);
    }

    public ISkandinaviskeRovdyr nyUlvehann(String ankommetDato, String adresse, String navn, Date fDato){
        return new Hannindivid("Ulv", "Canis lupus", "Canidae", ankommetDato, adresse, navn, fDato, true);
    }
}
