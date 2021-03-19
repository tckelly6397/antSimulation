package utils;

public class Node {
	private double hCost;
	private double gCost;
	private double x;
	private double y;
	private boolean canWalk;
	private Node parent;
	
	public Node(double x, double y, boolean canWalk) {
		super();
		this.x = x;
		this.y = y;
		this.canWalk = canWalk;
	}

	public double getCost() {
		return hCost + gCost;
	}
	
	public double getHCost() {
		return hCost;
	}

	public void setHCost(double hCost) {
		this.hCost = hCost;
	}

	public double getGCost() {
		return gCost;
	}

	public void setGCost(double gCost) {
		this.gCost = gCost;
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

	public boolean isCanWalk() {
		return canWalk;
	}

	public void setCanWalk(boolean canWalk) {
		this.canWalk = canWalk;
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Node [cost=" + (gCost + hCost) + ", canWalk=" + canWalk + "]";
	}
}
