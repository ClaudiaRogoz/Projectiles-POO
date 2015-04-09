package Shapes;

import Constants.Symbols;
import Screen.Screen;

/**
 * Class that defines the behaviour of a dot
 * This class extends basicShape
 */

public class Dot extends BasicShape{

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {
		
		//draws the dot on the screen
		screen.drawLineOnScreen(centerGrav, centerGrav , Symbols.DOT_SYMBOL);
		
	}
	

}
