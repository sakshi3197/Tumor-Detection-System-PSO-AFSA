/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Algorithms;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sony
 */
public class imagepixelcolor {
    public static int pixelcount[][]=new int[1500][1500];
    public static int totpix=0;
    public static int black=0;
    public static int white=0;
    
    public static int blackper=0;
    public static int whiteper=0;
    
    public static void main(String args[]) throws IOException {
        File file = new File("C:\\Users\\sony\\Desktop\\chatbotimages\\apple.png");
        BufferedImage image = ImageIO.read(file);
    
       imagepixelcolor.marchThroughImage(image);
       
       getColorPercent();

  }
    public static void marchThroughImage(BufferedImage image) {
    int w = image.getWidth();
    int h = image.getHeight();
    System.out.println("width, height: " + w + ", " + h);

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
//        System.out.println("x,y: " + j + ", " + i);
        int pixel = image.getRGB(j, i);
        pixelcount[i][j]=pixel;
        printPixelARGB(pixel);
//        System.out.println("");
      }
    }
  }
    
    
    public static void printPixelARGB(int pixel) {
    totpix++;
    int alpha = (pixel >> 24) & 0xff;
    int red = (pixel >> 16) & 0xff;
    int green = (pixel >> 8) & 0xff;
    int blue = (pixel) & 0xff;
//    System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
  
    if(alpha==255 && red==255 && green==255 && blue==255)
    {
        white++;
    }
    if(alpha==255 && red==0 && green==0 && blue==0)
    {
        black++;
    }

    
    }

    public static void getColorPercent() {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Totaal pixel====>"+totpix);
        System.out.println("black pixel====>"+black);
        System.out.println("white pixel====>"+white);
        
        blackper=(black*100)/totpix;
        whiteper=(white*100)/totpix;
        
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("white pixel percentage====>"+whiteper);
        System.out.println("black pixel percentage====>"+blackper);

    }
    public static int returnColorPercent(String colorname)
    {   
        int cpercent=0;
        if(colorname.equals("white"))
        {
            cpercent=whiteper;
        }
        if(colorname.equals("black"))
        {
            cpercent=blackper;
        }

        return  cpercent;
    }
    
}
