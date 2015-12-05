package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyScrollBarUI;

public class PaymentUI extends JPanel implements MouseListener{

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
	LabelTextField idField, deliverField, moneyField;
	JLabel addOrderLabel;
	JTextArea orderArea;
	JLabel bg;
	JButton exit;
	
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	Color areaColor = new Color(210, 232, 232);
	
	public PaymentUI(HallController controller){
		this.controller = controller;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0,0,width,height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		
		initPanel();
		initMargin();
		
		
		
		bg = new JLabel(new ImageIcon("ui/image/hall/payment.png"));
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
		panel.setLayout(null);
		panel.setBounds(128, 117, 723, 403);
		panel.setVisible(true);
		panel.setOpaque(false);
		
		

		
		dateLabel = new JLabel("装车日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(90, 80-45, 80, 45);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(170, 80-45, 500, 40);
		panel.add(dateBox);
		
		
		
		deliverField = new LabelTextField("收款快递员",19);
		deliverField.setBounds(100, 140-45, 300, 45);
		panel.add(deliverField);
		
		moneyField = new LabelTextField("金额   ",10);
		moneyField.setBounds(120, 200-45, 300, 45);
		panel.add(moneyField);
		
		addOrderLabel = new JLabel("请在此处添加本次收款所有订单号");
		addOrderLabel.setFont(font);
		addOrderLabel.setForeground(color);
		addOrderLabel.setBounds(110, 215, 300, 40);
		panel.add(addOrderLabel);
		
		orderArea = new JTextArea(10,500);
		orderArea.setLineWrap(true);
		orderArea.setWrapStyleWord(true);
		orderArea.setEditable(true);
		orderArea.setFont(font);
		orderArea.setBackground(areaColor);
		final JScrollPane orderpane = new JScrollPane();
		final MyScrollBarUI ui2 = new MyScrollBarUI();
		orderpane.setViewportView(orderArea);
		wrapScrollPane(orderpane, ui2);
		orderpane.setBounds(110, 255, 400, 100);
		panel.add(orderpane);
		
		addOrderBtn = new JButton("add");
		addOrderBtn.setBounds(460, 360, 50, 30);
		addOrderBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		addOrderBtn.addActionListener(controller);
		panel.add(addOrderBtn);
		
		mainpanel.add(panel);
		
	}
	
	
	
	public void initMargin(){
		
		submitBtn = new JButton("提交");
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		mainpanel.add(submitBtn);
		
		exit = new JButton(new ImageIcon("ui/button/X_darkgray.png"));
		exit.setBounds(840, 18, 30, 30);
		exit.setOpaque(false);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		mainpanel.add(exit);
	}
	
	public void wrapScrollPane(final JScrollPane s, final MyScrollBarUI ui){
		s.setOpaque(false);
		s.getViewport().setOpaque(false);
		s.getVerticalScrollBar().setUI(ui);
		s.getVerticalScrollBar().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e) {
				super.mouseEntered(e);
				s.getVerticalScrollBar().repaint();
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				s.getVerticalScrollBar().repaint();
				
			}
		});
		
		s.setBorder(new EmptyBorder(0, 0, 0, 0));
		s.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		s.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		s.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
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
