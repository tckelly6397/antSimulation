package antSimulation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Initialize extends JPanel {
	private static final long serialVersionUID = 1L; //Why does it recommend this???  Search it up later Tom
	//private static mouseHandler mouseHandler;
	public static final int worldWidth = 1000;
	public static final int envWidth = 500; 
	public static final int envHeight = 300;
	public static final int WIDTH = 1200;
	public static final int HEIGHT = (int)(envHeight * (double)worldWidth / envWidth);
	public static int fps = 0;
	public static Enviroment world;
	private static Rect zoomBox;
	private static Zoom zoomObj;
	private static MouseHandler mouseHandler = new MouseHandler();
	
	public Initialize() {
		addMouseListener(mouseHandler);
		addMouseMotionListener(mouseHandler);
		
	}
	
	public void paintComponent(Graphics g) {
		world.draw(g, worldWidth, zoomObj);
		if(zoomBox != null)
			zoomBox.draw((Graphics2D) g);
	}
	
	public static void main(String[] args) {
		final int HEIGHT = (int)(envHeight * (double)worldWidth / envWidth);
		world = new Enviroment(envWidth, envHeight, 236, 5, 2, 24);
		zoomObj = new Zoom(0, 0, 1);
		
		JFrame frame = new JFrame("My first ant farm");
		Initialize init = new Initialize();
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
				Thread.sleep(1);
		    } catch (InterruptedException e) {
		    	
		    }
		}
    }
	
	public static void zoom(int x1, int y1, double x2, double y2) {
		zoomObj = new Zoom(x1, y1, (worldWidth * zoomObj.getAspect()) / (x2 - x1));
		//System.out.println(zoomObj);
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
