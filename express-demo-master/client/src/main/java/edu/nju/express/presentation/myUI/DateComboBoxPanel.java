package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/*
 * 用来选择日期，默认为当天
 */
public class DateComboBoxPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	static Font font1 = new Font("黑体", Font.PLAIN, 16);
	static Font font2 = new Font("黑体", Font.PLAIN, 15);
	static Color color = Color.white;

	MyComboBox<String> year, month, day;

	public DateComboBoxPanel() {

		this.setOpaque(false);
		
		Calendar c = Calendar.getInstance(Locale.CHINA);
		
		year = new MyComboBox<String>();
		month = new MyComboBox<String>();
		day = new MyComboBox<String>();
		
		for (int i = 2015; i <= 2030; i++)
			year.addItem(i+"");
		year.setSelectedItem(c.get(Calendar.YEAR));

		for (int i = 1; i <= 12; i++)
			month.addItem(String.format("%02d",i));
		month.setSelectedItem(String.format("%02d",c.get(Calendar.MONTH)+1));
		
		for (int i = 1; i <= c.getActualMaximum(Calendar.DAY_OF_MONTH); i++)
			day.addItem(String.format("%02d",i));
		day.setSelectedItem(String.format("%02d",c.get(Calendar.DATE)));
		
		JLabel y = new JLabel("年");
		y.setFont(font1);
		y.setForeground(color);
		JLabel m = new JLabel("月");
		m.setFont(font1);
		m.setForeground(color);
		JLabel d = new JLabel("日");
		d.setFont(font1);
		d.setForeground(color);
		
		
		this.add(year);
		this.add(y);
		this.add(month);
		this.add(m);
		this.add(day);
		this.add(d);
		
	}
	
	public String getDate(){
		return year.getSelectedItem()+"/"+month.getSelectedItem()+"/"+day.getSelectedItem();
		
	}

}
