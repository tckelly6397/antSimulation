package blocks;

import java.awt.Color;

public class Dirt extends Block<Object> {
	private static int id = 1;
	
	public Dirt(Spot spot) {
		super(5, 60, 5, new Color((int)(Math.random() * 30 + 135), (int)(Math.random() * 30 + 40), (int)(Math.random() * 30)), false, true, id, spot);
	}
	
	public Dirt(double x, double y) {
		super(5, 60, 5, new Color((int)(Math.random() * 30 + 135), (int)(Math.random() * 30 + 40), (int)(Math.random() * 30)), false, true, id, new Spot(x, y));
	}
}
