import static javax.swing.JOptionPane.*;

class Klient{
	public static void main(String[] args){
		String[] muligheter = {"Åpne ny restaurant", "Reserver bord", "Sjekk reserverte bord for en person", "Frigi bord", "Liste over alle bord", "Se antall ledige og opptatte bord", "Informasjon om restauranten", "Nytt restaurantnavn", "Avslutt"};
		final int REG_RES = 0;
		final int RES_BORD = 1;
		final int SJEKK_NAVN = 2;
		final int FRIGI_BORD = 3;
		final int LISTE = 4;
		final int LEDIGE_OPPTATTE = 5;
		final int INFO = 6;
		final int ENDRE_NAVN = 7;
		final int AVSLUTT = 8;
		Restaurant restaurant = null;
		Bord bord = null;
		int valg = showOptionDialog(null, "Velg operasjon", "Øving 1", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		while(valg != AVSLUTT){
			switch(valg){
				case REG_RES:				String navn = showInputDialog("Navn på restaurant?");
											int år = Integer.parseInt(showInputDialog("Etableringsår?"));
											int antallBord = Integer.parseInt(showInputDialog("Hvor mange bord er det i restauranten?"));
											if(restaurant != null){
												int sikker = showConfirmDialog(null, "Du har allerede en restaurant! Vil du slette den og åpne en ny?");
												if(sikker == YES_OPTION){
													bord = new Bord(antallBord);
													restaurant = new Restaurant(bord, navn, år);
												}
											}else{
												bord = new Bord(antallBord);
												restaurant = new Restaurant(bord, navn, år);
											}
											showMessageDialog(null, "Restauranten er åpen!");
											break;

				case RES_BORD:				if(restaurant!= null){
												int antallBordRes = Integer.parseInt(showInputDialog("Antall bord som skal reserveres?"));
												int[] plasser = new int[antallBordRes];
												for(int i = 0; i<antallBordRes; i++){
													plasser[i] = Integer.parseInt(showInputDialog("Hvilke bordnr skal reserveres?"));
												}
												String resNavn = showInputDialog("Navn bord(ene) skal registrers på?");
												int sjekk = restaurant.reserverBord(resNavn, plasser, antallBordRes);
												if(sjekk == -1) showMessageDialog(null, "Feil på navn");
												if(sjekk == -2) showMessageDialog(null, "Kan ikke reservere flere bord enn det maks er i restauranten! Maks antall er " + bord.getAntBord());
												if(sjekk == -3) showMessageDialog(null, "Et eller flere av bordene finnes ikke. Velg mellom bordnr 0-" + bord.getAntBord());
												if(sjekk == -4) showMessageDialog(null, "Et eller flere av bordene er opptatt. Vennligst se oversikt over ledige bord");
												if(sjekk == 1)  showMessageDialog(null, "Bordene er reservert!");
											}else showMessageDialog(null, "Restauranten finnes ikke");
											break;

				case SJEKK_NAVN:			if(restaurant!= null){
												String sjekkNavn = showInputDialog("Skriv inn navnet du vil søke på:");
												int[] reservertListe = restaurant.reservertPåNavn(sjekkNavn);
												if(reservertListe != null){
													String res = sjekkNavn + " har reservert bordnr: ";
													for(int i = 0; i<reservertListe.length; i++){
														if(i == reservertListe.length-1) res += reservertListe[i] + ".";
														else if(i == reservertListe.length-2) res += reservertListe[i] + " og ";
														else res += reservertListe[i] + ", ";
													}
													showMessageDialog(null, res);
												}
											}else showMessageDialog(null, "Restauranten finnes ikke");
											break;

				case FRIGI_BORD:			if(restaurant != null){
												int frigi = Integer.parseInt(showInputDialog("Hvilket bord skal frigis?"));
												if(restaurant.frigiBord(frigi) == -1) showMessageDialog(null, "Dette bordet er allerede ledig");
												if(restaurant.frigiBord(frigi) == 1) showMessageDialog(null, "Bordet er nå ledig!");
											 }else showMessageDialog(null, "Restauranten finnes ikke");
											break;

				case LISTE:					if(restaurant != null){
												showMessageDialog(null, bord.toString());
											}else showMessageDialog(null, "Restauranten finnes ikke");
											break;

				case LEDIGE_OPPTATTE:		if(restaurant != null){
												showMessageDialog(null, "Antall ledige bord: " + bord.getAntLedige() + "\nAntall opptatte bord: " + bord.getAntOpptatt());
											}else showMessageDialog(null, "Restauranten finnes ikke");
											break;

				case INFO:					if(restaurant != null){
												showMessageDialog(null, "Informasjon om restauranten\n" + "Restaurantens navn: " + restaurant.getNavn() + "\nRestaurantens etableringsår: " + restaurant.getEtableringsår() + "\nRestaurantens alder: " + restaurant.getAlder());
											}else showMessageDialog(null, "Restauranten finnes ikke");
											break;

				case ENDRE_NAVN:			if(restaurant != null){
											String nyttNavn = showInputDialog("Skriv inn nytt navn");
											restaurant.setNavn(nyttNavn);
											}else showMessageDialog(null, "Restauranten finnes ikke");
											break;

				default:					break;
			}
			valg = showOptionDialog(null, "Velg operasjon", "Øving 1", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		}
	}
}