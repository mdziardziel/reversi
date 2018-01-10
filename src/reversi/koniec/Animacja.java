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
 * w tej klasie tworzymy animacje na ekranie po rozgrywce
 */
public class Animacja implements Runnable{
    private static boolean animacja = false; //żywotność wątku animacji true - może istanieć, false kończy się
    private static int obW = 165; //szerokość animowanego obrazka
    private static int obH = 200; //wysokość
    private static int ileO = 15; //ilość animowanych obrazków
    private int nx[] = new int[ileO]; //tablica z nwymi położeniami obrazków d których dążom (x)
    private int ny[] = new int[ileO]; //y
    private int sx[] = new int[ileO]; //obecne położenie obrazka (x)
    private int sy[] = new int[ileO]; //y
    public Animacja(){
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
    
    
    private void spij(int n){ //usypia wątek na określony czas ms
                try{
            Thread.sleep(n);
        }catch(InterruptedException e){
            System.out.println("Nie udało się zasnąć");
        }
    }
    
    @Override
    public void run() { // odpala się przy tworzeniu nowego wątku
        Random g = new Random();
        for(int i = 0; i < ileO; i++){ //losowanie obecnych lokalizacji obrazków i tych do których będą podązać
            nx[i] = g.nextInt(Ustawienia.getWidth()-obW);
            ny[i] = g.nextInt(Ustawienia.getHeight()-obH);
            sx[i] = g.nextInt(Ustawienia.getWidth()-obW);
            sy[i] = g.nextInt(Ustawienia.getHeight()-obH);
            Koniec.okno.picLabel[i].setLocation(sx[i], sy[i]); // ustawianie lokalizacji obrazków
        }
       while(animacja){ 
           for(int i = 0; i < ileO; i++){
                if(sx[i]<nx[i])sx[i]++; //dodawanie piksela lub odejmowanie w zależności od nowej i starej pozycji
                else if(sx[i]>nx[i])sx[i]--;
                if(sy[i]<ny[i])sy[i]++;
                else if(sy[i]>ny[i])sy[i]--;       
                Koniec.okno.picLabel[i].setLocation(sx[i], sy[i]);
                if(sx[i]==nx[i] && sy[i]==ny[i]){ //jeśli obiekt dotarł do nowej lokalizacji to losujemy mu nową
                    nx[i] = g.nextInt(Ustawienia.getWidth()-obW);
                    ny[i] = g.nextInt(Ustawienia.getHeight()-obH);
                }
           }
         spij(5);//ustalanie tempa animacji

     }
    }
}
