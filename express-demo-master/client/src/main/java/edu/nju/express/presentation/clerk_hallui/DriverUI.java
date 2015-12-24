package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import edu.nju.express.blservice.Vehicleblservice;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
import edu.nju.express.presentation.myUI.MyTablePanel;
import edu.nju.express.presentation.myUI.WarningDialog;
import edu.nju.express.vo.Drivervo;

public class DriverUI extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon new0 = new ImageIcon("ui/image/hall/new0.png");
	ImageIcon new1 = new ImageIcon("ui/image/hall/new1.png");
	ImageIcon edit0 = new ImageIcon("ui/image/hall/edit0.png");
	ImageIcon edit1 = new ImageIcon("ui/image/hall/edit1.png");
	ImageIcon trash0 = new ImageIcon("ui/image/hall/trash0.png");
	ImageIcon trash1 = new ImageIcon("ui/image/hall/trash1.png");
	
	int width = 900, height = 600;
	private HallController controller;
	private Vehicleblservice vehicleBL;
	private JPanel mainpanel;
	private JLabel bg;
	private JPanel listPanel, newPanel, deleteConfirmPanel;
	private JButton newBtn, editBtn, trashBtn;
	private JLabel  genderLabel, birthLabel, licenseLimitLabel;
	private LabelTextField driverIdField, nameField, identityField, cellphoneField;
	boolean driverErr, identityErr, cellphoneErr;
	private MyComboBox<String> genderBox;
	private DateComboBoxPanel birthBoxPanel, licenseLimitBoxPanel;
	private MyButton addBtn, saveBtn;
	private MySearchFieldPanel searchField;
	private MyTablePanel table;
	
	private boolean isInfo = false;
	private boolean isNew = true;
	
	
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
	ArrayList<Drivervo> driverList;
	
