package Testing;

/**
 * Created by Fellep on 27.02.2017.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

public class Land_Fasit_Test{
    private static Land instance;

    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp()throws Exception {
        //legge inn kjent data i tabellene
        instance = new Land("Norge", "Kong Harald V", 4); // plass til kun en by
        instance.regBy(new By("By1", "Ordfører1, en", 10, 12));
        instance.regBy(new By("By2", "Ordfører2, to", 10, 100));
        instance.regBy(new By("By3", "Ordfører3, tre", 10, 200));
    }

    @After
    public void tearDown() {
        // tilbakestill

    }
    /* Test av metoden getBy */
    @Test
    public void testGetBy() throws Exception{
        System.out.println("testGetBy()");
        By result = instance.getBy(0);
        By expResult = new By("By1", "Ordfører1, en", 10, 12);
        assertEquals(expResult, result);
    }

    /* Test av metoden getByerMedPlass */
    @Test
    public void testGetByerMedPlass() throws Exception{
        System.out.println("testGetByerMedPlass()");
        int antNyeInnbyggere = 80;
        By[] expResult = {new By("By2", "Ordfører2, to", 10, 100), new By("By3", "Ordfører3, tre", 10, 200)};
        By[] result = instance.getByerMedPlass(antNyeInnbyggere);
        assertArrayEquals(expResult, result);
    }


    /* Test av metoden Land.regBy */
    @Test (expected=Exception.class)// kan ikke opprette en by med for mange innbyggere
    public void testregByForMangeInnbyggere() throws Exception{
        System.out.println("testregByForMangeInnbyggere()");
        // skal kaste unntak fordi byen har for mange innbyggere, unntaket kastes fra konstruktør i klassen By
        instance.regBy(new By("TulleBy", "Hansen, Hege", 100, 10));
    }

    @Test // Normalsituasjon, reg en ok by
    public void testregByOk() throws Exception{
        System.out.println("testregByOk()");
        // registrere en by - normalsituasjon skal være ok
        boolean result = instance.regBy(new By("Trondheim", "Otervik, Rita", 170000, 200000));
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test // kan ikke opprette samme by to ganger
    public void testregByDuplikat() throws Exception{
        System.out.println("testregByDuplikat()");
        // registrere en by - normalsituasjon skal være ok
        instance.regBy(new By("Trondheim", "Otervik, Rita", 170000, 200000));

        // registrere samme by to ganger - forventes å feile
        boolean result = instance.regBy(new By("Trondheim", "Otervik, Rita", 170000, 200000));
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test // kan ikke opprette flere byer enn det er plass til
    public void testregByIkkePlass() throws Exception{
        System.out.println("testregByIkkePlass()");
        // registrere en by - normalsituasjon skal være ok
        instance.regBy(new By("Trondheim", "Otervik, Rita", 170000, 200000));

        // registrere en by mer enn det er plass til, forventes å feile
        boolean result = instance.regBy(new By("Stjørdal", "Vigdenes, Ivar", 23308, 23400));
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main(Land_Fasit_Test.class.getName()); // tas med dersom textpad ikke er konfigurert
    }
}
