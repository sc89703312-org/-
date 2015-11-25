package edu.nju.express.presentation.financeui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import edu.nju.express.presentation.myUI.MyBackground;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyFrame;
import edu.nju.express.presentation.myUI.MyLabel;

public class Finance_Frame extends MyFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	MyBackground bg;
	MyButton create,cost,balance,accounts,report,exit;
	MyLabel lb_1,lb_2,lb_3,lb_4,lb_5,lb_6;
	
	public Finance_Frame() {
		// TODO Auto-generated constructor stub
		
		
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setLayout(null);
	
	
		
		create = new MyButton(70, 150, 140, 48);
		
		create.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				lb_1.setVisible(false);
				lb_1.setVisible(true);
			}

			public void mouseExited(MouseEvent arg0) {
				lb_1.setVisible(true);
				lb_1.setVisible(false);
			}
		});
	     create.addActionListener(this);
	
	     this.add(create);
	     
	     
	     
	     
	     
	     cost = new MyButton(70, 235, 140, 48);
			
	     cost.addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent arg0) {
					lb_2.setVisible(false);
					lb_2.setVisible(true);
				}

				public void mouseExited(MouseEvent arg0) {
					lb_2.setVisible(true);
					lb_2.setVisible(false);
				}
			});
	       cost.addActionListener(this);
		
		     this.add(cost);
		     
		     
		     balance = new MyButton(70, 320, 140, 48);
				
		     balance.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent arg0) {
						lb_3.setVisible(false);
						lb_3.setVisible(true);
					}

				public void mouseExited(MouseEvent arg0) {
					lb_3.setVisible(true);
					lb_3.setVisible(false);
				}
			});
	     balance.addActionListener(this);
		
		     this.add(balance);
		     
		     
		     
		     
		     accounts = new MyButton(70, 405, 140, 48);
				
		     accounts.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent arg0) {
						lb_4.setVisible(false);
						lb_4.setVisible(true);
					}

					public void mouseExited(MouseEvent arg0) {
						lb_4.setVisible(true);
						lb_4.setVisible(false);
					}
				});
		     accounts.addActionListener(this);
			
			     this.add(accounts);
		     
		     
			     
			     
			     report = new MyButton(70, 500, 140, 48);
					
			     report.addMouseListener(new MouseAdapter() {

						public void mouseEntered(MouseEvent arg0) {
							lb_5.setVisible(false);
							lb_5.setVisible(true);
						}

						public void mouseExited(MouseEvent arg0) {
							lb_5.setVisible(true);
							lb_5.setVisible(false);
						}
					});
			     report.addActionListener(this);
				
				     this.add(report);
	     
	     
			exit = new MyButton(815, 27, 54, 41);
			exit.addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent arg0) {
					lb_6.setVisible(false);
					lb_6.setVisible(true);
				}

				public void mouseExited(MouseEvent arg0) {
					lb_6.setVisible(true);
					lb_6.setVisible(false);
				}
			});
			exit.addActionListener(this);
		
		     this.add(exit);
				     
				     
				     
				     
	     
	     lb_1 = new MyLabel(0, 0, 900, 600);
	     lb_1.setIcon(new ImageIcon("ui/image/finance/back_1.png"));
	     lb_1.setVisible(false);
	     lb_1.setOpaque(false);
		 this.add(lb_1);
		 
		 lb_2 = new MyLabel(0, 0, 900, 600);
	     lb_2.setIcon(new ImageIcon("ui/image/finance/back_2.png"));
	     lb_2.setVisible(false);
	     lb_2.setOpaque(false);
		 this.add(lb_2);
	     
		 
		 lb_3 = new MyLabel(0, 0, 900, 600);
	     lb_3.setIcon(new ImageIcon("ui/image/finance/back_3.png"));
	     lb_3.setVisible(false);
	     lb_3.setOpaque(false);
		 this.add(lb_3);
		 
		 
		 lb_4 = new MyLabel(0, 0, 900, 600);
	     lb_4.setIcon(new ImageIcon("ui/image/finance/back_4.png"));
	     lb_4.setVisible(false);
	     lb_4.setOpaque(false);
		 this.add(lb_4);
	     
		 
		 
		 lb_5 = new MyLabel(0, 0, 900, 600);
	     lb_5.setIcon(new ImageIcon("ui/image/finance/back_5.png"));
	     lb_5.setVisible(false);
	     lb_5.setOpaque(false);
		 this.add(lb_5);
	     
		 lb_6 = new MyLabel(0, 0, 900, 600);
		 lb_6.setIcon(new ImageIcon("ui/image/finance/back_exit.png"));
	     lb_6.setVisible(false);
	     lb_6.setOpaque(false);
		 this.add(lb_6);
		 
		 
		 bg = new MyBackground("ui/image/finance/background.png");
			
			this.add(bg);
			
			
			
			
	     this.setVisible(true);
	     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	     
	     

	     
	}
    
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==exit){
			System.exit(0);
		}
	}

}
