import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

class ArrayListAvNavn{
	public static void main(String[] args){
		ArrayList<String> navnene = new ArrayList<String>();
		String navn = showInputDialog("Oppgi navn");
		while(navn != null){
			navn = navn.trim();
			navnene.add(navn); //add er en metode i ArrayList
			navn = showInputDialog("Oppgi navn");
		}
		//Henter ut å skriver ut alle navnene
		for(int i = 0; i < navnene.size()
		; i++){
			String detteNavnet = navnene.get(i);
			System.out.println(detteNavnet);
		}
	}
}