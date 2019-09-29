/**
 * Personalia.java
 *
 * Klasse med personopplysninger: fornavn, etternavn, epostadresse og passord.
 * Passordet kan endres, men da ml det nye vcre forskjellig fra det gamle.
 * Passordkontrollen skiller ikke mellom store og sml bokstaver.
 */
class Personalia {
  private final String etternavn;
  private final String fornavn;
  private final String ePostadr;
  private String passord;

  /**
   * Konstruktrr:
   * Alle data ml oppgis: fornavn, etternavn, ePostadr, passord
   * Ingen av dataene kan vcre null eller blanke strenger.
   */
  public Personalia(String etternavn, String fornavn, String ePostadr, String passord) {
    if (fornavn == null || etternavn == null || ePostadr == null || passord == null ||
        fornavn.trim().equals("") || etternavn.trim().equals("") || ePostadr.trim().equals("") || passord.trim().equals("")) {
          throw new IllegalArgumentException("Et eller flere konstruktrrrargumenter er null og/eller blanke.");
    }
    this.fornavn = fornavn.trim();
    this.etternavn = etternavn.trim();
    this.ePostadr = ePostadr.trim();
    this.passord = passord.trim();
  }

  public String getFornavn() {
    return fornavn;
  }

  public String getEtternavn() {
    return etternavn;
  }

  public String getEPostadr() {
    return ePostadr;
  }

  /**
   * Metoden returnerer true dersom passordet er korrekt.
   * Passordkontrollen skiller ikke mellom store og sml bokstaver.
   */
  public boolean okPassord(String passordet) {
    return passord.equalsIgnoreCase(passordet);
  }

  /**
   * Metoden setter nytt passord, dersom det er forskjellig fra
   * det gamle. To passord betraktes som like dersom det kun er
   * forskjeller i store/sml bokstaver.
   *
   * Metoden returnerer true dersom passordet ble endret, ellers false.
   */
  public boolean endrePassord(String gml, String nytt) {
    if (gml == null || nytt == null) {
      return false;
    }
    if (!passord.equalsIgnoreCase(gml.trim())) {
      return false;
    } else {
      passord = nytt.trim();
      return true;
    }
  }

  public String toString(){
	  return "Navn: " + fornavn + " " + etternavn + ", Epost: " + ePostadr + ", Passord: " + passord;
  }
}