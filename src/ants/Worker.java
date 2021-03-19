package ants;

import java.awt.Color;

import state.State;

public abstract class Worker<T> extends Ant<Object> {

	public Worker(State<Object> state, double size, double speed, double x, double y, Color color) {
		super(state, size, speed, x, y, color);
		// TODO Auto-generated constructor stub
	}
	
}
