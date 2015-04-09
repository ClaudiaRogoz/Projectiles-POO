package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rectangle;

public class CanisterShot extends HeatedShot{

	static int id = 3; 

	
	public CanisterShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		
		//initiallizes the proper shape for CanisterShot
		shape = new Rectangle();
		
		//computes the time
		int o = currentTime.getH();
		int m = currentTime.getM();
		int s = currentTime.getS();
		
		//computes the shappeChangingDist with ethe given formula
		shapeChangingDist = 42 + ( id * id * o + id * m + s) % 42;
		
		//checks whether the projectile is transformed before the collision 
		//with the screen or not 
		if ( shapeChangingDist > dist ){
			
			//translates shooterPosition on the X axis
			shooterPosition.set(-dist, 0);
			
			//computes the new dimensions
			int dref = -dist/10 - id;
			this.ref = this.ref + dref;
			
			hitScreenAction(shooterPosition,this.ref);
		}
		
		else {
			
			//computes the new dimensions
			int dref = -shapeChangingDist/10 - id;
			this.ref = this.ref + dref;
			
			//computes the shooterPosition on the X axis
			shooterPosition.set(-shapeChangingDist, 0);
			
			//the projectile is transformed in HeatedShot
			//the new distance becomes old distance - shapeChangingDist
			super.shoot(dist - shapeChangingDist, shooterPosition);
		}}


}
