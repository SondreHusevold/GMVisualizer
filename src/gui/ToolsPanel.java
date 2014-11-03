package gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ToolsPanel extends JPanel
{
	
	private ButtonListener listener;
	private ToolsWindow win;
	private JButton btnSetLeftSprite, btnSetMiddleSprite, btnSetRightSprite, btnSetBackground, btnResetLeft, btnResetMiddle, btnResetRight, btnResetAll, btnUp, btnDown, btnLeft, btnRight,
	btnSetBackgroundFade, btnSetSpriteFade;
	private JComboBox<String> leftSpriteBox, middleSpriteBox, rightSpriteBox, backgroundBox;
	private String[] characters, backgrounds;
	private JTabbedPane tabbedPane;
	private TabChanger changelistener;
	private JTextField backgroundTimeField, spriteFadeTimeField;
	
	public ToolsPanel(ToolsWindow w, String[] chars, String[] bgs)
	{
		setLayout(null);
		
		listener = new ButtonListener();
		characters = chars;
		backgrounds = bgs;
		win = w;
		w.setSize(1000,600);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1000, 575);
		add(tabbedPane);
		changelistener = new TabChanger();
		
		JPanel visualizerToolsPanel = new JPanel();
		tabbedPane.addTab("Visual Tool", null, visualizerToolsPanel, null);
		tabbedPane.addChangeListener(changelistener);
		visualizerToolsPanel.setLayout(null);
		JPanel leftCharacterLabel = new JPanel();
		leftCharacterLabel.setBounds(119, 173, 192, 95);
		visualizerToolsPanel.add(leftCharacterLabel);
		leftCharacterLabel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Left Sprite:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		leftCharacterLabel.setLayout(null);
		leftSpriteBox = new JComboBox(characters);
		leftSpriteBox.setBounds(6, 18, 180, 27);
		leftCharacterLabel.add(leftSpriteBox);
		
		btnSetLeftSprite = new JButton("Set");
		btnSetLeftSprite.setBounds(35, 55, 117, 29);
		leftCharacterLabel.add(btnSetLeftSprite);
		btnSetLeftSprite.addActionListener(listener);
		
		JPanel middleSpriteLabel = new JPanel();
		middleSpriteLabel.setBounds(376, 173, 192, 94);
		visualizerToolsPanel.add(middleSpriteLabel);
		middleSpriteLabel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Middle Sprite:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		middleSpriteLabel.setLayout(null);
		
		middleSpriteBox = new JComboBox(characters);
		middleSpriteBox.setBounds(5, 17, 180, 27);
		middleSpriteLabel.add(middleSpriteBox);
		
		btnSetMiddleSprite = new JButton("Set");
		btnSetMiddleSprite.setBounds(39, 55, 117, 29);
		middleSpriteLabel.add(btnSetMiddleSprite);
		btnSetMiddleSprite.addActionListener(listener);
		
		JPanel rightSpriteLabel = new JPanel();
		rightSpriteLabel.setBounds(638, 173, 192, 95);
		visualizerToolsPanel.add(rightSpriteLabel);
		rightSpriteLabel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Right Sprite:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		rightSpriteLabel.setLayout(null);
		
		rightSpriteBox = new JComboBox(characters);
		rightSpriteBox.setBounds(6, 18, 180, 27);
		rightSpriteLabel.add(rightSpriteBox);
		
		btnSetRightSprite = new JButton("Set");
		btnSetRightSprite.setBounds(33, 52, 117, 29);
		rightSpriteLabel.add(btnSetRightSprite);
		btnSetRightSprite.addActionListener(listener);
		
		JPanel resetLabels = new JPanel();
		resetLabels.setBounds(292, 355, 387, 94);
		visualizerToolsPanel.add(resetLabels);
		resetLabels.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Reset Controls", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		resetLabels.setLayout(null);
		
		btnResetLeft = new JButton("Reset Left");
		btnResetLeft.addActionListener(listener);
		btnResetLeft.setBounds(6, 18, 117, 29);
		resetLabels.add(btnResetLeft);
		
		btnResetMiddle = new JButton("Reset Middle");
		btnResetMiddle.addActionListener(listener);
		btnResetMiddle.setBounds(135, 18, 117, 29);
		resetLabels.add(btnResetMiddle);
		
		btnResetRight = new JButton("Reset Right");
		btnResetRight.setBounds(264, 18, 117, 29);
		btnResetRight.addActionListener(listener);
		resetLabels.add(btnResetRight);
		
		btnResetAll = new JButton("Reset All Sprites");
		btnResetAll.setBounds(118, 59, 146, 29);
		btnResetAll.addActionListener(listener);
		resetLabels.add(btnResetAll);
		
		JPanel backgroundLabel = new JPanel();
		backgroundLabel.setBounds(368, 39, 192, 85);
		visualizerToolsPanel.add(backgroundLabel);
		backgroundLabel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Background", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		backgroundLabel.setLayout(null);
		
		backgroundBox = new JComboBox(backgrounds);
		backgroundBox.setBounds(6, 18, 180, 27);
		backgroundLabel.add(backgroundBox);
		
		btnSetBackground = new JButton("Set");
		btnSetBackground.setBounds(41, 48, 117, 29);
		backgroundLabel.add(btnSetBackground);
		
		JPanel backgroundFadeTimePanel = new JPanel();
		backgroundFadeTimePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Background Fade Time:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		backgroundFadeTimePanel.setBounds(660, 39, 170, 85);
		visualizerToolsPanel.add(backgroundFadeTimePanel);
		backgroundFadeTimePanel.setLayout(null);
		
		backgroundTimeField = new JTextField();
		backgroundTimeField.setBounds(6, 18, 158, 28);
		backgroundFadeTimePanel.add(backgroundTimeField);
		backgroundTimeField.setColumns(10);
		
		btnSetBackgroundFade = new JButton("Set");
		btnSetBackgroundFade.addActionListener(listener);
		btnSetBackgroundFade.setBounds(28, 50, 117, 29);
		backgroundFadeTimePanel.add(btnSetBackgroundFade);
		
		JPanel spriteFadeTimePanel = new JPanel();
		spriteFadeTimePanel.setLayout(null);
		spriteFadeTimePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Sprite Fade Time:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		spriteFadeTimePanel.setBounds(119, 39, 170, 85);
		visualizerToolsPanel.add(spriteFadeTimePanel);
		
		spriteFadeTimeField = new JTextField();
		spriteFadeTimeField.setColumns(10);
		spriteFadeTimeField.setBounds(6, 18, 158, 28);
		spriteFadeTimePanel.add(spriteFadeTimeField);
		
		btnSetSpriteFade = new JButton("Set");
		btnSetSpriteFade.addActionListener(listener);
		btnSetSpriteFade.setBounds(28, 50, 117, 29);
		spriteFadeTimePanel.add(btnSetSpriteFade);
		btnSetBackground.addActionListener(listener);
		btnResetLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel visualizerMapToolsPanel = new JPanel();
		tabbedPane.addTab("Map Tool", null, visualizerMapToolsPanel, null);
		visualizerMapToolsPanel.setLayout(null);
		
		btnLeft = new JButton("Left");
		btnLeft.setBounds(243, 226, 117, 29);
		btnLeft.addActionListener(listener);
		visualizerMapToolsPanel.add(btnLeft);
		
		btnUp = new JButton("Up");
		btnUp.addActionListener(listener);
		btnUp.setBounds(403, 155, 117, 29);
		visualizerMapToolsPanel.add(btnUp);
		
		btnRight = new JButton("Right");
		btnRight.addActionListener(listener);
		btnRight.setBounds(576, 226, 117, 29);
		visualizerMapToolsPanel.add(btnRight);
		
		btnDown = new JButton("Down");
		btnDown.addActionListener(listener);
		btnDown.setBounds(403, 298, 117, 29);
		visualizerMapToolsPanel.add(btnDown);
	}

	public JFrame getMainWindow()
	{
		return win;
	}

	private class ButtonListener implements ActionListener//lytter for
	{
		public void actionPerformed( ActionEvent e )
		{	
			win.checkForVisualizerWindow();
			if(e.getSource() == btnSetLeftSprite){
				win.getVisual().getVisualPanel().changeCharacter("Left", (String) leftSpriteBox.getSelectedItem());
			}
			else if(e.getSource() == btnSetMiddleSprite){
				win.getVisual().getVisualPanel().changeCharacter("Middle", (String) middleSpriteBox.getSelectedItem());
			}
			else if(e.getSource() == btnSetRightSprite){
				win.getVisual().getVisualPanel().changeCharacter("Right", (String) rightSpriteBox.getSelectedItem());
			}
			else if(e.getSource() == btnResetLeft){
				win.getVisual().getVisualPanel().resetCharacter("Left");
			}
			else if(e.getSource() == btnResetMiddle){
				win.getVisual().getVisualPanel().resetCharacter("Middle");
			}
			else if(e.getSource() == btnResetRight){
				win.getVisual().getVisualPanel().resetCharacter("Right");
			}
			else if(e.getSource() == btnResetAll){
				win.getVisual().getVisualPanel().resetCharacter("All");
			}
			else if(e.getSource() == btnSetBackground){
				win.getVisual().getVisualPanel().changeBackground((String) backgroundBox.getSelectedItem());
			}
			else if(e.getSource() == btnUp){
				win.getVisual().getLabyrinthPanel().setPlayerPosition(3);
			}
			else if(e.getSource() == btnDown){
				win.getVisual().getLabyrinthPanel().setPlayerPosition(4);
			}
			else if(e.getSource() == btnRight){
				win.getVisual().getLabyrinthPanel().setPlayerPosition(1);
			}
			else if(e.getSource() == btnLeft){
				win.getVisual().getLabyrinthPanel().setPlayerPosition(2);
			}
			else if(e.getSource() == btnSetSpriteFade){
				long time = Long.parseLong(spriteFadeTimeField.getText());
				win.getVisual().getVisualPanel().setSpriteTimeout(time);
			}
			else if(e.getSource() == btnSetBackgroundFade){
				long time = Long.parseLong(backgroundTimeField.getText());
				win.getVisual().getVisualPanel().setBackgroundTimeout(time);
			}
		}
	}
	
	private class TabChanger implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
	        int index = sourceTabbedPane.getSelectedIndex();
	        VisualizerWindow visualizerW = win.getVisual();
	        if(index == 1){
	        	visualizerW.changePanel(visualizerW.getLabyrinthPanel());
	        }
	        else if(index == 0){
	        	visualizerW.changePanel(visualizerW.getVisualPanel());
	        }
		}
	}
}