package allenexplorex1;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class bloodenergyctrl {

	public void bloodandenergycontrol()
    {
		
		TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
            	
            	if(texture.bloodpoint>=1840)//max blood point is 1840
            	{
            		texture.bloodpoint=1840; //hi
            		
            	}
            	if(texture.energypoint>=1840)//max energy point is 1840
            	{
            		texture.energypoint=1840;
            	}
            	
            	if(texture.bloodpoint>=753)//when blood point is smaller than 753, show low-blood warning
            	{
            		texture.lowwarning1=false;
            		if(texture.bloodpoint>=760&&texture.bloodpoint<=761)
            		{
            			texture.bloodbar.bar();//change the color of blood bar
      					
            		}
            		
            	}
            	if(texture.energypoint>=753)//when energy point is smaller than 753, show low-blood warning
            	{
            		texture.lowwarning2=false;
            		if(texture.energypoint>=760&&texture.energypoint<=761)
            		{
            			
      					texture.energybar.bar();//change the color of energy bar
            		}
            	}
            	
 	   if(texture.terramartix[texture.xexp+50][texture.yexp+50]==0)
			{
				if(texture.energypoint>=0)
				{
				texture.energypoint=texture.energypoint-0.5;//on water the energy is running out at 0.5 points per 0.02 sec
			
				}
	
			}
 	  if(texture.terramartix[texture.xexp+50][texture.yexp+50]==1)
		{
			if(texture.energypoint>=0)
			{
			texture.energypoint=texture.energypoint-0.3;//on land the energy is running out at 0.3 points per 0.02 sec
		
			}

		}
			if(texture.terramartix[texture.xexp+50][texture.yexp+50]==311)
			{//on hills the blood and energy are running out at 1 points per 0.02 sec
				if(texture.bloodpoint>=0)
				{
				texture.bloodpoint=texture.bloodpoint-1;	
			
				}
				if(texture.energypoint>=0)
				{
				texture.energypoint=texture.energypoint-1;
				
				}
			
			}
			if(texture.terramartix[texture.xexp+50][texture.yexp+50]==312)
			{//on mountains the blood are running out at 2 points per 0.02 sec
			//on mountains the energy are running out at 3 points per 0.02 sec
				if(texture.bloodpoint>=0)
				{
				texture.bloodpoint=texture.bloodpoint-2;

				}
				if(texture.energypoint>=0)
				{
				texture.energypoint=texture.energypoint-3;
				}
				
			}
			
			if(texture.daynightsign==false)
			{//in night time the energy are running out at 1 points per 0.02 sec
				
				if(texture.energypoint>=0)
				{
				texture.energypoint=texture.energypoint-1;
				}
			
			}
			
			if(texture.daynightsign==true)
			{//in day time the energy are increase at 0.5 points per 0.02 sec
				
				if(texture.energypoint<=1840)
				{
				texture.energypoint=texture.energypoint+0.5;
				
				}

			}
			if(texture.energypoint<=0)
			{//if energy run out, the blood points start to decrease
				 if(texture.terramartix[texture.xexp+50][texture.yexp+50]==0)
					{//if energy run out on water, directly fail
					 failed(1);
						texture.service.shutdownNow();
					}
				texture.bloodpoint=texture.bloodpoint-3;

			}
			if(texture.bloodpoint<=0)
			{ //if blood run out, fail
				failed(2);
				texture.service.shutdownNow();
			}
			
			texture.bloodbar.bloodbarmotion((int)(texture.bloodpoint/10-184));
			texture.energybar.energybarmotion((int)(texture.energypoint/10-184));
			if(texture.bloodpoint<=752&&texture.lowwarning1==false)
			{
				texture.bloodbar.lowstatus(1);
				
			}
			if(texture.energypoint<=752&&texture.lowwarning2==false)
			{
				texture.energybar.lowstatus(2);
				
			}			
    }
    };
    texture.service.scheduleAtFixedRate(timerTask, 0, 20, TimeUnit.MILLISECONDS);//execute every 0.02 sec
}
	public void failed(int num)//when fail, execute this function
	{
		if(num==1)
		{
		texture.explorer.explorerdown(1);//on water and energy run out, explorer will fall into water
		}
		if(num==2)
		{
		texture.explorer.explorerdown(2);//on land blood run out, explorer will down
		}
		texture.layeredPane.remove(texture.scanner);//scanner stop working
		try {
			Thread.sleep(3000);//wait for 3 sec
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		texture.layeredPane.add(texture.labelfail,new Integer(49));//start to show fail page
		texture.labelfail.setBounds(0,0,1000,600);
		texture.labelfail.setOpaque(false);
		texture.labelfail.Imagefailed();
	}
}