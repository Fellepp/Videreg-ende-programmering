/**
 * Created by Fellepp on 17.05.2017.
 */
public class TestKlient {
    public static void main(String[] args) {
        Bil FordFiestaBen = new Bensinbil("XAX123", 1990, false, 3000, 100);
        Bil FordFiestaBenVare = new Bensinbil("XAX123", 1990, true, 3000, 100);
        Bil FordFiestaDies = new Dieselbil("XAX123", 1990, false, 1000, 0.01);
        Bil FordFiestaDiesVare = new Dieselbil("XAX123", 1990, true, 1000, 0.01);
        Bil FordFiestaElek = new Elektriskbil("XAX123", 1990, false, 1000);
        Bil FordFiestaElekVare = new Elektriskbil("XAX123", 1990, true, 1000);

        java.util.ArrayList<Bil> biler = new java.util.ArrayList<Bil>();
        biler.add(FordFiestaBen);
        biler.add(FordFiestaBenVare);
        biler.add(FordFiestaDies);
        biler.add(FordFiestaDiesVare);
        biler.add(FordFiestaElek);
        biler.add(FordFiestaElekVare);
        Utleiefirma utleie = new Utleiefirma(biler);

        System.out.println(FordFiestaBen.finnÅrsavgift(1997));
        System.out.println(FordFiestaBenVare.finnÅrsavgift(1997));
        System.out.println(FordFiestaDies.finnÅrsavgift(1998));
        System.out.println(FordFiestaDiesVare.finnÅrsavgift(1998));
        System.out.println(FordFiestaElek.finnÅrsavgift(1997));
        System.out.println(FordFiestaElekVare.finnÅrsavgift(1997));

        System.out.println(utleie.finnTotalÅrsavgift(1997));

        utleie.sorteringsPrint(utleie.lagSortertListe());
    }
}
