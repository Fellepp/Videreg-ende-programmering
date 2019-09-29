/*
Interface handler om å lage en kontrakt som flere implementasjoner kan oppfylle uten å avsløre hvordan kontrakten oppfylles.
Samling av metodehoder

Comparator - Sorteringsmetode som fører til total ordning. Kan sortere f.eks
en array ved Arrays.sort. Sammenlikner to objekter, returnerer -1, 1 eller 0

Comparable - Naturlig ordning. Sammenlikningsmetode er compareTo

ActionListener - Lytter til handlinger som utføres av brukeren

ActionPerformed identifiserer og gir informasjon om eventen, som f.eks
e.getActionCommand

Dersom extends fjernes får man feilmeldinger på alle linjene i myWindow-klassen
Uten extends JFrame må vi opprette et objekt av klassen JFrame og skrive f.eks
frame.setTitle("xx");
*/