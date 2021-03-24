package state;

import java.util.ArrayList;

import pathFinding.Pathfinder;
import utils.Spot;

public abstract class State<T> {
	
	public ArrayList<Spot> findPath(double x1, double y1, double x2, double y2) {
		return Pathfinder.pathFind(x1, y1, x2, y2);
	}
	
	public ArrayList<Spot> findPath(Spot begin, Spot end) {
		return Pathfinder.pathFind(begin.getX(), begin.getY(), end.getX(), end.getY());
	}
}
