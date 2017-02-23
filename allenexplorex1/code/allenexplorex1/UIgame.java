package allenexplorex1;

import java.awt.Color;
import java.awt.Point;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
//import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class UIgame {

	Point origin=new Point(); //point recording map location
//	Point origin1=new Point();
	bloodenergyctrl bectrl=new bloodenergyctrl();// call class bloodenergyctrl
	texture tei=new texture();// call class texture (mainly for initiation function)

	suddendamage sud=new suddendamage();// call class suddendamage

	public void drawmap()
	{
		texture.startsign=true; //startsign
		texture.layeredPane.add(texture.map,new Integer(1));//add map to the base container
		texture.map.setBounds(0,0,3000,1800);//size of map
		// try {
		// 	texture.map.loadmap(texture.fileName+"/map.png");//load map picture
		// }
		// catch (IOException e2) {
		// 	// TODO Auto-generated catch block
		// 	//e2.printStackTrace();
		// }


		for(int i=0;i<30;i++)
		{
			for(int j=0;j<18;j++)
			{
				texture.terra[i][j]=new JLabel(); //initiating the landmark matrix
				texture.layeredPane.add(texture.terra[i][j],new Integer(2));//add landmark matrix to base container
				texture.terra[i][j].setBounds(i*100,j*100,100,100);// each landmark size is 100*100
				texture.terra[i][j].setOpaque(false);
				if(texture.mapmatrix[i*100][j*100]==311)
				{
					texture.terra[i][j].setIcon(texture.iconhill);//place hill according to the map matrix tag
				}
				if(texture.mapmatrix[i*100][j*100]==312)
				{
					texture.terra[i][j].setIcon(texture.iconmountain);//place mountain according to the map matrix tag
				}
				if(texture.mapmatrix[i*100][j*100]/10==314)
				{
					texture.terra[i][j].setIcon(texture.iconallenstr);//place sample "allenstr" according to the map matrix tag
				}
				if(texture.mapmatrix[i*100][j*100]/10==315)
				{
					texture.terra[i][j].setIcon(texture.iconship);//place sample "allenstr" according to the map matrix tag
				}


			}
		}


		texture.layeredPane.add(texture.ship,new Integer(3));//add mother ship canva to base container
		texture.ship.setBounds(0,0,3000,1800);//mother ship canva size
		texture.ship.setOpaque(false);

		texture.layeredPane.add(texture.explorer,new Integer(4));//add explorer canva to base container
		texture.explorer.setBounds(0,0,3000,1800);//explorer canva size
		texture.explorer.setOpaque(false);

		texture.layeredPane.add(texture.night,new Integer(29));//add night canva to base container
		texture.night.setBounds(0,0,1000,600);//night canva size
		texture.night.setOpaque(false);//currently night canva is a half-transparent black picture
		texture.night.loadImage();

		texture.terra[3][3].setIcon(texture.iconlandzone);//add landing zone
		texture.map.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				origin.x = e.getX();  //when mouse pressed, record mouse position
				origin.y = e.getY();

				if(e.getButton()==MouseEvent.BUTTON3)
				{ // these code is for displaying a symbol when right button is pressed. not used for now.

					//	                	 origin1.x = texture.xexp;
					//		                 origin1.y = texture.yexp;
					/* texture.layeredPane.add(texture.labelrightclicksign,new Integer(4));
					texture.labelrightclicksign.setBounds(e.getX()-15,e.getY()-15,30,30);
					texture.labelrightclicksign.setOpaque(false);
					texture.labelrightclicksign.setIcon(texture.iconrightclick);*/
				}
			}

			public void mouseReleased(MouseEvent e)
			{
				if(e.getButton()==MouseEvent.BUTTON3)//when right button released, move the character
				{

					texture.xdens=e.getX()-50;
					texture.ydens=e.getY()-50;
					if(texture.explorerstopsign==true)
					{
						texture.explorer.explorermotion();
					}

				}

			}
		});
		texture.map.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e) {

				Point p = texture.map.getLocation();  //when mouse is pressed and dragged, move the map

				int x=0;
				int y=0;
				x=p.x + e.getX() - origin.x;
				y=p.y + e.getY() - origin.y;
				if(x>=-2000&&x<=0)
				{
					if(y>=-1200&&y<=0)
					{
						if(y==-1200)
							--y;
						if(y==0)
							--y;
						if(x==-1500)
							++x;
						if(x==0)
							--x;
						texture.map.setLocation(x, y);
						texture.ship.setLocation(x, y);
						texture.explorer.setLocation(x, y);
						texture.scanner.setLocation(x+texture.xexp-25, y+texture.yexp-25);
						for(int i=0;i<30;i++)
						{
							for(int j=0;j<18;j++)
							{
								texture.terra[i][j].setLocation(i*100+x, j*100+y);

							}
						}
						texture.screenx=x;
						texture.screeny=y;

					}
				}
			}

		 });

		texture.terra[3][3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(texture.startsign==true&&texture.completesign==false) // when click on the landing zone, start loading character and UI
				{
					texture.layeredPane.add(texture.labelblood,new Integer(30));//adding blood window
					texture.labelblood.setBounds(0,0,200,75);
					texture.labelblood.setOpaque(false);
					texture.labelblood.setIcon(texture.iconblood);

					texture.layeredPane.add(texture.labelenergy,new Integer(30));//adding energy window
					texture.labelenergy.setBounds(0,75,200,75);
					texture.labelenergy.setOpaque(false);
					texture.labelenergy.setIcon(texture.iconenergy);

					texture.layeredPane.add(texture.bloodbar,new Integer(31));//adding blood bar
					texture.bloodbar.setBounds(8,37,184,30);
					texture.bloodbar.setOpaque(false);

					texture.layeredPane.add(texture.energybar,new Integer(31));//adding energy bar
					texture.energybar.setBounds(8,112,184,30);
					texture.energybar.setOpaque(false);

					texture.layeredPane.add(texture.labelminimap1,new Integer(30));//adding minimap window
					texture.labelminimap1.setBounds(745,0,250,150);
					texture.labelminimap1.setOpaque(false);
					texture.labelminimap1.setIcon(texture.iconminimap1);

					texture.layeredPane.add(texture.labelminimap2,new Integer(30));//adding minimap
					texture.labelminimap2.setBounds(750,5,240,140);
					texture.labelminimap2.setOpaque(false);
					ImageIcon iconminimap2=new ImageIcon(texture.fileName+"/"+"minimap.png");
					System.out.println(texture.fileName+"/"+"minimap.png");
					texture.labelminimap2.setIcon(iconminimap2);

					texture.layeredPane.add(texture.labeldscount,new Integer(30));//adding days and sample counter
					texture.labeldscount.setBounds(745,150,250,51);
					texture.labeldscount.setOpaque(false);
					texture.labeldscount.setIcon(texture.icondscount);

					texture.layeredPane.add(texture.labeldcount,new Integer(31));//adding day number
					texture.labeldcount.setBounds(770,155,40,40);
					texture.labeldcount.setFont(new java.awt.Font("Arial",1,18));
					texture.labeldcount.setForeground(Color.white);
					texture.labeldcount.setOpaque(false);

					texture.layeredPane.add(texture.labelscount,new Integer(31));//adding sample number
					texture.labelscount.setBounds(880,155,40,40);
					texture.labelscount.setFont(new java.awt.Font("Arial",1,18));
					texture.labelscount.setForeground(Color.white);
					texture.labelscount.setOpaque(false);

					texture.layeredPane.add(texture.labelcom,new Integer(30));//add complete sign container
					texture.labelcom.setBounds(745,180,200,100);
					texture.labelcom.setOpaque(false);

					texture.layeredPane.add(texture.labelclock,new Integer(30));//add clock
					texture.labelclock.setBounds(894,470,100,100);
					texture.labelclock.setOpaque(false);
					texture.labelclock.setIcon(texture.clockday);

					texture.layeredPane.add(texture.clock,new Integer(31));
					texture.clock.setBounds(904,480,80,80);
					texture.clock.setOpaque(false);

					texture.layeredPane.add(texture.nts,new Integer(32));
					texture.nts.setBounds(0,370,200,51);
					texture.nts.setOpaque(false);

					texture.nts.noticeshowon(1);

					bectrl.bloodandenergycontrol();
					texture.ship.shipdownmotion();
					texture.clock.pointerrun();
					texture.startsign=false;
				}
				if(texture.startsign==false&&texture.completesign==true)
				{
					texture.startsign=false;
				}
				if(texture.startsign==false&&texture.completesign==false)
				{

				}
			}

		});


		texture.labelminimap2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
