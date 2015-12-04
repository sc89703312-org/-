package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyTextField;

public class HallDeliverUI extends JPanel implements MouseListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	HallController controller;
	JPanel mainpanel;
	
	JButton addOrderBtn;
	JButton submitBtn;
	JLabel dateLabel;
	DateComboBoxPanel dateBox;
	LabelTextField idField, deliverIdField;
	JTextArea orderArea;
	JLabel bg;
	
	public HallDeliverUI(HallController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setLayout(null);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		initPanel();
//		initOrderContainer();
//		initMargin();
		JButton exit = new JButton(new ImageIcon("ui/button/X_darkgray.png"));
		exit.setBounds(840, 18, 30, 30);
		exit.setOpaque(false);
		exit.setBorderPainted(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		mainpanel.add(exit);
		bg = new JLabel(new ImageIcon("ui/image/hall/deliver.png"));
		bg.setBounds(0, 0, width, height);
		mainpanel.add(bg);
		this.add(mainpanel);
		this.add(new HallGuide(controller));
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
		
	}
	
	public void initPanel(){
		JPanel panel = new JPanel();
		
		Font font = new Font("黑体", Font.PLAIN, 18);
		Color color = new Color(44, 62,80);
		
		idField = new LabelTextField("派件单编号",15);
		idField.setBounds(120, 20, 300, 45);
		panel.add(idField);

		dateLabel = new JLabel("装车日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(90, 80, 80, 45);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(170, 80, 500, 40);
		panel.add(dateBox);
		
		
		deliverIdField = new LabelTextField("派送员  ",19);
		deliverIdField.setBounds(120, 135, 300, 45);
		panel.add(deliverIdField);
		
		
		panel.setLayout(null);
		panel.setBounds(128, 117, 723, 403);
		panel.setVisible(true);
		panel.setOpaque(false);
		mainpanel.add(panel);
	}
	
	public void initOrderContainer(){
		JPanel panel = new JPanel();
		
		orderArea = new JTextArea(10,100);
		orderArea.setLineWrap(true);
		orderArea.setWrapStyleWord(true);
		orderArea.setEditable(true);
		orderArea.setBackground(Color.DARK_GRAY);
		orderArea.setForeground(Color.white);
		JScrollPane qScroller = new JScrollPane(orderArea);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		qScroller.setBounds(30, 30, 250, 250);
		
		addOrderBtn = new JButton("add");
		addOrderBtn.setBounds(230, 300, 50, 30);
		addOrderBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		addOrderBtn.addActionListener(controller);
		
		panel.add(qScroller);
		panel.add(addOrderBtn);
		
		panel.setLayout(null);
		panel.setBounds(540, 50, 330, 450);
		panel.setVisible(true);
		panel.setOpaque(false);
		mainpanel.add(panel);
	}
	
	public void initMargin(){
		JPanel panel = new JPanel();
		
		
		submitBtn = new JButton(new ImageIcon("ui/image/hall/submit1.png"));
		submitBtn.setBounds(50, 510, 90, 30);
		submitBtn.setOpaque(false);
		submitBtn.setBorderPainted(false);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(controller);
		panel.add(submitBtn);
		
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(0, 0, width, height);
		panel.setVisible(true);
		mainpanel.add(panel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
