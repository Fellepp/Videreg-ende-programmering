package dyrehage;
import java.util.Date;


/**
 * Created by johan on 15.03.2017.
 */
public abstract class Individ extends Dyr implements ISkandinaviskeRovdyr{
    private final String navn;
    private final Date fDato;
    private final boolean farlig;

    public Individ(String norskNavn, String latNavn, String latFamilie, String ankommetDato, String adresse, String navn, Date fDato, boolean farlig) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.navn = navn;
        this.fDato = fDato;
        this.farlig = farlig;
    }

    @Override
    public String getNavn() {
        return navn;
    }

    @Override
    public String getAdresse(){ return super.getAdresse(); }

    @Override
    public int getAlder() {
        return Math.toIntExact((new Date().getTime() - fDato.getTime())/1000/60/60/24/365);
    }

    @Override
    public void flytt(String nyAdresse) {
        super.setAdresse(nyAdresse);
    }

    @Override
    public String skrivUtInfo() {
        return toString();
    }

    @Override
    public Date getFdato() {
        return fDato;
    }

    public boolean isFarlig() {
        return farlig;
    }

    @Override
    public String toString(){
        String ut = "Navn: " + navn + ", fødselsdato: " + fDato;
        if(farlig) ut += ", farlig";
        else ut += ", ufarlig";
        return super.toString() + ut;
    }
}
