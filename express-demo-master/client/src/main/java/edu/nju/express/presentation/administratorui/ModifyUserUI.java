package edu.nju.express.presentation.administratorui;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import edu.nju.express.common.Role;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.vo.UserVO;

public class ModifyUserUI extends MainPanel {

	private static final long serialVersionUID = 1L;
	private static int width=900,height=600;
	private static int y = 50;		//由标题栏高度决定
	private static int x =240;
	private static Font font = new Font("黑体", Font.PLAIN, 16);
	
	AdministratorController controller;

	LabelTextField id;
	LabelTextField name;
	LabelTextField password;
	JLabel roleLabel;	
	JComboBox<String> roleBox;
	JButton confirm;
	JPanel p;
	
	

	public ModifyUserUI(AdministratorController c) {
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

		p.setBounds(x, y+30, width-x, height-y-30);
		
		id = new LabelTextField(" ID   ",15);
		id.setBounds((width-x-350)/2, 30,350,40);
		p.add(id);
		
		name = new LabelTextField("姓名  ",15);
		name.setBounds((width-x-350)/2, 80, 350,40);
		p.add(name);

		JPanel jp = new JPanel();
		jp.setOpaque(false);
		roleLabel = new JLabel("职务  ");
		roleLabel.setForeground(Color.white);
		roleLabel.setFont( font); 
		jp.add(roleLabel);
		roleBox = new JComboBox<String>();
		roleBox.setOpaque(false);
		roleBox.setFont(new Font("黑体", Font.PLAIN, 14));
		roleBox.setBorder(new EmptyBorder(0,0,0,0));;
		for (Role r : Role.values())
			roleBox.addItem(r.getName());
		jp.add(roleBox);
		jp.setBounds((width-x-350)/2, 130, 350,40);
		p.add(jp);
		
		password = new LabelTextField("密码  ",15);
		password.setBounds((width-x-350)/2, 190, 350,40);
		p.add(password);
		
		confirm = new ConfirmButton();
		confirm.setActionCommand("ModifyUser");
		confirm.addActionListener(controller);
		confirm.setLocation(270, 260);
		p.add(confirm);
	}

	public UserVO getTextInput() {
		return new UserVO(id.getText(), name.getText(), Role.getRole((String) roleBox.getSelectedItem()),
				password.getText());
	}
}
