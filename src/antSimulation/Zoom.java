package antSimulation;

public class Zoom {
	private int x;
	private int y;
	private double aspect;
	
	public Zoom(int x, int y, double aspect) {
		super();
		this.x = x;
		this.y = y;
		this.aspect = aspect;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getAspect() {
		return aspect;
	}

	public void setAspect(double aspect) {
		this.aspect = aspect;
	}

	@Override
	public String toString() {
		return "Zoom [x=" + x + ", y=" + y + ", aspect=" + aspect + "]";
	}
}
