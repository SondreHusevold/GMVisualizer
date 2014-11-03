package gui;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.*;

public class FadePane extends JPanel {

    public long runningTime;

    private BufferedImage inImage;
    private BufferedImage outImage;
    private final Timer timer;
    private float alpha = 0f;
    private long startTime = -1;
    private ClassLoader cl;

    public FadePane(String imageFile) {
    	runningTime = 1000;
    	cl = this.getClass().getClassLoader();
    	this.setOpaque(false);
        try {
            inImage = ImageIO.read(new File("./Images/Sprites/" + imageFile));
            outImage = ImageIO.read(new File("./Images/Sprites/EmptyCharacter.png"));
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime < 0) {
                    startTime = System.currentTimeMillis();
                } else {

                    long time = System.currentTimeMillis();
                    long duration = time - startTime;
                    if (duration >= runningTime) {
                        startTime = -1;
                        ((Timer) e.getSource()).stop();
                        alpha = 0f;
                    } else {
                        alpha = 1f - ((float) duration / (float) runningTime);
                    }
                    repaint();
                }
            }
        });
    }
    
    public void fadeIn(){
    	alpha = 0f;
        BufferedImage tmp = inImage;
        inImage = outImage;
        outImage = tmp;
        timer.start();
    }
    
    public void fadeOut(){
    	alpha = 1f;
        BufferedImage tmp = outImage;
        outImage = inImage;
        inImage = tmp;
        timer.start();
    }
    
    public void changeImage(String fileName){
    	 try {
             inImage = ImageIO.read(new File("./Images/Sprites/" + fileName));
         } catch (IOException exp) {
         }
    	 fadeIn();
    }
    
    public void setRunningTime(long time){
    	runningTime = time;
    }

   @Override
    public Dimension getPreferredSize() {
        return new Dimension(
                        Math.max(inImage.getWidth(), outImage.getWidth()), 
                        Math.max(inImage.getHeight(), outImage.getHeight()));
    }

 	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
        int x = (getWidth() - inImage.getWidth()) / 2;
        int y = (getHeight() - inImage.getHeight()) / 2;
        g2d.drawImage(inImage, x, y, this);

        g2d.setComposite(AlphaComposite.SrcOver.derive(1f - alpha));
        x = (getWidth() - outImage.getWidth()) / 2;
        y = (getHeight() - outImage.getHeight()) / 2;
        g2d.drawImage(outImage, x, y, this);
        g2d.dispose();
    }

}