package utils;

import java.awt.Color;
import java.util.ArrayList;

public class GradientBar {
	private ArrayList<KeyColor> keys = new ArrayList<>();

	public GradientBar() {
		keys = new ArrayList<>();
	}
	
	public GradientBar(Color first, Color last) {
		super();
		this.keys.add(new KeyColor(first, 0));
		this.keys.add(new KeyColor(last, 1));
	}
	
	public Color getColor(double position) {
		Color color = keys.get(0).getColor();
		KeyColor min = keys.get(0);
		KeyColor max = keys.get(1);
		
		for(KeyColor key : keys) {
			double minV = position - min.getPosition();
			double maxV = position - max.getPosition();
			double val = position - key.getPosition();
			if(val >= 0 && val < minV)
				min = key;
			else if(val < 0 && val > maxV)
				max = key;
		}

		double posWidth = max.getPosition() - min.getPosition();
		double aspect = (position - min.getPosition()) / posWidth;
		color = new Color((int)(min.getColor().getRed() + ((max.getColor().getRed() - min.getColor().getRed()) * aspect)), (int)(min.getColor().getGreen() + ((max.getColor().getGreen() - min.getColor().getGreen()) * aspect)), (int)(min.getColor().getBlue() + ((max.getColor().getBlue() - min.getColor().getBlue()) * aspect)));
		
		return color;
	}
	
	public void addKey(Color color, double position) {
		keys.add(new KeyColor(color, position));
	}
	
	public void removeKey(KeyColor key) {
		keys.remove(key);
	}

	public ArrayList<KeyColor> getKeys() {
		return keys;
	}

	public void setKeys(ArrayList<KeyColor> keys) {
		this.keys = keys;
	}

	@Override
	public String toString() {
		return "GradientBar [keys=" + keys + "]";
	}
}
