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
        image = Toolkit.getDefaultToolkit().getImage("terraintexture/night.png"); //ȡ��ͼ��
        MediaTracker mt = new MediaTracker(this); //ʵ����ý�������
        mt.addImage(image, 0); //����ͼ�񵽼�������
        try {
            mt.waitForAll(); //�ȴ�ͼƬ����
        } catch (Exception ex) {
            ex.printStackTrace();  //���������Ϣ
        }
        
        bufImage1 = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);     //����ԭʼ������ͼ�� //����bufImage��ͼ�λ���          
        bufImage=bufImage1;
        bufImageG=bufImage.createGraphics();
        bufImageG.drawImage(image,0,0,this); //����Դͼ�����ݵ�������ͼ����
        repaint(); //�ػ����
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
          //����ͼƬ           
          }
       
       }
}
