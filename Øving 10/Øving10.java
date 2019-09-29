/*
Oppgave 1)
a)
Tabellen er på 1NF. Dette er fordi primærnøkkelen består av Ssn og Kursid,
men kursnavn avhenger bare av Kursid, altså en del av primærnøkkelen

b)
For hver person som må legges inn, må den tildeles et kurs fordi
kursid ikke kan være null. I tillegg kan informasjon bli registrert flere steder (dobbeltlagring eller redundans).
Kan også få selvmotsigende (inkonsistenser) ved endring, fjerning eller ny data.
Det kan være ineffektivt (ikke nødvendigvis kjappere) å bruke databasen om den ikke er normalisert

c)
2NF - Deler opp tabellen i en tabell for student, en for kurs og en for relasjonen mellom dem
STUD(_Ssn_*, navn, adresse, studieretning)
KURS(_Kursid_*, kursnavn, eksdato, klassenavn)
STUD_KURS(_Ssn_, _Kursid_)

3NF - Deler opp tabellen for å unngå transitiv determinering
STUD(_Ssn_*, navn, adresse)
KURS(_Kursid_*, kursnavn, eksdato)
Klasse(_klassenavn_*, studieretning)
STUD_KURS(_Ssn_*,_Kursid_)
STUD_KLASSE(_Ssn_,_klassenavn_)

BCNF - Alle krav ser ut til å være oppfylt

Oppgave 2)

kunde_id, eier_id, eiendoms_id
Kundedata: navn, adresse, telefon
Data om eiendom: adresse
Data om eier: navn, adresse, telefon
Data om utleieforhold: fra og med uke, til og med uke, pris pr uke

Tabell(kunde_id, eier_id, eiendoms_id, navn, adresse, telefon,
adresse, navn, adresse, telefon, fra og med uke, til og med uke, pris pr uke)

Kandidatnøkler: kundetelefon, eiendomadresse, kundeid, eiendomid

Dersom en attributt blir slettet, slettes hele raden i tabellen.
Dersom en eiendom blir registrert må den tildeles en kunde og en eier, fordi
eierid og eiendomid kan ikke være null, dette er primærnøkler

Eiendom(_eiendomsid_, eiendomsadresse, eierid*)
Eier(_eierid_, navn, adresse, tlf)
Eierskap(_eiendomsid*,FraUke_, TilUke, PrisPrUke, kundeid*)
Kunde(_kundeid_, navn, adresse, tlf)

*/