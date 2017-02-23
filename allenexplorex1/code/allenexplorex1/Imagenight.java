package allenexplorex1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
//import java.awt.geom.AffineTransform;
//import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Imagenight extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image image;
    BufferedImage bufImage;
    BufferedImage bufImage1;
    Graphics2D bufImageG;
    boolean changevalue=false;
    int x1=1001;
    TimerTask timerTask=null;
    
    public void loadImage() 
    {
        image = Toolkit.getDefaultToolkit().getImage("terraintexture/night.png"); //取得图像
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
    
	public void nightdaycoming()
	{
		
		ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
		timerTask = new TimerTask() {
            @Override
            public void run() {
		if(texture.daynightsign==false)
		{
		
               
               if(x1<=0)
               {
                   service.shutdownNow();
               }
               if(x1<=-1200)
               {
            	   x1=1001;
               }
               x1=x1-1;
               repaint();
            }
		
		if(texture.daynightsign==true)
		{
               if(x1<=-1200)
               {
            	   service.shutdownNow();          	   
               }
               
               x1=x1-1;
               repaint();
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
          //绘制图片           
          }
       
       }
}
