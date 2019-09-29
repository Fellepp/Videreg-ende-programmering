/**
 * Created by johan on 02.03.2017.
 */
public class VIP extends Tribune{
    private int antSolgteBilletter = 0;
    private String[][] tilskuer;
    private int plassPrRad;
    private int[] antOpptatt;

    public VIP(String tribunenavn, int kapasitet, int pris, int rad){
        super(tribunenavn, kapasitet, pris);
        plassPrRad = getKapasitet()/rad;
        antOpptatt = new int[rad];
        tilskuer = new String[rad][plassPrRad];
    }

    @Override
    public int finnAntallSolgteBilletter(){
        return antSolgteBilletter;
    }

    @Override
    public int finnInntekt(){
        return antSolgteBilletter * getPris();
    }

    @Override
    Billett[] kjøpBilletter(int antBilletter){
        return null;
    }

    private int ledigRad(int antPlass) {
        if (antPlass > 0) {
            for (int i = 0; i < antOpptatt.length; i++) {
                if (plassPrRad - antOpptatt[i] >= antPlass) return i;
            }
        }
        return -1;
    }

    @Override
    Billett[] kjøpBilletter(String[] navn){
        Billett[] billetter = new Billett[navn.length];
        int navnPlass = 0;
        if(navn.length > 0) {
            if(plassPrRad >= navn.length){
                int rad = ledigRad(navn.length);
                if(rad != -1) {
                    for(int i = 0; i<navn.length; i++){
                        if(tilskuer[rad][i] != null) continue;
                        tilskuer[rad][i] = navn[navnPlass];
                        billetter[navnPlass] = new SitteplassBillett(getTribunenavn(), getPris(), rad, i, navn[navnPlass]);
                        navnPlass++;
                        antSolgteBilletter++;
                        antOpptatt[rad]++;
                        }
                    }
                    return billetter;
                }
            }
        return null;
    }
}
