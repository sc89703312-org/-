package edu.nju.express.presentation.administratorui;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteUserUI extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width=900,height=600;
	JTextField idField;
	JLabel label;
	JButton confirm;
	AdministratorController controller;
	JPanel p ;
	
	public DeleteUserUI(AdministratorController c) {
		controller = c;
		this.setLayout(null);
		this.add(new AdministerGuide(controller));
		initComponents();
	}
	
	private void initComponents() {
		p = new JPanel();
		label = new JLabel("ID:");
		p.add(label);
		
		idField = new JTextField(10);
		p.add(idField);
		
		confirm = new JButton("确认");
		p.add(confirm);
		confirm.addActionListener(controller);
		confirm.setActionCommand("DeleteUser");
		
		this.add(p);
		p.setBounds((int)(width*0.2), 0, (int)(width*0.8), height);
	}

	public String getID(){
		return idField.getText();
	}

	

	
	
}
