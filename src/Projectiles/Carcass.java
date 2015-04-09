package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Square;

public class Carcass extends HeatedShot{

	static final int id = 2; 
	
	public Carcass(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	
		
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		
		//initializes shape with the proper one for Carcass
		shape = new Square();
		
		//computes the time
		int o = currentTime.getH();
		int m = currentTime.getM();
		int s = currentTime.getS();
		
		//computes the shapeChangingdist with the given formula
		shapeChangingDist = 42 + ( id * id * o + id * m + s) % 42;
		
		//checks whether the projectile is transformed before the collision 
		//with the screen or not 
		if ( shapeChangingDist > dist ){
			
			//translates the shooterPosition
			shooterPosition.set(0, dist);
			
			//computes the new dimensions
			int dref = -dist/10 - id;
			this.ref = this.ref + dref;
			
			hitScreenAction(shooterPosition,this.ref);
		}
		
		else { 
			
			//computes the new dimensions
			int dref = -shapeChangingDist/10 - id;
			this.ref = this.ref + dref;
			
			//translates the shooterposition only n the Y axis
			shooterPosition.set(0, shapeChangingDist);
			
			//the projectile is transformed in Shrapnel
			//the new distance becomes old distance - shapeChangingDist
			super.shoot(dist - shapeChangingDist, shooterPosition);
			}
		}

}
