import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{
	// it is common to have GUI-components as object variables
	private JButton myButton = new JButton("Trykk her!");

	public MyWindow(){
		// set Title
		setTitle("Mitt første vindu");
		// window size
		setBounds(0,0,400,400);
		// to close the window enda the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add button
		add(myButton);
		// make and register button listener
		ButtonListener theListener = new ButtonListener();
		myButton.addActionListener(theListener);
	}
}

class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent theEvent){
		// find the button that was clicked
		JButton theButton = (JButton) theEvent.getSource();
		// find its color
		Color myColor = theButton.getForeground();
		// change the color
		if (myColor.equals(Color.RED)){
			// change to blue
			theButton.setForeground(Color.BLUE);
		}else{
			// change to red
			theButton.setForeground(Color.RED);
		}
		System.out.println("Du trykket på knappen");
	}
}

class Oppgave1{
	public static void main(String[]args){
		MyWindow aWindow = new MyWindow();
		aWindow.setVisible(true);
	}
}