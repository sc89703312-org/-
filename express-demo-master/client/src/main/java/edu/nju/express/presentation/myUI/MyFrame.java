package edu.nju.express.presentation.myUI;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;


public class MyFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static Point location;
	
	public MyFrame() {
		// TODO Auto-generated constructor stub
	

		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0,0));
		this.setDragable();
		this.setSize(900, 600);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new HyalineValue().start();
	}
	
	
	public void closeFrame(){
		new Vanish().start();
	}
	
  protected class HyalineValue extends Thread {
		
		float hyalineValue = 0f;

		public void run() {
			
		
			
			while(true) {
				
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hyalineValue += 0.02f;
				if (hyalineValue > 1) {
					hyalineValue = 1;
				}
				setOpacity(hyalineValue);
				if (hyalineValue == 1) {
					break;
				}

			}
		}
	}
  
  
  private Point loc = null;
	private Point tmp = null;
	private boolean isDragged = false;

	/**
	 * 设置Frame可以拖动
	 * @author cylong
	 * @version 2014年12月12日 上午3:22:12
	 */
	public void setDragable() {
		this.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				isDragged = false;
			}

			public void mousePressed(MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
			}

		});

		this.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				if (isDragged) {
					loc = new Point(getLocation().x + e.getX() - tmp.x, getLocation().y + e.getY() - tmp.y);
					setLocation(loc);
					MyFrame.this.location = loc;
				}
			}
		});
	}
	
	
	
	private class Vanish extends Thread {

		/** 窗体透明值 */
		protected float hyalineValue = 1f;

		public void run() {
			try {
				
				
				
				while(true) {
					
					
		
					Thread.sleep(20);
					hyalineValue -= 0.05f;
					if (hyalineValue < 0) {
						hyalineValue = 0;
					}
					MyFrame.this.setOpacity(hyalineValue);
					if (hyalineValue == 0) {
						MyFrame.this.dispose();
						break;
					}
				}
			 
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static Point getLoc(){
		return location;
	}
}