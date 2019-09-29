import java.time.LocalDate;

public class Klient{
	public static void main(String[]args){
		Medlemsarkiv arkiv = new Medlemsarkiv();

		Personalia aleksander = new Personalia("Olsen", "Aleksander", "aleko@teit.com", "aleksander");
    	Personalia filip = new Personalia("Johansen", "Filip", "filip@filip.com", "filip");
    	Personalia kha = new Personalia("Do Nguyen", "Kha", "kha@donguyen.com", "kha");
    	Personalia øystein = new Personalia("Vikane", "Øystein", "øystein@øystein.com", "øystein");

    	int mFilip = arkiv.nyMedlem(filip, LocalDate.of(2012, 5, 11), 5);
    	int mAleks = arkiv.nyMedlem(aleksander, LocalDate.of(2013, 8, 10), 6);
    	int mKha = arkiv.nyMedlem(kha, LocalDate.of(2014, 3, 9), 1);
    	int mØystein = arkiv.nyMedlem(øystein, LocalDate.of(2015, 2, 12), 4);

    	LocalDate testdato = LocalDate.of(2013, 5, 11);

    	System.out.println("Før poeng registrert:\n" + arkiv.toString());

		arkiv.registrerPoeng(mFilip, 76000);
		arkiv.registrerPoeng(mAleks, 25000);
		arkiv.registrerPoeng(mKha, 80000);
		arkiv.registrerPoeng(mØystein, 15000);

    	System.out.println("Etter poeng registrert:\n" + arkiv.toString());

    	arkiv.sjekkMedlemmer(testdato);

    	System.out.println("Etter sjekk av medlemmer med testdato " + testdato.toString() + ":\n" + arkiv.toString());

    	int filipPassord = arkiv.finnPoeng(mFilip, "filip");
    	if(filipPassord != -1){
			System.out.println("Poeng for Filip med riktig passord:" + filipPassord);
		}
		else System.out.println("Feil passord for Filip");

    	int alekPassord = arkiv.finnPoeng(mAleks, "aleko");
    	if(alekPassord != -1){
			System.out.println("Poeng for Aleksander med riktig passord:" + filipPassord);
		}
		else System.out.println("Feil passord for Aleksander");
	}
}