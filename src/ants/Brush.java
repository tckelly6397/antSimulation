package ants;

public class Brush {
	private static String[][] brush;
	
	//Create a circle outline
	public static void makeACircle(int radius) {
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
			//System.out.println();
		}
	}
	
	//fill the circle in
	private static void fill() {
		for(int i = 0; i < brush.length; i++) {
			boolean start = false;
			
	    	for(int j = 0; j < brush[i].length; j++) {
	    		if(brush[i][j] == "#")
	    			start = true;
	    		if(j + 1 > brush[i].length || (start && brush[i][j + 1] == "#" && brush[i][brush.length / 2] == "#"))
	    			break;
	    		if(start)
	    			brush[i][j + 1] = "#";
	    	}
	    }
	}

	public static String[][] getBrush(int radius){
		makeACircle(radius);
	    fill();
	    return brush;
	}
	
}