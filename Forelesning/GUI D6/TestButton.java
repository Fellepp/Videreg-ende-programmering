import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends JFrame{
	public MyWindow(){
		// set Title
		setTitle("Mitt første vindu");
		// window size
		setBounds(0,0,400,400);
		// to close the window enda the program
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add button
		JButton myButton = new JButton("Click here free sex");
		add(myButton);
		// make and register button listener
		ButtonListener theListener = new ButtonListener();
		myButton.addActionListener(theListener);
	}
}

class ButtonListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
		System.out.println("Fuck you, go die virginboy");
	}
}

class TestButton{
	public static void main(String[]args){
		MyWindow aWindow = new MyWindow();
		aWindow.setVisible(true);
	}
}