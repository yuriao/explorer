package allenexplorex1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class noticeshow extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x1=-200;
	int y1=0;
	int count=0;
	int count2=0;
	boolean displaying=false;
	Image image;
    BufferedImage bufImage;
    BufferedImage bufImage1;
    Graphics2D bufImageG;
    int num=1;
	
	public void noticeselect()
	{
		File file=new File("basictexture/notice"+Integer.toString(num)+".png");
     	bufImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
     	try {
				bufImage=ImageIO.read(file);
				System.out.println("buhaha");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	x1=-200;
     	y1=0;
     	repaint();	

	}
	
	public void noticeshowon(int n)
	{	
		num=n;
		x1=-200;
		if(texture.collection<10)
		{
		 if(n==1)
         {
         	noticeselect();
         }
         
         if(n==2)
         {
         	noticeselect();
         }
         
         if(n==3)
         {
         	noticeselect();
         }
         
         if(n==4)
         {
         	noticeselect();
         }
         
         if(n==5)
         {
         	noticeselect();
         }
         
         if(n==6)
         {
         	noticeselect();
         }
         
		}
         if(texture.collection>=10)
         {
        	num=5;
         	noticeselect();
         }
		
		ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
		TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            if(x1<0&&count<=1500)
            {
            	x1=x1+5;
            }
            
            if(x1>=0&&count<=1500)
            {
            	x1=0;
            }
            if(x1>=0&&count>1500)
            {
            	x1=x1-5;
            }
            if(x1<0&&count>1500)
            {
            	x1=x1-5;
            }
            if(x1==-200&&count>1500)
            {
            	x1=-200;
            	count=0;
            	service.shutdownNow();
            }
            repaint();	
            count=count+10;
        }
            
        };
	    
		service.scheduleAtFixedRate(timerTask, 0, 10, TimeUnit.MILLISECONDS);
	    }
	
	public void paint(Graphics g) 
    {
        super.paintComponent(g);
        if (bufImage != null) {
        g.drawImage(bufImage,x1,y1,this);
        //ªÊ÷∆Õº∆¨           
        }
     
     }

}
