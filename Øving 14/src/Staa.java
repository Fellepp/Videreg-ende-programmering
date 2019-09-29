/**
 * Created by johan on 02.03.2017.
 */
public class Staa extends Tribune{
    private int antSolgteBilletter;
    private int pris;

    public Staa(String tribunenavn, int kapasitet, int pris) {
        super(tribunenavn, kapasitet, pris);
        this.pris = pris;
    }

    @Override
    public int finnAntallSolgteBilletter() {
        return antSolgteBilletter;
    }

    @Override
    public int finnInntekt() {
        return antSolgteBilletter * getPris();
    }

    @Override
    Billett[] kjøpBilletter(int antBilletter) {
        Billett[] billetter = new Billett[antBilletter];
        if(getKapasitet()-antSolgteBilletter >= antBilletter){
            for(int i = 0; i < billetter.length; i++){
                billetter[i] = new StaaplassBillett(getTribunenavn(), getPris());
                antSolgteBilletter++;
            }
            return billetter;
        }
        return null;
    }

    @Override
    Billett[] kjøpBilletter(String[] navn) {
        return kjøpBilletter(navn.length);
    }
}
