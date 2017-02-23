package allenexplorex1;

import java.awt.Container;
//import java.awt.Point;
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
	public static JFrame frame=new JFrame();
	public static Container layeredPane=frame.getLayeredPane();

	public static JLabel labelNew=new JLabel();
	public static JLabel labelLoad=new JLabel();
	public static JLabel labelBackGround=new JLabel();
	public static String fileName="";

	public static ImageIcon iconBackGround=new ImageIcon("basictexture/background.png");
	public static ImageIcon iconNew=new ImageIcon("basictexture/newgame.png");
	public static ImageIcon iconLoad=new ImageIcon("basictexture/loadgame.png");
	public static ImageIcon iconNewPressed=new ImageIcon("basictexture/newgamePressed.png");
	public static ImageIcon iconLoadPressed=new ImageIcon("basictexture/loadgamePressed.png");
	public static int [][]mapmatrix=new int[3000][1800];
	public static int [][]terramatrix=new int[3000][1800];
	public static int mtype=0; //1:continent;2:island;3:ancient continent;4:mediterranean
	public static int ttype=0; //1:grassland&plain;2:forest&jungle;3:desert;4:stone;5:snow&tundra;6:radiation
	public static int screenx=0;
	public static int screeny=0;
	public static int landcolor=-3355444;


	public static ImagePanel labelLoadingProcess=new ImagePanel();
	public static ImagePanel map=new ImagePanel();
	public static ImagePanel halfmap=new ImagePanel();
	public static JLabel [][]terra=new JLabel[30][18];
	public static int maplength=3000;
	public static int mapwidth=1800;

	public static ImageIcon iconhill=new ImageIcon("terraintexture/hill.png");
	public static ImageIcon iconmountain=new ImageIcon("terraintexture/mountain.png");
	public static ImageIcon iconmineral=new ImageIcon("terraintexture/mineral.png");
	public static ImageIcon iconallenstr=new ImageIcon("terraintexture/allenstr.png");
	public static ImageIcon iconfallallenstr=new ImageIcon("terraintexture/allenstrfall.png");
	public static ImageIcon iconship=new ImageIcon("terraintexture/ship.png");
	public static ImageIcon iconshadow=new ImageIcon("terraintexture/shadow.png");

	public static ImagePanel ship=new ImagePanel();
	public static Imageexplorer explorer=new Imageexplorer();
	public static int xexp=400;
	public static int yexp=300;
	public static int []xmon=new int[5];
	public static int []ymon=new int[5];
	public static int xdens=0;
	public static int ydens=0;
	public static int []xmondens=new int[5];
	public static int []ymondens=new int[5];
	public static JLabel labelrightclicksign=new JLabel();
	public static JLabel labelblood=new JLabel();
	public static JLabel labelenergy=new JLabel();
	public static JLabel labelminimap1=new JLabel();
	public static JLabel labelminimap2=new JLabel();
	public static JLabel labelclock=new JLabel();
	public static JLabel labelresource=new JLabel();
	public static JLabel labelmotherbu1=new JLabel();
	public static JLabel labelmotherbu2=new JLabel();
	public static JLabel labelgather1=new JLabel();
	public static ImagePanel1 bloodbar=new ImagePanel1();
	public static ImagePanel1 energybar=new ImagePanel1();
	public static Imageclockpointer clock=new Imageclockpointer();
	public static Imagenight night=new Imagenight();
	public static Imageminimap explorersignminimap=new Imageminimap();
	public static Imageminimap monstersignminimap=new Imageminimap();
	public static double bloodpoint=1840;
	public static double energypoint=1840;
	public static Imagescannermotion scanner=new Imagescannermotion();
	public static Imagemonsterdirt dirt=new Imagemonsterdirt();
	public static Imagemonsterdirt dirt2=new Imagemonsterdirt();
	public static Imagemonsterdirt dirt3=new Imagemonsterdirt();
	public static Imagemonsterdirt dirt4=new Imagemonsterdirt();
	public static Imagemonsterdirt dirt5=new Imagemonsterdirt();
	public static Imagemonsterbody body=new Imagemonsterbody();
	public static Imagemonsterbody body2=new Imagemonsterbody();
	public static Imagemonsterbody body3=new Imagemonsterbody();
	public static Imagemonsterbody body4=new Imagemonsterbody();
	public static Imagemonsterbody body5=new Imagemonsterbody();

	public static noticeshow nts=new noticeshow();
	public static JLabel labelcom=new JLabel();
	public static ImageIcon iconnote1=new ImageIcon("basictexture/notice1.png");
	public static ImageIcon iconnote2=new ImageIcon("basictexture/notice2.png");
	public static ImageIcon iconnote3=new ImageIcon("basictexture/notice3.png");
	public static ImageIcon iconnote4=new ImageIcon("basictexture/notice4.png");
	public static ImageIcon iconnote5=new ImageIcon("basictexture/notice5.png");
	public static ImageIcon iconnote6=new ImageIcon("basictexture/notice6.png");
	public static ImageIcon iconnote7=new ImageIcon("basictexture/notice7.png");

	public static ImageIcon iconlandzone=new ImageIcon("terraintexture/landzone.png");
	public static ImageIcon iconrightclick=new ImageIcon("basictexture/rightclick.png");
	public static ImageIcon iconblood=new ImageIcon("characters/hp.png");
	public static ImageIcon iconenergy=new ImageIcon("characters/ENERGY.png");
	public static ImageIcon iconminimap1=new ImageIcon("basictexture/minimap.png");
	public static ImageIcon clockday=new ImageIcon("basictexture/clockday.png");
	public static ImageIcon clocknight=new ImageIcon("basictexture/clocknight.png");
	public static ImageIcon iconplain=new ImageIcon("basictexture/noteplain.png");
	public static ImageIcon iconwater=new ImageIcon("basictexture/notewater.png");
	public static ImageIcon iconnhill=new ImageIcon("basictexture/notehill.png");
	public static ImageIcon iconnmountain=new ImageIcon("basictexture/notemountain.png");
	public static ImageIcon iconnmineral=new ImageIcon("basictexture/notemineral.png");
	public static ImageIcon iconnstr=new ImageIcon("basictexture/notestr.png");
	public static ImageIcon iconnship=new ImageIcon("basictexture/noteship.png");
	public static ImageIcon iconfallstr=new ImageIcon("basictexture/notestrfall.png");
	public static ImageIcon iconemptystr=new ImageIcon("basictexture/notestrempty.png");
	public static ImageIcon iconmothership=new ImageIcon("basictexture/notemothership.png");
	public static ImageIcon iconmothershipbu1=new ImageIcon("basictexture/motherbu1.png");
	public static ImageIcon iconmothershipbu2=new ImageIcon("basictexture/motherbu2.png");
	public static ImageIcon iconmothershipbu3=new ImageIcon("basictexture/motherbu3.png");
	public static ImageIcon icongathersample=new ImageIcon("basictexture/gathersample.png");

	public static int collection=0;

	public static boolean daynightsign=true;//true:day false:night
	public static boolean explorerstopsign=true;
	public static boolean lowwarning1=false;
	public static boolean lowwarning2=false;


	public static boolean landsign=false;
	public static ImageIcon iconopaque=new ImageIcon("terraintexture/opaque.png");
	public static boolean startsign=false;
	public static boolean completesign=false;
	public static JLabel labeldamage=new JLabel();
	public static ImageIcon icondamage=new ImageIcon("characters/damage.png");

	public static boolean strfall=false;
	public static boolean mineralsign=false;
	public static boolean strsign=false;
	public static boolean shipsign=false;
	public static boolean mothershipsign=false;

	public static ImagePanel labelsuccess=new ImagePanel();
	public static ImagePanel labelfail=new ImagePanel();
	public static JLabel labelmain=new JLabel();
	public static ImageIcon iconmain=new ImageIcon("basictexture/mainmenu.png");

	public static JLabel labeldscount=new JLabel();
	public static JLabel labeldcount=new JLabel(Integer.toString(texture.dcount));
	public static JLabel labelscount=new JLabel(Integer.toString(texture.collection));
	public static int dcount=0;
	public static ImageIcon icondscount=new ImageIcon("basictexture/dscount.png");

	public static int alp=255;
	public static int alpf=0;
	public static int alps=0;
	public static MainMenu menu=new MainMenu();


	public static ScheduledExecutorService service=Executors.newScheduledThreadPool(20);

	public void initation()
	{
		texture.labelNew=new JLabel();
		texture.labelLoad=new JLabel();
		texture.labelBackGround=new JLabel();
		texture.fileName="";

		texture.iconBackGround=new ImageIcon("basictexture/background.png");
		texture.iconNew=new ImageIcon("basictexture/newgame.png");
		texture.iconLoad=new ImageIcon("basictexture/loadgame.png");
		texture.iconNewPressed=new ImageIcon("basictexture/newgamePressed.png");
		texture.iconLoadPressed=new ImageIcon("basictexture/loadgamePressed.png");
		texture.mapmatrix=new int[3000][1800];
		texture.terramatrix=new int[3000][1800];
		texture.mtype=0;//1:continent;2:island;3:ancient continent;4:mediterranean
		texture.ttype=0;//1:grassland&plain;2:forest&jungle;3:desert;4:stone;5:snow&tundra;6:radiation
		texture.screenx=0;
		texture.screeny=0;
		texture.landcolor=-3355444;


		texture.labelLoadingProcess=new ImagePanel();
		texture.map=new ImagePanel();
		texture.halfmap=new ImagePanel();
		texture.terra=new JLabel[30][18];
		texture.maplength=3000;
		texture.mapwidth=1800;

		texture.iconhill=new ImageIcon("terraintexture/hill.png");
		texture.iconmountain=new ImageIcon("terraintexture/mountain.png");
		texture.iconmineral=new ImageIcon("terraintexture/mineral.png");
		texture.iconallenstr=new ImageIcon("terraintexture/allenstr.png");
		texture.iconfallallenstr=new ImageIcon("terraintexture/allenstrfall.png");
		texture.iconship=new ImageIcon("terraintexture/ship.png");
		texture.iconshadow=new ImageIcon("terraintexture/shadow.png");

		texture.ship=new ImagePanel();
		texture.explorer=new Imageexplorer();
		texture.xexp=400;
		texture.yexp=300;
		texture.xmon=new int[5];
		texture.ymon=new int[5];
		texture.xdens=0;
		texture.ydens=0;
		texture.xmondens=new int[5];
		texture.ymondens=new int[5];
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
		texture.monstersignminimap=new Imageminimap();
		texture.bloodpoint=1840;
		texture.energypoint=1840;
		texture.scanner=new Imagescannermotion();
		texture.dirt=new Imagemonsterdirt();
		texture.dirt2=new Imagemonsterdirt();
		texture.dirt3=new Imagemonsterdirt();
		texture.dirt4=new Imagemonsterdirt();
		texture.dirt5=new Imagemonsterdirt();
		texture.body=new Imagemonsterbody();
		texture.body2=new Imagemonsterbody();
		texture.body3=new Imagemonsterbody();
		texture.body4=new Imagemonsterbody();
		texture.body5=new Imagemonsterbody();

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
		texture.menu=new MainMenu();

		texture.service=Executors.newScheduledThreadPool(20);

	}
}
