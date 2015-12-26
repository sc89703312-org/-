package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.JDialog;

/**
 * 提示框
 */
public class WarningDialog extends JDialog {

	private static final long serialVersionUID = 2857496548979951207L;

	/** 窗口大小 */
	private Dimension dimen = new Dimension(726, 30);

	private Vanish vanish;

	public WarningDialog() {
		this.setUndecorated(true);
		// 创建透明色
		this.setBackground(new Color(0, 0, 0, 0.0f));
		this.setSize(dimen);
		
		if(MyFrame.getLoc() == null){
			this.setLocationRelativeTo(null);
			this.setLocation(getLocation().x+128-87, getLocation().y+504-285);
			
		}else{
			this.setLocation(MyFrame.getLoc().x+128,MyFrame.getLoc().y+504);
		}
		if (MyFrame.getLoc() == null) {
		}
		
		
		this.setVisible(true);
		vanish = new Vanish(); // 固定时间窗口消失
	}

	public void start() {
		vanish.start();
	}

	public void setComp(Component comp) {
		this.add(comp);
		this.setVisible(true);
	}

	public static void show(String title, String prompt) {
		WarningDialog promptDialog = new WarningDialog();
		promptDialog.setComp(new WarningPanel(title, prompt));
		promptDialog.start(); // 固定时间关闭窗口
	}

	public static void showConnectionError() {
		show("网络异常", "请检查网络状况和与服务器的连接是否正常");
	}

	public static void showSucess() {
		show("提交成功", "稍后返回主页面");
	}

	private class Vanish extends Thread {

		/** 窗体透明值 */
		protected float hyalineValue = 1f;

		public void run() {
			try {
				Thread.sleep(1000);
				while (true) {
					Thread.sleep(20);
					hyalineValue -= 0.05f;
					if (hyalineValue < 0) {
						hyalineValue = 0;
					}
					WarningDialog.this.setOpacity(hyalineValue);
					if (hyalineValue == 0) {
						WarningDialog.this.dispose();
						break;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
