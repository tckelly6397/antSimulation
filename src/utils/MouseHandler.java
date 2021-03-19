package utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import antSimulation.Initialize;
import blocks.DirtWall;
import state.State;

public class MouseHandler extends MouseAdapter implements KeyListener {
	private int mousePX = -1;
	private int mousePY = -1;
	private boolean CTRL = false;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(State.isWalkable(e.getX(), e.getY()));
		
		if(SwingUtilities.isRightMouseButton(e)) {
			long firstTime = System.currentTimeMillis();
			Initialize.path = State.pathFind(0, 0, e.getX(), e.getY());
			System.out.println("Operation took " + ((double)(System.currentTimeMillis() - firstTime) / 1000) + " seconds.");
		}
		if(CTRL)
			Initialize.zoomOut();
		else
			Initialize.drawBlocks(e.getX(), e.getY(), 5, DirtWall::new);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(CTRL) {
			mousePX = e.getX();
			mousePY = e.getY();
		}
		//System.out.println("Pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(mousePX == e.getX() || !CTRL) return; //Checks for infinity
		if(mousePX < e.getX()) //Uses upper left corner of zoom rectangle
			Initialize.zoom(mousePX, mousePY, e.getX(), e.getY());
		else
			Initialize.zoom(e.getX(), e.getY(), mousePX, mousePY);
		
		mousePX = -1;
		mousePY = -1;
		Initialize.resetZoomRect();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(mousePX != -1 && CTRL)
			Initialize.zoomRect(mousePX, mousePY, e.getX(), e.getY());
		if(!CTRL)
			Initialize.drawBlocks(e.getX(), e.getY(), 5, DirtWall::new);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_CONTROL)
			CTRL = true;
		//System.out.println(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_CONTROL) {
			CTRL = false;
			mousePX = -1;
			mousePY = -1;
			Initialize.resetZoomRect();
		}
		
	}

}
