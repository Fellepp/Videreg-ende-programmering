/*
Grafiske brukergrensesnitt bruker visualiseringer av fysiske objekter (som for eksempel knapper) for å la oss samhandle med programmer
Vi kaller dette metaforer. En av de viktigste er vinduet
Hva kan være alternativer til GUIer?

Et GUI styres i samarbeid mellom OSet (som har kontakt med I/O-enheter og styrer skjermen) og programmet
Brukeren gjør ting som fører til at programmets tilstand og gjerne også skjermbildet endrer seg
Dette skjer ved at OSet varsler programmet om hendelser som brukeren skaper
Før styrte vi brukeren, nå tar brukeren kontrollen, og programmet må være mer robust:
	Vi må håndtere at brukeren har mange valg i enhver situasjon, og respondere riktig på alle
	Vi må godta at ting gjøres i andre rekkefølger enn vi kanskje hadde ønsket oss
	Vi må forstå at brukere er veldig forskjellig, og tolker et gitt GUI forskjellig og derfor tenke nøye gjennom hvordan vi lager det
Det å lage gode GUIer er et stort fagfelt, som vi vil komme tilbake til i Systemutvikling 2

I Java gjøres dette ved hjelp av lyttere
Lyttere er objekter som knyttes til et GUI-komponent, og varsler Java-tolkeren når noe skjer med objektet:
	En knapp trykkes på, holdes nede, er aktiv eller ikke aktiv
	Et vindu tegnes, lukkes, endres størrelse på, gis eller fratas fokus
	Et tekstfelt skrives i, gis fokus, mister fokus
	Osv.
Vi programmerer lytteren og velger hvilke hendelser den skal reagere på. Alle andre hendelser ignoreres (av programmet)

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{
	public MyWindow(){
		//set Title
		setTitle("Mitt første vindu");
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









