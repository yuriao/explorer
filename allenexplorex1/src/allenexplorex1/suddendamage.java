package allenexplorex1;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class suddendamage {
	int count=0;
	public void suddamshow()
	{

		
		ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
		TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            
            	texture.layeredPane.add(texture.labeldamage,new Integer(40));
        		texture.labeldamage.setBounds(0,0,1000,600);
        		texture.labeldamage.setOpaque(false);
        		texture.labeldamage.setIcon(texture.icondamage);

            if(count>700)
            {
            	texture.layeredPane.remove(texture.labeldamage);
            	count=0;
            	service.shutdownNow();
            }
            	
            	count=count+10;
        }
            
        };
	    
		service.scheduleAtFixedRate(timerTask, 0, 10, TimeUnit.MILLISECONDS);
	}
}
