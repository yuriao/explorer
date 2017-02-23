package allenexplorex1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GameGeneration {
    
	UIgame gameui=new UIgame();
	
        boolean completesign=false;
		public void newGameGeneration() throws IOException
		{
	    	 
             System.out.println("1");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
 	    	Date now=new Date();
 	    	
         	File folder=new File("save/"+"save_"+dateFormat.format(now));
         	folder.mkdir();
         	texture.fileName="save/"+"save_"+dateFormat.format(now);
         	
         	for(int i=0;i<3000;i++)
    		{
    			for(int j=0;j<1800;j++)
    			{
    				texture.mapmartix[i][j]=0;
    				texture.terramartix[i][j]=0;
    			}
    		}
         	
	    	 maptype();
	    	 terriantype();
             mapgen();
             gameui.drawmap();
             
             System.out.println(texture.ttype);
             System.out.println(completesign);
		}
		public void maptype()
		{
			Random randn=new Random();
			texture.mtype=randn.nextInt(1)+1;
		}
		public void terriantype()
		{
			Random randn=new Random();
			texture.ttype=randn.nextInt(1)+1;
		}
		public void mapgen() throws IOException
		{
			if(texture.mtype==1)
			{
				System.out.println(111);
				continentgen cont=new continentgen();
				cont.continentareagen();
				System.out.println(111);
				System.out.println(1213);
				cont.shadegen();
				completesign=true;
			}
			
			
		}


	
}
