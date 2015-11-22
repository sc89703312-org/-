/*package edu.nju.express.presentation.UserUI;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteUserPanel extends JPanel{

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	JTextField idField;
	JLabel label;
	JButton confirm;
	UserController controller;
	
	public DeleteUserPanel() {
		controller = new UserController();
		this.setLayout(null);
		initComponents();
	}
	
	private void initComponents() {
		label = new JLabel("ID:");
		this.add(label);
		
		idField = new JTextField(10);
		this.add(idField);
		
		confirm = new JButton("ȷ��");
		this.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DeleteUser");
	}

	public String getID(){
		return idField.getText();
	}
}
*/