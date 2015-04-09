package Shapes;

import Constants.Symbols;
import Screen.Screen;

/**
 * Class that defines the behaviour of a rhombus
 * This class extends basicShape
 */

public class Rhombus extends  BasicShape{


	private Point[] endPoints;
	private Point[] startPoints;
	
	public Rhombus(){
		endPoints = new Point[4];
		startPoints = new Point[4]; 
	}
	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		
		//computes the needed edges of the triangle
		startPoints[0] = centerGrav.translate(0, -2 * ref);
		endPoints[0] = centerGrav.translate(ref, 0);
		startPoints[1] = centerGrav.translate(ref, 0);
		endPoints[1] = centerGrav.translate(0, 2 * ref);
		startPoints[2] = centerGrav.translate(0, 2 * ref);
		endPoints[2] = centerGrav.translate(-ref, 0);
		startPoints[3] = centerGrav.translate(-ref, 0);
		endPoints[3] = centerGrav.translate(0, -2* ref);
		
		//calling the method drawMultipleLinesOnScreen from screen class 
		//in order to draw the lines between the edges
		screen.drawMultipleLinesOnScreen(startPoints, endPoints, Symbols.RHOMBUS_SYMBOL);
	}
	

}
