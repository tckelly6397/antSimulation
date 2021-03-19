package blocks;

import java.awt.Color;

import utils.Spot;

public class DirtWall extends Block<Object> {
	private static int id = 2;
	
	public DirtWall(Spot spot) {
		super(5, 60, 5, new Color((int)(Math.random() * 30 + 225), (int)(Math.random() * 30 + 160), (int)(Math.random() * 115)), true, false, id, spot);
	}
	
	public DirtWall(double x, double y) {
		super(5, 60, 5, new Color((int)(Math.random() * 30 + 225), (int)(Math.random() * 30 + 160), (int)(Math.random() * 115)), true, false, id, new Spot(x, y));
	}
	
	public DirtWall() {
		super(5, 60, 5, new Color((int)(Math.random() * 30 + 90), (int)(Math.random() * 20 + 30), (int)(Math.random() * 0)), true, false, id, null);
	}
}
