package utils;

import java.awt.Color;

public class KeyColor {
	private Color color;
	private double position; //0-1
	
	public KeyColor(Color color, double position) {
		super();
		this.color = color;
		this.position = position;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public double getPosition() {
		return position;
	}
	
	public void setPosition(double position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "KeyColor [color=" + color + ", position=" + position + "]";
	}
}
