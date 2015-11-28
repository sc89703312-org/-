package edu.nju.express.presentation.postmanui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.ReceivalVO;
import edu.nju.express.vo.UserMessageVO;

public class ConfirmReceivalUI extends MainPanel{
	private static final long serialVersionUID = 1L;
	static int width=900,height=600;
	static int y=50;

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
		
		initComponents();
	}

	private void initComponents() {
		p = new JPanel();
		this.add(p);
		p.setLayout(null);
		p.setOpaque(false);
		p.setBounds(0, y,  width, height);

		jbtReturn = new ReturnButton();
		jbtReturn.setActionCommand("PostmanMainUI");
		jbtReturn.addActionListener(controller);
		p.add(jbtReturn);

		id = new LabelTextField("收件编号",12);
		id.setBounds((width-350)/2, 90,350,40);
		p.add(id);
		
		name = new LabelTextField("收件人  ",12);
		name.setBounds((width-350)/2, 160, 350,40);
		p.add(name);

		time = new JPanel();
		time.setOpaque(false);
		JLabel timeLabel = new JLabel("收件日期");
		timeLabel.setForeground(Color.white);
		timeLabel.setFont( new Font("黑体", Font.PLAIN, 16)); 
		time.add(timeLabel);
		
		date= new DateComboBoxPanel();
		time.add(date);
		time.setBounds((width-350)/2, 230, 350,40);
		p.add(time);

		confirm = new ConfirmButton();
		confirm.setLocation((width-confirm.getWidth())/2, 320);
		confirm.setActionCommand("ConfirmReceival");
		confirm.addActionListener(controller);
		p.add(confirm);
	}


	public ReceivalVO getTextInput() {
		return new ReceivalVO(id.getText(), date.getDate(), name.getText());
	}
}