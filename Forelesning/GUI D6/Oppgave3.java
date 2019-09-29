import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{
	// it is common to have GUI-components as object variables
	private JButton myButton = new JButton("Trykk her!");
	private JLabel myLabel = new JLabel("Foreløpig tomt");
	private JTextField myTextField = new JTextField(20);

	public MyWindow(){
		// set Title
		setTitle("Mitt første vindu");
		// window size
	//	setBounds(0,0,400,400);
		// to close the window enda the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add layout manager
		LayoutManager layout= new FlowLayout();
		setLayout(layout);
		// add components
		add(myButton);
		add(myLabel);
		add(myTextField);
		pack();
		// make and register button listener
		ButtonListener theListener = new ButtonListener();
		myButton.addActionListener(theListener);
	}


	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent theEvent){
			String text = myTextField.getText();
			text = text.toUpperCase();
			myLabel.setText(text);
			System.out.println("Du trykket på knappen");
		}
	}
}

class Oppgave3{
	public static void main(String[]args){
		MyWindow aWindow = new MyWindow();
		aWindow.setVisible(true);
	}
}