//				Point p = texture.map.getLocation();  //�������϶�ʱ��ȡ���ڵ�ǰλ��
				//���ô��ڵ�λ��
				//���ڵ�ǰ��λ�� + ���굱ǰ�ڴ��ڵ�λ�� - ���갴�µ�ʱ���ڴ��ڵ�λ��
				int x=0;
				int y=0;
				//calculate X
				if (x <= 42)
					x = 500-42*12;
				else if (x >=208)
					x = 500-208*12;
				else
					x = 500-e.getX()*12;
				//calculate y
				if (y <= 25)
					y = 300-25*12;
				else if (y >= 125)
					y = 300-125*12;
				else
					y = 300-e.getY()*12;
				texture.map.setLocation(x, y);
				texture.ship.setLocation(x, y);
				texture.explorer.setLocation(x, y);
				texture.dirt.setLocation(x, y);
				texture.dirt2.setLocation(x, y);
				texture.dirt3.setLocation(x, y);
				texture.dirt4.setLocation(x, y);
				texture.dirt5.setLocation(x, y);
				texture.scanner.setLocation(x+texture.xexp-25, y+texture.yexp-25);
				for(int i=0;i<30;i++)
				{
					for(int j=0;j<18;j++)
					{
						texture.terra[i][j].setLocation(i*100+x, j*100+y);
					}
				}
				texture.screenx=x;
				texture.screeny=y;
			}

		});

		texture.labelmotherbu1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(texture.mothershipsign==true)
				{
					texture.bloodpoint=1839;
					texture.energypoint=1839;
					texture.bloodbar.bar();
					texture.energybar.bar();
				}
			}
		});

		texture.labelmotherbu2.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(texture.collection>=10&&texture.mothershipsign==true)
				{
					texture.completesign=true;
					texture.layeredPane.remove(texture.explorer);
					texture.layeredPane.remove(texture.scanner);
					texture.ship.shipupmotion();
				}
			}
		});


		texture.labelgather1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(texture.mineralsign==true)
				{
					System.out.println("mineral");
					texture.collection=texture.collection+1;
					for(int u=-101;u<101;u++)
					{
						for(int v=-101;v<101;v++)
						{
							if(texture.mapmatrix[texture.xexp+50+u][texture.yexp+50+v]==texture.terramatrix[texture.xexp+50][texture.yexp+50])
							{
								texture.mapmatrix[texture.xexp+50+u][texture.yexp+50+v]=1;
								texture.terra[(texture.xexp+50+u)/100][(texture.yexp+50+v)/100].setIcon(texture.iconopaque);
								for(int m=10;m<80;m++)
								{
									for(int n=10;n<80;n++)
									{
										texture.terramatrix[(texture.xexp+50+u)+m][(texture.yexp+50+v)+n]=1;

									}
								}
							}

						}
					}
					texture.nts.noticeshowon(2);
					texture.mineralsign=false;
				}

				if(texture.strsign==true)
				{
					System.out.println("str");

					Random random=new Random();
					int p=random.nextInt(10);
					if(p<4)
					{
						texture.collection=texture.collection+1;
						texture.nts.noticeshowon(2);
					}
					if(p>=4&&p<=8)
					{
						texture.bloodpoint= texture.bloodpoint-500;
						sud.suddamshow();
						texture.strfall=true;
						texture.labelgather1.setIcon(texture.iconopaque);
						texture.nts.noticeshowon(3);
					}
					if(p>=8&&p<=9)
					{
						texture.bloodpoint= texture.bloodpoint+50;
						texture.energypoint= texture.energypoint+100;

						texture.collection=texture.collection+1;
						texture.nts.noticeshowon(4);
					}

					for(int u=-101;u<101;u++)
					{
						for(int v=-101;v<101;v++)
						{
							if(texture.mapmatrix[texture.xexp+50+u][texture.yexp+50+v]==texture.terramatrix[texture.xexp+50][texture.yexp+50])
							{
								if(texture.strfall==true)
								{
									texture.terra[(texture.xexp+50+u)/100][(texture.yexp+50+v)/100].setIcon(texture.iconfallallenstr);
								}
								for(int m=10;m<80;m++)
								{
									for(int n=10;n<80;n++)
									{
										texture.terramatrix[(texture.xexp+50+u)+m][(texture.yexp+50+v)+n]=316;

									}
								}
							}

						}
					}
					texture.strsign=false;
				}

				if(texture.shipsign==true)
				{
					Random random=new Random();
					int p1=random.nextInt(10);
					if(p1<4)
					{
						texture.collection=texture.collection+1;
						texture.nts.noticeshowon(2);
					}
					if(p1>=4&&p1<7)
					{
						texture.nts.noticeshowon(6);
					}

					if(p1>=7&&p1<=9)
					{
						texture.bloodpoint= texture.bloodpoint+p1*5;
						texture.energypoint= texture.energypoint+p1*7;

						texture.collection=texture.collection+1;
						texture.nts.noticeselect();
						texture.nts.noticeshowon(4);
					}
					for(int u=-101;u<101;u++)
					{
						for(int v=-101;v<101;v++)
						{
							if(texture.mapmatrix[texture.xexp+50+u][texture.yexp+50+v]==texture.terramatrix[texture.xexp+50][texture.yexp+50])
							{
								texture.terra[(texture.xexp+50+u)/100][(texture.yexp+50+v)/100].setIcon(texture.iconopaque);
								for(int m=10;m<80;m++)
								{
									for(int n=10;n<80;n++)
									{
										texture.terramatrix[(texture.xexp+50+u)+m][(texture.yexp+50+v)+n]=1;

									}
								}
							}

						}
					}
					texture.shipsign=false;
				}
			}
		});
		texture.labelmain.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				texture.layeredPane.remove(texture.labelfail);
				texture.layeredPane.remove(texture.labelsuccess);
				texture.layeredPane.remove(texture.labelmain);
				texture.alp=255;
				texture.alpf=0;
				texture.alps=0;

				tei.initation();
				texture.menu.mainmenu();
			}
		});

		}
	}
