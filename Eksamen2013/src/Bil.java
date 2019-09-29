/**
 * Created by Fellepp on 17.05.2017.
 */
abstract class Bil implements Comparable<Bil>{
    private static final double FAKTOR_VAREBIL = 0.5;
    private boolean varebil = false;
    private int regÅr;
    private String regNr;
    private java.util.ArrayList<KmÅr> antKm = new java.util.ArrayList<KmÅr>();

    protected Bil(int regÅr, String regNr, boolean varebil) {
        this.regÅr = regÅr;
        this.regNr = regNr;
        this.varebil = varebil;
        antKm.add(new KmÅr(10, 1998));
    }

    public String getRegNr() {
        return regNr;
    }

    public int getRegÅr() {
        return regÅr;
    }

    public boolean isVarebil() {
        return varebil;
    }

    abstract protected double beregnÅrsavgift(int år);

    public double finnÅrsavgift(int år) {
        if(år > regÅr && år<finnÅrstall()) {
            if(varebil) return FAKTOR_VAREBIL*beregnÅrsavgift(år);
            else return beregnÅrsavgift(år);
        }
        return 0.0;
    }

    public int finnKm(int år) {
        KmÅr objekt = finnKmÅr(år);
        if(objekt == null) return -1;
        else return objekt.getKm();
    }

    private KmÅr finnKmÅr(int år) {
        if(år >= regÅr && år<finnÅrstall()) {
          for(KmÅr objekt: antKm) {
              if(objekt.getÅr() == år) {
                  return objekt;
              }
          }
        }
        return null;
    }

    public static int finnÅrstall(){
        java.util.GregorianCalendar dagensDato = new java.util.GregorianCalendar();
        int år = dagensDato.get(java.util.Calendar.YEAR);
        return år;
    }

    public int compareTo(Bil denAndre) {
        int regÅr2 = denAndre.regÅr;
        if(regÅr < regÅr2) {
            return -1;
        }else if(regÅr > regÅr2) {
            return 1;
        }else {
            int antKmÅr1 = finnKm(regÅr);
            int antKmÅr2 = denAndre.finnKm(regÅr);
            if(antKmÅr1 < antKmÅr2) {
                return -1;
            }else if(antKmÅr1 > antKmÅr2) {
                return 1;
            }else {
                return 0;
            }
        }
    }

    public String toString() {
        String ut = "Registreringsår: " + regÅr + ", registreringsnummer: " + regNr;
        if(varebil) {
            ut += ", varebil";
        }
        else {
            ut += ", personbil";
        }
        return ut;
    }
}
