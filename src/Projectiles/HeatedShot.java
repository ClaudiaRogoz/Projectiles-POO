package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rhombus;

public class HeatedShot extends SpiderShot{
	
	static final int id = 6; 
	
	public HeatedShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		
		//initializes the proper shape for HeatedShot
		shape = new Rhombus();
		
		//computes the time
		int o = currentTime.getH();
		int m = currentTime.getM();
		int s = currentTime.getS();
		
		//computes the shapeChangingDist with the given formula
		shapeChangingDist = 42 + ( id * id * o + id * m + s) % 42;
		
		//checks whether the projectile is transformed before the collision 
		//with the screen or not 
		if ( shapeChangingDist > dist ){
			
			//translates the shooterPosition with dy only on the Y axis
			int dy = (int) Math.round(Math.cos(dist * Math.PI /2));
			shooterPosition.set(0, dy);
			
			//computes the new dimensions
			int dref = -dist/10 - id;
			this.ref = this.ref + dref;
			
			hitScreenAction(shooterPosition,ref);
		}
		
		else {
			
			//translates the shooterPosition with dy only on the Y axis
			int dy = (int) Math.round(Math.cos(shapeChangingDist * Math.PI /2));
			shooterPosition.set(0, dy);
			
			//computes the new dimensions
			int dref = -shapeChangingDist/10 - id;
			this.ref = this.ref + dref;
			
			//the projectile is transformed in SpiderShot
			//the new distance becomes old distance - shapeChangingDist
			super.shoot(dist - shapeChangingDist, shooterPosition);
			}
		}
	}


