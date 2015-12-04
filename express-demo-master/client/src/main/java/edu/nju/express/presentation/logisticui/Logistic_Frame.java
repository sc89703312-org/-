package edu.nju.express.presentation.logisticui;

import javax.swing.JFrame;

import edu.nju.express.log.config.LogUIConfig;
import edu.nju.express.log.ui.frame.Frame;
import edu.nju.express.log.ui.logmsg.LogPanel;
import edu.nju.express.log.ui.warning.PromptDialog;
import edu.nju.express.presentation.myUI.MyFrame;

public class Logistic_Frame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean isVanished;
	
	public Logistic_Frame() {
		// TODO Auto-generated constructor stub
		Logistic_Panel panel = new Logistic_Panel(this);
		this.add(panel);
		this.setTitle("物流查询");
		this.setSize(960,720);
		this.setLocationRelativeTo(null); // 居中
		hy.start(); // 透明度渐变启动界面
		
	
		
	}
	

	
	
	
}
