package Shapes;

import Constants.Symbols;
import Screen.Screen;

/**
 * Class that defines the behaviour of a rectangle
 * This class extends basicShape
 */
public class Rectangle extends BasicShape{

	private Point[] endPoints;
	private Point[] startPoints;
	
	public Rectangle(){
		endPoints = new Point[4];
		startPoints = new Point[4];
	}
	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		
		//computes the needed edges of the triangle
		startPoints[0]= centerGrav.translate(2*ref, ref);
		endPoints[0] = centerGrav.translate(-2*ref, ref);
		startPoints[1] = centerGrav.translate(-2*ref, ref);
		endPoints[1] = centerGrav.translate(-2 *ref, - ref);
		startPoints[2] = centerGrav.translate(- 2* ref, -ref);
		endPoints[2] = centerGrav.translate(2*ref, -ref);
		startPoints[3] = centerGrav.translate(2 *ref, -ref);
		endPoints[3] = centerGrav.translate(2* ref, ref);
		
		//calling the method drawMultipleLinesOnScreen from screen class 
		//in order to draw the lines between the edges
		screen.drawMultipleLinesOnScreen(startPoints, endPoints, Symbols.RECTANGLE_SYMBOL);
		
	}

}
