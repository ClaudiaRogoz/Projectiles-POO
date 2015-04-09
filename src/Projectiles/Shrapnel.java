package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Square;

public class Shrapnel extends SpiderShot{

	static final int id = 5; 
	
	public Shrapnel(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		
		//initializes the proper shape for Shrapnel
		shape = new Square();
		
		//computes the current time
		int o = currentTime.getH();
		int m = currentTime.getM();
		int s = currentTime.getS();

		//computes the shapeChangingDist with the given formula
		shapeChangingDist = 42 + ( id * id * o + id * m + s) % 42;

		//checks whether the projectile is transformed before the collision 
		//with the screen or not 
		if ( shapeChangingDist > dist ){
	
			//shooterposition is translated with dx only
			//on the X axis
			int dx = (int) Math.round(Math.sin(dist * Math.PI /2));
			shooterPosition.set(dx, 0);
			
			//computes the new dimensions
			int dref = -dist/10 - id;
			this.ref = this.ref + dref;
			
			hitScreenAction(shooterPosition,ref);
		}
		
		else {
			
			//shooterposition is translated with dx only
			//on the X axis
			int dx = (int) Math.round(Math.sin(shapeChangingDist * Math.PI /2));
			int dref = -shapeChangingDist/10 - id;
			
			//computes the new dimensions
			this.ref = this.ref + dref;
			shooterPosition.set(dx, 0);
			
			//the projectile is transformed in SpiderShot
			//the new distance becomes old distance - shapeChangingDist
			super.shoot(dist - shapeChangingDist, shooterPosition);
			}
	}

}
