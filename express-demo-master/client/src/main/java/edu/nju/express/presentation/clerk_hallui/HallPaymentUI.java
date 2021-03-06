package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

import edu.nju.express.blservice.Paymentblservice;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyScrollBarUI;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.Paymentvo;

public class HallPaymentUI extends MainPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width = 900;
	int height = 600;
	HallController controller;
	Paymentblservice payment;
	JPanel mainpanel;
	
	JButton addOrderBtn;
	ConfirmButton submitBtn;
	JLabel dateLabel;
	DateComboBoxPanel dateBox;
	LabelTextField deliverField, moneyField, orderField;
	boolean deliverErr, orderErr;
	JLabel addOrderLabel;
	JTextArea orderArea;
	Image bg = (new ImageIcon("ui/image/hall/payment.png")).getImage();
	
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	Color areaColor = new Color(210, 232, 232);
	
	public HallPaymentUI(HallController controller){
		this.controller = controller;
		this.payment = controller.payment;
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0,0,width,height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		
		initPanel();
		initMargin();
		
		
		
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
		
		

		
		dateLabel = new JLabel("收款日期");
		dateLabel.setFont(font);
		dateLabel.setForeground(color);
		dateLabel.setBounds(125, 80-45, 80, 45);
		panel.add(dateLabel);
		
		dateBox = new DateComboBoxPanel();
		dateBox.setBounds(115, 80-45, 500, 40);
		panel.add(dateBox);
		
		
		
		deliverField = new LabelTextField("收款快递员编号",19);
		deliverField.setBounds(35, 140-45, 400, 45);
		panel.add(deliverField);
		
		moneyField = new LabelTextField("金额   ",10);
		moneyField.setBounds(120, 200-45, 300, 45);
		panel.add(moneyField);
		
		orderField = new LabelTextField("订单号", 10);
		orderField.setBounds(120, 215, 300, 45);
		panel.add(orderField);
		
		
		mainpanel.add(panel);
		
	}
	
	public void clearPanel(){
		dateBox.setToday();
		deliverField.setText("");
		moneyField.setText("");
		orderField.setText("");
		
	}
	
	public void initMargin(){
		
		submitBtn = new ConfirmButton();
		submitBtn.setBounds(424, 523, 100, 40);
		submitBtn.addMouseListener(this);
		submitBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isFilled()){
					WarningDialog.show("提交内容不能为空", "请检查填写是否齐全");
				}
				else if(!isError()){
					if(!deliverErr){
						deliverField.setError();
					}
					if(!orderErr){
						orderField.setError();
					}
					WarningDialog.show("数据格式错误", "");
				}
				else{
					submitPayment(new Paymentvo(dateBox.getDate(), Double.parseDouble(moneyField.getText()),
							deliverField.getText(),orderField.getText(),"sc925200"));
					WarningDialog.show("", "提交成功！");
					clearPanel();
				}
			}
			
		});
		mainpanel.add(submitBtn);
		
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
	
	public ResultMessage submitPayment(Paymentvo vo){
		return payment.createReceipt(vo);
	}
	
	public boolean isFilled(){
		boolean deliver = (deliverField.getText().trim().length()==0)?false:true;
		boolean order = (orderField.getText().trim().length()==0)?false:true;
		boolean money = (moneyField.getText().trim().length()==0)?false:true;
				
		return deliver && order && money;
	}
	
	public boolean isError(){
		deliverErr = (deliverField.getText().trim().length()==8) ? true : false;
		orderErr = (orderField.getText().trim().length()==10) ? true : false;
		return deliverErr && orderErr;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
