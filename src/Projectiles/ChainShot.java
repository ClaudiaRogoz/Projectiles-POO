package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Triangle;

public class ChainShot extends Shrapnel{

	static final int id = 4;
	
	public ChainShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		
		//initializes the proper shape fro ChainShot
		shape = new Triangle();
		
		//computes the time
		int o = currentTime.getH();
		int m = currentTime.getM();
		int s = currentTime.getS();
		
		//computes the shapeChangingdist with the given formula
		shapeChangingDist = 42 + ( id * id * o + id * m + s) % 42;
		
		//checks whether the projectile is transformed before the collision 
		//with the screen or not 
		if ( shapeChangingDist > dist ){

			//translates shooterPosition on the Y axis
			shooterPosition.set(0, -dist);
			
			//computes the new dimensions
			int dref = -dist/10 - id;
			this.ref = this.ref + dref;
			
			hitScreenAction(shooterPosition,ref);
		}
		
		else{ 
			
			//computes the new dimensions
			int dref = -shapeChangingDist/10 - id;
			this.ref = this.ref + dref;
			
			//shooterPosition is translated on the Y axis
			shooterPosition.set(0, -shapeChangingDist);
			
			//the projectile is transformed in Shrapnel
			//the new distance becomes old distance - shapeChangingDist
			super.shoot(dist - shapeChangingDist, shooterPosition);
			}
		}
	}

