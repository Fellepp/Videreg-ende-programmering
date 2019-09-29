import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

class MyWindow extends JFrame{
	private JButton myButton = new JButton("Til SEK");
	private JButton myButton2 = new JButton("Til NOK");
	private JLabel myLabel = new JLabel("Beløp:");
	private JLabel myLabel2 = new JLabel("Resultatet av omregningen kommer her");
	private JTextField myTextField = new JTextField(10);

	public MyWindow(){
		setTitle("Skrifttyper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//FlowLayout med buttons
		Panel knapper = new Panel(new FlowLayout());
		knapper.add(myButton);
		knapper.add(myButton2);
		//FlowLayouts med beløp + tekstfelt
		Panel beløp = new Panel(new FlowLayout());
		beløp.add(myLabel);
		beløp.add(myTextField);
		//FlowLayouts med label2
		Panel sentrum = new Panel(new FlowLayout());
		sentrum.add(myLabel2);

		setLayout(new GridLayout(0,1,0,0));
		//setLayout(new BorderLayout());

		add(beløp, BorderLayout.NORTH);
		add(sentrum, BorderLayout.CENTER);
		add(knapper, BorderLayout.SOUTH);
		pack();
		ButtonListener theListener = new ButtonListener();
		myButton.addActionListener(theListener);
		myButton2.addActionListener(theListener);
	}

	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double tall = 0;

			Object source = e.getSource();
			if(source == myButton){
				try{
					tall = Double.parseDouble(myTextField.getText());
					double val = tall*1.061;
					double roundOff = (double)Math.round(val * 100) / 100;
					String totalt1 = String.valueOf(roundOff);
					myLabel2.setText(tall + " NOK =  " + totalt1 + " SEK");
				}catch(NumberFormatException feil){
					myLabel2.setText("Ugyldig input");
				}
			}
			else if(source == myButton2){
				try{
					tall = Double.parseDouble(myTextField.getText());
					double val = tall*0.942;
					double roundOff = (double)Math.round(val * 100) / 100;
					String totalt2 = String.valueOf(roundOff);
					myLabel2.setText(tall + " SEK  =  " + totalt2 + " NOK");
				}catch(NumberFormatException feil){
					myLabel2.setText("Ugyldig input");
				}
			}
		}
	}
}

class Oppgave2{
	public static void main(String[]args){
		MyWindow aWindow = new MyWindow();
		aWindow.setSize(300,150);
		aWindow.setResizable(false);
		aWindow.setVisible(true);
	}
}