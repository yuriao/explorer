package allenexplorex1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Imagemonsterdirt extends JPanel{

	private static final long serialVersionUID = 1L;
	Image image;
    BufferedImage bufImage;
    BufferedImage bufImage1;
    Graphics2D bufImageG;
    int x=0;
    int y=0;
    int count=0;
    
	 public void dirtinitiate(int num) 
     {
     	
     	File file=new File("terraintexture/dirt.png");

     	bufImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
     	try {
				bufImage=ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
     	
     	x=texture.xmon[num];
     	y=texture.ymon[num];
     	repaint();
     	
     }
     
     public void dirtmotion(int num) 
     {

     	Runnable runnable = new Runnable() 
		{
				public void run() {

					int xden=texture.xmondens[num];
					int yden=texture.ymondens[num];
					
             if(texture.xmon[num]!=xden&&texture.ymon[num]!=yden)
             {
				if(texture.xmon[num]!=xden)
				{
					texture.xmon[num]=texture.xmon[num]+(xden-texture.xmon[num])/((int)Math.abs(xden-texture.xmon[num]));
				texture.monstersignminimap.printminimap1();
				if(texture.mapmatrix[texture.xmon[num]+50*(xden-texture.xmon[num])/((int)Math.abs(xden-texture.xmon[num]))][texture.ymon[num]]==0)
				{
					if(texture.xmon[num]<texture.maplength/2)
					{
					texture.xmondens[num]=750;
					texture.ymondens[num]=900;
					}
					if(texture.xmon[num]>texture.maplength/2)
					{
					texture.xmondens[num]=2250;
					texture.ymondens[num]=900;
					}
					
					if(((int)Math.abs(xden-texture.xmon[num]))>0)
					{
						rotateImage(0);
					}
					if(((int)Math.abs(xden-texture.xmon[num]))<0)
					{
						rotateImage(180);
					}
				}
				
				}
				if(texture.ymon[num]!=yden)
				{
				texture.ymon[num]=texture.ymon[num]+(yden-texture.ymon[num])/((int)Math.abs(yden-texture.ymon[num]));
				texture.monstersignminimap.printminimap1();
				if(texture.mapmatrix[texture.xmon[num]][texture.ymon[num]+50*(yden-texture.ymon[num])/((int)Math.abs(xden-texture.ymon[num]))]==0)
				{
					if(texture.xmon[num]<texture.maplength/2)
					{
					texture.xmondens[num]=750;
					texture.ymondens[num]=900;
					}
					if(texture.xmon[num]>texture.maplength/2)
					{
					texture.xmondens[num]=2250;
					texture.ymondens[num]=900;
					}
				}
				}
                System.out.println("goodl");
				x=texture.xmon[num];
		     	y=texture.ymon[num];
		     	rotateImage(90*(yden-texture.ymon[num])/((int)Math.abs(yden-texture.ymon[num])));
				repaint();

             }
             
				if(xden==texture.xmon[num]&&yden!=texture.ymon[num])
				{
					
					texture.ymon[num]=texture.ymon[num]+(yden-texture.ymon[num])/((int)Math.abs(yden-texture.ymon[num]));
					texture.monstersignminimap.printminimap1();
					
					if(texture.mapmatrix[texture.xmon[num]+50*(xden-texture.xmon[num])/((int)Math.abs(xden-texture.xmon[num]))][texture.ymon[num]]==0)
					{
						if(texture.xmon[num]<texture.maplength/2)
						{
						texture.xmondens[num]=750;
						texture.ymondens[num]=900;
						}
						if(texture.xmon[num]>texture.maplength/2)
						{
						texture.xmondens[num]=2250;
						texture.ymondens[num]=900;
						}
					}
					x=texture.xmon[num];
			     	y=texture.ymon[num];
			     	rotateImage(90*(yden-texture.ymon[num])/((int)Math.abs(yden-texture.ymon[num])));
					repaint();
					
				}
				if(yden==texture.ymon[num]&&xden!=texture.xmon[num])
				{
					texture.xmon[num]=texture.xmon[num]+(xden-texture.xmon[num])/((int)Math.abs(xden-texture.xmon[num]));
					texture.monstersignminimap.printminimap();
					
					if(texture.mapmatrix[texture.xmon[num]][texture.ymon[num]+50*(yden-texture.ymon[num])/((int)Math.abs(yden-texture.ymon[num]))]==0)
					{
						if(texture.xmon[num]<texture.maplength/2)
						{
						texture.xmondens[num]=750;
						texture.ymondens[num]=900;
						}
						if(texture.xmon[num]>texture.maplength/2)
						{
						texture.xmondens[num]=2250;
						texture.ymondens[num]=900;
						}
					}
					
					x=texture.xmon[num];
			     	y=texture.ymon[num];
			     	if(((int)Math.abs(xden-texture.xmon[num]))>0)
					{
						rotateImage(0);
					}
					if(((int)Math.abs(xden-texture.xmon[num]))<0)
					{
						rotateImage(180);
					}
					repaint();
					
				}
				if(yden==texture.ymon[num]&&xden==texture.xmon[num])
				{
					Random random=new Random();
					int x1=random.nextInt(3000);
					int y1=random.nextInt(1800);
					if(texture.mapmatrix[x1][y1]!=0)
					{
					texture.xmondens[num]=x1;
					texture.ymondens[num]=y1;
					}
				}
				
				if(Math.abs(texture.xexp-texture.xmon[num])<=50||Math.abs(texture.yexp-texture.ymon[num])<=50)
				{
					texture.xmondens[num]=texture.xexp;
					texture.ymondens[num]=texture.yexp;
				}
				else if(texture.xmon[num]==xden&&texture.ymon[num]>=yden-1&&texture.ymon[num]<=yden+1&&count==10)
				{
					Random random=new Random();
					int x1=random.nextInt(3000);
					int y1=random.nextInt(1800);
					if(texture.mapmatrix[x1][y1]!=0)
					{
					texture.xmondens[num]=x1;
					texture.ymondens[num]=y1;
					}
										
				}
              count=count+1;
             if(count>10)
             {
	          count=0;
             }
				}
		 };
		 
		 ScheduledExecutorService service12=Executors.newScheduledThreadPool(1);
		service12.scheduleAtFixedRate(runnable, 0, 20, TimeUnit.MILLISECONDS);
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
        
         //绘制图片           
         }
      
      }
}
