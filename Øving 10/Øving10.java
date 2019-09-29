/*
Oppgave 1)
a)
Tabellen er p� 1NF. Dette er fordi prim�rn�kkelen best�r av Ssn og Kursid,
men kursnavn avhenger bare av Kursid, alts� en del av prim�rn�kkelen

b)
For hver person som m� legges inn, m� den tildeles et kurs fordi
kursid ikke kan v�re null. I tillegg kan informasjon bli registrert flere steder (dobbeltlagring eller redundans).
Kan ogs� f� selvmotsigende (inkonsistenser) ved endring, fjerning eller ny data.
Det kan v�re ineffektivt (ikke n�dvendigvis kjappere) � bruke databasen om den ikke er normalisert

c)
2NF - Deler opp tabellen i en tabell for student, en for kurs og en for relasjonen mellom dem
STUD(_Ssn_*, navn, adresse, studieretning)
KURS(_Kursid_*, kursnavn, eksdato, klassenavn)
STUD_KURS(_Ssn_, _Kursid_)

3NF - Deler opp tabellen for � unng� transitiv determinering
STUD(_Ssn_*, navn, adresse)
KURS(_Kursid_*, kursnavn, eksdato)
Klasse(_klassenavn_*, studieretning)
STUD_KURS(_Ssn_*,_Kursid_)
STUD_KLASSE(_Ssn_,_klassenavn_)

BCNF - Alle krav ser ut til � v�re oppfylt

Oppgave 2)

kunde_id, eier_id, eiendoms_id
Kundedata: navn, adresse, telefon
Data om eiendom: adresse
Data om eier: navn, adresse, telefon
Data om utleieforhold: fra og med uke, til og med uke, pris pr uke

Tabell(kunde_id, eier_id, eiendoms_id, navn, adresse, telefon,
adresse, navn, adresse, telefon, fra og med uke, til og med uke, pris pr uke)

Kandidatn�kler: kundetelefon, eiendomadresse, kundeid, eiendomid

Dersom en attributt blir slettet, slettes hele raden i tabellen.
Dersom en eiendom blir registrert m� den tildeles en kunde og en eier, fordi
eierid og eiendomid kan ikke v�re null, dette er prim�rn�kler

Eiendom(_eiendomsid_, eiendomsadresse, eierid*)
Eier(_eierid_, navn, adresse, tlf)
Eierskap(_eiendomsid*,FraUke_, TilUke, PrisPrUke, kundeid*)
Kunde(_kundeid_, navn, adresse, tlf)

*/