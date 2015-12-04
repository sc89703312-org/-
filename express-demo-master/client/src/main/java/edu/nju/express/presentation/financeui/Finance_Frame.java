package edu.nju.express.presentation.financeui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.nju.express.presentation.myUI.MyBackground;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyFrame;
import edu.nju.express.presentation.myUI.MyLabel;

public class Finance_Frame extends MyFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Finance_Frame() {
		// TODO Auto-generated constructor stub
	
		this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
   
        JPanel p = null;
        p = new PaymentUI(new FinanceController(this));
        this.add(p);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
