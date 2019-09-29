import static javax.swing.JOptionPane.*;

class Oppgave1{
	public static void main(String[]args){

		OppgaveOversikt oversikt = new OppgaveOversikt();
		GodkjenningBGS bgs = new GodkjenningBGS(oversikt);

		String valg = bgs.lesValg();
		while (valg != null){
			bgs.utførValgtOppgave(valg);
			valg = bgs.lesValg();
		}

		System.out.println("\nHer kommer informasjon om alle studentene: \n");
		System.out.println(oversikt);
	}
}