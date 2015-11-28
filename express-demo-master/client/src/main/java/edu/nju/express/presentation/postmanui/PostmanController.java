package edu.nju.express.presentation.postmanui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class PostmanController implements ActionListener {

	JPanel currentPanel;
	JFrame frame;
	
	public PostmanController(JFrame f) {
		this.frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("PostmanMainUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new PostmanMainUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("CreateOrderUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new CreateOrderPanel(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("InquireOrderUI")){
			
		}else if(e.getActionCommand().equals("ConfirmReceivalUI")){
			frame.getContentPane().removeAll();;
			currentPanel = new ConfirmReceivalUI(this);
			frame.add(currentPanel);
			frame.validate();
			frame.repaint();
		}else if(e.getActionCommand().equals("CaculateFee")){
			
		}else if(e.getActionCommand().equals("SubmitOrder")){
			
		}else if(e.getActionCommand().equals("ConfirmReceival")){
			System.out.println(((ConfirmReceivalUI)currentPanel).getTextInput());
		}
	}

}

