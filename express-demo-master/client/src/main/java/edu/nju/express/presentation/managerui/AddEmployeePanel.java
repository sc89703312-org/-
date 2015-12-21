package edu.nju.express.presentation.managerui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.common.Role;
import edu.nju.express.common.StaffChange;
import edu.nju.express.presentation.MainPanel;
import edu.nju.express.presentation.myUI.CancelButton;
import edu.nju.express.presentation.myUI.ConfirmButton;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.vo.UserMessageVO;

public class AddEmployeePanel extends MainPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Image bg = new ImageIcon("ui/image/manager/添加人员.png").getImage();
	static Font font = new Font("黑体", Font.PLAIN, 18);
	static Color color = new Color(44, 62,80);
	
	ManageController controller;

	ConfirmButton confirm;
	CancelButton cancel;
	LabelTextField id;
	LabelTextField name;
	JLabel roleLabel;
	JComboBox<String> roleBox;

	public AddEmployeePanel(ManageController c) {

		controller = c;
		initComponents();
		
		ManageGuide guide = new ManageGuide(c);
		guide.employee.setIcon(null);
		this.add(guide);
	}

	private void initComponents() {

		id = new LabelTextField("ID    ",15);
		id.setBounds(200+94, 170,400,40);
		this.add(id);
		
		name = new LabelTextField("姓名  ",15);
		name.setBounds(200+94,230,400,40);
		this.add(name);

		JPanel jp = new JPanel();
		jp.setOpaque(false);
		roleLabel = new JLabel("职务    ");
		roleLabel.setFont(font);
		roleLabel.setForeground(color);
		jp.add(roleLabel);
		roleBox = new MyComboBox<String>();
		for (Role r : Role.values())
			roleBox.addItem(r.getName());
		roleBox.setPreferredSize(new Dimension(160, 32));
		jp.add(roleBox);
		jp.setBounds(200+94, 300, 400,40);
		this.add(jp);

		confirm = new ConfirmButton();
		confirm.setBounds(400,537,80,30);
		confirm.setActionCommand("AddEmployee");
		confirm.addActionListener(controller);
		this.add(confirm);
		
		cancel = new CancelButton();
		this.add(cancel);
		cancel.addActionListener(controller);
		cancel.setActionCommand("EmployeeUI");
	}


	public UserMessageVO getTextInput() {
		if(id.getText().equals("")){
			id.setError();
			return null;
		}
		if(name.getText().equals("")){
			name.setError();
			return null;
		}
		
		return new UserMessageVO(StaffChange.add, id.getText(), name.getText(),
				Role.getRole((String) roleBox.getSelectedItem()));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(bg, 0, 0, null);
	}
}
