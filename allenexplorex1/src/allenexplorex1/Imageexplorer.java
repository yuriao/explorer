package allenexplorex1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Imageexplorer extends JPanel{
//this class defines the action of the character
	private static final long serialVersionUID = 1L;
	Image image;
    BufferedImage bufImage;
    BufferedImage bufImage1;
    Graphics2D bufImageG;
    int x=0;//x coordination of character
    int y=0;//y coordination of character
    
	 public void explorerinitiate() 
     {
     	
     	File file=new File("characters/explorerday.png");//get the image of character

     	bufImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
     	try {
				bufImage=ImageIO.read(file);//load the image
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	x=texture.xexp;//initiate the x coordination
     	y=texture.yexp;//initiate the y coordination
     	repaint();
     }
     
     public void explorerimagechange() //in the night, change the character's picture to night version
     {
     	if(texture.daynightsign==true)
     	{
     	File file=new File("characters/explorerday.png");

     	try {
				bufImage=ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	repaint();
     	}
     	
     	if(texture.daynightsign==false)
     	{
     	File file=new File("characters/explorernight.png");

     	try {
				bufImage=ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	repaint();
     	}
     	
     	
     }
     
     public void explorerdown(int num) 
     {    	
    	 File file=new File("basictexture/explorerdown.png");;
    	 if(num==2)
    	 {
     	file=new File("basictexture/explorerdown.png");
    	 }
    	 if(num==1)
    	 {
     	file=new File("basictexture/explorerdrown.png");
    	 }
    	 

     	try {
				bufImage=ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	repaint();

     }
     
     public void explorermotion() 
     {
     	texture.explorerstopsign=false;
     	Timer timer=new Timer();
		    timer.schedule(new TimerTask(){

				public void run() {
					
					if(texture.energypoint>0)
					{
					int xden=texture.xdens;
					int yden=texture.ydens;
				if(texture.xexp==xden&&texture.yexp>=yden-1&&texture.yexp<=yden+1)
				{
					texture.explorerstopsign=true;
					timer.cancel();					
				}
             if(texture.xexp!=xden&&texture.yexp!=yden)
             {
				if(texture.xexp!=xden)
				{
				texture.xexp=texture.xexp+(xden-texture.xexp)/((int)Math.abs(xden-texture.xexp));
				texture.explorersignminimap.printminimap();
				
				
				}
				if(texture.yexp!=yden)
				{
				texture.yexp=texture.yexp+(yden-texture.yexp)/((int)Math.abs(yden-texture.yexp));
				texture.explorersignminimap.printminimap();

				}
							
				x=texture.xexp;
				y=texture.yexp;
				repaint();
				if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==313)
				{
					texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
					for(int u=-101;u<101;u++)
					{
						for(int v=-101;v<101;v++)
						{
							if(texture.mapmartix[texture.xexp+50+u][texture.yexp+50+v]/10==313)
							{
							texture.terra[(texture.xexp+50+u)/100][(texture.yexp+50+v)/100].setIcon(texture.iconmineral);
							}
						}
						
					}
					
				}
				if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==314)
				{
					texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
					
				}
				if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==315)
				{
					texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
					
				}
				
             }
             
				if(xden==texture.xexp&&yden!=texture.yexp)
				{
					
					texture.yexp=texture.yexp+((yden-texture.yexp)/((int)Math.abs(yden-texture.yexp)));	
					texture.explorersignminimap.printminimap();
					
					x=texture.xexp;
					y=texture.yexp;
					repaint();
					if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==313)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						for(int u=-101;u<101;u++)
						{
							for(int v=-101;v<101;v++)
							{
								if(texture.mapmartix[texture.xexp+50+u][texture.yexp+50+v]==313)
								{
								texture.terra[(texture.xexp+50+u)/100][(texture.yexp+50+v)/100].setIcon(texture.iconmineral);
								}
							}
							
						}
					}
					if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==314)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						
					}
					if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==315)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						
					}
				}
				if(yden==texture.yexp&&xden!=texture.xexp)
				{
					texture.xexp=texture.xexp+((xden-texture.xexp)/((int)Math.abs(xden-texture.xexp)));	
					texture.explorersignminimap.printminimap();
					
					x=texture.xexp;
					y=texture.yexp;
					repaint();
					if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==313)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						for(int u=-101;u<101;u++)
						{
							for(int v=-101;v<101;v++)
							{
								if(texture.mapmartix[texture.xexp+50+u][texture.yexp+50+v]/10==313)
								{
								texture.terra[(texture.xexp+50+u)/100][(texture.yexp+50+v)/100].setIcon(texture.iconmineral);
								}
							}
							
						}
					}
					if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==314)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						
					}
					if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==315)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						
					}
				}
				if(yden==texture.yexp&&xden==texture.xexp)
				{
					
				}
					}
				
				}
		 },0,10);
     }
     
     public void paint(Graphics g) 
     {
         super.paintComponent(g);
         if (bufImage != null) {
         g.drawImage(bufImage,x,y,this);
         texture.scanner.setLocation(texture.xexp-25+texture.screenx,texture.yexp-25+texture.screeny);
         //����ͼƬ           
         }
      
      }
}
