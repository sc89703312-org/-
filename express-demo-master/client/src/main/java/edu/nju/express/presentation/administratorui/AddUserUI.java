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
import edu.nju.express.presentation.myUI.MyTextField;
import edu.nju.express.vo.UserVO;

public class AddUserUI extends MainPanel {

	private static final long serialVersionUID = 1L;
	int width=900,height=600;
	int y = 50;		//由标题栏高度决定
	
	AdministratorController controller;

	MyTextField id;
	MyTextField name;
	MyTextField password;
	JLabel roleLabel;	
	JComboBox<String> roleBox;
	JButton confirm;
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

		p.setBounds((int)(width*0.2), y, (int)(width*0.8), height);
		
		id = new MyTextField(" ID ",15);
		id.setBounds((p.getWidth()-350)/2, 30,350,40);
		p.add(id);
		
		name = new MyTextField("姓名",15);
		name.setBounds((p.getWidth()-350)/2, 80, 350,40);
		p.add(name);

		JPanel jp = new JPanel();
		jp.setOpaque(false);
		roleLabel = new JLabel("职务  ");
		roleLabel.setForeground(Color.white);
		roleLabel.setFont( new Font("微软雅黑", Font.PLAIN, 16)); 
		jp.add(roleLabel);
		roleBox = new JComboBox<String>();
		roleBox.setOpaque(false);
		roleBox.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		roleBox.setBorder(new EmptyBorder(0,0,0,0));;
		for (Role r : Role.values())
			roleBox.addItem(r.getName());
		jp.add(roleBox);
		jp.setBounds((p.getWidth()-350)/2, 130, 350,40);
		p.add(jp);
		
		password = new MyTextField("密码",15);
		password.setBounds((p.getWidth()-350)/2, 190, 350,40);
		p.add(password);
		
		confirm = new ConfirmButton();
		confirm.setActionCommand("AddUser");
		confirm.addActionListener(controller);
		p.add(confirm);
	}

	public UserVO getTextInput() {
		return new UserVO(id.getText(), name.getText(), Role.getRole((String) roleBox.getSelectedItem()),
				password.getText());
	}
}
