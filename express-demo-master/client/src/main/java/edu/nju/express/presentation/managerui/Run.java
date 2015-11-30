package edu.nju.express.presentation.managerui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Run {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		f.setSize(900, 600);
        f.setLocationRelativeTo(null);
        f.setUndecorated(true);
   
        JPanel p = null;
        p = new ReceiptApprovalUI(new ManageController(f));
        f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
