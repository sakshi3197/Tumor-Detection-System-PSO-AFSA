/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Pso;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
/*www. j  av  a  2 s. c  om*/
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayArea {
    public DisplayArea(BufferedImage im, int x1, int y1, int x2, int y2)
    {
     EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TestPane(im,x1,y1,x2,y2));
        frame.pack();
        frame.setVisible(true);
      }
    });
  }   
    
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TestPane());
        frame.pack();
        frame.setVisible(true);
      }
    });
  }
}

class TestPane extends JPanel {
  private BufferedImage myImage;
  
  int x1=48;
  int y1=72;
  int x2=55;
  int y2=41;
  
  int h=calculateheight(x1,y1,x2,y2);
  int w=calculatewidth(x1,y1,x2,y2);
  
  private Rectangle myOffice = new Rectangle(x1, y1, h, w);
  public TestPane() {
    try {
      myImage = ImageIO.read(new File("C:\\Users\\sony\\Desktop/apple.png"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
public TestPane(BufferedImage im, int x1, int y1, int x2, int y2) {
    try {
      myImage = im;
      
      this.x1=x1;
      this.y1=y1;
      this.x2=x2;
      this.y2=y2;
      
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  @Override
  public Dimension getPreferredSize() {
    return myImage == null ? new Dimension(200, 200) : new Dimension(
        myImage.getWidth(), myImage.getHeight());
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    if (myImage != null) {
      int x = (getWidth() - myImage.getWidth()) / 2;
      int y = (getHeight() - myImage.getHeight()) / 2;
      g2d.drawImage(myImage, x, y, this);

      g2d.setColor(Color.RED);
      g2d.translate(x, y);
      g2d.draw(myOffice);
    }
    g2d.dispose();
  }

    private int calculateheight(int x1, int y1, int x2, int y2) {
//        x=x2-x1;
//        y=y2-y1;
        return 55;
    }

    private int calculatewidth(int x1, int y1, int x2, int y2) {
        
        
        return 55;
    }
}