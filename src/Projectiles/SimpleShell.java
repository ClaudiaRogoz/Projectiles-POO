package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Dot;
import Shapes.Point;

public class SimpleShell extends Projectile{
	
	int id = 8;
	
	public SimpleShell(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		
	
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {
		
		//initializes the proper shape for SimpleShot
		shape = new Dot();
		
		//shapeChangingDist tends to infinity
		//in this case we give it the upper value for Integer type
		shapeChangingDist = Integer.MAX_VALUE;
		ref = ref - dist/10 - id;
		
		hitScreenAction(shooterPosition, ref);
	}



}
