/*
Grafiske brukergrensesnitt bruker visualiseringer av fysiske objekter (som for eksempel knapper) for � la oss samhandle med programmer
Vi kaller dette metaforer. En av de viktigste er vinduet
Hva kan v�re alternativer til GUIer?

Et GUI styres i samarbeid mellom OSet (som har kontakt med I/O-enheter og styrer skjermen) og programmet
Brukeren gj�r ting som f�rer til at programmets tilstand og gjerne ogs� skjermbildet endrer seg
Dette skjer ved at OSet varsler programmet om hendelser som brukeren skaper
F�r styrte vi brukeren, n� tar brukeren kontrollen, og programmet m� v�re mer robust:
	Vi m� h�ndtere at brukeren har mange valg i enhver situasjon, og respondere riktig p� alle
	Vi m� godta at ting gj�res i andre rekkef�lger enn vi kanskje hadde �nsket oss
	Vi m� forst� at brukere er veldig forskjellig, og tolker et gitt GUI forskjellig og derfor tenke n�ye gjennom hvordan vi lager det
Det � lage gode GUIer er et stort fagfelt, som vi vil komme tilbake til i Systemutvikling 2

I Java gj�res dette ved hjelp av lyttere
Lyttere er objekter som knyttes til et GUI-komponent, og varsler Java-tolkeren n�r noe skjer med objektet:
	En knapp trykkes p�, holdes nede, er aktiv eller ikke aktiv
	Et vindu tegnes, lukkes, endres st�rrelse p�, gis eller fratas fokus
	Et tekstfelt skrives i, gis fokus, mister fokus
	Osv.
Vi programmerer lytteren og velger hvilke hendelser den skal reagere p�. Alle andre hendelser ignoreres (av programmet)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{
	public MyWindow(){
		//set Title
		setTitle("Mitt f�rste vindu");
		// to close the window enda the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class TestButton{
	public static void main(String[]args){
		MyWindow aWindow = new MyWindow();
		aWindow.setVisible(true);
	}
}

*/









