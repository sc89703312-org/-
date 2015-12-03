package edu.nju.express.log.ui.logmsg;

import edu.nju.express.log.config.LogUIConfig;
import edu.nju.express.log.ui.frame.Frame;
import edu.nju.express.presentation.logisticui.Logistic_Panel;

/**
 * @author cylong
 * @version 2014年12月27日 下午9:15:35
 */
public class LogFrame extends Frame {

	/** serialVersionUID */
	private static final long serialVersionUID = -8558818784226467183L;

	public LogFrame() {
		// 显示日志信息的panel
		LogPanel panel = new LogPanel();
		this.add(panel);
		this.setTitle("日志查看");
		this.setSize(960,720);
		this.setLocationRelativeTo(null); // 居中
		hy.start(); // 透明度渐变启动界面
	}

}
