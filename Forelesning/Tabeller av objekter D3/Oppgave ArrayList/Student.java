/**
 * Student.java  - "Programmering i Java", 4.utgave - 2009-07-01
 * Fra programliste 11.5 side 361.
 *
 * Komposisjon: Navneobjektet er gjemt inne i studentobjektet.
 * Klienten forholder seg ikke til klassen Navn i det hele tatt.
 */

class Student {
  private Navn navn;
  private final int fdato;

  public Student(String fornavn, String etternavn, int fdato) {
    this.navn = new Navn(fornavn, etternavn);
    this.fdato = fdato;
  }

  public String getEtternavn() {
    return navn.getEtternavn();
  }

  public String getFornavn() {
    return navn.getFornavn();
  }

  public void setFornavn(String fornavn) {
    navn.setFornavn(fornavn);
  }

  public void setEtternavn(String etternavn) {
    navn.setEtternavn(etternavn);
  }

  public String toString() {
    return navn + ", født: " + fdato;
  }
}