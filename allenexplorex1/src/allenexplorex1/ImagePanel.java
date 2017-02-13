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
        BufferedImage bufImage;

        BufferedImage originalBufImage; 
        BufferedImage bufImagesav;
        Graphics2D bufImageG;
        
    int shipy=-100;// coordinate of mother ship
    int x=0;
    int y=0;
    	
        resourceandcollectionnote rs=new resourceandcollectionnote();//call class "resourceandcollectionnote"

        
        public void loadImage(String fileName) 
        { //function for loading image. get the variable "originalBufImage","bufImage" and "bufImageG" filled with the target image 
            image = Toolkit.getDefaultToolkit().getImage(fileName); //get image's location
            MediaTracker mt = new MediaTracker(this); 
            mt.addImage(image, 0); 
            try {
                mt.waitForAll(); 
            } catch (Exception ex) {
                ex.printStackTrace();  
            }
            
            originalBufImage = new BufferedImage(image.getWidth(this),image.getHeight(this),BufferedImage.TYPE_INT_ARGB);     //创建原始缓冲区图像
            bufImage = originalBufImage;
            bufImageG = bufImage.createGraphics(); 
            bufImageG.drawImage(image,0,0,this); 
            repaint(); //call the paint function at the bottom. This can draw the image in the base container
        }   
        
      
        public void saveMap() //for map. Save the generated map as a .png file in the "save" folder
        {
        	bufImagesav=new BufferedImage(texture.maplength,texture.mapwidth,BufferedImage.TYPE_INT_RGB);
        	
        	File Map_sav = new File(texture.fileName+"/"+"map.png");
        	 for(int i=0;i<texture.maplength;i++)
			 {
				 for(int j=0;j<texture.mapwidth;j++)
				 {
					 if(texture.mapmartix[i][j]==0)
					 {
						 Color c = new Color(30,30,73);//in the map the water parts are blue
						 bufImagesav.setRGB(i, j, c.getRGB());
						 texture.terramartix[i][j]=0;
					 }
					 if(texture.mapmartix[i][j]!=0)
					 {					
						 bufImagesav.setRGB(i, j, texture.mapmartix[i][j]);
						 texture.terramartix[i][j]=1;
					 }
					 
				 }
			 }
			 try {
				ImageIO.write(bufImagesav, "png", Map_sav);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
			 
			 int newWidth = 240 ; //save map as a smaller version for minimap use
			 int newHeight = 140;
			 BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);  
			 Graphics graphics = image.createGraphics();  
			 graphics.drawImage(bufImagesav, 0, 0, newWidth, newHeight, null);  
			 
			 Color cl = new Color(0,0,255);// draw the mother ship postion as a blue point
			 image.setRGB(8, 8, cl.getRGB());
			 image.setRGB(9, 8, cl.getRGB());
			 image.setRGB(7, 8, cl.getRGB());
			 image.setRGB(8, 7, cl.getRGB());
			 image.setRGB(8, 9, cl.getRGB());
			 image.setRGB(9, 9, cl.getRGB());
			 image.setRGB(7, 7, cl.getRGB());
			 image.setRGB(7, 9, cl.getRGB());
			 image.setRGB(9, 7, cl.getRGB());
			 File mini_sav = new File(texture.fileName+"/"+"minimap.png");
			 try {
				ImageIO.write(image, "png", mini_sav);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }   
        
        public void loadmap(String fileName) throws IOException //load the saved map from the .png file
        {
        	File file=new File(fileName);
        	bufImage=new BufferedImage(texture.maplength,texture.mapwidth,BufferedImage.TYPE_INT_RGB);
        	bufImage=ImageIO.read(file);
        	bufImageG = bufImage.createGraphics(); //创建bufImage的图形环境          
            bufImageG.drawImage(bufImage,0,0,this);
            repaint(); //重绘组件
        }   
        
       
        
        public void Imageexit()//animation of the loading page.(fade out when loading completed)
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
			 
        	Timer timer=new Timer();//get a time counter
   		    timer.schedule(new TimerTask(){

				public void run() {
				if(texture.alp<=0)// if the loading page has faded out, stop the animation
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
				texture.alp=texture.alp-15;// loading page fade out, alpha value minus 15 per 0.01 sec.
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
        
   		  public void Imagefailed()// when failed, show the failed page
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
 
  				if(texture.alpf>=250)//when the failed page showed up, stop the animaton
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
  					 {//failed page show up, alpha value add 15 per 0.01 sec
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
     		   public void Imagesucceed()//when succeed, show up success page
     	        {                        // the animation is similar with failed page
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
     	 
     	  				if(texture.alps>=250)//when success page completely show up, stop animation
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
     	  				 { //success page showing up, alpha value add 15 per 0.01 sec
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
        
        public void shipdownmotion() //when game started(click on the "click" range")
        {                            //show the animation of ship landing
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
				if(shipy==300)//when ship landed, add the remain elements to base container
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
        
        public void shipupmotion() //when collected enough samples and returned, click the button
        {                          //then the ship will go up and show success page
        	
        	ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
        	TimerTask timerTask = new TimerTask() {
				public void run() {
				if(shipy==-100)//when ship leave the base container, start to show the success page
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
        public void paint(Graphics g) //paint method, paint the target image
        {
            super.paintComponent(g);
            if (bufImage != null) {
            g.drawImage(bufImage,x,y,this);
            //绘制图片           
            }
         
         }
}

