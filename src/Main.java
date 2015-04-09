import java.util.StringTokenizer;

import Constants.ProjectileNames;
import ProcessingManagers.TimeManager;
import Projectiles.CanisterShot;
import Projectiles.Carcass;
import Projectiles.ChainShot;
import Projectiles.HeatedShot;
import Projectiles.Projectile;
import Projectiles.Shrapnel;
import Projectiles.SimpleShell;
import Projectiles.SpiderShot;
import Projectiles.TriGrapeShot;
import Screen.Screen;
import Shapes.Point;


/**
 * @author      Claudia Rogoz 321Ca
 * 
 */

/**
 * 
 * This execution entry point class handles the parsing and the initializations.
 */

public class Main {
	
	/*
	 *Initializes the proper class given the needed parameters 
	 * This method makes use of ProjectileNames class
	 * 
	 * @param p The Projectile to be initialized
	 * @param screen The screen where projectiles collide
	 * @param ref Initial dimensions of the projectile
	 * @param time When the projectile is shot
	 * @param point the initial center of gravity
	 * @param dist Distance to the screen  
	 */
	static void init(Projectile p, String projectile, Screen screen, int ref, TimeManager time,Point point, int dist ){
		if (projectile.equals(ProjectileNames.SIMPLE_SHELL))
				p = new SimpleShell(screen, ref, time);
		else if (projectile.equals(ProjectileNames.SPIDER_SHOT))
				p = new SpiderShot(screen, ref, time);
		else if (projectile.equals(ProjectileNames.HEATED_SHOT))
				p = new HeatedShot(screen, ref, time);
		else if (projectile.equals(ProjectileNames.CANNISTER_SHOT))
				p = new CanisterShot(screen, ref, time);
		else if (projectile.equals(ProjectileNames.CARCASS)) 
				p = new Carcass(screen, ref, time);
		else if (projectile.equals(ProjectileNames.CHAIN_SHOT))
				p = new ChainShot(screen, ref, time);
		else if (projectile.equals(ProjectileNames.SHRAPNEL))
				p = new Shrapnel(screen, ref, time);
		else  if (projectile.equals(ProjectileNames.TRI_GRAPE_SHOT))
				p = new TriGrapeShot(screen, ref, time);
		
		
		//after the initialization, method "shoot" is called
		p.shoot(dist, point);
		
		
	}

	public static void main(String[] args)  {
		
		//The string is obtained by Th eFileParser class
		FileParser f = new FileParser(args[0]);
		String str = f.getStr();
		
		int eX, eY,N, ref, posX, posY, h, m, s, dist;
		String proiectil;
	
		//Making use of the StringTokenizerll the needed info
		//all the needed info is beeing computed
		StringTokenizer st = new StringTokenizer(str,"\n");	
		eX = Integer.parseInt(st.nextToken(" "));
		eY = Integer.parseInt(st.nextToken("\n").substring(1));
		N = Integer.parseInt(st.nextToken("\n"));
		
		//initializes the screen where the projectiles collide
		Screen screen = new Screen(eX,eY);
		int i = 0;
		
		//the computation is repeated for 'N' times
		while (i < N){
			String[] row = st.nextToken("\n").split(" ");
			proiectil = row[0];
			ref = Integer.parseInt(row[1]);
			String[] row1 = row[2].split(":");
			h = Integer.parseInt(row1[0]);
			m = Integer.parseInt(row1[1]);
			s = Integer.parseInt(row1[2]);
			dist = Integer.parseInt(row[3]);
			posX = Integer.parseInt(row[4]);
			posY = Integer.parseInt(row[5]);
			Projectile pr = null;
			init(pr, proiectil, screen, ref, new TimeManager(h, m, s),new Point(posX, posY),dist);
			i++;
		}
		
		//writing the matrix to the file_out
		FileWriterMatrix fW = new FileWriterMatrix(screen.getMatrix(), args[0]);
		}
		
	}

