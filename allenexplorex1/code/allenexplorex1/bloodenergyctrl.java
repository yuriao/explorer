package allenexplorex1;

import java.util.TimerTask;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//import javax.swing.ImageIcon;
//import javax.swing.JLabel;

public class bloodenergyctrl {

	public void bloodandenergycontrol()
	{
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if(texture.bloodpoint>=1840)
					texture.bloodpoint=1840;
				if(texture.energypoint>=1840)
					texture.energypoint=1840;

				if(texture.bloodpoint>=753)
				{
					texture.lowwarning1=false;
					if(texture.bloodpoint>=760&&texture.bloodpoint<=761)
					{
						texture.bloodbar.bar();
					}
				}
				if(texture.energypoint>=753)
				{
					texture.lowwarning2=false;
					if(texture.energypoint>=760&&texture.energypoint<=761)
					{
						texture.energybar.bar();
					}
				}

				int spot = texture.terramatrix[texture.xexp+50][texture.yexp+50];
				if(spot==0)
				{
					if(texture.energypoint>=0)
						texture.energypoint-=0.5;
				}
				if(spot==1)
				{
					if(texture.energypoint>=0)
					{
						texture.energypoint=texture.energypoint-0.3;
					}
				}
				if(spot==311)
				{
					if(texture.bloodpoint>=0)
					{
					texture.bloodpoint-=1;
					}
					if(texture.energypoint>=0)
					{
						texture.energypoint-=1;
					}
				}
				if(spot==312)
				{
					if(texture.bloodpoint>=0)
					{
						texture.bloodpoint-=2;
					}
					if(texture.energypoint>=0)
					{
						texture.energypoint-=3;
					}
				}

				if(texture.daynightsign==false)
				{
					if(texture.energypoint>=0)
					{
						texture.energypoint-=1;
					}
				}

				if(texture.daynightsign==true)
				{
					if(texture.energypoint<=1840)
					{
						texture.energypoint+=0.5;
					}
				}
				if(texture.energypoint<=0)
				{
					if(texture.terramatrix[texture.xexp+50][texture.yexp+50]==0)
					{
						failed(1);
						texture.service.shutdownNow();
					}
					texture.bloodpoint=texture.bloodpoint-3;
				}
				if(texture.bloodpoint<=0)
				{
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
		texture.service.scheduleAtFixedRate(timerTask, 0, 20, TimeUnit.MILLISECONDS);
	}
	public void failed(int num)
	{
		if(num==1)
			texture.explorer.explorerdown(1);
		if(num==2)
			texture.explorer.explorerdown(2);
		
		texture.layeredPane.remove(texture.scanner);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		texture.layeredPane.add(texture.labelfail,new Integer(49));
		texture.labelfail.setBounds(0,0,1000,600);
		texture.labelfail.setOpaque(false);
		texture.labelfail.Imagefailed();
	}
}
