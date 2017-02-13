package allenexplorex1;

import java.io.IOException;
import java.util.Random;

public class continentgen {
	
	public void continentareagen() throws IOException//generate map(land and water)
	{
		int n=750;
		Random randn=new Random();
		for(int i=0;i<texture.maplength-n;i=i+n)
		{
			for(int j=0;j<texture.mapwidth-n;j=j+n)
			{
				texture.mapmartix[i][j]=randn.nextInt(300);				
			}
		}		

		for(int i=0;i<texture.maplength-n;i=i+n)
		{
			for(int j=0;j<texture.mapwidth-n;j=j+n)
			{
				for(int k=1;k<=n-1;k++)
				{
				texture.mapmartix[i+k][j]=(int)((double)(texture.mapmartix[i][j])+(((double)(texture.mapmartix[i+n][j])-(double)(texture.mapmartix[i][j]))/n)*((double)(k)));

				}
			}
		}
		
		for(int j=0;j<texture.mapwidth-n;j=j+n)
		{
			for(int i=0;i<texture.maplength-n;i=i+n)
			{
				for(int k=1;k<=n-1;k++)
				{
					texture.mapmartix[i][j+k]=(int)((double)(texture.mapmartix[i][j])+(((double)(texture.mapmartix[i][j+n])-(double)(texture.mapmartix[i][j]))/n)*((double)(k)));
				}
			}
		}
		for(int i=0;i<texture.maplength-n;i=i+n)
		{
			for(int j=0;j<texture.mapwidth-n;j=j+n)
			{
				for(int p=1;p<=n-1;p++)
				{
				for(int k=1;k<=n-1;k++)
				{
					texture.mapmartix[i+p][j+k]=(int)((double)(texture.mapmartix[i+p][j])+(((double)(texture.mapmartix[i+p][j+n])-(double)(texture.mapmartix[i+p][j]))/n)*((double)(k)));
				}
				}
			}
		}
		for(int i=0;i<texture.maplength-n;i++)
		{
			for(int j=0;j<texture.mapwidth-n;j++)
			{
				if(texture.mapmartix[i][j]>150)
				{
					texture.mapmartix[i][j]=texture.landcolor;
				}
				else
				{
					texture.mapmartix[i][j]=0;
				}
			}
		}
		for(int i=0;i<1000;i++)
		{
			for(int j=0;j<1000;j++)
			{
				texture.mapmartix[i][j]=texture.landcolor;
			}
		}
        texture.map.saveMap();//leftpart+rightpart
	}
	
