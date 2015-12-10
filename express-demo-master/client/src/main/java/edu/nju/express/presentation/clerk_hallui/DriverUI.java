package edu.nju.express.presentation.clerk_hallui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.express.blservice.Vehicleblservice;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.presentation.myUI.DateComboBoxPanel;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MyComboBox;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
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
	private JPanel newPanel, errorPanel1, nullPointerPanel,errorPanel2, deleteConfirmPanel;
	private JButton newBtn, editBtn, trashBtn;
	private JLabel  genderLabel, birthLabel, licenseLimitLabel;
	private LabelTextField driverIdField, nameField, identityField, cellphoneField;
	private MyComboBox<String> genderBox;
	private DateComboBoxPanel birthBoxPanel, licenseLimitBoxPanel;
	private MyButton addBtn, saveBtn;
	private MySearchFieldPanel searchField;
	private boolean isInfo = false;
	private boolean isNew = true;
	
	
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
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
		initNewPanel();
		initErrorPanel1();
		initNullPointerPanel();
		initErrorPanel2();
		initDeleteConfirmPanel();
		
		mainpanel.add(newPanel);
		
		
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
		newBtn = new JButton(new1);
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
				mainpanel.remove(addBtn);
				mainpanel.remove(saveBtn);
				if(isNew){
					mainpanel.remove(newPanel);
					mainpanel.remove(nullPointerPanel);
					mainpanel.add(errorPanel1);
					mainpanel.validate();
					mainpanel.repaint();
				}
				else if(isInfo){
					enableInfoPanel();
					//编辑时不让删除
					trashBtn.setEnabled(false);
					//
					mainpanel.add(saveBtn);
					mainpanel.validate();
					mainpanel.repaint();
				}
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
					mainpanel.remove(addBtn);
					mainpanel.remove(newPanel);
					mainpanel.remove(nullPointerPanel);
					mainpanel.remove(errorPanel1);
					mainpanel.add(errorPanel2);
					
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
				
				trashBtn.setEnabled(true);
				mainpanel.remove(addBtn);
				if(getDriver(searchField.getText())!=null){
					setIsInfo(true);
					setIsNew(false);
					initInfoPanel(getDriver(searchField.getText()));
					if(mainpanel.getComponentAt(130, 130).equals(nullPointerPanel)){
						mainpanel.remove(nullPointerPanel);
						mainpanel.add(newPanel);
						mainpanel.add(saveBtn);
					}
				}else{
					setIsNew(true);
					//remove 当前编辑区的panel
					mainpanel.remove(mainpanel.getComponentAt(130, 130));
					mainpanel.add(nullPointerPanel);
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
				addDriver(new Drivervo(driverIdField.getText(), nameField.getText(),
						birthBoxPanel.getDate(), identityField.getText(), 
						cellphoneField.getText(), hall_id, 
						genderBox.getSelectedIndex()==0?true:false,
						licenseLimitBoxPanel.getDate()
						));
			}
			
		});
		mainpanel.add(addBtn);     //初始为newPanel

		saveBtn = new MyButton(395, 525, 110, 45);
		saveBtn.setIcon(new ImageIcon("ui/image/hall/save0.png"));
		saveBtn.addMouseListener(this);
		saveBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				modifyDriver(driverIdField.getText(),
						new Drivervo(driverIdField.getText(), nameField.getText(),
						birthBoxPanel.getDate(), identityField.getText(), 
						cellphoneField.getText(), hall_id, 
						genderBox.getSelectedIndex()==0?true:false,
						licenseLimitBoxPanel.getDate()
						));
			}
			
		});
	}
	
	/**
	 * 给newPanel 添加信息
	 */
	public void initInfoPanel(Drivervo vo){
		driverIdField.setText(vo.getId());
		
		nameField.setText(vo.getName());
		
		genderBox.setSelectedIndex(vo.getSex()==true?0:1);
		
		String birthDate = vo.getBirthDate();
		String[] split = birthDate.split("/");
		birthBoxPanel.getYearComboBox().setSelectedItem(split[0]);
		birthBoxPanel.getMonthComboBox().setSelectedItem(split[1]);
		birthBoxPanel.getDayComboBox().setSelectedItem(split[2]);
		
		identityField.setText(vo.getCertificate());
		
		cellphoneField.setText(vo.getPhone());
		
		//阿西吧。。。。又来一个日期box
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
		
		//birthDate 暂时不写了！！
		
		identityField.setText("");
		
		cellphoneField.setText("");
		
		//ddlDate 暂时不写了！！
	}
	
	/**
	 * 使infoPanel变为可编辑, editBtn响应时调用这个方法
	 */
	public void enableInfoPanel(){
		
		driverIdField.getTextField().setEditable(true);
		
		nameField.getTextField().setEditable(true);
		
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
	
	public void initErrorPanel1(){
		errorPanel1 = new JPanel();
		errorPanel1.setLayout(null);
		errorPanel1.setVisible(true);
		errorPanel1.setOpaque(false);
		errorPanel1.setBounds(128, 117, 729, 452);
		
		JLabel errorLabel = new JLabel("(＞﹏＜)在上方的搜索框中输入司机编号才能编辑~");
		errorLabel.setFont(font);
		errorLabel.setForeground(color);
		errorLabel.setBounds(120, 180, 500, 40);
		errorPanel1.add(errorLabel);
		
	}
	
	public void initNullPointerPanel(){
		nullPointerPanel = new JPanel();
		nullPointerPanel.setLayout(null);
		nullPointerPanel.setVisible(true);
		nullPointerPanel.setOpaque(false);
		nullPointerPanel.setBounds(128, 117, 729, 452);
		
		JLabel errorLabel = new JLabel("Q A Q 司机编号不存在");
		errorLabel.setFont(font);
		errorLabel.setForeground(color);
		errorLabel.setBounds(250, 180, 500, 40);
		nullPointerPanel.add(errorLabel);
		
	}
	
	public void initErrorPanel2(){
		errorPanel2 = new JPanel();
		errorPanel2.setLayout(null);
		errorPanel2.setVisible(true);
		errorPanel2.setOpaque(false);
		errorPanel2.setBounds(128, 117, 729, 452);
		
		JLabel errorLabel = new JLabel("(＞﹏＜)还没输入要删除的司机编号呢~");
		errorLabel.setFont(font);
		errorLabel.setForeground(color);
		errorLabel.setBounds(120, 180, 500, 40);
		errorPanel2.add(errorLabel);
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
				mainpanel.remove(mainpanel.getComponentAt(396, 526));
				//remove deleteConfirmPanel
				mainpanel.remove(mainpanel.getComponentAt(355, 257));
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
	
	
}
