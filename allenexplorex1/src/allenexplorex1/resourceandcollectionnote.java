package allenexplorex1;

import java.awt.Color;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class resourceandcollectionnote {

	boolean displayed=false;
	int countdis=0;
	
	public void reconote()//this function decides the notice when character pass different areas of the map 
	{
		ScheduledExecutorService service=Executors.newScheduledThreadPool(1);// get a time count thread pool
		TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            	
            	if(texture.terramartix[texture.xexp+50][texture.yexp+50]==100)// for the mother ship
				{
            		texture.labelresource.setIcon(texture.iconmothership);//show mother ship label
					
            		if(texture.collection<5)//if not enough samples are collected, shows "repair" and "still exploring"
            		{	
            			texture.labelmotherbu1.setIcon(texture.iconmothershipbu1);
					    texture.labelmotherbu2.setIcon(texture.iconmothershipbu2);					    
            		}
            		if(texture.collection>=5)//if enough samples are collected, shows "repair" and "take off"
            		{
            			texture.labelmotherbu1.setIcon(texture.iconmothershipbu1);
    					texture.labelmotherbu2.setIcon(texture.iconmothershipbu3);
            		}
            		texture.mothershipsign=true;
            		texture.mineralsign=false;
            		texture.strsign=false;
            		texture.shipsign=false;
				}
            	if(texture.terramartix[texture.xexp+50][texture.yexp+50]==0)//for water part
				{
            		texture.mineralsign=false;
            		texture.strsign=false;
            		texture.shipsign=false;
            		texture.mothershipsign=false;
            		texture.labelmotherbu1.setIcon(texture.iconopaque);//mother ship label become transparent
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelgather1.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconwater);// show water label
				}
            	if(texture.terramartix[texture.xexp+50][texture.yexp+50]==1)//for normal land (no landmarks)
				{
            		texture.mineralsign=false;
            		texture.strsign=false;
            		texture.shipsign=false;
            		texture.mothershipsign=false;
            		texture.labelmotherbu1.setIcon(texture.iconopaque);//mother ship label become transparent
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelgather1.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconplain);//show land ("plain") label
				}
            	if(texture.terramartix[texture.xexp+50][texture.yexp+50]==311)//for hill
				{
            		texture.mineralsign=false;
            		texture.strsign=false;
            		texture.shipsign=false;
            		texture.mothershipsign=false;
            		texture.labelmotherbu1.setIcon(texture.iconopaque);//mother ship label become transparent
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelgather1.setIcon(texture.iconopaque);
            		texture.labelresource.setIcon(texture.iconnhill);//show hill label
				}
            	if(texture.terramartix[texture.xexp+50][texture.yexp+50]==312)//for mountain
				{
            		texture.mineralsign=false;
            		texture.strsign=false;
            		texture.shipsign=false;
            		texture.mothershipsign=false;
            		texture.labelmotherbu1.setIcon(texture.iconopaque);//mother ship label become transparent
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelgather1.setIcon(texture.iconopaque);
            		texture.labelresource.setIcon(texture.iconnmountain);//show mountain label
				}
            	if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==313)//for mineral
				{
            		texture.mineralsign=true;
            		texture.mothershipsign=false;
            		texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
        			texture.labelresource.setIcon(texture.iconnmineral);
            		texture.labelgather1.setIcon(texture.icongathersample);//show mountain label
        		}

				if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==314)//for weird structure
				{
            		texture.strsign=true;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);//mother ship label become transparent
					texture.labelmotherbu2.setIcon(texture.iconopaque);
            		texture.labelresource.setIcon(texture.iconnstr);
            		texture.labelgather1.setIcon(texture.icongathersample);//show 
				
				}
				if(texture.terramartix[texture.xexp+50][texture.yexp+50]/10==315)//for shipwreck
				{	
            		texture.shipsign=true;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);//mother ship label become transparent
					texture.labelmotherbu2.setIcon(texture.iconopaque);
            		texture.labelresource.setIcon(texture.iconnship);
            		texture.labelgather1.setIcon(texture.icongathersample);// show shipwreck label           		
				}
				if(texture.terramartix[texture.xexp+50][texture.yexp+50]==316)//for empty weird structure (after explored)
				{	
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);//mother ship label become transparent
					texture.labelmotherbu2.setIcon(texture.iconopaque);
            		texture.labelresource.setIcon(texture.iconemptystr);
            		texture.labelgather1.setIcon(texture.iconopaque); //show empty weird structure label
				}
				
				texture.labeldcount.setText(Integer.toString(texture.dcount));//show how many day has passed on counter
				texture.labelscount.setText(Integer.toString(texture.collection));//show how many samples have been collected on counter
				if(texture.collection>=5)
				{	
					texture.labelscount.setForeground(Color.green);//sample number larger than 10 means complete, sample counter turns green					
					texture.labelcom.setIcon(texture.iconnote5);//show the notice that character can return to mother ship to end game
          		
				}
				
             
                  }

            
        };
	    
		service.scheduleAtFixedRate(timerTask, 0, 10, TimeUnit.MILLISECONDS);//execute every 0.01 sec
	
	}
}
