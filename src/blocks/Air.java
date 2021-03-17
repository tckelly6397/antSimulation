package blocks;

import java.awt.Color;

import utils.Spot;

public class Air extends Block<Object> {
	private static int id = 0;
	
	public Air(Spot spot) {
		super(5, 60, 5, new Color(255, 100, 0, 0), false, true, id, spot);
	}
	
	public Air(double x, double y) {
		super(0, 0, 0, new Color(0, 230, 230, 0), true, false, id, new Spot(x, y));
	}
	
	public Air() {
		super(0, 0, 0, new Color(0, 230, 230, 0), true, false, id, null);
	}
	
	
}