//	String driverID = "12345";
	String hall_id = "025001";
	
	public DriverUI(HallController controller){
		this.controller = controller;
		this.vehicleBL = controller.vehicle;
		
		mainpanel = new JPanel();
		mainpanel.setLayout(null);
		mainpanel.setBounds(0, 0, width, height);
		mainpanel.setVisible(true);
		mainpanel.setOpaque(false);
		initButton();
		initListPanel();
		initNewPanel();
		initDeleteConfirmPanel();
		
		mainpanel.add(listPanel);
		
		
		bg = new JLabel(new ImageIcon("ui/image/hall/driver.png"));
		bg.setBounds(0, 0, width, height);
		
		this.add(mainpanel);
		//背景图一定要放在mainpanel下面！
		this.add(bg);
		this.add(new HallGuide(controller));
		this.setLayout(null);
		this.setBounds(0, 0, width, height);
		this.setOpaque(false);
		this.setVisible(true);
	}
	
	public void initButton(){
		JButton exit = new JButton(new ImageIcon("ui/button/X_darkgray.png"));
		exit.setBounds(840, 18, 30, 30);
		exit.setOpaque(false);
		exit.setBorderPainted(false);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		mainpanel.add(exit);
		//初始化为新建司机信息
		newBtn = new JButton(new0);
		newBtn.setBounds(729, 81, 30, 30);
		newBtn.setBorderPainted(false);
		newBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//新建信息无前置条件
					mainpanel.remove(saveBtn);
					mainpanel.add(addBtn);
					mainpanel.remove(mainpanel.getComponentAt(130, 130));
					clearPanel();// clear components(public)
					enableInfoPanel();
					trashBtn.setEnabled(true);
					//clear searchpanel
					searchField.clearText();
					mainpanel.add(newPanel);
					setIsNew(true);
					mainpanel.validate();
					mainpanel.repaint();
			}
			
		});
		newBtn.addMouseListener(this);
		mainpanel.add(newBtn);
		
		editBtn = new JButton(edit0);
		editBtn.setBounds(767, 81, 30, 30);
		editBtn.setBorderPainted(false);
		editBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//只要点击edit就remove “添加”按钮
				
				if(isNew){
					WarningDialog.show("温馨提示", "请先查找您要编辑的司机信息");
				}
				else if(isInfo){
					mainpanel.remove(addBtn);
					
					enableInfoPanel();
					//编辑时不让删除
					trashBtn.setEnabled(false);
					//
					mainpanel.add(saveBtn);
					
				}
				mainpanel.validate();
				mainpanel.repaint();
			}
			
		});
		editBtn.addMouseListener(this);
		mainpanel.add(editBtn);
		
		trashBtn = new JButton(trash0);
		trashBtn.setBounds(807, 81, 30, 30);
		trashBtn.setBorderPainted(false);
		trashBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(isNew){
					WarningDialog.show("温馨提示", "请先查找您要删除的司机信息");
				}
				else if(isInfo){
					mainpanel.remove(newPanel);
					mainpanel.add(deleteConfirmPanel);
					newBtn.setEnabled(false);
					editBtn.setEnabled(false);
					
				}
				mainpanel.validate();
				mainpanel.repaint();
			}
			
		});
		trashBtn.addMouseListener(this);
		mainpanel.add(trashBtn);
		
		
		
		
		searchField = new MySearchFieldPanel(controller);
		searchField.getButton().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				if(searchField.getText().length()==0){
					WarningDialog.show("温馨提示", "输入内容不能为空");
				}
				else if(getDriver(searchField.getText())==null){
					WarningDialog.show("T ^ T", "sorry，"+searchField.getText()+"不在");
				}
				else{
					mainpanel.remove(listPanel);
					trashBtn.setEnabled(true);
					mainpanel.remove(addBtn);
					mainpanel.remove(saveBtn);
					setIsInfo(true);
					setIsNew(false);
					initInfoPanel(getDriver(searchField.getText()));
					mainpanel.add(newPanel);
				}
				newBtn.setIcon(new0);
				newBtn.repaint();
				editBtn.setIcon(edit0);
				editBtn.repaint();
				trashBtn.setIcon(trash0);
				trashBtn.repaint();
				mainpanel.validate();
				mainpanel.repaint();
			}

		});
		searchField.setBounds(480, 76, 200, 40);
		mainpanel.add(searchField);

		addBtn = new MyButton(395, 525, 110, 45);
		addBtn.setIcon(new ImageIcon("ui/image/hall/add0.png"));
		addBtn.addMouseListener(this);
		addBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isFilled()){
					WarningDialog.show("温馨提示", "请检查信息项是否齐全");
				}
				else if(!isError()){
					if(!driverErr)
						driverIdField.setError();
					if(!identityErr)
						identityField.setError();
					if(!cellphoneErr)
						cellphoneField.setError();
					WarningDialog.show("数据格式错误", "司机编号应为10位"+"\n"
						+"身份证号为18位"+"\n"+"手机号为11位");
				}
				else{
					addDriver(new Drivervo(driverIdField.getText(), nameField.getText(),
							birthBoxPanel.getDate(), identityField.getText(), 
							cellphoneField.getText(), hall_id, 
							genderBox.getSelectedIndex()==0?true:false,
									licenseLimitBoxPanel.getDate()
							));

					mainpanel.remove(newPanel);
					mainpanel.remove(addBtn);
					refreshData();
					mainpanel.add(listPanel);
					mainpanel.validate();
					mainpanel.repaint();
				}
			}

		});

		saveBtn = new MyButton(395, 525, 110, 45);
		saveBtn.setIcon(new ImageIcon("ui/image/hall/save0.png"));
		saveBtn.addMouseListener(this);
		saveBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isFilled()){
					WarningDialog.show("温馨提示", "请检查填写信息是否齐全");
				}
				else if(!isError()){
					if(!driverErr)
						driverIdField.setError();
					if(!identityErr)
						identityField.setError();
					if(!cellphoneErr)
						cellphoneField.setError();
					WarningDialog.show("数据格式错误", "司机编号应为10位"+"\n"
						+"身份证号为18位"+"\n"+"手机号为11位");
				}
				else{
					modifyDriver(driverIdField.getText(),
							new Drivervo(driverIdField.getText(), nameField.getText(),
									birthBoxPanel.getDate(), identityField.getText(), 
									cellphoneField.getText(), hall_id, 
									genderBox.getSelectedIndex()==0?true:false,
											licenseLimitBoxPanel.getDate()
									));
					mainpanel.remove(newPanel);
					mainpanel.remove(saveBtn);
					refreshData();
					mainpanel.add(listPanel);
					mainpanel.validate();
					mainpanel.repaint();
				}
			}

		});
	}
	
	/**
	 * 给newPanel 添加信息
	 */
	public void initInfoPanel(Drivervo vo){
		driverIdField.setText(vo.getId());
		driverIdField.getTextField().setEditable(false);
		
		nameField.setText(vo.getName());
		nameField.getTextField().setEditable(false);
		
		genderBox.setSelectedIndex(vo.getSex()==true?0:1);
		
		String birthDate = vo.getBirthDate();
		String[] split = birthDate.split("/");
		birthBoxPanel.getYearComboBox().setSelectedItem(split[0]);
		birthBoxPanel.getMonthComboBox().setSelectedItem(split[1]);
		birthBoxPanel.getDayComboBox().setSelectedItem(split[2]);
		
		identityField.setText(vo.getCertificate());
		identityField.getTextField().setEditable(false);
		
		cellphoneField.setText(vo.getPhone());
		cellphoneField.getTextField().setEditable(false);
		
		
		String ddlDate = vo.getDdl();
		System.out.println(ddlDate);
		String[] ddl = ddlDate.split("/");
		licenseLimitBoxPanel.getYearComboBox().setSelectedItem(ddl[0]);
		licenseLimitBoxPanel.getMonthComboBox().setSelectedItem(ddl[1]);
		licenseLimitBoxPanel.getDayComboBox().setSelectedItem(ddl[2]);
		
		
	}
	
	public void clearPanel(){
		driverIdField.setText("");
		
		nameField.setText("");
		
		genderBox.setSelectedIndex(0);

		birthBoxPanel.setToday();
		
		identityField.setText("");
		
		cellphoneField.setText("");
		
		licenseLimitBoxPanel.setToday();
		
	}
	
	/**
	 * 使infoPanel变为可编辑, editBtn响应时调用这个方法
	 */
	public void enableInfoPanel(){
		
		driverIdField.getTextField().setEditable(true);
		
		nameField.getTextField().setEditable(true);
		
		identityField.getTextField().setEditable(true);
		
		cellphoneField.getTextField().setEditable(true);
		
	}	
	
	public void initListPanel(){
		listPanel = new JPanel();
		listPanel.setLayout(null);
		listPanel.setOpaque(false);
		listPanel.setVisible(true);
		listPanel.setBounds(128, 117, 729, 403);
		
		String[] header = {"司机编号","司机姓名"};
		DefaultTableModel model = new DefaultTableModel(null,header){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new MyTablePanel(model,header);
		table.setBounds(0, 0, 710, 350);
		table.getTable().setPreferredScrollableViewportSize(new Dimension(690,350));
		listPanel.add(table);
		
		//refresh driver data
		refreshData();
	}
	
	
	public void initNewPanel(){
		newPanel = new JPanel();
		newPanel.setLayout(null);
		newPanel.setBounds(128, 117, 729, 403);
		newPanel.setOpaque(false);
		newPanel.setVisible(true);
		
		
		driverIdField = new LabelTextField("司机编号",9);
		driverIdField.setBounds(110, 20, 300, 45);	
		newPanel.add(driverIdField);
		
		nameField = new LabelTextField("司机姓名",4);
		nameField.setBounds(110, 80, 300, 45);
		newPanel.add(nameField);
		
		genderLabel = new JLabel("性别  ");
		genderLabel.setFont(font);
		genderLabel.setForeground(color);
		genderLabel.setBounds(120, 140, 90, 40);
		newPanel.add(genderLabel);
		
		genderBox = new MyComboBox<String>();
		genderBox.setBounds(200, 140, 100, 30);
		String[] genderlist = {"男", "女"};
		for(int i=0; i<genderlist.length; i++){
			genderBox.addItem(genderlist[i]);
		}
		genderBox.setSelectedItem(genderlist[0]);
		newPanel.add(genderBox);

		

		birthLabel = new JLabel("出生日期");
		birthLabel.setFont(font);
		birthLabel.setForeground(color);
		birthLabel.setBounds(110, 190, 80, 40);
		newPanel.add(birthLabel);

		birthBoxPanel = new DateComboBoxPanel();
		birthBoxPanel.setBounds(120, 190, 500, 40);
		newPanel.add(birthBoxPanel);

		identityField = new LabelTextField("身份证号",18);
		identityField.setBounds(110, 245, 300, 45);
		newPanel.add(identityField);
		
		cellphoneField = new LabelTextField("手机号   ",11);
		cellphoneField.setBounds(110, 305, 300, 45);
		newPanel.add(cellphoneField);
		
		licenseLimitLabel = new JLabel("行驶证期限");
		licenseLimitLabel.setFont(font);
		licenseLimitLabel.setForeground(color);
		licenseLimitLabel.setBounds(100, 365, 90, 40);
		newPanel.add(licenseLimitLabel);
		
		licenseLimitBoxPanel = new DateComboBoxPanel();
		licenseLimitBoxPanel.setBounds(120, 365, 500, 40);
		newPanel.add(licenseLimitBoxPanel);
		
		
	}
	
	
	
	public void initDeleteConfirmPanel(){
		deleteConfirmPanel = new JPanel();
		deleteConfirmPanel.setLayout(null);
		deleteConfirmPanel.setVisible(true);
		deleteConfirmPanel.setOpaque(false);
		deleteConfirmPanel.setBounds(291, 214, 360, 240);
		
		JButton confirm = new JButton("确认");
		confirm.setBounds(58, 144, 90, 40);
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setIsNew(true);
				deleteDriver(driverIdField.getText());
				//remove deleteConfirmPanel
				mainpanel.remove(deleteConfirmPanel);
				refreshData();
				mainpanel.add(listPanel);
				newBtn.setEnabled(true);
				editBtn.setEnabled(true);
				mainpanel.validate();
				mainpanel.repaint();
			}
			
		});
		deleteConfirmPanel.add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(221, 144, 90, 40);
		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				mainpanel.remove(mainpanel.getComponentAt(396, 526));
				//remove deleteConfirmPanel
				mainpanel.remove(mainpanel.getComponentAt(355, 257));
				mainpanel.add(newPanel);
				newBtn.setEnabled(true);
				editBtn.setEnabled(true);
				mainpanel.validate();
				mainpanel.repaint();
			}
			
		});
		deleteConfirmPanel.add(cancel);
		
		JLabel deletebg = new JLabel(new ImageIcon("ui/image/hall/deletebg.png"));
		deletebg.setBounds(0, 0, 360, 240);
		deleteConfirmPanel.add(deletebg);
		
	}
	
	
	private void setIsNew (boolean isNew){
		this.isNew = isNew;
	}
	
	private void setIsInfo(boolean isInfo){
		this.isInfo = isInfo;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(newBtn)){
			newBtn.setIcon(new1);
			editBtn.setIcon(edit0);
			trashBtn.setIcon(trash0);
		}
		if(e.getSource().equals(editBtn)){
			newBtn.setIcon(new0);
			editBtn.setIcon(edit1);
			trashBtn.setIcon(trash0);
		}
		if(e.getSource().equals(trashBtn)){
			newBtn.setIcon(new0);
			editBtn.setIcon(edit0);
			trashBtn.setIcon(trash1);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addBtn)){
			addBtn.setIcon(new ImageIcon("ui/image/hall/add1.png"));
		}
		else if(e.getSource().equals(saveBtn)){
			saveBtn.setIcon(new ImageIcon("ui/image/hall/save1.png"));
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addBtn)){
			addBtn.setIcon(new ImageIcon("ui/image/hall/add0.png"));
		}
		else if(e.getSource().equals(saveBtn)){
			saveBtn.setIcon(new ImageIcon("ui/image/hall/save0.png"));
		}
	}
	
	public ArrayList<Drivervo> getAll(){
		return vehicleBL.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return DriverVO
	 */
	public Drivervo getDriver(String id){
		
		return vehicleBL.viewDriver(id);
	}
	
	/**
	 * 
	 * @param id
	 */
	public ResultMessage deleteDriver(String id){
		
		return vehicleBL.deleteDriver(id);
	}
	
	/**
	 * 
	 * @param vo
	 */
	public ResultMessage addDriver(Drivervo vo){
		
		return vehicleBL.addDriver(vo);
	}
	
	/**
	 * 
	 * @param id
	 * @param vo
	 */
	public void modifyDriver(String id, Drivervo vo){
		
		vehicleBL.modifyDriver(id, vo);
		
	}
	
	public void refreshData(){
		//清空table
		int rowCount = table.getTableModel().getRowCount();
		for(int i = rowCount - 1; i >= 0 ; i --){
			table.getTableModel().removeRow(i);
		}
		
		driverList = new ArrayList<Drivervo>();
		int length = getAll().size();
		for(int i = 0; i < length; i ++){
			driverList.add(getAll().get(i));
		}
		
		String[] row = new String[2];
		for(int i = 0; i < driverList.size(); i ++){
			row[0] = driverList.get(i).getId();
			row[1] = driverList.get(i).getName();
			table.getTableModel().addRow(row);
		}
		
	}
	
	public boolean isFilled(){
		boolean driverId, name, identity, cellphone;
		driverId = (driverIdField.getText().length() == 0) ? false : true;
		name = (nameField.getText().length() == 0) ? false : true;
		identity = (identityField.getText().length() == 0) ? false : true;
		cellphone = (cellphoneField.getText().length() == 0) ? false : true;
		return driverId && name && identity && cellphone;
	}
	
	public boolean isError(){
		driverErr = (driverIdField.getText().trim().length()==10) ? true : false;
		identityErr = (identityField.getText().trim().length()==18) ? true : false;
		cellphoneErr = (cellphoneField.getText().trim().length()==11) ? true : false;
		return driverErr && identityErr && cellphoneErr;
	}
}
