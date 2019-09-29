class Kunde {
    private final int kundeId;
    private final String navn;
    private final String epost;
    public Kunde(int kundeId, String navn, String epost) {
        this.kundeId = kundeId;
        this.navn = navn;
        this.epost = epost;
    }
    public int getKundeId() {
        return kundeId;
    }
    public String getNavn() {
        return navn;
    }
    public String getEpost() {
        return epost;
    }
    public String toString() {
        return "KundeId: " + kundeId + ", navn: + " + navn + ", epost: " + epost;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Kunde)) return false; //De er ikke like hvis object ikke er instanceof kunde
        if(this == obj) return true; //De er like hvis DENNE kunden = obj
        Kunde kunde = (Kunde) obj; //caster obj til å bli Kunde
        return (this.kundeId == kunde.kundeId); //Returnerer true hvis lik, false hvis forskjellig
    }
}