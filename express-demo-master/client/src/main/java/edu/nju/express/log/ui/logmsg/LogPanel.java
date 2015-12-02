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
import edu.nju.express.presentation.myUI.MyLabel;
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
	private MyButton search, showAll,exit;
	
	
	private MyLabel yearLabel,monthLabel,dayLabel,searchLabel,viewAllLabel,exit_1,exit_2;
	
	
	/** 显示日志 */
	private LogTextArea logText;
	/** 显示日志的TextArea与界面的内边距 */
	private int padding = 265;
	private Point logTextPoint = new Point(padding,175);
	private Dimension logTextSize = new Dimension(590, 415);
	
	


	public LogPanel() {
		this.setOpaque(false);
		this.setLayout(null);
		
		this.addLogText();
		
		
		
		search = new MyButton(140, 229, 90, 35);        
		search.addMouseListener(new btnListener());
		this.add(search);
		
		
		showAll = new MyButton(140, 303, 90, 35);
		showAll.addMouseListener(new btnListener());
		this.add(showAll);
		
		
		exit_1 = new MyLabel(890, 40, 50, 30);
		exit_1.setIcon(new ImageIcon("ui/image/log/logmain/exit.png"));
		exit_1.setVisible(true);
		exit_1.setOpaque(false);
		this.add(exit_1);
		
		exit_2= new MyLabel(890, 40, 50, 30);
		exit_2.setIcon(new ImageIcon("ui/image/log/logmain/exit_1.png"));
		exit_2.setVisible(false);
		exit_2.setOpaque(false);
		this.add(exit_2);
		
		exit = new MyButton(890, 40, 50, 30);
		exit.addMouseListener(new btnListener());
		this.add(exit);

		year = new MyTextFieldV2(526,134,63,25);
		year.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		year.setForeground(new Color(130,130,130));
		year.setOpaque(false);
		year.setBorder(BorderFactory.createEmptyBorder());
		this.add(year);
		year.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				yearLabel.setVisible(true);
			}

			public void mouseExited(MouseEvent arg0) {
				yearLabel.setVisible(false);
			}
		});
		
		
		
		
		month = new MyTextFieldV2(650,134,63,25);
		month.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		month.setForeground(new Color(130,130,130));
		month.setOpaque(false);
		month.setBorder(BorderFactory.createEmptyBorder());
		this.add(month);
		
		
		
		month.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				monthLabel.setVisible(true);
			}

			public void mouseExited(MouseEvent arg0) {
				monthLabel.setVisible(false);
			}
		});
		
		day = new MyTextFieldV2(772,134,63,25);
		day.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		day.setForeground(new Color(130,130,130));
		day.setOpaque(false);
		day.setBorder(BorderFactory.createEmptyBorder());
		this.add(day);
		

		
		day.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				dayLabel.setVisible(true);
			}

			public void mouseExited(MouseEvent arg0) {
				dayLabel.setVisible(false);
			}
		});
		
		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy MM dd");
		String[] date = sdfdate.format(new Date()).split(" ");
		year.setText(date[0]);
		month.setText(date[1]);
		day.setText(date[2]);
		
		
		
		
		
		
		
		
		yearLabel = new MyLabel(0, 0, 960, 720);
		yearLabel.setIcon(new ImageIcon("ui/image/log/logmain/year.png"));
		yearLabel.setVisible(false);
		yearLabel.setOpaque(false);
		this.add(yearLabel);
		
		monthLabel = new MyLabel(0, 0, 960, 720);
		monthLabel.setIcon(new ImageIcon("ui/image/log/logmain/month.png"));
		monthLabel.setVisible(false);
		monthLabel.setOpaque(false);
		this.add(monthLabel);
		
		dayLabel = new MyLabel(0, 0, 960, 720);
		dayLabel.setIcon(new ImageIcon("ui/image/log/logmain/day.png"));
		dayLabel.setVisible(false);
		dayLabel.setOpaque(false);
		this.add(dayLabel);
		
		
		searchLabel = new MyLabel(0, 0, 960, 720);
		searchLabel.setIcon(new ImageIcon("ui/image/log/logmain/search.png"));
		searchLabel.setVisible(false);
		searchLabel.setOpaque(false);
		this.add(searchLabel);
		
		
		viewAllLabel = new MyLabel(0, 0, 960, 720);
		viewAllLabel.setIcon(new ImageIcon("ui/image/log/logmain/show_all.png"));
		viewAllLabel.setVisible(false);
		viewAllLabel.setOpaque(false);
		this.add(viewAllLabel);
		
		
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
	    public void mouseEntered(MouseEvent e) {
			if(e.getSource()==search){
				searchLabel.setVisible(false);
				searchLabel.setVisible(true);
			}else if (e.getSource()==showAll) {
				viewAllLabel.setVisible(false);
				viewAllLabel.setVisible(true);
			}else {
				exit_2.setVisible(true);
				exit_1.setVisible(false);
			}
		}
		
		

		public void mouseExited(MouseEvent e) {
			
			if(e.getSource()==search){
			searchLabel.setVisible(true);
			searchLabel.setVisible(false);
			}else if (e.getSource()==showAll) {
            viewAllLabel.setVisible(true);
            viewAllLabel.setVisible(false);
			}else {
				exit_2.setVisible(false);
				exit_1.setVisible(true);
			}
		}
		
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
				
				
				
				
				
				if(!isDigit(day)||!isDigit(month))
					PromptDialog.show("日期错误", "请检查日期是否输入正确");
				
				
				
				
				String date = year + month + day;
				

				
				
				ArrayList<LogMessage> logs = LogController.getLogsByDate(date);
				logText.setText("");
				logText.append(logs);
				logText.setTitle(date);
				
				
	
				
				
				
			} else if (e.getSource() == showAll) {
				logText.setTitle("全部日志");
				logText.setText("");
				
					ArrayList<LogMessage> logs = LogController.viewAllMsg();
					logText.append(logs);
				
			}else {
				System.exit(0);
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
				if (!((num.charAt(i)>='0'&&num.charAt(i)<='9')||num.charAt(i)=='-')) {
					return false;
				}
			}
			return true;
		}
	}

}




