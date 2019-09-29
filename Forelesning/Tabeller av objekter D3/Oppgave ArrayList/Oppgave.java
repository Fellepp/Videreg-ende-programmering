/*
I hele oppgaven skal du vedlikeholde en figur som viser objektene som blir laget og sammenhengen mellom dem
Opprett tre studentobjekter; Kåre, Anders og Tove. Etternavn og fødselsdato bestemmer du selv
Lag ArrayListen studenter og legg objektene inn i den
Lag ArrayListen studenter2 og legg objektene inn i den også
Prøv deg fram med endringer av objektene
Hent ut objekt fra en av ArrayListene og endre det
Prøv flere ArrayList-metoder
remove()
set()
*/

import java.util.ArrayList;
import javax.swing.JOptionPane.*;

class Oppgave{
	public static void main(String[]args){
		Student s1 = new Student("Kåre", "Olsen", 19951012);
		Student s2 = new Student("Anders", "Bø", 19950512);
		Student s3 = new Student("Tove", "Jensen", 19940123);
		ArrayList<Student> stud = new ArrayList<Student>();
		stud.add(s1);
		stud.add(s2);
		stud.add(s3);

		for(int i = 0; i < stud.size(); i++){
			System.out.println(stud.get(i).toString());
		}
		System.out.println();
		s2.setFornavn("Arve");

		ArrayList<Student> stud2 = new ArrayList<Student>();
		stud2.add(s1);
		stud2.add(s2);
		stud2.add(s3);
		Student s = stud.get(2);
		s.setFornavn("Inger");
		for(int i = 0; i < stud2.size(); i++){
			System.out.println(stud2.get(i).toString());
		}

		/* Kortversjonen av for-løkka, veldig grei for ArrayList
		for(Student s: stud2){
			System.out.println(s.toString());
		}
		*/


	}
}