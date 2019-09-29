import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

class MyWindow extends JFrame{
	private JButton myButton = new JButton("Sans Serif");
	private JButton myButton2 = new JButton("Serif");
	private JButton myButton3 = new JButton("Monospaced");
	private JButton myButton4 = new JButton("Dialog");
	private JLabel myLabel = new JLabel("Trykk for å forandre font");

	public MyWindow(){
		setTitle("Skrifttyper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1));
		add(myLabel);
		add(myButton);
		add(myButton2);
		add(myButton3);
		add(myButton4);
		pack();
		ButtonListener theListener = new ButtonListener();

		myButton.addActionListener(theListener);
		myButton.setActionCommand("button1Command");

		myButton2.addActionListener(theListener);
		myButton2.setActionCommand("button2Command");

		myButton3.addActionListener(theListener);
		myButton3.setActionCommand("button3Command");

		myButton4.addActionListener(theListener);
		myButton4.setActionCommand("button4Command");
	}

	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String action = e.getActionCommand();
			if(action.equals("button1Command")){
				myLabel.setFont(new Font("SansSerif", Font.PLAIN, 50));
			}else if(action.equals("button2Command")){
				myLabel.setFont(new Font("Serif", Font.PLAIN, 50));
			}else if(action.equals("button3Command")){
				myLabel.setFont(new Font("Monospaced", Font.PLAIN, 50));
			}else{
				myLabel.setFont(new Font("Dialog", Font.PLAIN, 10));
			}
		}
	}
}

class Oppgave1{
	public static void main(String[]args){
		MyWindow aWindow = new MyWindow();
		aWindow.setVisible(true);
	}
}