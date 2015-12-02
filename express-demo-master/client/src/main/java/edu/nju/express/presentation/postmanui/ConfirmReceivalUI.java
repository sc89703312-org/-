package edu.nju.express.presentation.postmanui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.ReceivalVO;

public class ConfirmReceivalUI extends MainPanel{
	private static final long serialVersionUID = 1L;
	private static int width=900,height=600;
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	private static Color color = new Color(44, 62,80);

	PostmanController controller;
	
	JPanel p;
	ConfirmButton confirm;
	ReturnButton jbtReturn;
	LabelTextField id;
	LabelTextField name;
	JPanel time;
	DateComboBoxPanel date;
	
	public ConfirmReceivalUI(PostmanController c) {
		controller = c;
		
		this.add(new PostmanGuide(c));
		
		initComponents();
	}

	private void initComponents() {
		p = new JPanel();
		this.add(p);
		p.setLayout(null);
		p.setOpaque(false);
		p.setBounds(94, 112,  width-94, height-112);


		id = new LabelTextField("收件编号",12);
		id.setBounds(200, 60,400,40);
		p.add(id);
		
		name = new LabelTextField("收件人  ",12);
		name.setBounds(200, 150, 400,40);
		p.add(name);

		time = new JPanel();
		time.setOpaque(false);
		JLabel timeLabel = new JLabel("收件日期");
		timeLabel.setForeground(color);
		timeLabel.setFont(font); 
		time.add(timeLabel);
		
		date= new DateComboBoxPanel();
		time.add(date);
		time.setBounds(200,240,400,40);
		p.add(time);

		confirm = new ConfirmButton();
		confirm.setActionCommand("ConfirmReceival");
		confirm.addActionListener(controller);
		this.add(confirm);
	}


	public ReceivalVO getTextInput() {
		return new ReceivalVO(id.getText(), date.getDate(), name.getText());
	}
}