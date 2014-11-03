package gui;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VisualizerPanel extends FadeBackgroundPane
{
	
	private ButtonListener listener;
	private VisualizerWindow win;
	private Image bgImg;
	private FadePane characterLeft, characterMiddle, characterRight;
	private String characterImagePath, characterEmptyPath;
	
	public VisualizerPanel(VisualizerWindow w)
	{
		super("black.png");
		setBounds(new Rectangle(0, 0, 1920, 1080));
		win = w;
		characterEmptyPath = "EmptyCharacter.png";
		changeBackground("black");
		
		listener = new ButtonListener();
		setLayout(null);
		
		characterLeft = new FadePane(characterEmptyPath);
		characterLeft.setBounds(43, 380, 577, 711);
		add(characterLeft);
		
		characterMiddle = new FadePane(characterEmptyPath);
		characterMiddle.setBounds(669, 380, 577, 711);
		add(characterMiddle);
		
		characterRight = new FadePane(characterEmptyPath);
		characterRight.setBounds(1297, 380, 577, 711);
		add(characterRight);
	}


	public JFrame getMainWindow()
	{
		return win;
	}
	
	public void changeCharacter(String side, String fileName){
		if(side.equals("Left")) {
			changeLeftChara(fileName);
		}
		else if(side.equals("Middle")){
			changeMiddleChara(fileName);
		}
		else if(side.equals("Right")){
			changeRightChara(fileName);
		}
		else{
			resetAllSprites();
		}
	}
	
	public void resetCharacter(String side){
		if(side.equals("Left")) {
			resetLeftChara();
		}
		else if(side.equals("Middle")){
			resetMiddleChara();
		}
		else if(side.equals("Right")){
			resetRightChara();
		}
		else{
			resetAllSprites();
		}
	}
	
	public void changeBackground(String fileName){
		this.changeImage(fileName + ".png");
	}
	
	public void changeLeftChara(String fileName){
		characterLeft.changeImage(fileName + ".png");
		//characterLeft.repaint();
	}
	
	public void resetLeftChara(){
		characterLeft.changeImage(characterEmptyPath);
	}
	
	public void changeMiddleChara(String fileName){
		characterMiddle.changeImage(fileName + ".png");
	}
	
	public void resetMiddleChara(){
		characterMiddle.changeImage(characterEmptyPath);
	}
	
	public void changeRightChara(String fileName){
		characterRight.changeImage(fileName + ".png");
	}
	
	public void resetRightChara(){
		characterRight.changeImage(characterEmptyPath);
	}
	
	public void setSpriteTimeout(long time){
		characterLeft.setRunningTime(time);
		characterMiddle.setRunningTime(time);
		characterRight.setRunningTime(time);
	}
	
	public void setBackgroundTimeout(long time){
		this.setRunningTime(time);
	}
	
	public void resetAllSprites(){
		resetLeftChara();
		resetMiddleChara();
		resetRightChara();
		repaint();
	}
	
	@Override protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, this);
	}

	private class ButtonListener implements ActionListener//lytter for
	{
		public void actionPerformed( ActionEvent e )
		{
			
		}
	}
}