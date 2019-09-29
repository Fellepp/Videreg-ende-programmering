/**
 * Created by johan on 02.03.2017.
 */
public class Sitte extends Tribune{
    private int antSolgteBilletter;
    private int[] antOpptatt;
    private int plassPrRad;

    public Sitte(String tribunenavn, int kapasitet, int pris, int rad){
        super(tribunenavn, kapasitet, pris);
        plassPrRad = kapasitet/rad;
        antOpptatt = new int[rad];
    }

    @Override
    public int finnAntallSolgteBilletter(){
        return antSolgteBilletter;
    }

    @Override
    public int finnInntekt(){
        return antSolgteBilletter * getPris();
    }

    private int ledigRad(int antPlass){
        if(antPlass > 0) {
                for (int i = 0; i < antOpptatt.length; i++) {
                    if (plassPrRad - antOpptatt[i] >= antPlass) return i;
                }
        }
        return -1;
    }

    @Override
    Billett[] kjøpBilletter(int antBilletter) {
        Billett[] billetter = new Billett[antBilletter];
            if(antBilletter <= plassPrRad){
                int rad = ledigRad(antBilletter);
                if(rad != -1){
                    for(int i = 0; i<antBilletter; i++){
                        billetter[i] = new SitteplassBillett(getTribunenavn(), getPris(), rad, antOpptatt[rad]);
                        antOpptatt[rad]++;
                        antSolgteBilletter++;
                    }
                    return billetter;
                }
            }
        return null;
    }

    @Override
    Billett[] kjøpBilletter(String[] navn) {
        return kjøpBilletter(navn.length);
    }
}
