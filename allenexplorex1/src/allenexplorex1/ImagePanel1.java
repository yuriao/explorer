package allenexplorex1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel1 extends JPanel{
// this class load the image and realize the motion of blood bar and energy bar
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage bufImage1;
    int x1=0;//x coordination of bar
    int y1=0;//y coordination of bar
    
    public void bar() //load the image of bar and initiate the x and y coordination
    {
    	
    	File file=new File("characters/bar.png");

    	bufImage1=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
    	try {
			bufImage1=ImageIO.read(file);//load the image
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	x1=0;
    	y1=0;
    	repaint();

    }
    
	public void bloodbarmotion(int x11) //motion of blood bar
    {

    	x1=x11;//receive the x coordination from x11. x11 is defined by other actions, 
    	       //such as repair, accident at weird structure, on the hill or mountain, etc.
    	y1=0;
    	repaint();

    }
    
    public void energybarmotion(int x11) //motion of energy bar
    {
    	
    	x1=x11;//receive the x coordination from x11. x11 is defined by other actions, 
	       //such as repair, in the night, etc.
    	y1=0;
    	repaint();

    }
    
    public void lowstatus(int num)//when blood or energy is low
    {
    	
    	File file=new File("characters/barcri.png");//change the image of bar (green to red)
    	bufImage1=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
    	try {
			bufImage1=ImageIO.read(file);//load new image
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			repaint();
		}
    	if(num==1)//blood is low
    	{
    	texture.lowwarning1=true;
    	}
    	if(num==2)//energy is low
    	{
    	texture.lowwarning2=true;
    	}
    }
    
    public void paint(Graphics g) 
    {
        super.paintComponent(g);
        if (bufImage1 != null) {
        g.drawImage(bufImage1,x1,y1,this);
        //ªÊ÷∆Õº∆¨           
        }
     
     }
}
