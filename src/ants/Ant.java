package ants;

import java.awt.Color;
import java.util.ArrayList;

import state.State;

public abstract class Ant<T> {
	private ArrayList<State<Object>> states;
	private double size;
	private double speed;
	private double x;
	private double y;
	private Color color;
	
	public Ant(State<Object> state, double size, double speed, double x, double y, Color color) {
		super();
		this.states.add(state);
		this.size = size;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public ArrayList<State<Object>> getStates() {
		return states;
	}
	
	public void setState(ArrayList<State<Object>> states) {
		this.states = states;
	}
	
	public State<Object> getCurrentState() {
		return states.get(0);
	}
	
	public boolean addState(State<Object> state) {
		this.states.add(state);
		return true;
	}
	
	public boolean addState(State<Object> state, int index) {
		this.states.add(index, state);
		return true;
	}
	
	public boolean removeCurrent() {
		this.states.remove(0);
		return true;
	}
	
	public boolean removeState(State<Object> state) {
		if(this.states.get(this.states.indexOf(state)) == null) return false;
		
		this.states.remove(state);
		return true;
	}
	
	public boolean removeStateAtIndex(int index) {
		if(this.states.get(index) == null) return false;
		
		this.states.remove(index);
		return true;
	}
	
	public double getSize() {
		return size;
	}
	
	public void setSize(double size) {
		this.size = size;
	}
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
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

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
