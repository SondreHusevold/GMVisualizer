package gui;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				ToolsWindow window = new ToolsWindow(new VisualizerWindow());
			}
		});
	}

}
