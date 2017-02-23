package allenexplorex1;

import java.util.Random;

public class Continentgen {
	//0=water, 1=grass, 2=sand,
	
	
	
	
	public void generate(int mtype, int ttype)
	{
		switch (mtype){
			case 1: //continent
				for (int i=0; i<3000; ++i){
					for (int j=0; j<1800; ++j){
						texture.mapmatrix[i][j] = 1;
					}
				}
				break;
			case 2: //island
				for (int i=0; i<3000; ++i){
					for (int j=0; j<1800; ++j){
						if (i>20 && j<1770 && i*j > 10000){
							Random randn=new Random(); //random number generation
							if (randn.nextInt() < 5)
								texture.mapmatrix[i][j] = 1;
							else
								texture.mapmatrix[i][j] = 0;
						}
						else
							texture.mapmatrix[i][j] = 0;
					}
				}
				break;
			case 3: //ancient continent
				for (int i=0; i<3000; ++i){
					for (int j=0; j<1800; ++j){
						texture.mapmatrix[i][j] = 2;
					}
				}
				break;
			default: //mediterranean
				for (int i=0; i<3000; ++i){
					for (int j=0; j<1800; ++j){
						if (i>300 && j<1700 && i*j > 10000)
							texture.mapmatrix[i][j] = 0;
						else
							texture.mapmatrix[i][j] = 1;
					}
				}
				break;
		}
		switch (ttype){
			case 1: //grassland & plain
				break;
			case 2: //forest & jungle
				break;
			case 3: // desert
				break;
			case 4: //stone
				break;
			case 5: //snow&tundra
				break;
			default: //radiation
				break;
		}
	}
	
	public void shadegen()
	{
		
	}
}
