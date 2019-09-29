import static javax.swing.JOptionPane.*;

class GodkjenningBGS{
	public final String NY_STUDENT = "Ny student";
	public final String AVSLUTT = "Avslutt";
	private String[] muligeValg = {NY_STUDENT, AVSLUTT};

	private OppgaveOversikt oversikt;
	public GodkjenningBGS(OppgaveOversikt oversikt){
		this.oversikt = oversikt;
	}

	public String lesValg(){
		int antStud = oversikt.finnAntStud();
		String valg = (String) showInputDialog(null, "Velg fra listen, " + antStud + " studenter: ", "Godkjente oppgaver", DEFAULT_OPTION, null, muligeValg, muligeValg[0]);
		if(AVSLUTT.equals(valg)){
			valg = null;
		}
		return valg;
	}

	public void utførValgtOppgave(String valg){
		if(valg != null && !valg.equals(AVSLUTT)){
			if(valg.equals(NY_STUDENT)){
				registrerNyStudent();
			} else {
				registrerOppgaver(valg);
			}
		}
	}

	private void registrerNyStudent(){
		String navnNyStud = null;
		do{
			navnNyStud = showInputDialog("Oppgi navn: ");
		}while(navnNyStud == null);

		navnNyStud = navnNyStud.trim();
		if(oversikt.regNyStudent(navnNyStud)){
			showMessageDialog(null, navnNyStud + " er registrert.");
			String[] alleNavn = oversikt.finnAlleNavn();
			String[] nyMuligeValg = new String[alleNavn.length + 2];
			for(int i = 0; i < alleNavn.length; i++){
				nyMuligeValg[i] = alleNavn[i];
			}
			nyMuligeValg[alleNavn.length] = NY_STUDENT;
			nyMuligeValg[alleNavn.length + 1] = AVSLUTT;
			muligeValg = nyMuligeValg;
			}else{
				showMessageDialog(null, navnNyStud + " er allerede registrert.");
			}
		}

		private void registrerOppgaver(String studNavn){
			String melding = "Oppgi antall nye oppgaver som skal godkjennes for " + studNavn + ": ";
			int antOppgØkning = 0;
			boolean registrert = false;
			do{
				try{
					antOppgØkning = lesHeltall(melding);
					oversikt.økAntOppg(studNavn, antOppgØkning);
					registrert = true;
				}catch(IllegalArgumentException e){
					melding = "Du skrev " + antOppgØkning + ". \nIkke godkjent økning for " + studNavn + ". Prøv igjen: ";
				}
			}while(!registrert);

			melding = "Totalt antall oppgaver registrert på " + studNavn + " er " + oversikt.finnAntOppgaver(studNavn) + ".";
			showMessageDialog(null, melding);
		}

		private int lesHeltall(String melding){
			int tall = 0;
			boolean ok = false;
			do{
				String tallLest = showInputDialog(melding);
				try{
					tall = Integer.parseInt(tallLest);
					ok = true;
				}catch(Exception e){
					showMessageDialog(null, "Kan ikke tolke det du skrev som tall. Prøv igjen. ");
				}
			}while(!ok);
			return tall;
	}
}


