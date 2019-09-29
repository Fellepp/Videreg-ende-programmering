import static javax.swing.JOptionPane.*;

class Klient{
	public static void main(String[]args){
		String[] muligheter = {"Registrer nytt rom", "Reserver rom", "Oversikt over rom", "Finn rom gitt indeks", "Finn rom gitt romnr", "Avslutt"};
		final int REG_ROM = 0;
		final int RES_ROM = 1;
		final int OVERSIKT = 2;
		final int ROM_INDEKS = 3;
		final int ROM_ROMNR = 4;
		final int AVSLUTT = 5;
		Konferansesenter konferansesenter = new Konferansesenter();
		int valg = showOptionDialog(null, "Velg operasjon", "�ving 3", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		while(valg != AVSLUTT){
			switch(valg){
				case REG_ROM:
				boolean feil1 = true;
				do{
					try{
						int st�rrelse  = Integer.parseInt(showInputDialog("Skriv inn romst�rrelse"));
						int romnr = Integer.parseInt(showInputDialog("Skriv inn romnr"));
						int sjekk = konferansesenter.registrerRom(st�rrelse, romnr);
						if(sjekk == 1) showMessageDialog(null, "Rommet er registrert");
						if(sjekk == -1) showMessageDialog(null, "Rommets st�rrelse m� v�re st�rre enn 0");
						if(sjekk == -2) showMessageDialog(null, "Romnr kan ikke v�re negativt eller ikke-eksisterende");
						if(sjekk == -3) showMessageDialog(null, "Romnr eksisterer allerede");
						feil1 = false;
					}catch(Exception e){
						showMessageDialog(null, "Ugyldig input");
					}
				}while(feil1);
					break;
				case RES_ROM:
				boolean feil2 = true;
				do{
					try{
						if(konferansesenter.getAntRom() != 0){
							long fraTid = Long.parseLong(showInputDialog("Klokkeslett og dato rommet skal reserveres fra: (����mmddttmm)"));
							long tilTid = Long.parseLong(showInputDialog("Klokkeslett og dato rommet skal reserveres til: (����mmddttmm)"));
							int antPersoner = Integer.parseInt(showInputDialog("Antall personer: "));
							String navn = showInputDialog("Navn rommet skal reserveres p�: ");
							String tlf = showInputDialog("Kundens telefonnummer");
							int romnrSjekk = konferansesenter.reserverRom(new Tidspunkt(fraTid), new Tidspunkt(tilTid), antPersoner, new Kunde(navn, tlf));
							if(romnrSjekk > 0) showMessageDialog(null, "Rom nr " + romnrSjekk + " er reservert p� " + navn);
							if(romnrSjekk == -1) showMessageDialog(null, "Antall personer m� v�re st�rre enn 0");
							if(romnrSjekk == -2) showMessageDialog(null, "Ugyldig tidspunkt!");
							if(romnrSjekk == -3) showMessageDialog(null, "Ingen ledige rom innenfor kravene");
						}else showMessageDialog(null, "Ingen rom er registrert");
						feil2 = false;
					}catch(Exception e){
						showMessageDialog(null, "Ugyldig input");
					}
				}while(feil2);
					break;
				case OVERSIKT:
					if(konferansesenter.getAntRom() != 0){
						showMessageDialog(null, konferansesenter.toString());
					}else showMessageDialog(null, "Ingen rom er registrert");
					break;
				case ROM_INDEKS:
				boolean feil3 = true;
				do{
					try{
						if(konferansesenter.getAntRom() != 0){
							int indeks = Integer.parseInt(showInputDialog("S�k p� indeks: "));
							if(konferansesenter.getRomIndeks(indeks) != null) showMessageDialog(null, konferansesenter.getRomIndeks(indeks).toString());
							else showMessageDialog(null, "Dette rommet finnes ikke");
						}else showMessageDialog(null, "Ingen rom er registrert");
						feil3 = false;
					}catch(Exception e){
						showMessageDialog(null, "Ugyldig input");
					}
				}while(feil3);
					break;
				case ROM_ROMNR:
				boolean feil4 = true;
				do{
					try{
						if(konferansesenter.getAntRom() != 0){
							int romnrS�k = Integer.parseInt(showInputDialog("S�k p� romnr: "));
							if(konferansesenter.getRomNr(romnrS�k) != null) showMessageDialog(null, konferansesenter.getRomNr(romnrS�k).toString());
							else showMessageDialog(null, "Dette rommet finnes ikke");
						}else showMessageDialog(null, "Ingen rom er registrert");
						feil4 = false;
					}catch(Exception e){
						showMessageDialog(null, "Ugyldig input");
					}
				}while(feil4);
					break;
				default:
					break;
			}
			valg = showOptionDialog(null, "Velg operasjon", "�ving 3", YES_NO_OPTION, INFORMATION_MESSAGE, null, muligheter, muligheter[0]);
		}
	}
}