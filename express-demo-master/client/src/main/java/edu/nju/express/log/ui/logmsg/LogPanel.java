package edu.nju.express.log.ui.logmsg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.express.log.LogController;
import edu.nju.express.log.config.LogUIConfig;
import edu.nju.express.log.ui.warning.PromptDialog;
import edu.nju.express.po.LogMessage;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyTextFieldV2;


/**
 * 显示日志信息
 * @author cylong
 * @version 2014年12月26日 下午9:11:28
 */
public class LogPanel extends JPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 8770200041944584165L;

	/** 背景图片 */
	private static final Image IMG_BACK = new ImageIcon("ui/image/log/logmain/back.png").getImage();


	/** 三个输入框 */
	private MyTextFieldV2 year,month,day;
	/** 查询和显示全部日志按钮 */
	private MyButton search, showAll;
	
	
	
	/** 显示日志 */
	private LogTextArea logText;
	/** 显示日志的TextArea与界面的内边距 */
	private int padding = 119;
	private Point logTextPoint = new Point(padding,233 );
	private Dimension logTextSize = new Dimension(LogUIConfig.WIDTH - padding * 2, 302);
	
	


	public LogPanel() {
		this.setOpaque(false);
		this.setLayout(null);

		year = new MyTextFieldV2(189,184,63,25);
		year.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		year.setForeground(new Color(130,130,130));
		year.setOpaque(false);
		year.setBorder(BorderFactory.createEmptyBorder());
		this.add(year);
		
		month = new MyTextFieldV2(316,184,63,25);
		month.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		month.setForeground(new Color(130,130,130));
		month.setOpaque(false);
		month.setBorder(BorderFactory.createEmptyBorder());
		this.add(month);
		
		
		day = new MyTextFieldV2(436,184,63,25);
		day.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		day.setForeground(new Color(130,130,130));
		day.setOpaque(false);
		day.setBorder(BorderFactory.createEmptyBorder());
		this.add(day);
		

		
		
		
		this.addLogText();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(IMG_BACK, 0, 0, this);
		super.paintComponent(g);
	}



	/**
	 * 添加日志信息
	 * @author cylong
	 * @version 2014年12月27日 上午4:19:53
	 */
	private void addLogText() {
		logText = new LogTextArea();
		logText.setLocation(logTextPoint);
		logText.setSize(logTextSize);
		this.add(logText, BorderLayout.CENTER);
	}

	
	
	
	
	

		
		
		
	private class btnListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == search) {
				Date current = new Date();
				String year = LogPanel.this.year.getText();
				SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

				year = (isDigit(year)) ? year : sdfYear.format(current);	// 默认为当年
				String month = LogPanel.this.month.getText();
				month = (isDigit(month)) ? ("-" + month) : "";
				String day = LogPanel.this.day.getText();
				day = (isDigit(day) && month.length() != 0) ? ("-" +day) : "";
				
				
//				if(!isDigit(day)||!isDigit(year))
//					PromptDialog.show("日期错误", "请检查日期是否输入正确");
				
				
				
				
				String date = year + month + day;
				
				System.out.println(date);
				
				
				ArrayList<LogMessage> logs = LogController.getLogsByDate(date);
				logText.setText("");
				logText.append(logs);
				logText.setTitle(date);
			} else if (e.getSource() == showAll) {
				logText.setTitle("全部日志");
				logText.setText("");
				
					ArrayList<LogMessage> logs = LogController.viewAllMsg();
					logText.append(logs);
				
			}
		}

		/**
		 * 判断一个字符串是否为数字
		 * @param num
		 * @return
		 * @author cylong
		 * @version 2014年12月27日 下午3:18:35
		 */
		private boolean isDigit(String num) {
			if (num.length() == 0) {
				return false;
			}
			for(int i = 0; i < num.length(); i++) {
				if (!Character.isDigit(num.charAt(i))) {
					return false;
				}
			}
			return true;
		}
	}

}




