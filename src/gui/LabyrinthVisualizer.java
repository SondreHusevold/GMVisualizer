package gui;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.file.NoSuchFileException;

import com.jgoodies.forms.layout.*;

import javax.swing.*;

public class LabyrinthVisualizer extends JPanel{
	
	private VisualizerWindow win;
	private JLabel player;
	private int[][] labyrinthTiles;
	private int playerX, playerY;
	private JLabel[][] mapTile;
	private JPanel labyrinthGrid, playerGrid;
	private Image bgImg;
	private ClassLoader cl;
	
	public LabyrinthVisualizer(VisualizerWindow w){
		setLayout(null);
		/*cl = this.getClass().getClassLoader();
		win = w;
		
		try {
			bgImg = ImageIO.read(cl.getResource("Images/Backgrounds/MapBG.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		playerX = 1;
		playerY = 1;
		player = null;
		
		labyrinthGrid = new JPanel();
		labyrinthGrid.setOpaque(false);
		labyrinthGrid.setBounds(0, 0, 1919, 943);
		labyrinthGrid.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("120px:grow"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),},
			new RowSpec[] {
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),}));
	
		
		mapTile = new JLabel[30][35];
		String[][] labyrinthTiles = null;
		try {
			labyrinthTiles = getLabyrinth("Labyrinth/test.txt");
		} catch (IOException e) {
			System.out.println("ERROR: COULD NOT READ LABYRINTH FILE!");
		}
		writeTilesMap(labyrinthTiles);
		writeLabyrinthToPanel(1, 1);
		
		playerGrid = new JPanel();
		playerGrid.setOpaque(false);
		playerGrid.setBounds(0, 0, 1919, 943);
		add(playerGrid);
		playerGrid.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("120px"),},
			new RowSpec[] {
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),
				RowSpec.decode("120px"),}));
		add(labyrinthGrid);
		updatePlayerPosition();
		validate();
		repaint();*/
	}
	
	 public String[][] getLabyrinth(String url) throws IOException
	  {
		 
		BufferedReader readFile = new BufferedReader( new FileReader( url ));

	    String[] dim = readFile.readLine().split(" ");  // filens første linje
	    int m = Integer.parseInt(dim[0]);          // m er antall rader
	    int n = Integer.parseInt(dim[1]);          // n er antall kolonner
	   String[][] a = new String[m][n];               // oppretter tabellen

	    for (int i = 0; i < m; i++)
	    {
	      String linje = readFile.readLine();    
	      for (int j = 0; j < n; j++)
	      {
	        if (linje.charAt(j) == 'A') a[i][j] = "A";
	        else if (linje.charAt(j) == 'B') a[i][j] = "B";
	        else if (linje.charAt(j) == 'C') a[i][j] = "C";
	        else if (linje.charAt(j) == 'D') a[i][j] = "D";
	        else if (linje.charAt(j) == 'E') a[i][j] = "E";
	        else if (linje.charAt(j) == 'F') a[i][j] = "F";
	        else if (linje.charAt(j) == 'G') a[i][j] = "G";
	        else if (linje.charAt(j) == 'H') a[i][j] = "H";
	        else if (linje.charAt(j) == 'I') a[i][j] = "I";
	        else if (linje.charAt(j) == 'J') a[i][j] = "J";
	        else if (linje.charAt(j) == 'K') a[i][j] = "K";
	        else if (linje.charAt(j) == 'L') a[i][j] = "L";
	        else if (linje.charAt(j) == 'M') a[i][j] = "M";
	        else if (linje.charAt(j) == 'N') a[i][j] = "N";
	        else if (linje.charAt(j) == 'O') a[i][j] = "O";
	        else if (linje.charAt(j) == 'P') a[i][j] = "P";
	        else if (linje.charAt(j) == 'Q') a[i][j] = "Q";
	        else if (linje.charAt(j) == 'R') a[i][j] = "R";
	        else if (linje.charAt(j) == 'S') a[i][j] = "S";
	        else if (linje.charAt(j) == 'T') a[i][j] = "T";
	        else if (linje.charAt(j) == 'U') a[i][j] = "U";
	        else if (linje.charAt(j) == 'V') a[i][j] = "V";
	        else if (linje.charAt(j) == 'W') a[i][j] = "W";
	        else a[i][j] = "0";
	      }
	    }
	    readFile.close();
	    return a;
	  }
	 
