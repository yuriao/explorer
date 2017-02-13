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

public class Imagescannermotion extends JPanel{
//this class define the motion of the scanner
	private static final long serialVersionUID = 1L;
	Image image;
    BufferedImage bufImage;
    BufferedImage bufImage1;
    Graphics2D bufImageG;
    double angle=3;//define the initiate angle of the scanner
    
    public void loadImage() 
    {
        image = Toolkit.getDefaultToolkit().getImage("characters/scanner.png"); //load the scanner image
        MediaTracker mt = new MediaTracker(this); 
        mt.addImage(image, 0);
        try {
            mt.waitForAll(); 
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
        
        bufImage1 = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);//load the image to memory
        bufImage=bufImage1;
        bufImageG=bufImage.createGraphics();
        bufImageG.drawImage(image,0,0,this);
        repaint(); 
    }       
    
	public void scannerrun()
	{
		loadImage();
		Runnable runnable = new Runnable() 
		{
            public void run() 
            {
              
              rotateImage(angle);//rotate the scanner
              angle=angle+0.5;// 0.5 degree per 0.01 sec
              if(angle>360)//360 degree equals to 0 degree
              {
            	  angle=angle-360;
              }
              
            }
        };
			
		texture.service.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.MILLISECONDS);//timer start
		
	}
	 public void rotateImage(double angle) {
		 angle=angle*3.14/(180);
         if (bufImage == null)
             return; //if bufImage is empty, return
         BufferedImage filteredBufImage =new BufferedImage(image.getWidth(this) ,image.getHeight(this),BufferedImage.TYPE_INT_ARGB); 
         AffineTransform transform = new AffineTransform(); //call transform class
         
         transform.rotate(angle,75,75); //rotate image
         AffineTransformOp imageOp = new AffineTransformOp(transform, null);    
         imageOp.filter(bufImage1, filteredBufImage);//filter image
         bufImage = filteredBufImage; //use filtered image to replace original image, finish rotation
         repaint(); 
     }
	  public void paint(Graphics g) 
      {
          super.paintComponent(g);
          if (bufImage != null) {
          g.drawImage(bufImage,0,0,this);
          //ªÊ÷∆Õº∆¨           
          }
       
       }
}
