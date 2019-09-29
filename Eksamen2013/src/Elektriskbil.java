/**
 * Created by Fellepp on 17.05.2017.
 */
public class Elektriskbil extends Bil {
    private double fastAvgift;

    public Elektriskbil(String regNr, int regÅr, boolean varebil, double fastAvgift) {
        super(regÅr, regNr, varebil);
        this.fastAvgift = fastAvgift;
    }

    public double getFastAvgift() {
        return fastAvgift;
    }

    public double beregnÅrsavgift(int år) {
        return fastAvgift;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFast årsavgift: " + fastAvgift;
    }
}
