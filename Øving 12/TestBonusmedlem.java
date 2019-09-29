import java.time.LocalDate;
import java.time.Period;

class TestBonusmedlem {
  public static void main(String[] args) throws Exception {
    Personalia ole = new Personalia("Olsen", "Ole", "ole.olsen@dot.com", "ole");
    Personalia tove = new Personalia("Hansen", "Tove", "tove.hansen@dot.com", "tove");
    LocalDate testdato = LocalDate.of(2008, 2, 10);
    System.out.println("Totalt antall tester: 8");

    BasicMedlem b1 = new BasicMedlem(100, ole, LocalDate.of(2006, 2, 15));
    b1.regPoeng(30000);
    if (b1.finnKvalPoeng(testdato) == 0 && b1.getPoeng() == 30000) {
      System.out.println("Test 1 ok");
    }
    else System.out.println("Test 1 feil");

    b1.regPoeng(15000);
    if (b1.finnKvalPoeng(testdato) == 0 && b1.getPoeng() == 45000) {
      System.out.println("Test 2 ok");
    }
	else System.out.println("Test 2 feil");

    BasicMedlem b2 = new BasicMedlem(110, tove, LocalDate.of(2007, 3, 5));
    b2.regPoeng(30000);
    if (b2.finnKvalPoeng(testdato) == 30000 && b2.getPoeng() == 30000) {
      System.out.println("Test 3 ok");
    }
    else System.out.println("Test 3 feil");

    SoelvMedlem b3 = new SoelvMedlem(b2.getMedNr(), b2.getPers(), b2.getInnmeldtDato(), b2.getPoeng());
    b3.regPoeng(50000);
    if (b3.finnKvalPoeng(testdato) == 90000 && b3.getPoeng() == 90000) {
      System.out.println("Test 4 ok");
    }
    else System.out.println("Test 4 feil");

    GullMedlem b4 = new GullMedlem(b3.getMedNr(), b3.getPers(), b3.getInnmeldtDato(), b3.getPoeng());
    b4.regPoeng(30000);
    if (b4.finnKvalPoeng(testdato) == 135000 && b4.getPoeng() == 135000) {
      System.out.println("Test 5 ok");
    }
    else System.out.println("Test 5 feil");

    testdato = LocalDate.of(2008, 12, 10);
    if (b4.finnKvalPoeng(testdato) == 0 && b4.getPoeng() == 135000) {
      System.out.println("Test 6 ok");
    }
    else System.out.println("Test 6 feil");

    if (!ole.okPassord("OOO")) {
      System.out.println("Test 7 ok");
    }
    else System.out.println("Test 7 feil");

    if (tove.okPassord("tove")) {
      System.out.println("Test 8 ok");
    }
    else System.out.println("Test 8 feil");
  }
}