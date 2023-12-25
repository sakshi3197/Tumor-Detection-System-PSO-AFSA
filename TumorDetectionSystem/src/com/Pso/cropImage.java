/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Pso;

import com.Admin.AdminDashboard;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author sony
 */
public class cropImage {
    public static void main(String[] args) {
try {
            
            int x1=55;
  int y1=41;
  int x2=55;
  int y2=41;
  
  int h=55;
  int w=55;
            BufferedImage myImage = ImageIO.read(new File("C:\\Users\\sony\\Desktop/apple.png"));
            BufferedImage cropedImage=myImage.getSubimage(x1, y1, w, h);
            
//            Image dimg1=myImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),Image.SCALE_SMOOTH);
//     	          ImageIcon imageIcon1 = new ImageIcon(dimg1);
//            jLabel1.setIcon(imageIcon1);
            
//            Image dimg2=cropedImage.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(),Image.SCALE_SMOOTH);
//     	          ImageIcon imageIcon2 = new ImageIcon(dimg2);
//            jLabel2.setIcon(imageIcon2);
            
            BufferedImage TumorImage=gettumorAreaImage(myImage,x1,y1,w,h);
//            Image dimg3=TumorImage.getScaledInstance(jLabel3.getWidth(), jLabel3.getHeight(),Image.SCALE_SMOOTH);
//     	          ImageIcon imageIcon3 = new ImageIcon(dimg3);
//            jLabel3.setIcon(imageIcon3);
            
            BufferedImage NonTumorImage=getNontumorAreaImage(myImage,x1,y1,w,h);
//            Image dimg4=NonTumorImage.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(),Image.SCALE_SMOOTH);
//     	          ImageIcon imageIcon4 = new ImageIcon(dimg4);
//            jLabel4.setIcon(imageIcon4);

        } catch (Exception e) {
        }

    }
    
    public static BufferedImage gettumorAreaImage(BufferedImage img, int x1, int y1, int w, int h){
        
        BufferedImage orignalImg=img;
        int width = orignalImg.getWidth();
      int height = orignalImg.getHeight();
      int x=x1;
      int y=y1;
        System.out.println("x===>"+x);
        System.out.println("y===>"+y);
      BufferedImage im=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);;
        
        System.out.println("width===>"+width);
        System.out.println("height===>"+height);
        int [][]AllPix=new int[width][height];
        ArrayList al=new ArrayList();
        for (int i = 0; i < width; i++) {
          for (int j=0; j< height; j++)
          {
              try {
                
                  if(i>=x1 && i<=(w+x) && j>=y1 && j<=(h+y))
                  {
                      al.add(i+"#"+j);
                  }
              AllPix[i][j]=orignalImg.getRGB(i,j);

              } catch (Exception e) {
              e.printStackTrace();
              }
          }
          }
        
//        Iterator it=al.iterator();
//        while (it.hasNext()) {
//            Object val = it.next();
//           System.out.println("val===>"+val.toString());    
        
//        }
//        crating Tumor area Image
        try {
            
            for(int i=0; i<width; i++){
               for(int j=0; j<height; j++){
                   if(al.contains(i+"#"+j))
                   {
                   im.setRGB(i, j, AllPix[i][j]);
                   }
                   else{
                       im.setRGB(i, j, 00000000);
                   }
               }                   
              }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return im;
    }

    public static BufferedImage getNontumorAreaImage(BufferedImage myImage, int x1, int y1, int w, int h) {
                BufferedImage orignalImg=myImage;
        int width = orignalImg.getWidth();
      int height = orignalImg.getHeight();
      int x=x1;
      int y=y1;
        System.out.println("x===>"+x);
        System.out.println("y===>"+y);
      BufferedImage inm=new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);;
        
        System.out.println("width===>"+width);
        System.out.println("height===>"+height);
        int [][]AllPix=new int[width][height];
        ArrayList al=new ArrayList();
        for (int i = 0; i < width; i++) {
          for (int j=0; j< height; j++)
          {
              try {
                
                  if(i>=x1 && i<=(w+x) && j>=y1 && j<=(h+y))
                  {
                      al.add(i+"#"+j);
                  }
              AllPix[i][j]=orignalImg.getRGB(i,j);

              } catch (Exception e) {
              e.printStackTrace();
              }
          }
          }
        
//        Iterator it=al.iterator();
//        while (it.hasNext()) {
//            Object val = it.next();
//           System.out.println("val===>"+val.toString());    
        
//        }
//        crating NonTumor area Image
        try {
            
            for(int i=0; i<width; i++){
               for(int j=0; j<height; j++){
                   if(al.contains(i+"#"+j))
                   {
                   inm.setRGB(i, j, 00000000);
                   }
                   else{
                   inm.setRGB(i, j, AllPix[i][j]);
                   }
               }                   
              }
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return inm;
    }

    public static BufferedImage getCropedArea(BufferedImage image, int x1, int y1, int h, int w) {
//        int x11=x1;
//  int y11=y1;
////  int x12=55;
////  int y12=41;
//  
//  int h1=h;
//  int w1=w;
            BufferedImage myImage = image;
            BufferedImage cropedImage=myImage.getSubimage(x1, y1, w, h);
            
//            Image dimg1=myImage.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(),Image.SCALE_SMOOTH);
//     	          ImageIcon imageIcon1 = new ImageIcon(dimg1);
//            jLabel1.setIcon(imageIcon1);
            
//            Image dimg2=cropedImage.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(),Image.SCALE_SMOOTH);
//     	          ImageIcon imageIcon2 = new ImageIcon(dimg2);
//            jLabel2.setIcon(imageIcon2);
            
            BufferedImage TumorImage=gettumorAreaImage(myImage,x1,y1,w,h);
            Image dimg3=TumorImage.getScaledInstance(AdminDashboard.jLabel10.getWidth(), AdminDashboard.jLabel10.getHeight(),Image.SCALE_SMOOTH);
     	          ImageIcon imageIcon3 = new ImageIcon(dimg3);
            AdminDashboard.jLabel10.setIcon(imageIcon3);
            
            BufferedImage NonTumorImage=getNontumorAreaImage(myImage,x1,y1,w,h);
            Image dimg9=NonTumorImage.getScaledInstance(AdminDashboard.jLabel9.getWidth(), AdminDashboard.jLabel9.getHeight(),Image.SCALE_SMOOTH);
     	          ImageIcon imageIcon9 = new ImageIcon(dimg9);
            AdminDashboard.jLabel9.setIcon(imageIcon9);
    return TumorImage;
    }
    
}
