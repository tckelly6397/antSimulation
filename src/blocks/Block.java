package blocks;

import java.awt.Color;

public abstract class Block<T> {
	private double weight;
	private int stackSize;
	private double strength; //Multiplier for how hard it is to break
	private Color c;
	private boolean transparent;
	private boolean canPickUp;
	private int id;
	private Spot spot;
	
	public Block(double weight, int stackSize, double strength, Color c, boolean transparent, boolean canPickUp, int id, Spot point) {
		super();
		this.weight = weight;
		this.stackSize = stackSize;
		this.strength = strength;
		this.c = c;
		this.transparent = transparent;
		this.canPickUp = canPickUp;
		this.id = id;
		this.spot = point;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getStackSize() {
		return stackSize;
	}

	public void setStackSize(int stackSize) {
		this.stackSize = stackSize;
	}

	public double getStrength() {
		return strength;
	}

	public void setStrength(double strength) {
		this.strength = strength;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public boolean isTransparent() {
		return transparent;
	}

	public void setTransparent(boolean transparent) {
		this.transparent = transparent;
	}

	public boolean isCanPickUp() {
		return canPickUp;
	}

	public void setCanPickUp(boolean canPickUp) {
		this.canPickUp = canPickUp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Spot getPoint() {
		return spot;
	}

	public void setPoint(Spot point) {
		this.spot = point;
	}

	@Override
	public String toString() {
		return "Block [weight=" + weight + ", stackSize=" + stackSize + ", strength=" + strength + ", c=" + c
				+ ", transparent=" + transparent + ", canPickUp=" + canPickUp + ", id=" + id + ", point=" + spot + "]";
	}
}
