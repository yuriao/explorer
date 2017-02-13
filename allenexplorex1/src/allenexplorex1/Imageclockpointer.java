package allenexplorex1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Imageclockpointer extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
    BufferedImage bufImage;
    BufferedImage bufImage1;
    Graphics2D bufImageG;
    double angle=3;
    
    public void loadImage() 
    {
        image = Toolkit.getDefaultToolkit().getImage("basictexture/clockpointer.png"); //get the pointer image
        MediaTracker mt = new MediaTracker(this); 
        mt.addImage(image, 0);
        try {
            mt.waitForAll(); 
        } catch (Exception ex) {
            ex.printStackTrace();  
        }
        
        bufImage1 = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB); // add pointer image to memory          
        bufImage=bufImage1;
        bufImageG=bufImage.createGraphics();
        bufImageG.drawImage(image,0,0,this); 
        repaint(); 
    }   
    
	public void pointerrun()
	{
		loadImage();//load pointer image to memory
		Runnable runnable = new Runnable() 
		{
            public void run() 
            {
              
              rotateImage(angle);//rotate the pointer to specific angle
              angle=angle+0.1;//change the angle
              if(angle>360)//360 degree is same to 0 degree
              {
            	  angle=angle-360;
              }
              if(angle>=0&&angle<=2)//when angle in 0-2 degree, means day coming
              {
            	  
            	  texture.daynightsign=true;
            	  texture.labelclock.setIcon(texture.clockday);//change clock window 
            	  if(angle>=1.9&&angle<2)
            	  {
            	  texture.dcount=texture.dcount+1;//day number add 1
            	  }
            	  texture.night.nightdaycoming();//remove night
            	  texture.explorer.explorerimagechange();//character to day status
              }
              if(angle>=208&&angle<=212)//when angle in 208-212 degree, means night coming
              {
            	  texture.daynightsign=false;
            	  texture.labelclock.setIcon(texture.clocknight);//change clock window 
            	  texture.night.nightdaycoming();//add night
            	  texture.explorer.explorerimagechange();//character to night status
              }
              
            }
        };
			
		texture.service.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.MILLISECONDS);//execute per 0.01 sec
		
	}
	 public void rotateImage(double angle) {//image rotation function
		 angle=angle*3.14/(180);
         if (bufImage == null)
             return; //if bufImage is empty, return
         BufferedImage filteredBufImage =new BufferedImage(image.getWidth(this) ,image.getHeight(this),BufferedImage.TYPE_INT_ARGB); 
         AffineTransform transform = new AffineTransform(); //call transform class
         
         transform.rotate(angle,40,40); //rotate image
         AffineTransformOp imageOp = new AffineTransformOp(transform, null);         
         imageOp.filter(bufImage1, filteredBufImage);//filter image
         bufImage = filteredBufImage; //use filtered image to replace original image, finish rotation
         repaint(); //paint the pointer to window
     }
	  public void paint(Graphics g) 
      {
          super.paintComponent(g);
          if (bufImage != null) {
          g.drawImage(bufImage,0,0,this);
                     
          }
       
       }


}
