package edu.nju.express.presentation.UserUI;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Run {

	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		f.setSize(900, 600);
        f.setLocationRelativeTo(null);
  //      f.setUndecorated(true);
   
        JPanel p = null;
        p = new AddUserPanel(new UserController( f));
        f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
