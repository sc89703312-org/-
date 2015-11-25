package edu.nju.express.presentation.myUI;

import javax.swing.JFrame;


public class MyFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public MyFrame() {
		// TODO Auto-generated constructor stub
	
	
		this.setUndecorated(true);
		new HyalineValue().start();
	}
	
  protected class HyalineValue extends Thread {
		
		float hyalineValue = 0f;

		public void run() {
			while(true) {
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				hyalineValue += 0.05f;
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
}
