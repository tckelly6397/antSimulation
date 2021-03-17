package utils;

import java.awt.Color;

public class Star {
	private Color color;
	private double x;
	private double y;
	
	public Star(double x, double y, Color color) {
		super();
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
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
		return "Star [x=" + x + ", y=" + y + "]";
	}
}
