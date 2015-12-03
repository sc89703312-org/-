package edu.nju.express.log.ui.logmsg;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import edu.nju.express.log.LogController;
import edu.nju.express.log.config.LogUIConfig;
import edu.nju.express.po.LogMessage;
import edu.nju.express.presentation.myUI.MyScrollBarUI;


/**
 * 把日志信息放到TextArea中
 * @author cylong
 * @version 2014年12月26日 下午9:19:12
 */
public class LogTextArea extends JScrollPane {

	/** serialVersionUID */
	private static final long serialVersionUID = 3963201247039258871L;

	/** 真正的TextArea在这 */
	private JTextArea textArea;
	JScrollBar bar = this.getVerticalScrollBar();

    MyScrollBarUI ui_1 = new MyScrollBarUI();
	
	//	/** 边框标题 */
	//	private String title;

	public LogTextArea() {
		this.setOpaque(false);	// 将JScrollPane设置为透明
		this.getViewport().setOpaque(false);	// 将中间的viewport设置为透明
		this.addMouseWheelListener(new WheelListener()); // 设置鼠标滚轮监听
		this.addTextArea();	// 添加文本域
		this.setBorder();	// 设置边框
		
		ui_1.setThumbColor(new Color(76,161,219));
		this.modifyScrollBar();	// 修改滚动条样式
	}

	private void modifyScrollBar() {
		
		bar.setBackground(Color.LIGHT_GRAY);
		bar.setOpaque(false);
		bar.setBorder(new EmptyBorder(0, 0, 0, 0));
		bar.setUI(ui_1);
		
	
	
			
			
			
			
			
			
	}

	private void addTextArea() {
		
		SimpleDateFormat sdfdate = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdfdate.format(new Date());
		
		
		textArea = new JTextArea();
		textArea.setForeground(new Color(130, 130, 130));
		// 最新的在前面显示
		ArrayList<LogMessage> logs = LogController.getLogsByDate(date);
		for(int i = 0; i < logs.size(); i++) {
			LogMessage log = logs.get(i);
			textArea.append(log.toString() + "\r\n");
		}
		textArea.setLineWrap(true);
		textArea.setFont(LogUIConfig.TEXT_FONT);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		this.setViewportView(textArea);
	}

	private void setBorder() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// title = sdf.format(new Date()); // 初始化标题为当前日期
		this.setBorder(null);
		// this.setBorder(BorderFactory.createTitledBorder(null, title, TitledBorder.CENTER, TitledBorder.TOP, LogUIConfig.TEXT_FONT));
	}

	public void setTitle(String title) {
		// this.title = title;
		this.setBorder(null);
		// this.setBorder(BorderFactory.createTitledBorder(getBorder(), title, TitledBorder.CENTER, TitledBorder.TOP, LogUIConfig.TEXT_FONT));
		this.repaint();
	}

	/**
	 * 将存放在ArrayList里的LogMessage显示在TextArea中
	 * @param logs
	 * @author cylong
	 * @version 2014年12月27日 上午4:40:09
	 */
	public void append(ArrayList<LogMessage> logs) {
		if (logs == null) {
			return;
		}
		for(LogMessage log : logs) {
			textArea.append(log.toString() + "\r\n");
		}
	}

	public void append(String text) {
		textArea.append(text);
	}

	public void setText(String text) {
		textArea.setText(text);
	}

	private class WheelListener implements MouseWheelListener {

		
		public void mouseWheelMoved(MouseWheelEvent e) {
			JScrollBar onlineFriendsBar = LogTextArea.this.getVerticalScrollBar();
			if (!((onlineFriendsBar.getValue() == onlineFriendsBar.getMinimum() && e.getWheelRotation() <= 0) || (onlineFriendsBar.getValue() == onlineFriendsBar.getMaximum() && e.getWheelRotation() >= 0))) {
				if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 >= onlineFriendsBar.getMaximum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMaximum());
				} else if (onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement() * e.getUnitsToScroll() * 2 <= onlineFriendsBar.getMinimum()) {
					onlineFriendsBar.setValue(onlineFriendsBar.getMinimum());
				} else {
					onlineFriendsBar.setValue(onlineFriendsBar.getValue() + onlineFriendsBar.getUnitIncrement()
												* e.getUnitsToScroll() * 10);
				}
			}
		}
	}

}
