package edu.nju.express.presentation.administratorui;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.nju.express.common.Role;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.vo.UserVO;

public class AddUserUI extends MainPanel {

	private static final long serialVersionUID = 1L;
	private static int width=900,height=600;
	private static int x =94;
	private static Font font = new Font("黑体", Font.PLAIN, 18);
	private Color color = new Color(44, 62,80);
	
	AdministratorController controller;

	LabelTextField id;
	LabelTextField name;
	LabelTextField password;
	JLabel roleLabel;	
	JComboBox<String> roleBox;
	ConfirmButton confirm;
	JPanel p;
	
	

	public AddUserUI(AdministratorController c) {
		controller = c;
		this.setLayout(null);
		this.add(new AdministerGuide(controller));
		this.setOpaque(false);
		initComponents();
	}


	private void initComponents() {
		p = new JPanel();
		p.setOpaque(false);
		p.setLayout(null);
		this.add(p);

		p.setBounds(x, 90, width-x, height-90);
		
		id = new LabelTextField(" ID    ",15);
		id.setBounds(200, 30,400,40);
		p.add(id);
		
		name = new LabelTextField("姓名   ",15);
		name.setBounds(200, 100, 400,40);
		p.add(name);

		JPanel jp = new JPanel();
		jp.setOpaque(false);
		roleLabel = new JLabel("职务    ");
		roleLabel.setForeground(color);
		roleLabel.setFont( font); 
		jp.add(roleLabel);
		roleBox = new MyComboBox<String>();
		for (Role r : Role.values())
			roleBox.addItem(r.getName());
		jp.add(roleBox);
		jp.setBounds(180, 180, 400,40);
		p.add(jp);
		
		password = new LabelTextField("密码   ",15);
		password.setBounds(200, 250, 400,40);
		p.add(password);
		
		confirm = new ConfirmButton();
		confirm.setActionCommand("AddUser");
		confirm.addActionListener(controller);
		this.add(confirm);
	}

	public UserVO getTextInput() {
		return new UserVO(id.getText(), name.getText(), Role.getRole((String) roleBox.getSelectedItem()),
				password.getText());
	}
}
