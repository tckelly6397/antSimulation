package utils;

import java.util.ArrayList;

public class Brush {
	private String[][] brush;
	private ArrayList<int[]> actions = new ArrayList<>();
	
	public Brush(int radius, boolean visualize){
		makeACircle(radius);
	    fill();
	    generateActions();
	    
	    if(visualize) {
	    	for(int i = 0; i < brush.length; i++) {
	    		for(int j = 0; j < brush[i].length; j++)
	    			System.out.print(brush[i][j]);
	    		System.out.println();
	    	}
	    }
	}
	
	//Create a circle outline
	private void makeACircle(int radius) {
		brush = new String[radius * 2 + 1][radius * 2 + 1];
		
		for (int i = 0;i <= radius + radius; i++) {
			for(int j = 0;j <=radius + radius; j++) {
				int xSquared = (i - radius)*(i - radius);
				int ySquared = (j - radius)*(j - radius);
				
				if(Math.abs(xSquared + ySquared - radius * radius) < radius) 
					brush[j][i] = "#";
				else 
					brush[j][i] = " ";
			}
		}
	}
	
	//fill the circle in
	private void fill() {
		for(int i = 0; i < brush.length; i++) {
			boolean start = false;
			
	    	for(int j = 0; j < brush[i].length; j++) {
	    		if(brush[i][j] == "#")
	    			start = true;
	    		if((j + 1 >= brush[i].length) || (start && brush[i][j + 1] == "#" && brush[i][brush.length / 2] == "#"))
	    			break;
	    		if(start)
	    			brush[i][j + 1] = "#";
	    	}
	    }
	}
	
	public ArrayList<int[]> generateActions() {
		int radius = brush.length / 2;
		
		for(int i = 0; i < brush.length; i++) 
			for(int j = 0; j < brush[i].length; j++) 
				if(brush[i][j] == "#")
					actions.add(new int[]{i - radius, j - radius});
		
		/*for(int[] i : actions) {
			System.out.println(i[0] + " " + i[1]);
		}*/
		return actions;
	}

	public String[][] getBrush() {
		return brush;
	}

	public ArrayList<int[]> getActions() {
		return actions;
	}
	
}