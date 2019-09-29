/**
* Klassen Utstyr er mutabel. Antall på lager og nedre grense for
* bestilling kan endres.
*/
class Utstyr {
  public static final int BESTILLINGSFAKTOR = 5;
  private final String betegnelse;  // identifikasjon
  private final String leverandør;
  private int påLager; // mengde på lager
  private int nedreGrense;

  public Utstyr implements Comparable<Utstyr>(String betegnelse, String leverandør, int påLager, int nedreGrense) {
    this.betegnelse = betegnelse;
    this.leverandør = leverandør;
    this.påLager = påLager;
    this.nedreGrense = nedreGrense;
  }

  public int compareTo(Utstyr obj){ //OBS, objektenes naturlige orden
	  return betegnelse.compareTo(obj.getBetegnelse());
  }

  public boolean equals(Object obj){ //OBS, parametertype Object, ikke utstyr
	  if(!(obj instanceof Utstyr)) return false;
	  if(this == obj) return true;
	  Utstyr u = (Utstyr)obj;
	  return (betegnelse.equals(u.betegnelse));
  }

  public String getBetegnelse() {
    return betegnelse;
  }

  public String getLeverandør() {
    return leverandør;
  }

  public int getPåLager() {
    return påLager;
  }

  public int getNedreGrense() {
    return nedreGrense;
  }

  public void setNedreGrense(int nyNedreGrense) {
    nedreGrense = nyNedreGrense;
  }

  public int finnBestKvantum() {
    return (påLager < nedreGrense) ? BESTILLINGSFAKTOR * nedreGrense : 0;
  }

  /**
  * Endring av lagerbeholdning.
  * Den kan være positiv eller negativ. Men det er ikke
  * mulig å ta ut mer enn det som fins på lager. Hvis klienten
  * prøver på det, vil metoden returnere false, og intet uttak gjøres.
  */
  public boolean endreLagerbeholdning(int endring) {
    if (påLager + endring < 0) {
      return false;
    } else {
      påLager += endring;
      return true;
    }
  }

  public String toString() {
    String resultat = "Betegnelse: " + betegnelse + ", ";
    resultat += "Leverandør: " + leverandør + ", ";
    resultat += "På lager: " + påLager + ", ";
    resultat += "Nedre grense: " + nedreGrense;
    return resultat;
  }
}