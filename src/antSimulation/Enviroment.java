package antSimulation;

import java.awt.Graphics;

import blocks.Air;
import blocks.Block;
import blocks.Dirt;

public class Enviroment {
	private int width;
	private int height;
	private int dirtHeight;
	private int wheatAmt;
	private int wheatGrow;
	private int dayLength;
	private Block<Object>[][] map; //Look at this warning
	
	@SuppressWarnings("unchecked") //May wanna change this
	public Enviroment(int width, int height, int dirtHeight, int wheatAmt, int wheatGrow, int dayLength) {
		super();
		this.width = width;
		this.height = height;
		this.dirtHeight = dirtHeight;
		this.wheatAmt = wheatAmt;
		this.wheatGrow = wheatGrow;
		this.dayLength = dayLength;
		this.map = new Block[width][height]; //Check this, may have to be height width		
		init();
	}
	
	/*Initialize the map*/
	public boolean init() {
		for(int j = 0; j < height; j++) {
			for(int i = 0; i < width; i++) {
				if(j < height - dirtHeight)
					map[i][j] = new Air(i, j);
				else
					map[i][j] = new Dirt(i, j);
			}
		}
		return true;
	}
	
	/*Draw the map from the map array*/
	public boolean draw(Graphics g, int worldWidth, Zoom zoomObj) {
		double spacing = (worldWidth * zoomObj.getAspect()) / map.length;
		
	    for(int i = 0; i < map.length; i++) {
	    	for(int j = 0; j < map[i].length; j++) {
	    		g.setColor(map[i][j].getC());
	    		
	    		int x = (int)(Math.ceil((i * spacing) - (zoomObj.getX() * zoomObj.getAspect()))); //I believe the x is off due to the (int) and math.ceil although can't really get rid of those
	    		int y = (int)(Math.ceil((j * spacing) - (zoomObj.getY() * zoomObj.getAspect()))); //Think about this later, for now congratulations on messing up one variable
	    		int size = (int)Math.ceil(spacing);
	    		g.fillRect(x, y, size, size);
	    		//g.setColor(Color.BLACK);
	    		//g.drawRect((int)(i * spacing), (int)(j * spacing), (int)spacing, (int)spacing);
	    		//System.out.println(map[i][j]);
	    	}
	    }
		return true;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDirtHeight() {
		return dirtHeight;
	}

	public void setDirtHeight(int dirtHeight) {
		this.dirtHeight = dirtHeight;
	}

	public int getWheatAmt() {
		return wheatAmt;
	}

	public void setWheatAmt(int wheatAmt) {
		this.wheatAmt = wheatAmt;
	}

	public int getWheatGrow() {
		return wheatGrow;
	}

	public void setWheatGrow(int wheatGrow) {
		this.wheatGrow = wheatGrow;
	}

	public int getDayLength() {
		return dayLength;
	}

	public void setDayLength(int dayLength) {
		this.dayLength = dayLength;
	}

	public Block<Object>[][] getMap() {
		return map;
	}

	public void setMap(Block<Object>[][] map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Enviroment [width=" + width + ", height=" + height + ", dirtHeight=" + dirtHeight + ", wheatAmt="
				+ wheatAmt + ", wheatGrow=" + wheatGrow + ", dayLength=" + dayLength + "]";
	}
}