	  public void writeTilesMap(String[][] a)
	  {
	    for (int i = 0; i < a.length; i++)
	    {
	      for (int j = 0; j < a[i].length; j++)
	      {
	        mapTile[i][j] = new JLabel("");
	        mapTile[i][j].setIcon(new ImageIcon(writeTile(a[i][j] + "")));
	      }
	    }
	  }
	  
	  public String writeTile(String tile){
		  switch (tile) {
		case "0":
			return "Images/MapTiles/0.png";
		case "A":
			return "Images/MapTiles/A.png";
		case "B":
			return "Images/MapTiles/B.png";
		case "C":
			return "Images/MapTiles/C.png";
		case "D":
			return "Images/MapTiles/D.png";
		case "E":
			return "Images/MapTiles/E.png";
		case "F":
			return "Images/MapTiles/F.png";
		case "G":
			return "Images/MapTiles/G.png";
		case "H":
			return "Images/MapTiles/H.png";
		case "I":
			return "Images/MapTiles/I.png";
		case "J":
			return "Images/MapTiles/J.png";
		case "K":
			return "Images/MapTiles/K.png";
		case "L":
			return "Images/MapTiles/L.png";
		case "M":
			return "Images/MapTiles/M.png";
		case "N":
			return "Images/MapTiles/N.png";
		case "O":
			return "Images/MapTiles/O.png";
		case "P":
			return "Images/MapTiles/P.png";
		case "Q":
			return "Images/MapTiles/Q.png";
		case "R":
			return "Images/MapTiles/R.png";
		case "S":
			return "Images/MapTiles/S.png";
		case "T":
			return "Images/MapTiles/T.png";
		case "U":
			return "Images/MapTiles/U.png";
		case "V":
			return "Images/MapTiles/V.png";
		case "W":
			return "Images/MapTiles/W.png";
		default:
			System.out.println("OH SHIT! Cannot find tile.");
			break;
		}
		return null;
	  }
	  
	  public void setPlayerPosition(int direction){
		 removePlayerPosition();
		 switch(direction){
		 case 1: playerX++; scrollHorizontal(); break;
		 case 2: playerX--; scrollHorizontal(); break;
		 case 3: playerY--; scrollVertical(); break;
		 case 4: playerY++; scrollVertical(); break;
		 default: break;
		 }
		 updatePlayerPosition();
		 System.out.println("Player Position: " + playerX + " " + playerY);
		 validate();
		 repaint();
	  }
	  
	  public int getPlayerX(){
		  return playerX;
	  }
	  
	  public int getPlayerY(){
		  return playerY;
	  }
	  
	  public void removePlayerPosition(){
		  playerGrid.remove(player);
	  }
	  
	  public void updatePlayerPosition(){
		  //player = new JLabel("");
		  //player.setIcon(new ImageIcon("Images/MapTiles/Player.png"));
		  //playerGrid.add(player, playerX + ", " + playerY);
	  }
	  
	  public void writeLabyrinthToPanel(int x, int y){
		 for(int i = 1; i < 17; i++){
			  for(int j = 1; j < 10; j++){
				  labyrinthGrid.add(mapTile[x + j - 1][y + i - 1], i + ", " + j);
			  }
		  }
	  }
	  
	  public void removeLabyrinthToPanel(int x, int y){
			 for(int i = 1; i < 17; i++){
				  for(int j = 1; j < 10; j++){
					  labyrinthGrid.remove(mapTile[x + j - 1][y + i - 1]);
				  }
			  }
		  }
		  
	  
	  public void scrollHorizontal(){
		  if(playerX - 16 < 0){
			  return;
		  }
		  else if(playerX + 16 > 35){
			  return;
		  }
		  removeLabyrinthToPanel(playerX, playerY);
		  writeLabyrinthToPanel(playerX, playerY);
	  }
	  
	  public void scrollVertical(){
		  if(playerY - 10 < 0){
			  return;
		  }
		  else if(playerY + 10 > 30){
			  return;
		  }
		  removeLabyrinthToPanel(playerX, playerY);
		  writeLabyrinthToPanel(playerX, playerY);
	  }
	  

		@Override protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
			g.drawImage(bgImg, 0, 0, this);
		}
	  
}
