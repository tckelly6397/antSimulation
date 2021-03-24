package state;

import java.util.ArrayList;

import utils.Spot;

public class TestState extends State<Object> {
	private double x1, y1, x2, y2;

	public TestState(double x1, double y1, double x2, double y2) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public ArrayList<Spot> getPath() {
		return findPath(x1, y1, x2, y2);
	}

}
