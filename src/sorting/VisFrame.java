package sorting;

import javax.swing.JFrame;

public class VisFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final int SCREEN_X = 1500;
	private final int SCREEN_Y = 500;
	public VisFrame(SortingVisualizer vis) {
		super("Sorting Visualizer");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     this.setSize(SCREEN_X,SCREEN_Y);
	     vis.setScreenY(SCREEN_Y);
	     this.getContentPane().add(vis);
	     this.setVisible(true);
	}
}
