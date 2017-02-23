package allenexplorex1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

	public class ImagePanel extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Image image;
        BufferedImage bufImage; //用于显示的缓冲区图像

        BufferedImage originalBufImage; //原始缓冲区图像
        BufferedImage bufImagesav;
        Graphics2D bufImageG; //缓冲区图像的图形环境   
        
    int shipy=-100;
    int x=0;
    int y=0;
    	
        resourceandcollectionnote rs=new resourceandcollectionnote();

        
        public void loadImage(String fileName) 
        {
            image = Toolkit.getDefaultToolkit().getImage(fileName); //取得图像
            MediaTracker mt = new MediaTracker(this); //实例化媒体加载器
            mt.addImage(image, 0); //增加图像到加载器中
            try {
                mt.waitForAll(); //等待图片加载
            } catch (Exception ex) {
                ex.printStackTrace();  //输出出错信息
            }
            
            originalBufImage = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);     //创建原始缓冲区图像
            bufImage = originalBufImage;
            bufImageG = bufImage.createGraphics(); //创建bufImage的图形环境          
            bufImageG.drawImage(image,0,0,this); //传输源图像数据到缓冲区图像中
            repaint(); //重绘组件
        }   
        
        public void saveMap() 
        {
        	bufImagesav=new BufferedImage(3000,1800,BufferedImage.TYPE_INT_RGB);
        	
        	File Map_sav = new File(texture.fileName+"/"+"map.png");
        	 for(int i=0;i<3000;i++)
			 {
				 for(int j=0;j<1800;j++)
				 {
					 if(texture.mapmatrix[i][j]==0)
					 {
						 Color c = new Color(30,30,73);
						 bufImagesav.setRGB(i, j, c.getRGB());
						 texture.terramatrix[i][j]=0;
					 }
					 if(texture.mapmatrix[i][j]<0)
					 {					
						 bufImagesav.setRGB(i, j, texture.mapmatrix[i][j]);
						 texture.terramatrix[i][j]=1;
					 }
					 
				 }
			 }
			 try {
				ImageIO.write(bufImagesav, "png", Map_sav);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			 
			 int newWidth = 240 ; //save minimap
			 int newHeight = 140;
			 BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);  
			 Graphics graphics = image.createGraphics();  
			 graphics.drawImage(bufImagesav, 0, 0, newWidth, newHeight, null);  
			 
			 Color cl = new Color(0,0,255);
			 image.setRGB(24, 24, cl.getRGB());
			 image.setRGB(25, 24, cl.getRGB());
			 image.setRGB(23, 24, cl.getRGB());
			 image.setRGB(24, 23, cl.getRGB());
			 image.setRGB(24, 25, cl.getRGB());
			 image.setRGB(25, 25, cl.getRGB());
			 image.setRGB(23, 23, cl.getRGB());
			 image.setRGB(23, 25, cl.getRGB());
			 image.setRGB(25, 23, cl.getRGB());
			 File img_sav = new File(texture.fileName+"/"+"minimap.png");
			 try {
				ImageIO.write(image, "png", img_sav);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }   
        
        public void loadmap(String fileName) throws IOException 
        {
        	File file=new File(fileName);
        	bufImage=new BufferedImage(3000,1800,BufferedImage.TYPE_INT_RGB);
        	bufImage=ImageIO.read(file);
        	bufImageG = bufImage.createGraphics(); //创建bufImage的图形环境          
            bufImageG.drawImage(bufImage,0,0,this);
            repaint(); //重绘组件
        }   
        
        public void loadhalfmap(String fileName,int x1,int x2) throws IOException 
        {
        	File file=new File(fileName);
        	bufImage=new BufferedImage(1500,1800,BufferedImage.TYPE_INT_RGB);
        	bufImage=ImageIO.read(file);
        	
            for (int i=0;i<1500;i++)
            {
            	for(int j=0;j<1800;j++)
            	{
            		if(x1==0&&x2==1500)
            		{
            		texture.mapmatrix[i][j]=bufImage.getRGB(i, j);
            		if(texture.mapmatrix[i][j]==-16777216)//black
            		{
            			texture.mapmatrix[i][j]=0;
            		}
            		}
            		if(x1==1500&&x2==3000)
            		{
            		texture.mapmatrix[i+1500][j]=bufImage.getRGB(i, j);
            		if(texture.mapmatrix[i+1500][j]==-16777216)
            		{
            			texture.mapmatrix[i+1500][j]=0;
            		}
            		}
            		
            	}
            }
        }   
        
        public void Imageexit()
        {
        	int oriwidth=bufImage.getWidth(null);
			int oriheight=bufImage.getHeight(null);
			int [][]rgb=new int[oriwidth][oriheight];
			 
			 for(int i=0;i<oriwidth;i++)
			 {
				 for(int j=0;j<oriheight;j++)
				 {
					 rgb[i][j]=bufImage.getRGB(i,j);
				 }
			 }
			 
        	Timer timer=new Timer();
   		    timer.schedule(new TimerTask(){

				public void run() {
				if(texture.alp<=0)
				{
					for(int i=0;i<oriwidth;i++)
					 {
						 for(int j=0;j<oriheight;j++)
						 {
							 Color c = new Color(rgb[i][j]);
							 Color cc =  new Color(c.getRed(), c.getGreen(), c.getBlue(), 0);
							 bufImage.setRGB(i, j, cc.getRGB()); 
						 }
					 }
					repaint();
					texture.layeredPane.remove(texture.labelLoadingProcess);
					timer.cancel();					
				}
				else
				{
				texture.alp=texture.alp-15;
				for(int i=0;i<oriwidth;i++)
				 {
					 for(int j=0;j<oriheight;j++)
					 {
						 Color c = new Color(rgb[i][j]);
						 Color cc =  new Color(c.getRed(), c.getGreen(), c.getBlue(), texture.alp);
						 bufImage.setRGB(i, j, cc.getRGB()); 
					 }
				 }
				repaint();	
				}
				}
   		 },0,10);
        }
   		  public void Imagefailed()
          {
   			File file=new File("basictexture/failed.png");
	        	bufImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
	        	try {
					bufImage=ImageIO.read(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          	int oriwidth=bufImage.getWidth(null);
  			int oriheight=bufImage.getHeight(null);
  			int [][]rgb=new int[oriwidth][oriheight];
  			ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
  			
  			 for(int i=0;i<oriwidth;i++)
  			 {
  				 for(int j=0;j<oriheight;j++)
  				 {
  					 rgb[i][j]=bufImage.getRGB(i,j);
  					 Color c = new Color(rgb[i][j]);
                     Color cc =  new Color(c.getRed(), c.getGreen(), c.getBlue(),0);
					bufImage.setRGB(i, j, cc.getRGB());
  				 }
  			 }
  			 
  			TimerTask timerTask = new TimerTask() {
  	            @Override
  	            public void run() {
 
  				if(texture.alpf>=250)
  				{
  					texture.layeredPane.add(texture.labelmain,new Integer(50));
  					texture.labelmain.setBounds(400,400,200,50);
  					texture.labelmain.setIcon(texture.iconmain); 					
  				    service.shutdownNow();
  				}
  				else
  				{
  				texture.alpf=texture.alpf+15;
  				for(int i=0;i<oriwidth;i++)
  				 {
  					 for(int j=0;j<oriheight;j++)
  					 {
  						 Color c = new Color(rgb[i][j]);
  						 Color cc =  new Color(c.getRed(), c.getGreen(), c.getBlue(), texture.alpf);
  						 bufImage.setRGB(i, j, cc.getRGB()); 
  					 }
  				 }
  				repaint();	
  	            }
  	            }
     		 };
     		service.scheduleAtFixedRate(timerTask, 0, 10, TimeUnit.MILLISECONDS);
          }
     		   public void Imagesucceed()
     	        {
     			  File file=new File("basictexture/success.png");
     	        	bufImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
     	        	try {
     					bufImage=ImageIO.read(file);
     				} catch (IOException e) {
     					// TODO Auto-generated catch block
     					e.printStackTrace();
     				}
     			  int oriwidth=bufImage.getWidth(null);
     	  			int oriheight=bufImage.getHeight(null);
     	  			int [][]rgb=new int[oriwidth][oriheight];
     	  			ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
     	  			
     	  			 for(int i=0;i<oriwidth;i++)
     	  			 {
     	  				 for(int j=0;j<oriheight;j++)
     	  				 {
     	  					 rgb[i][j]=bufImage.getRGB(i,j);
     	  					 Color c = new Color(rgb[i][j]);
     	                     Color cc =  new Color(c.getRed(), c.getGreen(), c.getBlue(),0);
     						bufImage.setRGB(i, j, cc.getRGB());
     	  				 }
     	  			 }
     	  			 
     	  			TimerTask timerTask = new TimerTask() {
     	  	            @Override
     	  	            public void run() {
     	 
     	  				if(texture.alps>=250)
     	  				{
     	  					texture.layeredPane.add(texture.labelmain,new Integer(50));
     	  					texture.labelmain.setBounds(400,400,200,50);
     	  					texture.labelmain.setIcon(texture.iconmain); 	  					
     	  				    service.shutdownNow();	
     	  				}
     	  				else
     	  				{
     	  				texture.alps=texture.alps+15;
     	  				for(int i=0;i<oriwidth;i++)
     	  				 {
     	  					 for(int j=0;j<oriheight;j++)
     	  					 {
     	  						 Color c = new Color(rgb[i][j]);
     	  						 Color cc =  new Color(c.getRed(), c.getGreen(), c.getBlue(), texture.alps);
     	  						 bufImage.setRGB(i, j, cc.getRGB()); 
     	  					 }
     	  				 }
     	  				repaint();	
     	  	            }
     	  	            }
     	     		 };
     	     		service.scheduleAtFixedRate(timerTask, 0, 10, TimeUnit.MILLISECONDS);
        }
        
        public void shipdownmotion() 
        {
        	texture.terra[3][3].setIcon(texture.iconopaque);
        	File file=new File("characters/ship.png");
        	bufImage=new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
        	try {
				bufImage=ImageIO.read(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	x=300;
        	
        	Timer timer=new Timer();
   		    timer.schedule(new TimerTask(){

				public void run() {
				if(shipy==300)
				{
					texture.bloodbar.bar();
					texture.energybar.bar();
					texture.explorer.explorerinitiate();
					texture.layeredPane.add(texture.explorersignminimap,new Integer(31));
					texture.explorersignminimap.setBounds(755,5,240,140);
					texture.explorersignminimap.setOpaque(false);
					texture.layeredPane.add(texture.scanner,new Integer(11));
					texture.scanner.setBounds(texture.xexp-25,texture.yexp-25,150,150);
					texture.scanner.setOpaque(false);
					texture.scanner.scannerrun();
					texture.layeredPane.add(texture.labelresource,new Integer(25));
					texture.labelresource.setBounds(694,470,200,100);
					texture.labelresource.setOpaque(false);
					texture.layeredPane.add(texture.labelgather1,new Integer(27));
            		texture.labelgather1.setBounds(705,540,182,20);
            		texture.labelgather1.setOpaque(false);
            		texture.layeredPane.add(texture.labelmotherbu1,new Integer(26));
					texture.labelmotherbu1.setBounds(705,520,82,33);
					texture.labelmotherbu1.setOpaque(false);					
					texture.layeredPane.add(texture.labelmotherbu2,new Integer(26));
					texture.labelmotherbu2.setBounds(797,520,82,33);
					texture.labelmotherbu2.setOpaque(false);
					rs.reconote();
		        	texture.landsign=true;
					timer.cancel();					
				}
				shipy=shipy+5;
				y=shipy;
				repaint();		
				}
   		 },0,10);
        	
        	
        }
        
        public void shipupmotion() 
        {
        	
        	ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
        	TimerTask timerTask = new TimerTask() {
				public void run() {
				if(shipy==-100)
				{
					texture.layeredPane.add(texture.labelsuccess,new Integer(49));
					texture.labelsuccess.setBounds(0,0,1000,600);
					texture.labelsuccess.setOpaque(false);
					texture.labelsuccess.Imagesucceed();
					service.shutdown();				
				}
				shipy=shipy-5;
				y=shipy;
				repaint();		
				}
   		 };
   		service.scheduleAtFixedRate(timerTask, 0, 10, TimeUnit.MILLISECONDS);
        }
        
       

        //重载容器的paintComponent()方法
        public void paint(Graphics g) 
        {
            super.paintComponent(g);
            if (bufImage != null) {
            g.drawImage(bufImage,x,y,this);
            //绘制图片           
            }
         
         }
}

