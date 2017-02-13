package allenexplorex1;

import java.awt.Container;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class texture extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame=new JFrame(); //base container of all the elements
	public static Container layeredPane=frame.getLayeredPane();//there are multiple layers in the base container.
	
	public static JLabel labelNew=new JLabel();//"new game" button
	public static JLabel labelBackGround=new JLabel();//welcome page background
	public static String fileName="";

	public static int maplength=9000;
	public static int mapwidth=4500;
	
	public static ImageIcon iconBackGround=new ImageIcon("basictexture/background.png");//add image to welcome page background
	public static ImageIcon iconNew=new ImageIcon("basictexture/newgame.png");//add image to "new game" button
	public static ImageIcon iconNewPressed=new ImageIcon("basictexture/newgamePressed.png");//when pressed, change the image of "new game" button
	public static int [][]mapmartix=new int[9001][5401];//map matrix
	public static int [][]terramartix=new int[9000][5400];//landmark matrix
	public static int mtype=0;//different land-water distribution	
	public static int ttype=0;//different land type	
	public static int screenx=0;
	public static int screeny=0;
	public static int landcolor=-3355444;//major color of land
	
	
	public static ImagePanel labelLoadingProcess=new ImagePanel();//loading process background
	public static ImagePanel map=new ImagePanel();//map image
	public static ImagePanel halfmap=new ImagePanel();//left part and right part of the map
	public static JLabel [][]terra=new JLabel[90][54];//landmark image matrix
	
	public static ImageIcon iconhill=new ImageIcon("terraintexture/hill.png");//landmark "hill" image
	public static ImageIcon iconmountain=new ImageIcon("terraintexture/mountain.png");//landmark "mountain" image	
	public static ImageIcon iconmineral=new ImageIcon("terraintexture/mineral.png");//sample "mineral" image 
	public static ImageIcon iconallenstr=new ImageIcon("terraintexture/allenstr.png");//sample "weird structure" image
	public static ImageIcon iconfallallenstr=new ImageIcon("terraintexture/allenstrfall.png");//"empty structure" image
	public static ImageIcon iconship=new ImageIcon("terraintexture/ship.png");//sample "shipwreck" image
	
	public static ImagePanel ship=new ImagePanel();	//mother ship
	public static Imageexplorer explorer=new Imageexplorer();//character
	public static int xexp=400;//character's x coordination
	public static int yexp=300;//character's y coordination
	public static int xdens=0;//character's x destination
	public static int ydens=0;//character's y destination
	public static JLabel labelrightclicksign=new JLabel();//this label is not used for now
	public static JLabel labelblood=new JLabel();//blood window
	public static JLabel labelenergy=new JLabel();//energy window
	public static JLabel labelminimap1=new JLabel();//minimap 
	public static JLabel labelminimap2=new JLabel();//labels on minimap
	public static JLabel labelclock=new JLabel();//clock window
	public static JLabel labelresource=new JLabel();//sample and landmark notice
	public static JLabel labelmotherbu1=new JLabel();//button on mother ship notice
	public static JLabel labelmotherbu2=new JLabel();//button on mother ship notice
	public static JLabel labelgather1=new JLabel();//the "gather resource" button on resource notice
	public static ImagePanel1 bloodbar=new ImagePanel1();//blood bar in blood window
	public static ImagePanel1 energybar=new ImagePanel1();//energy bar in energy window
	public static Imageclockpointer clock=new Imageclockpointer();//pointers in clock window
	public static Imagenight night=new Imagenight();//the night shadow (a half-transparent black rectangle)
	public static Imageminimap explorersignminimap=new Imageminimap();//character label on minimap
	public static double bloodpoint=1840;//total blood point
	public static double energypoint=1840;//total energy point
	public static Imagescannermotion scanner=new Imagescannermotion();//the scanner of character (the blue light around the character) 
	
	public static noticeshow nts=new noticeshow();//notice
	public static JLabel labelcom=new JLabel();//notice indicate game complete
	public static ImageIcon iconnote1=new ImageIcon("basictexture/notice1.png");//notice type1 image
	public static ImageIcon iconnote2=new ImageIcon("basictexture/notice2.png");//notice type2 image
	public static ImageIcon iconnote3=new ImageIcon("basictexture/notice3.png");//notice type3 image
	public static ImageIcon iconnote4=new ImageIcon("basictexture/notice4.png");//notice type4 image
	public static ImageIcon iconnote5=new ImageIcon("basictexture/notice5.png");//notice type5 image
	public static ImageIcon iconnote6=new ImageIcon("basictexture/notice6.png");//notice type6 image
	public static ImageIcon iconnote7=new ImageIcon("basictexture/notice7.png");//notice type7 image
	
	public static ImageIcon iconlandzone=new ImageIcon("terraintexture/landzone.png");//landing zone image
	public static ImageIcon iconrightclick=new ImageIcon("basictexture/rightclick.png");//this is not used for now
	public static ImageIcon iconblood=new ImageIcon("characters/hp.png");//blood window image
	public static ImageIcon iconenergy=new ImageIcon("characters/ENERGY.png");//energy window image
	public static ImageIcon iconminimap1=new ImageIcon("basictexture/minimap.png");//minimap image
	public static ImageIcon clockday=new ImageIcon("basictexture/clockday.png");//clock window image at daytime
	public static ImageIcon clocknight=new ImageIcon("basictexture/clocknight.png");//clock window image at night time
	public static ImageIcon iconplain=new ImageIcon("basictexture/noteplain.png");//no landmark land area notice image
	public static ImageIcon iconwater=new ImageIcon("basictexture/notewater.png");//water area notice image
	public static ImageIcon iconnhill=new ImageIcon("basictexture/notehill.png");//landmark hill label image
	public static ImageIcon iconnmountain=new ImageIcon("basictexture/notemountain.png");//landmark mountain notice image
	public static ImageIcon iconnmineral=new ImageIcon("basictexture/notemineral.png");//sample mineral notice image
	public static ImageIcon iconnstr=new ImageIcon("basictexture/notestr.png");//sample "weird structure" notice image
	public static ImageIcon iconnship=new ImageIcon("basictexture/noteship.png");//sample "shipwreck" notice image
	public static ImageIcon iconfallstr=new ImageIcon("basictexture/notestrfall.png");//"empty structure" (after accident) notice image
	public static ImageIcon iconemptystr=new ImageIcon("basictexture/notestrempty.png");//"empty structure" (no accident) notice image
	public static ImageIcon iconmothership=new ImageIcon("basictexture/notemothership.png");//mother ship notice image
	public static ImageIcon iconmothershipbu1=new ImageIcon("basictexture/motherbu1.png");//"repair" button image
	public static ImageIcon iconmothershipbu2=new ImageIcon("basictexture/motherbu2.png");//"still exploring" button image
	public static ImageIcon iconmothershipbu3=new ImageIcon("basictexture/motherbu3.png");//"take off" button image
	public static ImageIcon icongathersample=new ImageIcon("basictexture/gathersample.png");//"gather sample" image
	
	public static boolean daynightsign=true;//true:day false:night
	public static boolean explorerstopsign=true;//sign of whether the character is stopped
	public static boolean lowwarning1=false;//low blood warning
	public static boolean lowwarning2=false;//low energy warning
	
	
	public static boolean landsign=false;//sign of whether the mother ship has landed
	public static ImageIcon iconopaque=new ImageIcon("terraintexture/opaque.png");//an transparent label, used for remove labels
	public static boolean startsign=false;//whether the game has started
	public static boolean completesign=false;//whether the game has completed
	public static JLabel labeldamage=new JLabel();//a red half-transparent rectangle that will appear when exploration accident happens
	                                              //i.e. weird structure is fallen
	public static ImageIcon icondamage=new ImageIcon("characters/damage.png");// image of the damage label
	
	public static boolean strfall=false;//whether the weird structure is fallen (accident happen)
	public static boolean mineralsign=false;//whether this position has a mineral
	public static boolean strsign=false;//whether this position has a weird structure
	public static boolean shipsign=false;//whether this position has a shipwreck
	public static boolean mothershipsign=false;//whether this position has mothership
	
	public static ImagePanel labelsuccess=new ImagePanel();//success page
	public static ImagePanel labelfail=new ImagePanel();//fail page
	public static JLabel labelmain=new JLabel();//"return to main page" button
	public static ImageIcon iconmain=new ImageIcon("basictexture/mainmenu.png");//"return to main page" button image
	
	public static JLabel labeldscount=new JLabel();//day and collected sample number counter window
	public static JLabel labeldcount=new JLabel(Integer.toString(texture.dcount));//day number counter
	public static JLabel labelscount=new JLabel(Integer.toString(texture.collection));//sample number counter
	public static int dcount=0;//day number	
	public static int collection=0;// number of samples collected
	public static ImageIcon icondscount=new ImageIcon("basictexture/dscount.png");//day and collected sample number counter window image
	
	public static int alp=255;//alpha value of loading page
	public static int alpf=0;//alpha value of fail page
	public static int alps=0;//alpha value of success page
	public static UIwelcome wel=new UIwelcome();
	
	
	public static ScheduledExecutorService service=Executors.newScheduledThreadPool(20);//a time counter thread pool. can be used by other functions
	
	public void initation()//when game ended, return to main page. all variables are set the initial value
	{	
		texture.labelNew=new JLabel();
		texture.labelBackGround=new JLabel();
		texture.fileName="";

		texture.iconBackGround=new ImageIcon("basictexture/background.png");
		texture.iconNew=new ImageIcon("basictexture/newgame.png");
		texture.iconNewPressed=new ImageIcon("basictexture/newgamePressed.png");
		texture.mapmartix=new int[9000][5400];
		texture.terramartix=new int[9000][5400];
		texture.mtype=0;//1:continent;2:island;3:ancient continent;4:mediterranean	
		texture.ttype=0;//1:grassland&plain;2:forest&jungle;3:desert;4:stone;5:snow&tundra;6:radiation	
		texture.screenx=0;
		texture.screeny=0;
		texture.landcolor=-3355444;
		
		
		texture.labelLoadingProcess=new ImagePanel();
		texture.map=new ImagePanel();
		texture.halfmap=new ImagePanel();
		texture.terra=new JLabel[90][54];
		texture.maplength=9000;
		texture.mapwidth=5400;
		
		texture.iconhill=new ImageIcon("terraintexture/hill.png");
		texture.iconmountain=new ImageIcon("terraintexture/mountain.png");
		texture.iconmineral=new ImageIcon("terraintexture/mineral.png");
		texture.iconallenstr=new ImageIcon("terraintexture/allenstr.png");
		texture.iconfallallenstr=new ImageIcon("terraintexture/allenstrfall.png");
		texture.iconship=new ImageIcon("terraintexture/ship.png");
		
		texture.ship=new ImagePanel();	
		texture.explorer=new Imageexplorer();
		texture.xexp=400;
		texture.yexp=300;
		texture.xdens=400;
		texture.ydens=300;
		texture.labelrightclicksign=new JLabel();
		texture.labelblood=new JLabel();
		texture.labelenergy=new JLabel();
		texture.labelminimap1=new JLabel();
		texture.labelminimap2=new JLabel();
		texture.labelclock=new JLabel();
		texture.labelresource=new JLabel();
		texture.labelmotherbu1=new JLabel();
		texture.labelmotherbu2=new JLabel();
		texture.labelgather1=new JLabel();
		texture.bloodbar=new ImagePanel1();
		texture.energybar=new ImagePanel1();
		texture.clock=new Imageclockpointer();
		texture.night=new Imagenight();
		texture.explorersignminimap=new Imageminimap();
		texture.bloodpoint=1840;
		texture.energypoint=1840;
		texture.scanner=new Imagescannermotion();
		
		texture.nts=new noticeshow();
		texture.labelcom=new JLabel();
		texture.iconnote1=new ImageIcon("basictexture/notice1.png");
		texture.iconnote2=new ImageIcon("basictexture/notice2.png");
		texture.iconnote3=new ImageIcon("basictexture/notice3.png");
		texture.iconnote4=new ImageIcon("basictexture/notice4.png");
		texture.iconnote5=new ImageIcon("basictexture/notice5.png");
		texture.iconnote6=new ImageIcon("basictexture/notice6.png");
		texture.iconnote7=new ImageIcon("basictexture/notice7.png");
		
		texture.iconlandzone=new ImageIcon("terraintexture/landzone.png");
		texture.iconrightclick=new ImageIcon("basictexture/rightclick.png");
		texture.iconblood=new ImageIcon("characters/hp.png");
		texture.iconenergy=new ImageIcon("characters/ENERGY.png");
		texture.iconminimap1=new ImageIcon("basictexture/minimap.png");
		texture.clockday=new ImageIcon("basictexture/clockday.png");
		texture.clocknight=new ImageIcon("basictexture/clocknight.png");
		texture.iconplain=new ImageIcon("basictexture/noteplain.png");
		texture.iconwater=new ImageIcon("basictexture/notewater.png");
		texture.iconnhill=new ImageIcon("basictexture/notehill.png");
		texture.iconnmountain=new ImageIcon("basictexture/notemountain.png");
		texture.iconnmineral=new ImageIcon("basictexture/notemineral.png");
		texture.iconnstr=new ImageIcon("basictexture/notestr.png");
		texture.iconnship=new ImageIcon("basictexture/noteship.png");
		texture.iconfallstr=new ImageIcon("basictexture/notestrfall.png");
		texture.iconemptystr=new ImageIcon("basictexture/notestrempty.png");
		texture.iconmothership=new ImageIcon("basictexture/notemothership.png");
		texture.iconmothershipbu1=new ImageIcon("basictexture/motherbu1.png");
		texture.iconmothershipbu2=new ImageIcon("basictexture/motherbu2.png");
		texture.iconmothershipbu3=new ImageIcon("basictexture/motherbu3.png");
		texture.icongathersample=new ImageIcon("basictexture/gathersample.png");
		
		texture.collection=0;
		
		texture.daynightsign=true;//true:day false:night
		texture.explorerstopsign=true;
		texture.lowwarning1=false;
		texture.lowwarning2=false;
		
		
		texture.landsign=false;
		texture.iconopaque=new ImageIcon("terraintexture/opaque.png");
		texture.startsign=false;
		texture.completesign=false;
		texture.labeldamage=new JLabel();
		texture.icondamage=new ImageIcon("characters/damage.png");
		
		texture.strfall=false;
		texture.mineralsign=false;
		texture.strsign=false;
		texture.shipsign=false;
		texture.mothershipsign=false;
		
		texture.labelsuccess=new ImagePanel();
		texture.labelfail=new ImagePanel();
		texture.labelmain=new JLabel();
		texture.iconmain=new ImageIcon("basictexture/mainmenu.png");
		
		texture.labeldscount=new JLabel();
		texture.labeldcount=new JLabel(Integer.toString(texture.dcount));
		texture.labelscount=new JLabel(Integer.toString(texture.collection));
		texture.dcount=0;
		texture.icondscount=new ImageIcon("basictexture/dscount.png");
		
		texture.alp=255;
		texture.alpf=0;
		texture.alps=0;
		texture.wel=new UIwelcome();
		
		texture.service=Executors.newScheduledThreadPool(20);
		
	}
}
