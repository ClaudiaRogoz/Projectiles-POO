package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Triangle;

public class TriGrapeShot extends Shrapnel{
	
	static final int id = 1;
	
	public TriGrapeShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		//initializes the proper shape for TriGrapeShoot
		shape = new Triangle(); 
		
		//computes the time
		int o = currentTime.getH();
		int m = currentTime.getM();
		int s = currentTime.getS();
		
		//computing the distance with the given formula
		shapeChangingDist = 42 + ( id * id * o + id * m + s) % 42;
	
		//checks whether the projectile is transformed before the collision 
		//with the screen or not 
		if ( shapeChangingDist > dist ){
		
			//the shooterPosition is translated 
			//only on the X axis with dist
			shooterPosition.set(dist, 0);
			
			//computing the new dimensions 
			int dref = -dist/10 - id;
			ref = ref + dref;
			
			hitScreenAction(shooterPosition,ref);
		}
		
		else {
			
			//computing the new dimensions
			int dref = -shapeChangingDist/10 - id;
			ref = ref + dref;
			
			//shooterPosition is translated
			//only on X axis with shapeChangingDist
			shooterPosition.set(shapeChangingDist, 0);
			
			//the projectile is transformed in Shrapnel
			//the new distance becomes old distance - shapeChangingDist
			super.shoot(dist - shapeChangingDist, shooterPosition);
		}
	}


}
