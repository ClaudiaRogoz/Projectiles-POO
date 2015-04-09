package Projectiles;
import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rectangle;

public class SpiderShot extends SimpleShell{

	int id = 7;
	
	public SpiderShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		
		//initializes the proper shape for SpiderShot
		shape = new Rectangle();
		
		//computes the time
		int o = currentTime.getH();
		int m = currentTime.getM();
		int s = currentTime.getS();
		
		//computing the shapeChangingDist with the given formula
		shapeChangingDist = 42 + ( id * id * o + id * m + s) % 42;
		
		//checks whether the projectile is transformed before the collision 
		//with the screen or not 
		if ( shapeChangingDist > dist ){
			
			//shooterPosition is translated with dx and dy
			int dx = (int) Math.round(Math.sin(dist * Math.PI /2));
			int dy = (int) Math.round(Math.cos(dist * Math.PI /2));
			shooterPosition.set(dx, dy);
			
			//computing the new dimensions
			int dref = -dist/10 - id;
			this.ref = this.ref + dref;
			
			hitScreenAction(shooterPosition,this.ref);
		}
		
		else {
			//shooterPosition is translated with dx and dy
			int dx = (int) Math.round(Math.sin(shapeChangingDist * Math.PI /2));
			int dy = (int) Math.round(Math.cos(shapeChangingDist* Math.PI /2));
			shooterPosition.set(dx, dy);
			
			//computing the new dimensions
			int dref = -shapeChangingDist/10 - id;
			this.ref = this.ref + dref;
			
			//the projectile is transformed in SimpleShell
			//the new distance becomes old distance - shapeChangingDist
			super.shoot(dist - shapeChangingDist, shooterPosition);
			}
		
	}




}
