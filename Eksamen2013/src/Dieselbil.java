/**
 * Created by Fellepp on 17.05.2017.
 */
public class Dieselbil extends Bil {
    private double fastAvgift;
    private double økningPrKm;

    public Dieselbil(String regNr, int regÅr, boolean varebil, double fastAvgift, double økningPrKm) {
        super(regÅr, regNr, varebil);
        this.fastAvgift = fastAvgift;
        this.økningPrKm = økningPrKm;
    }

    public double getFastAvgift() {
        return fastAvgift;
    }

    public double getØkningPrKm() {
        return økningPrKm;
    }

    public double beregnÅrsavgift(int år) {
        if(økningPrKm >= 0) {
            double antKm = finnKm(år);
            if(antKm>=0) {
                return fastAvgift + antKm * økningPrKm;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return super.toString() + "\nÅrsavgift første år: " + fastAvgift + ", økning per km: " + økningPrKm;
    }
}