	public void shadegen()//generate landmarks
	{
		int count=0;//pixel sign that determines whether a 100*100 area is seashore or land 
		int isshade=0;//lankmark sign that determines whether the 100*100 area is a landmark
		int shadetext=0;//landmark sign that determines the type of landmark
		int mineralcount=0;//number of landmark "mineral" in left part
		int shipcount=0;//number of landmark "shipwreck" in left part
		
		for(int i=100;i<texture.maplength-100;i=i+100)//add landmarks in left part of the map
		{
			for(int j=100;j<texture.mapwidth-100;j=j+100)
			{
				if(texture.mapmartix[i][j]!=0)//if this pixel in map does represent water
				{                         
					for(int u=0;u<100;u++)
					{
						for(int v=0;v<100;v++)
						{
							if(texture.mapmartix[i+u][j+v]==0)
							{
								count=count+1;//count the number of water pixels in the surrounding area
							}
						}
					}
					if(count>=1000)// if the number of water pixels larger than 1000, 
					{              //consider it as a "seashore". "seashore" do not have landmarks
						
					}else
					{// if the number of water pixels smaller than 1000, consider it as land
						Random randn=new Random();
						isshade=randn.nextInt(15);//choose the value of this sign randomly from 0-10
						
							if(isshade<=1)//if this landmark sign equals to 0 and 1, then it is landmark
							{
							Random randn1=new Random();
							shadetext=randn1.nextInt(2)+311;//311:hills,312:mountains,313:mineral,314:weird structure,315:shipwreck
							texture.mapmartix[i][j]=shadetext;
							
							if(texture.mapmartix[i][j]==311&&count==0)// for "hill"
							{
						
							
								for(int u=0;u<100;u++)
								{
									for(int v=0;v<100;v++)
									{
										texture.terramartix[i+u][j+v]=311;
									}
								}
							
							
							}
							
							if(texture.mapmartix[i][j]==312&&count==0)//for "mountain"
							{
							
								for(int u=0;u<100;u++)
								{
									for(int v=0;v<100;v++)
									{
										texture.terramartix[i+u][j+v]=312;
									}
								}
							
							
							}
							}
															
							if(isshade>1&&isshade<=11)
							{		                      
								Random randn1=new Random();
								shadetext=randn1.nextInt(3)+313;
								int count21=0;
								
								for(int u=-100;u<100;u++)
								{
									for(int v=-100;v<100;v++)
									{
										if(texture.mapmartix[i+u][j+v]==texture.landcolor)
										{
											count21=count21+1;
										}
									}
								}
								
								if(shadetext==313&&count==0&&count21>=30000&&i>700&&j>700&&mineralcount<=20)//for "mineral"
								{// the max number of mineral in leftpart is 20	
									int num=0;								
									System.out.println("min");
									texture.mapmartix[i][j]=shadetext*10+num;
									for(int u=10;u<80;u++)
									{
										for(int v=10;v<80;v++)
										{
											texture.terramartix[i+u][j+v]=313*10+num;											
										}
									}
									num=num+1;
								
								mineralcount=mineralcount+1;//after deploy the landmark, mineral number add 1 
								}
																
								if(shadetext==315&&count==0&&count21>=30000&&shipcount<=6&&i>700&&j>700)//for "shipwreck"
								{
									int num=0;
										texture.mapmartix[i][j]=shadetext*10+num;
										System.out.println("asd");
										for(int u=10;u<80;u++)
										{
											for(int v=10;v<80;v++)
											{
												texture.terramartix[i+u][j+v]=315*10+num;
												
											}
										}										
									
									shipcount=shipcount+1;
									num=num+1;
								}								
								}	
							
							}
						}
				count=0;
					}	
				}
				
        objectdeploy(3000,100);
        objectdeploy(6000,100);
        objectdeploy(100,2000);
        objectdeploy(3000,2000);
        objectdeploy(6000,2000);
		
		//draw landing zone 
		for(int u=0;u<300;u++)
		{
			for(int v=0;v<100;v++)
			{
				texture.mapmartix[300+u][300+v]=texture.landcolor;
				texture.terramartix[300+u][300+v]=1;
				
			}
		}
		
		for(int u=-50;u<150;u++)
		{
			for(int v=-50;v<150;v++)//landing zone clearance. no landmarks near the landing zone
			{
				texture.terramartix[300+u][300+v]=100;
				
			}
		}
	}
	
	public void objectdeploy(int x,int y)
	{
		
		int shadetext=0;
		int strcount=0;
		for(int u=x;u<x+3000;u++)//target object
		{
			for(int v=y;v<y+2000;v++)
			{
				int n=1;
				Random randn1=new Random();
				shadetext=314;
				if(shadetext==314&&strcount<1)//for "weird structure"
				{//the max number of weird structure in left part is 2
					int num=0;
					
						texture.mapmartix[u][v]=shadetext*10+num;
						System.out.println(u);
						System.out.println(v);
						for(int k=10;k<80;k++)
						{
							for(int l=10;l<80;l++)
							{
								texture.terramartix[u+k][v+l]=314*10+num;
								
							}
						}
						
					
					strcount=strcount+1;
					num=num+1;
					n=n-1;
				}
				
			}
		}	
		System.out.println("ob");
	}
}
