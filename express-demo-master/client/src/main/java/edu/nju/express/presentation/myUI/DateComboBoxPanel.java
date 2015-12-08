package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 用来选择日期，默认为当天
 */
public class DateComboBoxPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	static Font font = new Font("黑体", Font.PLAIN, 18);
	static Color color = new Color(44, 62,80);

	MyComboBox<String> year, month, day;

	public DateComboBoxPanel() {

		this.setOpaque(false);
		
		Calendar c = Calendar.getInstance(Locale.CHINA);
		
		year = new MyComboBox<String>();
		month = new MyComboBox<String>();
		day = new MyComboBox<String>();
		year.setPreferredSize(new Dimension(90, 32));
		month.setPreferredSize(new Dimension(65, 32));
		day.setPreferredSize(new Dimension(65, 32));
		
		for (int i = 1965; i <= 2025; i++)
			year.addItem(i+"");
		year.setSelectedItem(c.get(Calendar.YEAR)+"");

		for (int i = 1; i <= 12; i++)
			month.addItem(String.format("%02d",i));
		month.setSelectedItem(String.format("%02d",c.get(Calendar.MONTH)+1));
		
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++)
			day.addItem(String.format("%02d",i));
		day.setSelectedItem(String.format("%02d",c.get(Calendar.DATE)));
		
		JLabel y = new JLabel("年");
		y.setFont(font);
		y.setForeground(color);
		JLabel m = new JLabel("月");
		m.setFont(font);
		m.setForeground(color);
		JLabel d = new JLabel("日");
		d.setFont(font);
		d.setForeground(color);
		
		
		this.add(year);
		this.add(y);
		this.add(month);
		this.add(m);
		this.add(day);
		this.add(d);
		
	}
	
	public JComboBox<String> getYearComboBox(){
		return year;
	}
	
	public JComboBox<String> getMonthComboBox(){
		return month;
	}
	
	public JComboBox<String> getDayComboBox(){
		return day;
	}
	
	public String getDate(){
		return year.getSelectedItem()+"/"+month.getSelectedItem()+"/"+day.getSelectedItem();
		
	}
	
	public void setYearComboBox(String item){
		year.setSelectedItem(item);
	}
	
	public void setMonthComboBox(String item){
		month.setSelectedItem(item);
	}
	
	public void setDayComboBox(String item){
		day.setSelectedItem(item);
	}

}
