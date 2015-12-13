package edu.nju.express.presentation.loginui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.nju.express.businesslogic.DataFactory;
import edu.nju.express.businesslogic.login.Login;
import edu.nju.express.common.Role;
import edu.nju.express.io.IO;
import edu.nju.express.log.ui.frame.Frame;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.presentation.administratorui.Administor_Frame;
import edu.nju.express.presentation.clerk_hallui.Hall_Frame;
import edu.nju.express.presentation.clerk_stationui.Station_Frame;
import edu.nju.express.presentation.commodityui.Commodity_Frame;
import edu.nju.express.presentation.financeui.Finance_Frame;
import edu.nju.express.presentation.logisticui.Logistic_Frame;
import edu.nju.express.presentation.managerui.Manager_Frame;
import edu.nju.express.presentation.myUI.MyBackground;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyFrame;
import edu.nju.express.presentation.myUI.MyLabel;
import edu.nju.express.presentation.myUI.MyPasswordField;
import edu.nju.express.presentation.myUI.MyTextFieldV2;
import edu.nju.express.presentation.postmanui.Postman_Frame;

public class LoginUI extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int WIDTH = 900;
	int HEIGHT = 600;
	int BAR_HEIGHT = 40;

	Login loginBL = DataFactory.createLoginBLInstance();

	MyButton login;
	MyButton logistics;
	MyButton errorConfirm;
	MyButton recordPassword;
	String  record = "false";
	String userName;
	String userPassword;

	MyPasswordField passwordField;
	MyTextFieldV2 userNameField;
	MyLabel label_field1, label_field2, label_field3, label_field4, label_field5, label_field6;
	MyLabel recordLabel;
	MyBackground background;

	Image bg;

	ImageIcon exit_icon;

	JLabel exit_label;
	MyButton quit;

	public LoginUI() {
		// TODO Auto-generated constructor stub

		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setLayout(null);

		

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String temp[]=IO.readTxt().split(" ");
		record = temp[0];
		userName = temp[1];
		userPassword = temp[2];
		
		new LoadPictures().start();

	}

	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			if (e.getSource() == login) {
				login();
			} else if (e.getSource() == logistics) {

				LoginUI.this.closeFrame();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new Logistic_Frame();
			}
		}

	}

	private void login() {
		System.out.println(userNameField.getText() + "\n" + passwordField.getText());

		@SuppressWarnings("deprecation")
		Role role = loginBL.login(userNameField.getText(), passwordField.getText());
		
		
		if(role!=null)
			recordPassword();
		
		

		if (role == Role.ACCOUNTANT) {

			LoginUI.this.closeFrame();

			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new Finance_Frame();

		} else if (role == Role.ADMINISTRATOR) {
			LoginUI.this.closeFrame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new Administor_Frame();

		} else if (role == Role.MANAGER) {
			LoginUI.this.closeFrame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new Manager_Frame();
		} else if (role == Role.POSTMAN) {
			LoginUI.this.closeFrame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new Postman_Frame();
		} else if (role == Role.CLERK_HALL) {
			LoginUI.this.closeFrame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			new Hall_Frame();
		} else if (role == Role.CLERK_STATION) {
			LoginUI.this.closeFrame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			new Station_Frame();
		} else if (role == Role.STOREKEEPER) {
			LoginUI.this.closeFrame();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			new Commodity_Frame();
		} else {
			System.out.println("failed");
			label_field5.setVisible(true);

			errorConfirm.setEnabled(true);
			errorConfirm.setVisible(true);

			errorConfirm.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					label_field6.setVisible(false);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					label_field6.setVisible(true);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					label_field5.setVisible(false);
					errorConfirm.setVisible(false);
				}
			});

			LoginUI.this.add(errorConfirm);

		}

	}

	private class LoadPictures extends Thread {

		public void run() {
			bg = new ImageIcon("ui/image/login/login_4.png").getImage();
			exit_icon = new ImageIcon("ui/image/login/exit.png");
			
			
			
			recordLabel = new MyLabel(339, 359, 30, 30);
			recordLabel.setIcon(new ImageIcon("ui/image/login/record.png"));		
			recordLabel.setVisible(false);
			recordLabel.setOpaque(false);
			
			if(record.equals("true"))
				recordLabel.setVisible(true);
			
			LoginUI.this.add(recordLabel);
			
			

			label_field6 = new MyLabel(0, 0, 900, 600);
			label_field6.setIcon(new ImageIcon("ui/image/login/报错_1.png"));
			label_field6.setVisible(false);
			label_field6.setOpaque(false);
			LoginUI.this.add(label_field6);

			label_field5 = new MyLabel(0, 0, 900, 600);
			label_field5.setIcon(new ImageIcon("ui/image/login/报错.png"));
			label_field5.setVisible(false);
			label_field5.setOpaque(false);
			LoginUI.this.add(label_field5);

			errorConfirm = new MyButton(400, 430, 114, 44);
			errorConfirm.setEnabled(false);

			quit = new MyButton(WIDTH - BAR_HEIGHT - 10, 10, BAR_HEIGHT, BAR_HEIGHT);
			quit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});

			// init buttons
			exit_label = new JLabel(exit_icon);
			exit_label.setBounds(WIDTH - BAR_HEIGHT - 10, 10, BAR_HEIGHT, BAR_HEIGHT);

			LoginUI.this.add(quit);
			LoginUI.this.add(exit_label);

			userNameField = new MyTextFieldV2(390, 210, 220, 40);
			LoginUI.this.requestFocusInWindow();
			userNameField.grabFocus();
			userNameField.requestFocus();
			userNameField.requestFocus(true);
			userNameField.requestFocusInWindow();
			
			System.out.println(userNameField.hasFocus());
			userNameField.setFont(new Font("Arail", Font.BOLD, 20));
			userNameField.setForeground(Color.WHITE);
			userNameField.setOpaque(false);
			userNameField.setBorder(BorderFactory.createEmptyBorder());
			userNameField.addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent arg0) {
					label_field1.setVisible(true);
				}

				public void mouseExited(MouseEvent arg0) {
					label_field1.setVisible(false);
				}
			});
			
			if(record.equals("true"))
				userNameField.setText(userName);
			
			
			LoginUI.this.add(userNameField);

			login = new MyButton(487, 341, 130, 40);
			login.addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent arg0) {
					label_field3.setVisible(false);
					label_field3.setVisible(true);
				}

				public void mouseExited(MouseEvent arg0) {
					label_field3.setVisible(true);
					label_field3.setVisible(false);
				}
			});
			login.addActionListener(new btnListener());

			LoginUI.this.add(login);

			logistics = new MyButton(487, 400, 130, 40);
			logistics.addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent arg0) {
					label_field4.setVisible(false);
					label_field4.setVisible(true);
				}

				public void mouseExited(MouseEvent arg0) {
					label_field4.setVisible(true);
					label_field4.setVisible(false);
				}
			});
			logistics.addActionListener(new btnListener());
			LoginUI.this.add(logistics);
			
			
			
			recordPassword = new MyButton(339, 359, 30, 30);
			recordPassword.addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent arg0) {
					
				}

				public void mouseExited(MouseEvent arg0) {
					
				}
				@Override
				public void mouseClicked(MouseEvent arg0){
					if(record.equals("true")){
						record = "false";
						recordLabel.setVisible(false);
					}else {
						record = "true";
						recordLabel.setVisible(true);
					}
					
					
					System.out.println("Current state is: "+record);
				}
				
				
			});
			
			LoginUI.this.add(recordPassword);
			
			
			
			

			passwordField = new MyPasswordField(390, 280, 220, 40);
			passwordField.setFont(new Font("Arail", Font.PLAIN, 20));
			passwordField.setForeground(Color.WHITE);
			passwordField.addMouseListener(new MouseAdapter() {

				public void mouseEntered(MouseEvent arg0) {
					label_field2.setVisible(true);
				}

				public void mouseExited(MouseEvent arg0) {
					label_field2.setVisible(false);
				}
			});
			
			
			if(record.equals("true"))
				passwordField.setText(userPassword);
			
			LoginUI.this.add(passwordField);

			passwordField.addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					System.out.println(12331);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						login();
						System.out.println(213);
					}
				}
			});

			label_field1 = new MyLabel(0, 0, 900, 600);
			label_field1.setIcon(new ImageIcon("ui/image/login/login_6.png"));
			label_field1.setVisible(false);
			label_field1.setOpaque(false);
			LoginUI.this.add(label_field1);

			label_field2 = new MyLabel(0, 0, 900, 600);
			label_field2.setIcon(new ImageIcon("ui/image/login/login_5.png"));
			label_field2.setVisible(false);
			label_field2.setOpaque(false);
			LoginUI.this.add(label_field2);

			label_field3 = new MyLabel(0, 0, 900, 600);
			label_field3.setIcon(new ImageIcon("ui/image/login/login_7.png"));
			label_field3.setVisible(false);
			label_field3.setOpaque(false);
			LoginUI.this.add(label_field3);

			label_field4 = new MyLabel(0, 0, 900, 600);
			label_field4.setIcon(new ImageIcon("ui/image/login/login_8.png"));
			label_field4.setVisible(false);
			label_field4.setOpaque(false);
			LoginUI.this.add(label_field4);

			background = new MyBackground("ui/image/login/login_4.png");

			LoginUI.this.add(background);

		}
	}

	
	
	private void recordPassword(){
		IO.writerTxt(record+" "+LoginInfo.getUserID()+" "+LoginInfo.getUserPassword());
	}
}
