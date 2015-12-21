package edu.nju.express.presentation.postmanui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.NumberValidation;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.ReceivalVO;

public class ConfirmReceivalUI extends MainPanel{
	private static final long serialVersionUID = 1L;
	private static final Image bg = new ImageIcon("ui/image/postman/确认收货.png").getImage();
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
		
		PostmanGuide guide = new PostmanGuide(c);
		this.add(guide);
		guide.confirmReceival.setIcon(null);
		
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
		time.setBounds(200,240,400,50);
		p.add(time);

		confirm = new ConfirmButton();
		confirm.setActionCommand("ConfirmReceival");
		confirm.addActionListener(controller);
		this.add(confirm);
	}


	public ReceivalVO getTextInput() {
		if(id.getText().equals("")||id.getText().length()!=10||!NumberValidation.isNumeric(id.getText())){
			id.setError();
			return null;
		}
		return new ReceivalVO(id.getText(), date.getDate(), name.getText());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}