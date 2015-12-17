package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/*
 * 用来选择日期，默认为当天
 */
public class DateComboBoxV2 extends JPanel {
	private static final long serialVersionUID = 1L;

	static Font font = new Font("黑体", Font.PLAIN, 16);
	private static Icon search1 = new ImageIcon("ui/button/searchbutton1.png");
	private static Icon search2 = new ImageIcon("ui/button/searchbutton2.png");
	static Color color = new Color(44, 62,80);

	MyComboBox<String> year1, month1, day1;
	MyComboBox<String> year2, month2, day2;
	private JButton search;

	public DateComboBoxV2() {

		this.setOpaque(false);
		
		
		
		year1 = new MyComboBox<String>();
		month1 = new MyComboBox<String>();
		day1 = new MyComboBox<String>();
		year1.setPreferredSize(new Dimension(78, 30));
		month1.setPreferredSize(new Dimension(55, 30));
		day1.setPreferredSize(new Dimension(55, 30));
		
		
		for (int i = 1965; i <= 2025; i++)
			year1.addItem(i+"");
		
		for (int i = 1; i <= 12; i++)
			month1.addItem(String.format("%02d",i));
		
		for (int i = 1; i <= 31; i++)
			day1.addItem(String.format("%02d",i));
		
		
		year2 = new MyComboBox<String>();
		month2 = new MyComboBox<String>();
		day2 = new MyComboBox<String>();
		year2.setPreferredSize(new Dimension(78, 30));
		month2.setPreferredSize(new Dimension(55, 30));
		day2.setPreferredSize(new Dimension(55, 30));
		
		
		for (int i = 1965; i <= 2025; i++)
			year2.addItem(i+"");
		
		for (int i = 1; i <= 12; i++)
			month2.addItem(String.format("%02d",i));
		
		for (int i = 1; i <= 31; i++)
			day2.addItem(String.format("%02d",i));
		
		
		setToday();

		
		JLabel y1 = new JLabel("年");
		y1.setFont(font);
		y1.setForeground(color);
		JLabel m1 = new JLabel("月");
		m1.setFont(font);
		m1.setForeground(color);
		JLabel d1 = new JLabel("日 ");
		d1.setFont(font);
		d1.setForeground(color);
		
		JLabel y2 = new JLabel("年");
		y2.setFont(font);
		y2.setForeground(color);
		JLabel m2 = new JLabel("月");
		m2.setFont(font);
		m2.setForeground(color);
		JLabel d2 = new JLabel("日 ");
		d2.setFont(font);
		d2.setForeground(color);
		
		
		this.add(year1);
		this.add(y1);
		this.add(month1);
		this.add(m1);
		this.add(day1);
		this.add(d1);
		
		JLabel l = new JLabel("- ");
		l.setOpaque(false);
		l.setForeground(color);
		l.setFont(font);
		this.add(l);
		
		this.add(year2);
		this.add(y2);
		this.add(month2);
		this.add(m2);
		this.add(day2);
		this.add(d2);
		
		search = new JButton(search1);
		search.setContentAreaFilled(false);
		search.setFocusPainted(false);
		search.setBorder(new EmptyBorder(0, 0, 0, 0));
		search.setRolloverIcon(search2);
		this.add(search);
		
	}
	
	
	public String[] getDate(){
		String[] dates = new String[2];
		dates[0]=year1.getSelectedItem()+"/"+month1.getSelectedItem()+"/"+day1.getSelectedItem();
		dates[1]=year2.getSelectedItem()+"/"+month2.getSelectedItem()+"/"+day2.getSelectedItem();
		
		return dates;
	}
	
	public void setToday(){
		Calendar c = Calendar.getInstance(Locale.CHINA);
		year1.setSelectedItem(c.get(Calendar.YEAR)+"");
		month1.setSelectedItem(String.format("%02d",c.get(Calendar.MONTH)+1));
		day1.setSelectedItem(String.format("%02d",c.get(Calendar.DATE)));
		
		year2.setSelectedItem(c.get(Calendar.YEAR)+"");
		month2.setSelectedItem(String.format("%02d",c.get(Calendar.MONTH)+1));
		day2.setSelectedItem(String.format("%02d",c.get(Calendar.DATE)));
	}
	
	public JButton getSearchButton(){
		return search;
	}

}
