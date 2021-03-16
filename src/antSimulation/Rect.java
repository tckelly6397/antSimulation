package antSimulation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Rect {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private boolean dashed;
	private boolean filled;
	private Color color;
	
	public Rect(int x1, int y1, int x2, int y2, boolean dashed, boolean filled, Color color) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.dashed = dashed;
		this.filled = filled;
		this.color = color;
	}
	
	public boolean draw(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
		g2d.setColor(color);
		int[] xs = {x1, x1, x2, x2};
		int[] ys = {y1, y2, y2, y1};
		g2d.drawPolygon(xs, ys, 4);
		
		g2d.dispose();
		return true;
	}
	
	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public boolean isDashed() {
		return dashed;
	}

	public void setDashed(boolean dashed) {
		this.dashed = dashed;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
