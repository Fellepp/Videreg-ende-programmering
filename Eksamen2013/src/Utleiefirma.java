import java.util.ArrayList;

/**
 * Created by Fellepp on 17.05.2017.
 */
public class Utleiefirma {
    private java.util.ArrayList<Bil> biler = new ArrayList<Bil>();

    public Utleiefirma(java.util.ArrayList<Bil> nyeBiler) {
        for(int i = 0; i<nyeBiler.size(); i++) {
            biler.add(nyeBiler.get(i));
        }
    }

    public double finnTotalÅrsavgift(int år) {
        double sum = 0.0;
        for(int i = 0; i<biler.size(); i++) {
            sum += biler.get(i).finnÅrsavgift(år);
        }
        return sum;
    }

    public void sorteringsPrint(java.util.ArrayList<Bil> sorterteBiler){
        for(int i = 0; i< sorterteBiler.size(); i++) {
            System.out.println(sorterteBiler.get(i).toString());
        }
    }

    public java.util.ArrayList<Bil> lagSortertListe() {
        java.util.ArrayList<Bil> liste = new java.util.ArrayList<Bil>();
        for(int i = 0; i<biler.size(); i++) {
            liste.add(biler.get(i));
        }
        java.util.Collections.sort(liste);
        return liste;
    }
}
