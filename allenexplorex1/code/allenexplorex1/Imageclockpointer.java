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
        image = Toolkit.getDefaultToolkit().getImage("basictexture/clockpointer.png"); //取得图像
        MediaTracker mt = new MediaTracker(this); //实例化媒体加载器
        mt.addImage(image, 0); //增加图像到加载器中
        try {
            mt.waitForAll(); //等待图片加载
        } catch (Exception ex) {
            ex.printStackTrace();  //输出出错信息
        }
        
        bufImage1 = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);     //创建原始缓冲区图像 //创建bufImage的图形环境          
        bufImage=bufImage1;
        bufImageG=bufImage.createGraphics();
        bufImageG.drawImage(image,0,0,this); //传输源图像数据到缓冲区图像中
        repaint(); //重绘组件
    }   
    
	public void pointerrun()
	{
		loadImage();
		Runnable runnable = new Runnable() 
		{
            public void run() 
            {
              
              rotateImage(angle);
              angle=angle+0.1;
              if(angle>360)
              {
            	  angle=angle-360;
              }
              if(angle>=0&&angle<=2)
              {
            	  
            	  texture.daynightsign=true;
            	  texture.labelclock.setIcon(texture.clockday);
            	  if(angle>=1.9&&angle<2)
            	  {
            	  texture.dcount=texture.dcount+1;
            	  }
            	  texture.night.nightdaycoming();
            	  texture.explorer.explorerimagechange();
              }
              if(angle>=208&&angle<=212)
              {
            	  texture.daynightsign=false;
            	  texture.labelclock.setIcon(texture.clocknight);
            	  texture.night.nightdaycoming();
            	  texture.explorer.explorerimagechange();
              }
              
            }
        };
			
		texture.service.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.MILLISECONDS);
		
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
          g.drawImage(bufImage,0,0,this);
          //绘制图片           
          }
       
       }


}
