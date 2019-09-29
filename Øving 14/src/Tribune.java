import java.io.Serializable;

/**
 * Created by johan on 02.03.2017.
 */
abstract public class Tribune implements Comparable, Serializable{
    private final String tribunenavn;
    private final int kapasitet;
    private final int pris;
    private int antSolgteBilletter;

    public Tribune(String tribunenavn, int kapasitet, int pris) {
        this.tribunenavn = tribunenavn;
        this.kapasitet = kapasitet;
        this.pris = pris;
    }

    abstract public int finnAntallSolgteBilletter();

    public int finnInntekt(){
        return finnAntallSolgteBilletter() * pris;
    }

    public String getTribunenavn(){
        return tribunenavn;
    }

    public int getKapasitet(){
        return kapasitet;
    }

    public int getPris(){
        return pris;
    }

    abstract Billett[] kjøpBilletter(int antBilletter);
    abstract Billett[] kjøpBilletter(String[] navn);

    public String toString(){
        return "Tribunenavn: " + tribunenavn + ", kapasitet: " + kapasitet + ", pris: " + pris + "\nAntall solgte billetter: " + finnAntallSolgteBilletter() + "\nInntekt: " + finnInntekt();
    }

    @Override
    public int compareTo(Object obj){
        if(this == obj) return 0;
        if(obj instanceof Tribune) {
            Tribune tribune = (Tribune)obj;
            if(finnInntekt() == tribune.finnInntekt()) return 0;
            else if(finnInntekt() > tribune.finnInntekt()) return -1;
        }
        return 1;
    }
}
