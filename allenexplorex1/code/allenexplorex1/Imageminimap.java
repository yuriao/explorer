package allenexplorex1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Imageminimap extends JPanel{

	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		BufferedImage bufImage1;
	    int x1=texture.xexp*240/3000;
	    int y1=texture.yexp*140/1800;
	    int x2=texture.xexp*240/3000;
	    int y2=texture.yexp*140/1800;
	    int emsign=0;
	    boolean [][]terrarecord=new boolean[240][140];
	    
	    public void printminimap()
	    {
	    	x1=texture.xexp*240/3000;
	    	y1=texture.yexp*140/1800;
	    	emsign=1;
	    	repaint();
	    }
	    
	    public void printminimap1()
	    {
	    	x1=texture.xexp*240/3000;
	    	y1=texture.yexp*140/1800;
	    	emsign=2;
	    	repaint();
	    }
	    
	    public void printresource(int x,int y)
	    {
	    	x2=x*240/3000;
	    	y2=y*140/1800;
	    	terrarecord[x2][y2]=true;
	    }
	    
	    public void paint(Graphics g) 
        {
            super.paintComponent(g);

            if(emsign==1)
            {
       			 g.setColor(Color.green);
                 g.fillRect(x1,y1,3,3);
            }
            if(emsign==2)
            {
       			 g.setColor(Color.red);
                 g.fillRect(x1,y1,3,3);
            }

            for(int u=0;u<240;u++)
            {
            	for(int v=0;v<140;v++)
            	{
            		if(terrarecord[u][v]==true)
            		{
       			 g.setColor(Color.gray);
                 g.fillRect(u-1,v-1,3,3);
            		}
            	}
            }
        }
         
}

