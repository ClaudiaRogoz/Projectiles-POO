package Shapes;

import Constants.Symbols;
import Screen.Screen;

/**
 * Class that defines the behaviour of a square
 * This class extends basicShape
 */

public class Square extends BasicShape{


	private Point[] endPoints;
	private Point[] startPoints;
	
	public Square(){
		endPoints = new Point[4];
		startPoints = new Point[4]; 
	}
	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		
		//computes the needed edges of the triangle
		startPoints[0]= centerGrav.translate(ref, ref);
		endPoints[0] = centerGrav.translate(ref, -ref);
		startPoints[1] = centerGrav.translate(ref, -ref);
		endPoints[1] = centerGrav.translate(-ref, -ref);
		startPoints[2] = centerGrav.translate(-ref, -ref);
		endPoints[2] = centerGrav.translate(-ref, ref);
		startPoints[3] = centerGrav.translate(-ref, ref);
		endPoints[3] = centerGrav.translate(ref, ref);
		
		//calling the method drawMultipleLinesOnScreen from screen class 
		//in order to draw the lines between the edges
		screen.drawMultipleLinesOnScreen(startPoints, endPoints, Symbols.SQUARE_SYMBOL);
		
	}
	

}
