package antSimulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Supplier;

import javax.swing.JFrame;
import javax.swing.JPanel;

import blocks.Block;
import state.TestState;
import utils.Brush;
import utils.GradientBar;
import utils.MouseHandler;
import utils.Node;
import utils.Rect;
import utils.Spot;
import utils.Zoom;

public class Initialize extends JPanel {
	private static final long serialVersionUID = 1L; //Why does it recommend this???  Search it up later Tom
	private static JFrame frame;
	public static final int envWidth = 500; 
	public static final int envHeight = 300;
	public static final int WIDTH = 1200;
	public static final int worldWidth = 1000;
	public static final int HEIGHT = (int)(envHeight * (double)worldWidth / envWidth);
	public static int fps = 0;
	public static Enviroment world;
	private static Rect zoomBox;
	private static Zoom zoomObj;
	private static MouseHandler mouseHandler = new MouseHandler();
	private static Brush brush;
	public static TestState ts;
	public static ArrayList<Node> path = new ArrayList<>();
	
	public Initialize() {
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
		
	}
	
	public void paintComponent(Graphics g) {
		world.draw(g, worldWidth, zoomObj);
		if(zoomBox != null)
			zoomBox.draw((Graphics2D) g);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(worldWidth, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.GREEN);
		double spacing = worldWidth / (world.getMap().length * 2);
		
		if(path != null)
		for(Node n : path)
			g.fillRect((int)(n.getX() / spacing * zoomObj.getAspect()) - (int)(zoomObj.getX() * zoomObj.getAspect()), (int)(n.getY() / spacing * zoomObj.getAspect()) - (int)(zoomObj.getY() * zoomObj.getAspect()), (int)(spacing * zoomObj.getAspect()), (int)(spacing * zoomObj.getAspect()));
		
	}
	
	public static void main(String[] args) {
		final int HEIGHT = (int)(envHeight * (double)worldWidth / envWidth);
		Initialize init = new Initialize();
		
		world = new Enviroment(envWidth, envHeight, 236, 5, 2, 24, 500);
		world.createStars(worldWidth);
		
		zoomObj = new Zoom(0, 0, 1);
		brush = new Brush(5, false);
		
		frame = new JFrame("My first ant farm");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(WIDTH + 16, HEIGHT + 39);
	    frame.setVisible(true);
	    frame.setFocusable(true);
	    frame.requestFocusInWindow();
	    frame.add(init);
	    frame.setBackground(new Color(50, 50, 50));    
	    frame.addKeyListener(mouseHandler);
	    
	    runAnimation(frame);
	}
	
	public static void runAnimation(JFrame frame) {
		double timeSpeed = 100;
		double dt = 0;
	    int frames = 0;
	    long totalTime = 0;
	    long curTime = System.currentTimeMillis();
	    long lastTime = curTime;
	    while (true) {
		    try {
		    	frame.repaint();
				// Calculations for FPS.
				lastTime = curTime;
				curTime = System.currentTimeMillis();
				totalTime += curTime - lastTime;
				//double time = curTime - lastTime;
				if (totalTime > 1000) {
					totalTime -= 1000;
					fps = frames;
					frames = 0;
				}
				frames++;
				
				if(ts != null) {
					long firstTime = System.currentTimeMillis();
					path = ts.getPath();
					System.out.println("Operation took " + ((double)(System.currentTimeMillis() - firstTime) / 1000) + " seconds.");
					ts = null;
				}
				
				//Sky stuff
				GradientBar gb = new GradientBar(new Color(218, 59, 58), new Color(218, 59, 58));
			    gb.addKey(new Color(229, 128, 65), 0.00);
			    gb.addKey(new Color(108, 167, 255), 0.03);
			    gb.addKey(new Color(166, 225, 230), 0.05);
			    gb.addKey(new Color(200, 245, 255), 0.25);
			    gb.addKey(new Color(166, 225, 230), 0.45);
			    gb.addKey(new Color(108, 167, 255), 0.47);
			    gb.addKey(new Color(229, 128, 65), 0.49);
			    gb.addKey(new Color(25, 5, 28), 0.5);
			    gb.addKey(new Color(5, 0, 8), 0.725);
			    gb.addKey(new Color(25, 5, 28), 0.95);
			    gb.addKey(new Color(229, 128, 65), 1);
			    
			    frame.setBackground(gb.getColor(dt / (world.getDayLength() * timeSpeed)));
			    world.setTimeAspect(dt / (world.getDayLength() * timeSpeed));
			    dt++;
			    if(dt >= world.getDayLength() * timeSpeed)
			    	dt = 0;
			    
				Thread.sleep(1);
		    } catch (InterruptedException e) {
		    	
		    }
		}
    }
	
	public static boolean drawBlocks(int x, int y, int radius, Supplier<Block<?>> s, boolean walk) {
		if(s.get() instanceof Block<?>) {
			Block<Object>[][] map = world.getMap();
			double spacing = (worldWidth * zoomObj.getAspect()) / world.getMap().length;
			
			int i = (int) ((int)(Math.ceil(x / spacing)) + (zoomObj.getX() * zoomObj.getAspect() / spacing));
			int j = (int) ((int)(Math.ceil(y / spacing)) + (zoomObj.getY() * zoomObj.getAspect() / spacing));
			
			for(int[] coords : brush.getActions()) {
				@SuppressWarnings("unchecked")
				Block<Object> block = (Block<Object>) s.get();
				int newi = i + coords[0];
				int newj = j + coords[1];
				
				block.setPoint(new Spot(newi, newj));
				
				if(newi < world.getWidth() && newi >= 0 && newj >= 0 && newj < world.getHeight() && map[newi][newj].isTransparent() == !walk)
					map[newi][newj] = block;
			}
			
			world.setMap(map);
		}
		
		return false;
	}
	
	public static void zoom(int x1, int y1, double x2, double y2) {
		zoomObj = new Zoom(x1, y1, (worldWidth * zoomObj.getAspect()) / (x2 - x1));
	}
	
	public static void zoomOut() {
		zoomObj = new Zoom(0, 0, 1);
	}
	
	public static void zoomRect(double x1, double y1, double x2, double y2) {
		final double ASPECT = (double)HEIGHT / worldWidth;
		zoomBox = new Rect((int)x1, (int)y1, (int)x2, (int)(y1 + (Math.abs(x2 - x1) * ASPECT)), true, false, Color.BLACK); 
	}
	
	public static void resetZoomRect() {
		zoomBox = null;
	}
}
