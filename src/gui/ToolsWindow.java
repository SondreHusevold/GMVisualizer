package gui;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class ToolsWindow extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private Register register;
	private ToolsPanel middle;
	private WinListener winListener;
	private Container c;
	private BorderLayout layout;
	private VisualizerWindow visualizer;
	private String[] characters, backgrounds;
	private VisualizerPanel visualPanel;
	private LabyrinthVisualizer labyrinthPanel;
	
	public ToolsWindow(VisualizerWindow visualizerPara)
	{
		super("GM's Visualizer Tools");
		winListener = new WinListener();
		try {
			characters = readSprites("./characterSprites.txt");
			backgrounds = readSprites("./backgrounds.txt");
		} catch (IOException e) {
			System.out.println("Something went extremely wrong when reading sprites.");
		}
		
		//oppretter paneler
		c = getContentPane();
		layout = new BorderLayout();
		c.setLayout(layout);
		visualizer = visualizerPara;
		middle = new ToolsPanel(this, characters, backgrounds);
		//legger til komponenter
		c.add(middle, BorderLayout.CENTER);
		addWindowListener(winListener);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}

	public void changePanel(ToolsPanel in)//metode endrer hovedpanelet middle til in
	{
		c.remove(layout.getLayoutComponent(BorderLayout.CENTER) );
		middle = in;
		c.add(middle, BorderLayout.CENTER);
		validate();
		repaint();
	}
	
	private String[] readSprites(String file) throws IOException{
		String[] allSprites;
		int totalFilesToRead = 0;
		
		try (BufferedReader inntekst = new BufferedReader( new FileReader( file ))){ 
			String line = null;
			do{
				line = inntekst.readLine();
				if ( line != null ){
					totalFilesToRead++;
				}
	    	} 
			while ( line != null );
		} catch (FileNotFoundException e) { 
			System.out.println("Cannot find file: " + file);
			return null;
		}
		
		try (BufferedReader inntekst = new BufferedReader( new FileReader( file ))){ 
			String line = null;
			allSprites = new String[totalFilesToRead--];
			totalFilesToRead = 0;
			do{
				line = inntekst.readLine();
				if ( line != null ){
					allSprites[totalFilesToRead++] = line;
				}
	    	} 
			while ( line != null );
		} catch (FileNotFoundException e) { 
			System.out.println("Cannot find file: " + file);
			return null;
		}
		
		return allSprites;
	}
	
	public String[] getCharacters(){
		return characters;
	}
	
	public String[] getBackgrounds(){
		return backgrounds;
	}
	
	public void checkForVisualizerWindow(){
		if(visualizer.isVisible()){
			return;
		}
		visualizer.setVisible(true);
	}
	
	public VisualizerWindow getVisual(){
		return visualizer;
	}
	
	
	public void stopVisual(){
		visualizer.setVisible(false);
	}

	private class WinListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}