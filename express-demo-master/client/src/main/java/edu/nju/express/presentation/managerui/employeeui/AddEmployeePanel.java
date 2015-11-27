package edu.nju.express.presentation.managerui.employeeui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.managerui.ManageController;
import edu.nju.express.presentation.managerui.ManageGuide;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.ReturnButton;
import edu.nju.express.vo.UserMessageVO;

public class AddEmployeePanel extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int width = 900, height = 600;
	int y = 50;		//由标题栏高度决定
	
	ManageController controller;

	ManageGuide guide;
	JButton confirm;
	LabelTextField id;
	LabelTextField name;
	JLabel roleLabel;
	JComboBox<String> roleBox;
	JButton jbtReturn;
	JPanel p;

	public AddEmployeePanel(ManageController c) {

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
		jbtReturn.setActionCommand("EmployeeUI");
		jbtReturn.addActionListener(controller);
		p.add(jbtReturn);

		id = new LabelTextField("ID    ",15);
		id.setBounds((width-350)/2, 80,350,40);
		p.add(id);
		
		name = new LabelTextField("姓名  ",15);
		name.setBounds((width-350)/2, 130, 350,40);
		p.add(name);

		JPanel jp = new JPanel();
		jp.setOpaque(false);
		roleLabel = new JLabel("职务  ");
		roleLabel.setForeground(Color.white);
		roleLabel.setFont( new Font("黑体", Font.PLAIN, 16)); 
		jp.add(roleLabel);
		
		roleBox = new JComboBox<String>();
		roleBox.setOpaque(false);
		roleBox.setFont(new Font("黑体", Font.PLAIN, 14));
		roleBox.setBorder(new EmptyBorder(0,0,0,0));;
		for (Role r : Role.values())
			roleBox.addItem(r.getName());
		jp.add(roleBox);
		jp.setBounds((width-350)/2, 180, 350,40);
		p.add(jp);

		confirm = new ConfirmButton();
		confirm.setLocation((width-confirm.getWidth())/2, 260);
		confirm.setActionCommand("AddEmployee");
		confirm.addActionListener(controller);
		p.add(confirm);
	}


	public UserMessageVO getTextInput() {
		return new UserMessageVO(StaffChange.add, id.getText(), name.getText(),
				Role.getRole((String) roleBox.getSelectedItem()));
	}
}
