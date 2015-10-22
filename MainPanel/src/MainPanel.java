import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class MainPanel {
	
	
	
	
	
    Vector PointList = new Vector();
	JFrame frame = new JFrame();
	JavaDraw2DPanel panel = new JavaDraw2DPanel();
    double ini_x=450.0+200*Math.cos(Math.PI/8);
    double ini_y=300.0+200*Math.sin(Math.PI/8);
    double x;
    double y;
    double next_x;
    double next_y;
    int i=0;
    Line2D.Double line = new Line2D.Double();	
    int j=0;
	int u=0;
	boolean is =true;
	int index=0;
	double t;
	boolean isContained =false ;
	Point p =new Point(0,0);//used to record the mouse position
    GameColor gamecolor  =new GameColor();
    int ini1=(int)ini_x;
	int ini2=(int)ini_y;
	int vx=16;
	int vy=8;
	int t1=5;
	int t2=15;
    Vector linelist = new Vector();
    Vector linelist2 =new Vector();
    double ini_x0 = ini1;
    double ini_y0 = ini2;
    double x0=ini_x0;
    double y0=ini_y0;    
    double ini_x2=ini1+vx*(t1+1);
    double ini_y2=ini2-vy*(t1+1);
    double x2=ini_x2;
    double y2=ini_y2;
	boolean isOk=false;
	
	public static void main(String [] args){
		
		
		new MainPanel().init();
		
		
	
	}
	
	
	
	public void init(){
		frame.setTitle("Test");
		frame.setSize(1080, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
		
		
		while(true){
			
			
			if(isContained){
			if(x0<=ini1+t1*vx) {
	    		 x0=ini_x0+vx;
	    		 y0=ini_y0-vy;
	             
	             }
	             else if(x0<ini1+vx*t2){
	            	 y2=ini_y2-vy;
	            	 x0=ini_x0+vx;
	             }
	             else if(x2<ini1+vx*t2){
	            	 y0=ini_y0-vy;
	            	 x2=ini_x2+vx;
	             }
			
	             else{
	            	 isOk = true;
	             }
			
			}
			
			
			
			
			
			
			
			
 
        	t=i*Math.PI/100;
        	double t1=(i+1)*Math.PI/100;
        	if(t>2*Math.PI-9*Math.PI/100)
        		 is =false;
        	x=450.0+200*Math.cos(Math.PI/8)*Math.cos(t)-100*Math.sin(t)*Math.sin(Math.PI/8);
			y=300.0+200*Math.sin(Math.PI/8)*Math.cos(t)+100*Math.sin(t)*Math.cos(Math.PI/8);
			next_x=450.0+200*Math.cos(Math.PI/8)*Math.cos(t1)-100*Math.sin(t1)*Math.sin(Math.PI/8);
			next_y=300.0+200*Math.sin(Math.PI/8)*Math.cos(t1)+100*Math.sin(t1)*Math.cos(Math.PI/8);
			panel.repaint();
			ini_x=x;
			ini_y=y;	
			
		    i++;
			try{
				Thread.sleep(25);	

				}catch(Exception ex){}	
		
		}
		
		
	}
	
	
	
	
	
	
	
	public class JavaDraw2DPanel extends JPanel implements MouseListener,MouseMotionListener{
		BufferedImage iBuffer = new BufferedImage(1080,720,BufferedImage.TYPE_INT_RGB);
		Graphics2D gBuffer;
        Color c1;//the color of background
		Color c2;//the color of oval
		Color c3;//the color of star
	
		
		
		
		public JavaDraw2DPanel(){
			super();
			addMouseListener(this);
			addMouseMotionListener(this);
			setPreferredSize(new Dimension(1080,720));
				}
			
			
		
		
		
			public void paintComponent(Graphics g){
				//设置颜色
               c1= gamecolor.darkColors[0];
               c2=gamecolor.lightColors[0];
               c3=gamecolor.lightColors[1];
               
               //设置透明度
               AlphaComposite ac1 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
               AlphaComposite ac2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
    
               
              
               
               
               linelist.add(new Line2D.Double(ini_x0, ini_y0, x0, y0));
      		 linelist2.add(new Line2D.Double(ini_x2, ini_y2, x2, y2));
               PointList.add(new Line2D.Double(ini_x, ini_y, next_x, next_y));
               
				
				gBuffer = iBuffer.createGraphics();
				gBuffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				gBuffer.setColor(c1);
				gBuffer.fillRect(0, 0, iBuffer.getWidth(), iBuffer.getHeight());	
		        gBuffer.setColor(c2);

				if(isContained){
		        
				gBuffer.setStroke(new BasicStroke(5.0f));
				for(int j=0;j<linelist.size();j++){
	    			 Line2D s =(Line2D)linelist.get(j);
	    			    
	 	 	    	     gBuffer.draw(s);
	    		 
	    		 }
	    		 for(int i=0;i<linelist2.size();i++){
	    			 Line2D s =(Line2D)linelist2.get(i);
	  	    	     gBuffer.draw(s);
	    		 }
	    		 if(isOk){
	        		 
	        		 gBuffer.drawString("Click the oval to start", ini1+vx*t1+25, ini2-vy*t1-60);
	        		 }
				
				}
				
				
				//画出oval
				Ellipse2D.Double oval = new Ellipse2D.Double();
				oval.setFrameFromCenter(ini_x, ini_y, ini_x+50, ini_y+50);
				Shape ovals =oval;
                
				if(ovals.contains(p)){
					isContained =true;
				}

				
				
	
				
                
				Ellipse2D.Double star =new Ellipse2D.Double();
				star.setFrameFromCenter(450, 275, 600, 125);
				
				
				
				
				AffineTransform tr = new AffineTransform();
				tr.rotate(Math.PI/8, 450, 300);
				Shape stars = tr.createTransformedShape(star);
				
                
				if(next_x<x){
					
					if(!is){
						for(int w=99;w<200;w++){
							try {
								Line2D s =(Line2D)PointList.get(w);
							 gBuffer.setStroke(new BasicStroke(5.0f));
							 gBuffer.setComposite(ac1);
							 gBuffer.setColor(c2);
	               			 gBuffer.draw(s);   
	               			 gBuffer.setComposite(ac2);
							} catch (Exception e) {
								// TODO: handle exception
							}
							 
						}
					}
					
					
					
					
				gBuffer.setColor(c3);	
				gBuffer.draw(stars);	   
                gBuffer.fill(stars);
                
                
                if(is){
                for(j=0;j<PointList.size();j++){
       			 Line2D s =(Line2D)PointList.get(j);
       			gBuffer.setStroke(new BasicStroke(5.0f));
 				gBuffer.setColor(c2);
 				 gBuffer.setComposite(ac1);
       			 gBuffer.draw(s);            
       			 gBuffer.setComposite(ac2);
                }               

                }
                else{
                	for(int m=0;m<=100;m++){
                		 Line2D s =(Line2D)PointList.get(m);
                		 gBuffer.setStroke(new BasicStroke(5.0f));
         				 gBuffer.setColor(c2);
         				 gBuffer.setComposite(ac1);
               			 gBuffer.draw(s);   
               			 gBuffer.setComposite(ac2);
                	}
                }

                
             
                gBuffer.setColor(c2);
                gBuffer.draw(ovals);                 
                gBuffer.fill(ovals);   
                  
				g.drawImage(iBuffer, 0, 0, null);
				}
				
				
				
				
				else {	
					
					if(is){
						
						
					  for( u=j;u<PointList.size();u++){
			       			 Line2D s =(Line2D)PointList.get(u);
			       			gBuffer.setStroke(new BasicStroke(5.0f));
			 				 gBuffer.setColor(c2);
			 				 gBuffer.setComposite(ac1);
			       			 gBuffer.draw(s);
			       			 gBuffer.setComposite(ac2);
				                }
					}
					else{
						for(int m=100;m<=201;m++){
							try {
								Line2D s =(Line2D)PointList.get(m);
								gBuffer.setStroke(new BasicStroke(5.0f));
							gBuffer.setColor(c2);
							 gBuffer.setComposite(ac1);
			       			gBuffer.draw(s);
			       		 gBuffer.setComposite(ac2);
							} catch (Exception e) {
								// TODO: handle exception
							}
							
							
						}
					}
					
					
				
                    gBuffer.setColor(c2);
	                gBuffer.draw(ovals);
	                gBuffer.fill(ovals);
			
	                
	                
	                gBuffer.setColor(c3);
	                gBuffer.draw(stars);	               
	                gBuffer.fill(stars);	                
	                gBuffer.setColor(c2);
	                
	                
	               if(is){
	                  for(int q=0;q<j;q++){
	        	          Line2D s = (Line2D) PointList.get(q);
	        	          gBuffer.setStroke(new BasicStroke(5.0f));
	      				  gBuffer.setColor(c2);
	      				 gBuffer.setComposite(ac1);
	        	          gBuffer.draw(s);
	        	          gBuffer.setComposite(ac2);
	                   }
	                }
	               else{
	            	   for(int n=0;n<100;n++){
	            		   Line2D s = (Line2D) PointList.get(n);
	            		   gBuffer.setStroke(new BasicStroke(5.0f));
	       				      gBuffer.setColor(c2);
	       				   gBuffer.setComposite(ac1);
		        	          gBuffer.draw(s);
		        	          gBuffer.setComposite(ac2);
	            	   }
	               }
	               
	               
	            
                  
					g.drawImage(iBuffer, 0, 0, null);
					
				}
                     ini_x0=x0;
		    		 ini_y0=y0;
		             ini_x2=x2;
		             ini_y2=y2;
		
	}


			
			
			
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				p=(Point) e.getPoint();
			}


			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				
			}


			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


		
}



}
