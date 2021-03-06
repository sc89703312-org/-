package edu.nju.express.presentation.managerui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyFrame;

public class Run {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
		
		f.setBackground(new Color(0, 0, 0,0));
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
