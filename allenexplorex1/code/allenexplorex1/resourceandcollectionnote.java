package allenexplorex1;

import java.awt.Color;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class resourceandcollectionnote {

	boolean displayed=false;
	int countdis=0;

	public void reconote()
	{
		ScheduledExecutorService service=Executors.newScheduledThreadPool(1);
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				int spot = texture.terramatrix[texture.xexp+50][texture.yexp+50];

				if(spot == 100)
				{
					texture.labelresource.setIcon(texture.iconmothership);

					if(texture.collection<10)
					{
						texture.labelmotherbu1.setIcon(texture.iconmothershipbu1);
						texture.labelmotherbu2.setIcon(texture.iconmothershipbu2);
					}
					if(texture.collection>=10)
					{
						texture.labelmotherbu1.setIcon(texture.iconmothershipbu1);
						texture.labelmotherbu2.setIcon(texture.iconmothershipbu3);
					}
					texture.mineralsign=false;
					texture.strsign=false;
					texture.shipsign=false;
					texture.mothershipsign=true;
				}
				if(spot == 0)
				{
					texture.mineralsign=false;
					texture.strsign=false;
					texture.shipsign=false;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelgather1.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconwater);
				}
				if(spot == 1)
				{
					texture.mineralsign=false;
					texture.strsign=false;
					texture.shipsign=false;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelgather1.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconplain);
				}
				if(spot == 311)
				{
					texture.mineralsign=false;
					texture.strsign=false;
					texture.shipsign=false;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelgather1.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconnhill);
				}
				if(spot == 312)
				{
					texture.mineralsign=false;
					texture.strsign=false;
					texture.shipsign=false;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelgather1.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconnmountain);
				}
				if(spot/10 == 313)
				{
					texture.mineralsign=true;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconnmineral);
					texture.labelgather1.setIcon(texture.icongathersample);
				}
				if(spot/10 == 314)
				{
					texture.strsign=true;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconnstr);
					texture.labelgather1.setIcon(texture.icongathersample);
				}
				if(spot/10==315)
				{
					texture.shipsign=true;
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconnship);
					texture.labelgather1.setIcon(texture.icongathersample);
				}
				if(spot==316)
				{
					texture.mothershipsign=false;
					texture.labelmotherbu1.setIcon(texture.iconopaque);
					texture.labelmotherbu2.setIcon(texture.iconopaque);
					texture.labelresource.setIcon(texture.iconemptystr);
					texture.labelgather1.setIcon(texture.iconopaque);
				}

				texture.labeldcount.setText(Integer.toString(texture.dcount));
				texture.labelscount.setText(Integer.toString(texture.collection));
				if(texture.collection>=10)
				{
					texture.labelscount.setForeground(Color.green);
					texture.labelcom.setIcon(texture.iconnote5);

				}
			}
		};

		service.scheduleAtFixedRate(timerTask, 0, 10, TimeUnit.MILLISECONDS);

	}
}
