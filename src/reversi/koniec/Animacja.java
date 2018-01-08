/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static reversi.multi.Timer.startTime;
import static reversi.multi.Timer.time;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Animacja extends JPanel implements Runnable{
    private static long startTime;
    Animacja(){
        startTime = System.currentTimeMillis();
        setLocation(0,0);
        setSize(reversi.settings.Ustawienia.getWidth(),reversi.settings.Ustawienia.getHeight()); 
        setBackground(reversi.settings.Ustawienia.getKolorOkna()); 
    }
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
                
    }

    @Override
    public void run() {
       while(true){
        time = System.currentTimeMillis()-startTime;
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            System.out.println("Nie udało się zasnąć");
        }
     }
    }
}
