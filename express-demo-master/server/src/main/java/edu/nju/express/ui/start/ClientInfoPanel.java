package edu.nju.express.ui.start;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.ImageIcon;




import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.dataimpl.LoginInfoDataService_Impl;
import edu.nju.express.po.LoginInfo;
import edu.nju.express.ui.ServerButton;
import edu.nju.express.ui.ServerPanel;
import edu.nju.express.ui.ServerTable;
import edu.nju.express.ui.frame.ServerFrame;

/**
 * 显示当前登录的用户信息
 * @author cylong
 * @version 2014年12月16日 上午12:48:15
 */
public class ClientInfoPanel extends ServerPanel {

	/** serialVersionUID */
	private static final long serialVersionUID = 1368738531558639195L;

	/** ClientInfoPanel的尺寸 */
	private Dimension dimension = new Dimension(515, 460);
	/** ClientInfoPanel横轴内边距 */
	private int PaddingX = 25;
	/** ClientInfoPanel纵轴内边距 */
	private int PaddingY = 46;

	/** 当前登录用户信息的表格 */
	private ServerTable usersTable;

	/** 刷新信息按钮 */
	private ServerButton refreshBtn;
	/** 刷新按钮图片 */
	private static final Image IMG_REFRESH_TEXT = new ImageIcon("images/refresh_text.png").getImage();
	/** 刷新按钮的大小 */
	private Dimension btnDimen = new Dimension(IMG_REFRESH_TEXT.getWidth(null), IMG_REFRESH_TEXT.getHeight(null));
	/** 刷新按钮的位置 */
	private Point btnPoint = new Point((dimension.width - btnDimen.width) / 2, dimension.height - btnDimen.height -2);

	private ServerFrame parent;

	
	public ClientInfoPanel(ServerFrame parent) {
		this.setSize(dimension);
		// this.setBorder(BorderFactory.createTitledBorder(getBorder(), "客户端信息", TitledBorder.CENTER, TitledBorder.TOP, UIConfig.TEXT_FONT));
		this.initUserTable();
		this.addRefreshBtn();

		this.parent = parent;
	}

	/**
	 * 添加当前登录的用户的信息table
	 * @author cylong
	 * @version 2014年12月15日 下午10:40:36
	 */
	private void addUsersTable() {
		String[] columnNames = {"用户名", "时间", "姓名", "登录IP"};
		String[][] rowData = new String[LoginInfoDataService_Impl.showAll().size()][columnNames.length];
		for(int i = 0; i < LoginInfoDataService_Impl.showAll().size(); i++) {
			LoginInfo tempInfo = LoginInfoDataService_Impl.showAll().get(i);
			rowData[i][0] = tempInfo.getID();
			rowData[i][1] = tempInfo.getTime();
			rowData[i][2] = tempInfo.getName();
			rowData[i][3] = tempInfo.getClientIP();
		}
		usersTable = new ServerTable(columnNames, rowData);
		Point usersTablePoint = new Point(PaddingX, PaddingY);
		usersTable.setLocation(usersTablePoint);
		Dimension usersTableDimen = new Dimension(dimension.width - PaddingX * 2, dimension.height - PaddingY * 2);
		usersTable.setSize(usersTableDimen);
		usersTable.init();
		this.add(usersTable);
	}

	
	private void initUserTable(){
		String[] columnNames = {"用户名", "时间", "姓名", "登录IP"};
		String[][] rowData = new String[0][columnNames.length];
		
		usersTable = new ServerTable(columnNames, rowData);
		Point usersTablePoint = new Point(PaddingX, PaddingY);
		usersTable.setLocation(usersTablePoint);
		Dimension usersTableDimen = new Dimension(dimension.width - PaddingX * 2, dimension.height - PaddingY * 2);
		usersTable.setSize(usersTableDimen);
		usersTable.init();
		this.add(usersTable);
	}
	
	
	
	private void addRefreshBtn() {
		refreshBtn = new ServerButton(IMG_REFRESH_TEXT);
		refreshBtn.setSize(btnDimen);
		refreshBtn.setLocation(btnPoint);
		refreshBtn.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				ClientInfoPanel.this.remove(usersTable);
				ClientInfoPanel.this.addUsersTable();

			}
		});
		this.add(refreshBtn);
	}
	
	
	
	
	
	

	

}
