package edu.nju.express.presentation.administratorui;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.express.common.Role;
import edu.nju.express.vo.UserVO;

public class ModifyUserUI extends JPanel {

	private static final long serialVersionUID = 1L;
	int width=900,height=600;
	
	AdministratorController controller;

	JLabel idLabel;
	JLabel nameLabel;
	JLabel roleLabel;
	JLabel passwordLabel;
	JTextField idField;
	JTextField nameField;
	JComboBox<String> roleBox;
	JTextField passwordField;
	JButton confirm;
	JPanel p;

	public ModifyUserUI(AdministratorController c) {
		controller = c;
		this.setLayout(null);
		this.add(new AdministerGuide(controller));
		
		initComponents();
	}


	private void initComponents() {
		p = new JPanel();
		this.add(p);
		p.setBounds((int)(width*0.2), 0, (int)(width*0.8), height);
		
		idLabel = new JLabel("ID:");
		p.add(idLabel);
		idField = new JTextField(10);
		p.add(idField);

		nameLabel = new JLabel("姓名:");
		p.add(nameLabel);
		nameField = new JTextField(10);
		p.add(nameField);

		roleLabel = new JLabel("ְ职务:");
		p.add(roleLabel);
		roleBox = new JComboBox<String>();
		for (Role r : Role.values())
			roleBox.addItem(r.getName());
		p.add(roleBox);

		passwordLabel = new JLabel("密码:");
		p.add(passwordLabel);
		passwordField = new JTextField(10);
		p.add(passwordField);

		
		confirm = new JButton("确认");
		confirm.setActionCommand("ModifyUser");
		confirm.addActionListener(controller);
		p.add(confirm);
	}

	public UserVO getTextInput() {
		return new UserVO(idField.getText(), nameField.getText(), Role.getRole((String) roleBox.getSelectedItem()),
				passwordField.getText());
	}
}
