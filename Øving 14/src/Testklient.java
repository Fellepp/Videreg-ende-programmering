/**
 * Created by johan on 02.03.2017.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.util.Arrays.sort;

public class Testklient {
    public static void main(String[]args) throws Exception{
        Tribune[] tribune = new Tribune[4];
        tribune[0] = new Sitte("Tribune Sitteplass 1", 15, 100, 3);
        tribune[1] = new Staa("Tribune Ståplass 1", 15, 80);
        tribune[2] = new Staa("Tribune Ståplass 2", 4, 80);
        tribune[3] = new VIP("Tribune VIP 1", 6, 150, 2);

        //Tester kjøpBilletter() for ståtribune
        System.out.println("Ståtribune, 3 tester:\n");
        Billett[] billetter = tribune[1].kjøpBilletter(6);
        if(billetter != null) if(billetter.length == 6)System.out.println("Test 1: ok");
        System.out.print(billettUtskrift(billetter) +"\n");
        billetter = tribune[1].kjøpBilletter(new String[]{"Øystein","Kha"});
        if(billetter != null) if(billetter.length == 2)System.out.println("Test 2: ok");
        System.out.print(billettUtskrift(billetter) +"\n");
        billetter = tribune[2].kjøpBilletter(5);
        if(billetter == null) System.out.println("Test 3: ok");
        System.out.print(billettUtskrift(billetter) +"\n");

        //Tester kjøpBilletter() for sittetribune
        System.out.println("\nSittetribune, 3 tester:\n");
        billetter = tribune[0].kjøpBilletter(2);
        if(billetter != null) if(billetter.length == 2) System.out.println("Test 1: ok");
        System.out.print(billettUtskrift(billetter) +"\n");
        billetter = tribune[0].kjøpBilletter(new String[]{"Aleksander", "Filip"});
        if(billetter != null) if(billetter.length == 2) System.out.println("Test 2: ok");
        System.out.print(billettUtskrift(billetter) +"\n");
        billetter = tribune[0].kjøpBilletter(6);
        if(billetter == null) System.out.println("Test 3: ok");
        System.out.print(billettUtskrift(billetter) +"\n");

        //Tester kjøpBilletter() for VIPtribune
        System.out.println("\nVIP-tribune, 3 tester:\n");
        billetter = tribune[3].kjøpBilletter(2);
        if(billetter == null) System.out.println("Test 1: ok");
        System.out.print(billettUtskrift(billetter) +"\n");
        billetter = tribune[3].kjøpBilletter(new String[]{"Filip", "Øystein"});
        if(billetter != null) if(billetter.length == 2) System.out.println("Test 2: ok");
        System.out.print(billettUtskrift(billetter) +"\n");
        billetter = tribune[3].kjøpBilletter(new String[]{"Kha", "Aleksander", "Dmitry" , "Warsa"});
        if(billetter == null) System.out.println("Test 3: ok");
        System.out.print(billettUtskrift(billetter) +"\n");

        // Sortering av tribuner etter inntekt (Desc)
        System.out.println("\nUsortert: ");
        for(Tribune trib : tribune) System.out.println(trib);
        sort(tribune);
        System.out.println("\nSortert: ");
        for(Tribune trib : tribune) System.out.println(trib);


        // Lagring av Tribune-objekter
        FileOutputStream fout = new FileOutputStream("tribuner.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(tribune);
        oos.close();

        // Henting av objekter
        FileInputStream fis = new FileInputStream("tribuner.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Tribune[] tFil = null;

        try {
            tFil = (Tribune[])ois.readObject();
        } catch (Exception e) { }
        finally {
            ois.close();
        }

        // Skriver objekter fra fil
        System.out.println("\nObjekter fra fil");
        for(Tribune trib : tFil) System.out.println(trib);
    }

    private static String billettUtskrift(Billett[] billetter) {
        String ut = "Billetter:\n";
        if (billetter == null) ut = "Feil i billettene";
        else{
            for(int i = 0; i<billetter.length; i++){
                ut += "Billett " + (i+1) + ": " + billetter[i].toString() + "\n";
            }
        }
        return ut;
    }
}
