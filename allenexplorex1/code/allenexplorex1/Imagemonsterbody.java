package allenexplorex1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Imagemonsterbody extends JPanel{

	private static final long serialVersionUID = 1L;
	Image image;
    BufferedImage bufImage;
    BufferedImage bufImage1;
    Graphics2D bufImageG;
    int x=0;
    int y=0;
    
	 public void dirtinitiate() 
     {
     	
     	File file=new File("terraintexture/dirt.png");

     	bufImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
     	try {
				bufImage=ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	
     	for(int i=0;i<7;i++)
     	{
     	x=texture.xmon[i];
     	y=texture.ymon[i];
     	repaint();
     	}
     }
     
     public void explorerimagechange() 
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

     }
     
     public void explorermotion() 
     {
     	texture.explorerstopsign=false;
     	Timer timer=new Timer();
		    timer.schedule(new TimerTask(){

				public void run() {
			
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
				if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==313)
				{
					texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
					texture.terra[texture.xexp/100][texture.yexp/100].setIcon(texture.iconmineral);
				}
				if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==314)
				{
					texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
					
				}
				if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==315)
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
					if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==313)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						texture.terra[texture.xexp/100][texture.yexp/100].setIcon(texture.iconmineral);
					}
					if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==314)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						
					}
					if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==315)
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
					if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==313)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						texture.terra[texture.xexp/100][texture.yexp/100].setIcon(texture.iconmineral);
					}
					if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==314)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						
					}
					if(texture.terramatrix[texture.xexp-50][texture.yexp-50]==315)
					{
						texture.explorersignminimap.printresource(texture.xexp,texture.yexp);
						
					}
				}
				if(yden==texture.yexp&&xden==texture.xexp)
				{
					
				}
				
				}
		 },0,10);
     }
     
     public void rotateImage(double angle) {
		 angle=angle*3.14/(180);
         if (bufImage == null)
             return; //如果bufImage为空则直接返回
         BufferedImage filteredBufImage =new BufferedImage(image.getWidth(this) ,image.getHeight(this),BufferedImage.TYPE_INT_ARGB); //过滤后的图像
         AffineTransform transform = new AffineTransform(); //仿射变换对象
         
         transform.rotate(angle,40,40); //旋转图像（change）
         AffineTransformOp imageOp = new AffineTransformOp(transform, null);//创建仿射变换操作对象           
         imageOp.filter(bufImage1, filteredBufImage);//过滤图像，目标图像在filteredBufImage
         bufImage = filteredBufImage; //让用于显示的缓冲区图像指向过滤后的图像
         repaint(); //重绘组件
     }
     
     public void paint(Graphics g) 
     {
         super.paintComponent(g);
         if (bufImage != null) {
         g.drawImage(bufImage,x,y,this);
         texture.scanner.setLocation(texture.xexp-25+texture.screenx,texture.yexp-25+texture.screeny);
         //绘制图片           
         }
      
      }
}
