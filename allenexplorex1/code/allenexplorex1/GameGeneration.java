package allenexplorex1;

import java.io.File;
import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Random;

public class GameGeneration {

	UIgame gameui=new UIgame(); //call class "GameGeneration"

  boolean completesign=false; //sign of map generation process. 0 represents non-complete while 1 represents complete
	public void newGameGeneration() throws IOException
	{
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
//    	Date now=new Date(); //get current time

//     	texture.fileName="save/save_"+dateFormat.format(now); //generate the name of save data, mainly for save the map
  	texture.fileName="save/hardcoded";
  	File folder=new File(texture.fileName);
   	folder.mkdir();

    for(int i=0;i<3000;i++)
    {
      for(int j=0;j<1800;j++)
      {
        texture.mapmatrix[i][j]=0; //initiate map matrix
        texture.terramatrix[i][j]=0;// initiate landmark matrix
      }
    }

    maptype(); //randomly choose map type, originally considered several types, but do not have to consider for now
    terriantype();//randomly choose terrain type (desert, ice, etc.)
    mapgen();//generate map
    completesign = true; //map generation completed
    gameui.drawmap();//load map to base container

	}

	public void maptype()
	{
//		Random randn=new Random(); //random number generation
//		texture.mtype=randn.nextInt(1)+1;//choose maptype
		texture.mtype=1;
	}

	public void terriantype()
	{
		Random randn=new Random();//random number generation
		texture.ttype=randn.nextInt(1)+1;//choose terrain type
	}

	public void mapgen() throws IOException
	{
		//1:continent;2:island;3:ancient continent;4:mediterranean
		//1:grassland&plain;2:forest&jungle;3:desert;4:stone;5:snow&tundra;6:radiation

		Continentgen cont=new Continentgen();//call class "Continentgen"
		cont.generate(texture.mtype, texture.ttype);//call the function for generating map
		cont.shadegen();//call the function for generating landmarks

	}



}
