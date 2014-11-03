package gui;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Method;

public class VisualizerWindow extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Register register;
	private JPanel middle;
	private WinListener winListener;
	private Container c;
	private BorderLayout layout;
	private VisualizerPanel visualizerPanel;
	private LabyrinthVisualizer labyrinthPanel;
	
	public VisualizerWindow()
	{
		super("GM Visualizer");
		winListener = new WinListener();
	   if (isMacOSX()) {
            System.setProperty(
                    "com.apple.mrj.application.apple.menu.about.name",
                    "Full Screen Demo");
        }
		c = getContentPane();
		layout = new BorderLayout();
		c.setLayout(layout);
		visualizerPanel = new VisualizerPanel(this);
		//labyrinthPanel = new LabyrinthVisualizer(this);
		middle = visualizerPanel;
		//legger til komponenter
		c.add(middle, BorderLayout.CENTER);
		addWindowListener(winListener);
		setLocationRelativeTo(null);
		setSize(1920,1200);
		if (isMacOSX()) {
            enableFullScreenMode(this);
        }
		setVisible(true);
		
	}
	public void setSizeByPanel()//metode brukes ikke, men er her hvis det er ønskelig å endre størrelsen basert på gjeldene hoved panel
	{
		setSize(middle.getPreferredSize() );//krever redefinisjon av getPrefferedSize() metoden
	}

	public void changePanel(VisualizerPanel in) {
		c.remove(layout.getLayoutComponent(BorderLayout.CENTER) );
		labyrinthPanel = (LabyrinthVisualizer) middle;
		middle = in;
		setTitle("GM Visualizer");
		c.add(middle, BorderLayout.CENTER);
		validate();
		repaint();
	}
	
	public void changePanel(LabyrinthVisualizer in)//metode endrer hovedpanelet middle til in
	{
		c.remove(layout.getLayoutComponent(BorderLayout.CENTER) );
		visualizerPanel = (VisualizerPanel) middle;
		middle = in;
		setTitle("Labyrinth Visualizer");
		c.add(middle, BorderLayout.CENTER);
		validate();
		repaint();
	}
	
	 public static void enableFullScreenMode(Window window) {
        String className = "com.apple.eawt.FullScreenUtilities";
        String methodName = "setWindowCanFullScreen";
 
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, new Class<?>[] {
                    Window.class, boolean.class });
            method.invoke(null, window, true);
        } catch (Throwable t) {
            System.err.println("Full screen mode is not supported");
            t.printStackTrace();
        }
    }
	 
    private static boolean isMacOSX() {
        return System.getProperty("os.name").indexOf("Mac OS X") >= 0;
    }

	public VisualizerPanel getVisualPanel(){
		return visualizerPanel;
	}
	
	public LabyrinthVisualizer getLabyrinthPanel(){
		return labyrinthPanel;
	}
	
	private class WinListener extends WindowAdapter//vindu lytter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
		}
	}
}