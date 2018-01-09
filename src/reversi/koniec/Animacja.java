/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static reversi.multi.Timer.time;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Animacja implements Runnable{
    private static boolean animacja = false;
    private static long startTime;
    private static int obW = 165;
    private static int obH = 200;
    private static int ileO = 15;
    private int nx[] = new int[ileO];
    private int ny[] = new int[ileO];
    private int sx[] = new int[ileO];
    private int sy[] = new int[ileO];
    public Animacja(){
        startTime = System.currentTimeMillis();
    }
    public static boolean getAnim(){
        return animacja;
    }
    public static void setAnim(boolean b){
        animacja = b;
    }
    public static int getIleO(){
        return ileO;
    }
    public static int getWO(){
        return obW;
    }
    public static int getHO(){
        return obH;
    }
    
    
    private void spij(int n){
                try{
            Thread.sleep(n);
        }catch(InterruptedException e){
            System.out.println("Nie udało się zasnąć");
        }
    }
    
    @Override
    public void run() {
        Random g = new Random();
        for(int i = 0; i < ileO; i++){
            nx[i] = g.nextInt(Ustawienia.getWidth()-obW);
            ny[i] = g.nextInt(Ustawienia.getHeight()-obH);
            sx[i] = g.nextInt(Ustawienia.getWidth()-obW);
            sy[i] = g.nextInt(Ustawienia.getHeight()-obH);
            Koniec.okno.picLabel[i].setLocation(sx[i], sy[i]);
        }
       while(animacja){
           for(int i = 0; i < ileO; i++){
                if(sx[i]<nx[i])sx[i]++;
                else if(sx[i]>nx[i])sx[i]--;
                if(sy[i]<ny[i])sy[i]++;
                else if(sy[i]>ny[i])sy[i]--;       
                Koniec.okno.picLabel[i].setLocation(sx[i], sy[i]);
                if(sx[i]==nx[i] && sy[i]==ny[i]){
                    nx[i] = g.nextInt(Ustawienia.getWidth()-obW);
                    ny[i] = g.nextInt(Ustawienia.getHeight()-obH);
                }
           }
         spij(5);

     }
    }
}
