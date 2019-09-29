import dyrehage.*;

import java.util.Date;

/**
 * Created by Fellepp on 13.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Rovdyrfabrikk r = new Rovdyrfabrikk();
        ISkandinaviskeRovdyr binne = r.nyHannbjørn("13.05.2017", "Bur 15, Bjørneland", "Bjørg-Laila", new Date(2000-1900, 5,23));
        System.out.println(binne);
        binne.flytt("Bur 14, Bjørneland");
        System.out.println(binne.getAdresse() + "\n" + binne.getNavn() + "\n" + binne.getAlder() + "\n" +
        binne.getFdato() + "\n" + binne.skrivUtInfo());
        binne.leggTilNyttKull();
        System.out.println(binne.getAntKull());
        binne.leggTilKull(2);
        System.out.println(binne.getAntKull());
    }
}
