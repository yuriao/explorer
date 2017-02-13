package allenexplorex1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Imagenight extends JPanel{
// this class define how the night is coming
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
    BufferedImage bufImage;
    BufferedImage bufImage1;
    Graphics2D bufImageG;
    boolean changevalue=false;
    int x1=1001;//initiate x coordination of night image 
    TimerTask timerTask=null;
    
    public void loadImage() 
    {
        image = Toolkit.getDefaultToolkit().getImage("terraintexture/night.png"); //get the night image
        MediaTracker mt = new MediaTracker(this); 
        mt.addImage(image, 0); 
        try {
            mt.waitForAll(); 
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
        
        bufImage1 = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);//load image to memory         
        bufImage=bufImage1;
        bufImageG=bufImage.createGraphics();
        bufImageG.drawImage(image,0,0,this); 
        repaint(); 
    }   
    
	public void nightdaycoming()
	{
		
		ScheduledExecutorService service=Executors.newScheduledThreadPool(1);//get a timer thread
		timerTask = new TimerTask() {
            @Override
            public void run() {
		if(texture.daynightsign==false)
		{
		                 //when night time start
               
               if(x1<=0) //if the night image has filled the window, stop moving the image
               {
                   service.shutdownNow();
               }
               if(x1<=-1200)
               {
            	   x1=1001;//initiate the x coordination again after first day time
               }

               x1=x1-1;//move the night image 1 pixel per 0.1 sec
               repaint();
            }
		
		if(texture.daynightsign==true)
		{
               if(x1<=-1200)//if the night image has go out the window, stop moving the image
               {
            	   
            	   service.shutdownNow();  
            	   
               }
               
               x1=x1-1;
               repaint();//move the night image 1 pixel per 0.1 sec
            }
        }
        };
	
		service.scheduleAtFixedRate(timerTask, 0, 100, TimeUnit.MILLISECONDS);
		}
	 
	  public void paint(Graphics g) 
      {
          super.paintComponent(g);
          if (bufImage != null) {
          g.drawImage(bufImage,x1,0,this);
          //»æÖÆÍ¼Æ¬           
          }
       
       }
}
