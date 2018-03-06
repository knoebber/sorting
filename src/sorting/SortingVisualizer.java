package sorting;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class SortingVisualizer extends Frame {
	private static final long serialVersionUID = 1L;
	private final int SCREEN_X = 1500;
	private final int SCREEN_Y = 900;
	private final int MS_DELAY = 50;//delay between each move
	private int interval = 2;//the distance between bars
	private int offset= 0;
	private int rectWidth;
	private int subStart = -1; //if these values are set then only redraw the array between these indexes
	private int subEnd = -1;
	private Sorter sorter;
       
   public SortingVisualizer(){
      super("Sorting Visualizer");
      prepareGUI();
   }
   public void setSorter(Sorter s) throws Exception {
	   sorter = s;
	   if(s.getSize()*3>SCREEN_X)
		   throw new Exception("Sorter has too many values to fit on screen");
	   //interval = SCREEN_X/sorter.getSize();
	   rectWidth = (SCREEN_X-interval)/sorter.getSize() -2 ;
	   //offset = (SCREEN_X-padding)%sorter.getSize();
   }

   private void prepareGUI(){
      setSize(SCREEN_X,SCREEN_Y);
      addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      }); 
   }    
   public void refresh() {
		repaint();
		try {
		  Thread.sleep(MS_DELAY); 
		}
		catch (Exception e) {} 
}

   @Override
   public void paint(Graphics g) {
      int xLoc = interval+offset;
      int height;
      int index = 0;
      for(Integer value: sorter.getValues()) {
    	  if(sorter.indexWasSwapped(index)) g.setColor(Color.GREEN);
    	  else                              g.setColor(Color.BLACK); 
    		 
    	  height = SCREEN_Y - value;
    	  xLoc+=this.interval;
    	  if(subStart==-1 && subEnd ==-1 || (index>=subStart && index <=subEnd)) 
    		  g.fillRect(xLoc,value, rectWidth, height);
    	  xLoc+=this.rectWidth;
    	  index++;
      }
   }
}
