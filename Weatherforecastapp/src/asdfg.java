import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class asdfg {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          JFrame frame = new JFrame("weather forecast app");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(400, 600);
         frame.setLayout(new FlowLayout());
      
		  
          JTextField LocationField = new JTextField(15);
          JButton fetchButton = new JButton("fetch weather");
          JTextArea weatherdisplay = new JTextArea(10,30);
         weatherdisplay.setEditable(false);
         frame.add(new JLabel("enter the city name"));
	}
}


