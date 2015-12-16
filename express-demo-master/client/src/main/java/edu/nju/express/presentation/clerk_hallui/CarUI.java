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

import edu.nju.express.blservice.CarControlService;
import edu.nju.express.common.ResultMessage;
import edu.nju.express.presentation.UIController;
import edu.nju.express.presentation.myUI.LabelTextField;
import edu.nju.express.presentation.myUI.MyButton;
import edu.nju.express.presentation.myUI.MySearchFieldPanel;
import edu.nju.express.vo.Carvo;
import edu.nju.express.vo.Drivervo;

public class CarUI extends JPanel implements MouseListener{
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
	
	private int width = 900, height = 600;
	private HallController controller;
	private CarControlService car;
	private JPanel mainpanel;
	private JLabel bg;
	private JButton newBtn, editBtn, trashBtn;
	private JPanel newPanel, errorPanel1, nullPointerPanel, errorPanel2, deleteConfirmPanel;
	private JButton saveBtn, addBtn;
	private MySearchFieldPanel searchField;
	private LabelTextField idField, numberField;
	
	Font font = new Font("黑体", Font.PLAIN, 18);
	Color color = new Color(44, 62,80);
	
	private boolean isInfo = false;
	private boolean isNew = true;
	
	public 	CarUI(HallController controller){
		this.controller = controller;
		this.car = controller.car;
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
		
		
		
		
		bg = new JLabel(new ImageIcon("ui/image/hall/car.png"));
		bg.setBounds(0, 0, width, height);
		
		
		this.add(mainpanel);
		this.add(bg);
		this.add(new HallGuide(controller));
		this.setLayout(null);
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
				mainpanel.remove(errorPanel1);
				mainpanel.remove(errorPanel2);
				mainpanel.remove(nullPointerPanel);

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
				//只要点击edit就remove “添加”"保存"按钮
				mainpanel.remove(addBtn);
				mainpanel.remove(saveBtn);
				if(isNew){
					mainpanel.remove(newPanel);
					mainpanel.remove(nullPointerPanel);
					mainpanel.remove(errorPanel2);
					mainpanel.add(errorPanel1);
					
				}
				else if(isInfo){
					enableInfoPanel();
					//编辑时不让删除
					trashBtn.setEnabled(false);
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
					mainpanel.remove(addBtn);
					mainpanel.remove(newPanel);
					mainpanel.remove(errorPanel1);
					mainpanel.remove(nullPointerPanel);
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
				mainpanel.remove(saveBtn);
				if(getCar(searchField.getText())!=null){
					setIsInfo(true);
					setIsNew(false);
					initInfoPanel(getCar(searchField.getText()));
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
				addCar(new Carvo(idField.getText(), "motor", numberField.getText(),
						"base", "purchase", 1));
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
				modifyCar(idField.getText(), new Carvo(idField.getText(), "motor",
						numberField.getText(),
						"base", "purchase", 1));
			}
			
		});
	}

	public void initInfoPanel(Carvo vo){ 
		
		idField.setText(vo.getId());
		idField.getTextField().setEditable(false);
		
		numberField.setText(vo.getCar());
		numberField.getTextField().setEditable(false);
	}
	
	public void clearPanel(){
		idField.setText("");
		numberField.setText("");
	}
	
	public void enableInfoPanel(){
		idField.getTextField().setEditable(true);
		numberField.getTextField().setEditable(true);
	}

	public void initNewPanel(){
		newPanel = new JPanel();
		newPanel.setLayout(null);
		newPanel.setBounds(128, 117, 729, 452);
		newPanel.setOpaque(false);
		newPanel.setVisible(true);
		
		idField = new LabelTextField("车辆代号",9 );
		idField.setBounds(110, 80, 300, 45);
		newPanel.add(idField);
		
		numberField = new LabelTextField("车牌号  ",7);
		numberField.setBounds(110, 160, 300, 45);
		newPanel.add(numberField);
		

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
				delCar(idField.getText());
				clearPanel();
				mainpanel.remove(mainpanel.getComponentAt(396, 526));
				//remove deleteConfirmPanel
				mainpanel.remove(mainpanel.getComponentAt(355, 257));
				mainpanel.add(addBtn);
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
				trashBtn.setIcon(trash0);
				
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
	
	public ArrayList<Carvo> getAll(){
		return car.;
	}
	
	public Carvo getCar(String id){
		return car.viewCar(id);
	}
	
	public ResultMessage addCar(Carvo vo){
		return car.addCar(vo);
	}
	
	public ResultMessage delCar(String id){
		return car.deleteCar(id);
	}
	
	public ResultMessage modifyCar(String id, Carvo vo){
		return car.modifyCar(id, vo);
	}
}
