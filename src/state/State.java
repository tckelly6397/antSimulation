package state;

import java.util.ArrayList;
import java.util.Collections;

import antSimulation.Initialize;
import blocks.Block;
import utils.Node;

public abstract class State<T> {
	
	public static boolean isWalkable(double x, double y) {
		Block<Object>[][] map = Initialize.world.getMap();
		double spacing = Initialize.worldWidth / map.length;
		if(!map[(int)(x / spacing)][(int)(y / spacing)].isTransparent())
			return false;
		
		return true;
	}
	
	public static Node[][] createNodeGrid(int sizeX, int sizeY, double spacing) {
		Node[][] nodes = new Node[sizeX][sizeY];
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes[0].length; j++) {
				double x = i * spacing;
				double y = j * spacing;
				nodes[i][j] = new Node(x, y, isWalkable(x, y));
			}
		}
		
		return nodes;
	}
	
	public static ArrayList<Node> getNeighbours(Node node, Node[][] nodes, double spacing) {
		ArrayList<Node> neighbours = new ArrayList<>();
		
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(i == 0 && j == 0)
					continue;
				
				int checkX = (int)(node.getX() / spacing) + i;
				int checkY = (int)(node.getY() / spacing) + j;
				
				if(checkX >= 0 && checkX < nodes.length && checkY >= 0 && checkY < nodes[0].length)
					neighbours.add(nodes[checkX][checkY]);
			}
		}
		
		return neighbours;
	}
	
	//added spacing for peace of mind
	public static int getDistance(Node a, Node b, double spacing) {
		int distX = (int)Math.abs((a.getX() / spacing) - (b.getX() / spacing));
		int distY = (int)Math.abs((a.getY() / spacing) - (b.getY() / spacing));
		
		if(distX > distY)
			return 14 * distY + 10 * (distX - distY);
		
		return 14 * distX + 10 * (distY - distX);
	}
	
	public static ArrayList<Node> retracePath(Node startNode, Node endNode) {
		ArrayList<Node> path = new ArrayList<>();
		Node currentNode = endNode;
		
		while(currentNode != startNode) {
			path.add(currentNode);
			currentNode = currentNode.getParent();
		}
		
		Collections.reverse(path);
		
		return path;
	}
	
	public static ArrayList<Node> pathFind(double x1, double y1, double x2, double y2) {
		//ArrayList<Node> path = new ArrayList<>();
		ArrayList<Node> open = new ArrayList<>();
		ArrayList<Node> closed = new ArrayList<>();
		Block<Object>[][] map = Initialize.world.getMap();
		
		int width = Initialize.worldWidth;
		double spacing = width / (map.length);
		Node[][] nodes = createNodeGrid(map.length, map[0].length, spacing);
		
		int pos1X = (int)(x1 / spacing);
		int pos1Y = (int)(y1 / spacing);
		int pos2X = (int)(x2 / spacing);
		int pos2Y = (int)(y2 / spacing);
		
		Node startNode = nodes[pos1X][pos1Y];
		Node targetNode = nodes[pos2X][pos2Y];
		open.add(startNode);
		
		while(open.size() > 0) {
			Node currentNode = open.get(0);
			for(int i = 1; i < open.size(); i++) {
				if(open.get(i).getCost() < currentNode.getCost() || open.get(i).getCost() == currentNode.getCost() && open.get(i).getHCost() < currentNode.getHCost())
					currentNode = open.get(i);
			}
			
			open.remove(currentNode);
			closed.add(currentNode);
			
			if(currentNode == targetNode) {
				return retracePath(startNode, targetNode);
			}
			
			for(Node neighbor : getNeighbours(currentNode, nodes, spacing)) {
				if(!neighbor.isCanWalk() || closed.contains(neighbor)) 
					continue;
				
				int newMoveCostToNeighbor = (int)currentNode.getGCost() + getDistance(currentNode, neighbor, spacing);
				if(newMoveCostToNeighbor < neighbor.getGCost() || !open.contains(neighbor)) {
					neighbor.setGCost(newMoveCostToNeighbor);
					neighbor.setHCost(getDistance(neighbor, targetNode, spacing));
					neighbor.setParent(currentNode);
					
					if(!open.contains(neighbor))
						open.add(neighbor);
				}
			}
		}
		
		return null;
	}
	
}
