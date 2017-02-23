package allenexplorex1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel1 extends JPanel{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage bufImage1;
    int x1=0;
    int y1=0;
    
    public void bar() 
    {
    	
    	File file=new File("characters/bar.png");

    	bufImage1=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
    	try {
			bufImage1=ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	x1=0;
    	y1=0;
    	repaint();

    }
    
	public void bloodbarmotion(int x11) 
    {

    	x1=x11;
    	y1=0;
    	repaint();

    }
    
    public void energybarmotion(int x11) 
    {
    	
    	x1=x11;
    	y1=0;
    	repaint();

    }
    
    public void lowstatus(int num)
    {
    	
    	File file=new File("characters/barcri.png");
    	bufImage1=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
    	try {
			bufImage1=ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			repaint();
		}
    	if(num==1)
    	{
    	texture.lowwarning1=true;
    	}
    	if(num==2)
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
