import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JOptionPane.*;

class ListeboksVindu extends JFrame{
	private Valuta[] valutaliste = {
		new Valuta("Euro", 8.10, 1),
		new Valuta("US Dollar", 6.23, 1),
    	new Valuta("Britiske pund", 12.27, 1),
    	new Valuta("Svenske kroner", 88.96, 100),
   		new Valuta("Danske kroner", 108.75, 100),
   		new Valuta("Yen", 5.14, 100),
   		new Valuta("Islandske kroner", 9.16, 100),
   		new Valuta("Norske kroner", 100, 100)
	};

	private ArrayList<Valuta> liste = new ArrayList<Valuta>();
	private DefaultListModel listeinnhold = new DefaultListModel();
	private JList fraValutaListe = new JList(listeinnhold);
	private JList tilValutaListe = new JList(listeinnhold);

	private JLabel ledetekst = new JLabel("Velg fravaluta og tilvaluta fra listene: ");
	private JLabel beløplabel = new JLabel("Beløp: ");
	private JTextField tekst = new JTextField(15);
	private JTextField beløpTekst = new JTextField(10);
	private JButton beregne = new JButton("Beregn");

	public ListeboksVindu(String tittel){
		getListe();
		leggTilListe();
		setTitle(tittel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		//Paneler for orden
		Panel fraValutaPanel = new Panel(new BorderLayout());
		Panel tilValutaPanel = new Panel(new BorderLayout());
		Panel beløpPanel = new Panel(new FlowLayout());

		//Adder alt i nedre panel
		beløpPanel.add(beløplabel);
		beløpPanel.add(beløpTekst);
		beløpPanel.add(beregne);

		//Legger til ledetekster i de forskjellige panelene
		JLabel ledetekstFra = new JLabel("Fravaluta: ");
		JLabel ledetekstTil = new JLabel("Tilvaluta: ");

		add(ledetekst, BorderLayout.NORTH);
		tilValutaPanel.add(ledetekstTil, BorderLayout.NORTH);
		fraValutaPanel.add(ledetekstFra, BorderLayout.NORTH);

		//Skrollbar for de to valutalistene
		JScrollPane fraValutaSkroll = new JScrollPane(fraValutaListe);
		fraValutaPanel.add(fraValutaSkroll, BorderLayout.CENTER);

		JScrollPane tilValutaSkroll = new JScrollPane(tilValutaListe);
		tilValutaPanel.add(tilValutaSkroll, BorderLayout.CENTER);

		add(fraValutaPanel);
		add(tilValutaPanel);
		add(beløpPanel);

		ListeboksLytter listener = new ListeboksLytter();
		fraValutaListe.addListSelectionListener(listener);
		tilValutaListe.addListSelectionListener(listener);
		ButtonListener knappelytter = new ButtonListener();
		beregne.addActionListener(knappelytter);

		pack();
	}

	public void getListe(){
		liste.add(new Valuta("Ny valuta", 1, 1));
		for(int i = 0; i<valutaliste.length; i++){
			liste.add(valutaliste[i]);
		}
	}

	public void leggTilListe(){
		for(int i = 0; i < liste.size(); i++){
			listeinnhold.addElement(liste.get(i).getNavn());
		}
	}

	public double beregn(Valuta fraValuta, Valuta tilValuta, double beløp){
		return beløp * (fraValuta.getKurs()/fraValuta.getEnhet()) / (tilValuta.getKurs() / tilValuta.getEnhet());
	}

	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent hendelse){
			Valuta fraValuta = liste.get(fraValutaListe.getSelectedIndex());
			Valuta tilValuta = liste.get(tilValutaListe.getSelectedIndex());
			double beløp = Double.parseDouble(beløpTekst.getText());
			double beregnet = beregn(fraValuta, tilValuta, beløp);
			DecimalFormat desimal = new DecimalFormat("0.00");
			String formatert = desimal.format(beregnet);
			showMessageDialog(ListeboksVindu.this, beløp + " " + fraValuta.getNavn() + " er " + formatert + " " + tilValuta.getNavn());
		}
	}

	class ListeboksLytter implements ListSelectionListener{
		public void valueChanged(ListSelectionEvent event){
			int fraValg = fraValutaListe.getSelectedIndex();
			int tilValg = tilValutaListe.getSelectedIndex();
			if(fraValg == 0 || tilValg == 0){
				Valuta nyValuta = new Valuta(showInputDialog("Skriv inn valutatype"), Double.parseDouble(showInputDialog("Skriv inn kurs")), Integer.parseInt(showInputDialog("Skriv inn enhet(1 eller 100)")));
				listeinnhold.addElement(nyValuta.getNavn());
				liste.add(nyValuta);
			}
		}
	}
}

class Valuta{
	String valutanavn;
	double kurs;
	int enhet;

	public Valuta(String valutanavn, double kurs, int enhet){
		this.valutanavn = valutanavn;
		this.kurs = kurs;
		this.enhet = enhet;
	}

	public String getNavn(){
		return valutanavn;
	}

	public double getKurs(){
		return kurs;
	}

	public int getEnhet(){
		return enhet;
	}
}

class Øving6{
	public static void main(String[]args){
		ListeboksVindu listeboksVindu = new ListeboksVindu("Valutakalkulator");
		listeboksVindu.setSize(300,270);
		listeboksVindu.setResizable(false);
		listeboksVindu.setVisible(true);
	}
}