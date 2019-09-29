/**
 * Created by Fellepp on 17.05.2017.
 */
class Bensinbil extends Bil {
    private double startPris;
    private double avtaking;

    public Bensinbil(String regNr, int regÅr, boolean varebil, double startPris, double avtaking) {
        super(regÅr, regNr, varebil);
        this.startPris = startPris;
        this.avtaking = avtaking;
    }

    public double getStartPris() {
        return startPris;
    }

    public double getAvtaking() {
        return avtaking;
    }

    public double beregnÅrsavgift(int år) {
        if(år >= super.getRegÅr() && startPris - avtaking >= 0) {
            if (år == super.getRegÅr()) return startPris;
            double nyAvgift = startPris - avtaking * (år-super.getRegÅr());
            if(nyAvgift <= 0) return 0.0;
            else return nyAvgift;
        }
        return -1;
    }

    @Override
    public String toString() {
        return super.toString() + "\nÅrsavgift første år: " + startPris + ", avtakelse per år: " + avtaking;
    }
}
