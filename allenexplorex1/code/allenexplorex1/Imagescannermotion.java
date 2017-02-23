package allenexplorex1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Imagescannermotion extends JPanel{

	private static final long serialVersionUID = 1L;
	Image image;
	BufferedImage bufImage;
	BufferedImage bufImage1;
	Graphics2D bufImageG;
	double angle=3;

  public void loadImage()
  {
    image = Toolkit.getDefaultToolkit().getImage("characters/scanner.png"); //ȡ��ͼ��
    MediaTracker mt = new MediaTracker(this); //ʵ����ý��������
    mt.addImage(image, 0); //����ͼ�񵽼�������
    try {
      mt.waitForAll(); //�ȴ�ͼƬ����
    } catch (Exception ex) {
      ex.printStackTrace();  //����������Ϣ
    }

    bufImage1 = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);     //����ԭʼ������ͼ�� //����bufImage��ͼ�λ���
    bufImage=bufImage1;
    bufImageG=bufImage.createGraphics();
    bufImageG.drawImage(image,0,0,this); //����Դͼ�����ݵ�������ͼ����
    repaint(); //�ػ�����
  }

	public void scannerrun()
	{
		loadImage();
		Runnable runnable = new Runnable()
		{
			public void run()
			{

			  rotateImage(angle);
			  angle=angle+0.5;
			  if(angle>360)
			  {
				  angle=angle-360;
			  }

			}
    };

		texture.service.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.MILLISECONDS);
	}
	public void rotateImage(double angle) {
		angle=angle*3.14/(180);
		if (bufImage == null)
		   return; //����bufImageΪ����ֱ�ӷ���
		BufferedImage filteredBufImage =new BufferedImage(image.getWidth(this) ,image.getHeight(this),BufferedImage.TYPE_INT_ARGB); //���˺���ͼ��
		AffineTransform transform = new AffineTransform(); //�����任����

		transform.rotate(angle,75,75); //��תͼ����change��
		AffineTransformOp imageOp = new AffineTransformOp(transform, null);//���������任��������
		imageOp.filter(bufImage1, filteredBufImage);//����ͼ����Ŀ��ͼ����filteredBufImage
		bufImage = filteredBufImage; //��������ʾ�Ļ�����ͼ��ָ�����˺���ͼ��
		repaint(); //�ػ�����
	}
  public void paint(Graphics g)
  {
    super.paintComponent(g);
    if (bufImage != null) {
	    g.drawImage(bufImage,0,0,this);
	    //����ͼƬ
    }

   }
}
