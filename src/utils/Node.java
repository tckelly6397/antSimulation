package utils;

public class Node {
	private double hCost;
	private double gCost;
	private double x;
	private double y;
	private int index;
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
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public int compareTo(Node parent) {
		int compare = Integer.valueOf((int)this.getCost()).compareTo(Integer.valueOf((int)parent.getCost()));//.compareTo(parent.getCost());
		if(compare == 0) {
			compare = Integer.valueOf((int)hCost).compareTo(Integer.valueOf((int)parent.getHCost()));
		}
		return -1 * compare;
	}

	@Override
	public String toString() {
		return "Node [cost=" + (gCost + hCost) + ", canWalk=" + canWalk + "]";
	}
}
