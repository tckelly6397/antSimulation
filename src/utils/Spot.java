package utils;

public class Spot {
	private double x;
	private double y;
	
	public Spot(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public static double getDistance(Spot s1, Spot s2) {
		return Math.sqrt(Math.pow(s2.getX() - s1.getX(), 2) + Math.pow(s2.getY() - s1.getY(), 2));
	}
	
	public double getDistance(Spot s) {
		return Math.sqrt(Math.pow(s.getX() - x, 2) + Math.pow(s.getY() - y, 2));
	}
	
	public static double getAngle(Spot s1, Spot s2) {
		return Math.atan2((s2.getY() - s1.getY()), (s2.getX() - s1.getX()));
		
	}
	
	public double getAngle(Spot s) {
		return Math.atan2((s.getY() - y), (s.getX() - x));
	}
	
	public boolean setSpot(double x, double y) {
		this.x = x;
		this.y = y;
		
		return true;
	}
	
	public boolean setSpot(Spot s) {
		this.x = s.x;
		this.y = s.y;
		
		return true;
	}
	
	public int getXAsInt() {
		return (int)x;
	}
	
	public int getYAsInt() {
		return (int)y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Spot [x=" + x + ", y=" + y + "]";
	}
}
