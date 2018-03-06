package sorting;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SortingVisualizer extends JPanel implements Runnable{
	private static final long serialVersionUID = 1L;
	private final int MS_DELAY = 10;// delay between each move
	private int screenY;
	private int interval = 2;// the distance between bars
	private int rectWidth = 5;
	private Sorter sorter;
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int xLoc = interval;
		int yLoc;
		for (Integer value : sorter.getValues()) {
			g.setColor(Color.GREEN);
			yLoc = screenY - value;
			xLoc += rectWidth;
			g.fillRect(xLoc, yLoc, rectWidth, value);
			g.setColor(Color.BLACK);
			g.drawRect(xLoc, yLoc, rectWidth, value);
			xLoc += interval;
		}
	}
	public void setScreenY(int screenY) {
		this.screenY = screenY;
	}
	public void setSorter(Sorter s) {
		sorter = s;
	}
	public void run() {
		repaint();
		try {
			Thread.sleep(MS_DELAY);
		} catch (Exception e) {
		}
	}
}