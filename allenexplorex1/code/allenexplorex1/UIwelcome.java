package allenexplorex1;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class UIwelcome extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; //serial ID, added automatically
	GameGeneration gameg=new GameGeneration(); //declare a reference of class "GameGeneration"
	int loadsign=0; //sign of loading process. 0 represents loading not complete, 1 represents loading complete
	
	
	public void welcome(){
		
		texture.layeredPane.removeAll(); //clean all the objects in the base container (game window)
		texture.layeredPane.add(texture.labelBackGround, new Integer(1)); //add the welcome background to the base container
		texture.labelBackGround.setBounds(0,0,1000,600); //background size
		texture.layeredPane.add(texture.labelNew,new Integer(2));//add the "New Game" button to the base container
		texture.labelNew.setBounds(400,170,200,100);// button size
		
		texture.labelBackGround.setIcon(texture.iconBackGround); //content of the background, i.e.the picture
		texture.labelNew.setIcon(texture.iconNew);//content of the button
//		texture.labelLoad.setIcon(texture.iconLoad); //another button, not used for now
		
		texture.labelNew.addMouseListener(new MouseAdapter() { // action of the "New Game" button depending on the mouse movement
	         public void mouseEntered(MouseEvent e) {  //按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
	        	 texture.labelNew.setIcon(texture.iconNewPressed); //mouse enter, button format change
           }
	         public void mouseExited(MouseEvent e)
	         {
	        	 texture.labelNew.setIcon(texture.iconNew);//mouse exit, button format return to default
	         }
	         public void mouseClicked(MouseEvent e) //mouse click, start generating game
	         {
	        	 texture.frame.requestFocus(); //make the focus of JVM from button to the base container.
	        	 
		    	 texture.layeredPane.remove(texture.labelBackGround);//remove BackGround from the base container
		    	 texture.layeredPane.remove(texture.labelNew);//remove "New Game" button from the base container
//		    	 texture.layeredPane.remove(texture.labelLoad);
		    	 texture.labelLoadingProcess.loadImage("basictexture/loading.png");//load the loading background to memory
		    	 texture.layeredPane.add(texture.labelLoadingProcess,new Integer(10));//add the loading background to the base container
		    	 texture.labelLoadingProcess.setBounds(0,0,1000,600);// loading background size
		    	 texture.labelLoadingProcess.setOpaque(false);
		    	 
		    	 ScheduledExecutorService service=Executors.newScheduledThreadPool(1);// a counter, manage the loading process
		    		TimerTask timerTask = new TimerTask() {
		  	            @Override
		  	            public void run() {
	    		    		
	    		    		if(loadsign>=4) //after 4 second check whether loading is completed
	    		    		{
	    		    			if(gameg.completesign==true)
	    		    			{
	    		    				service.shutdownNow();
	    		    				texture.labelLoadingProcess.Imageexit();// if finished, the loading background will gradually fade out
	    		    				loadsign=0;
	    		    			}
	    		    		}
	    		    		else
	    		    		{
	    		    			if(loadsign==2)// after 2 second, start the loading process
	   	   	   	        	 {
	   	    		    		try {
	   								gameg.newGameGeneration();
	   							} catch (IOException e) {
	   								// TODO Auto-generated catch block
	   								e.printStackTrace();
	   							}
	   	   	   	        	 }
	    		    		loadsign=loadsign+1;
	    		    		}
	    		    	}
	    		 };
	    		 
	    		 service.scheduleAtFixedRate(timerTask, 0, 10, TimeUnit.MILLISECONDS);//start counter
	        	
	         }
        });
		
//		texture.labelLoad.addMouseListener(new MouseAdapter() {
//	         public void mouseEntered(MouseEvent e) {  //按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
//	        	 texture.labelLoad.setIcon(texture.iconLoadPressed);
//          }
//	         public void mouseExited(MouseEvent e)
//	         {
//	        	 texture.labelLoad.setIcon(texture.iconLoad);
//	         }
//	         public void mouseClicked(MouseEvent e)
//	         {
//	        	 
//	         }
//      });
		
		
		texture.frame.setSize(1000,600); //base container size
		texture.frame.setResizable(false); //game window cannot change size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();// get resolution
		texture.frame.setLocation(screenSize.width/2-500,screenSize.height/2-300);// determine the base container's position on the screen
		texture.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		texture.frame.setVisible(true);
	}
	
	
}
