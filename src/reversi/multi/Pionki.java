/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import reversi.settings.Ustawienia;

import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class Pionki extends JComponent{
    private int jednostka;
    private int poczatekX;
    private int poczatekY;
    private int ile = 15;
    private int rPionka;
    
    Pionki(){
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        rPionka = (int)Math.floor(jednostka*0.8);
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        setLocation(0, 0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
    }
    
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
        
        for(int i = poczatekX+jednostka*5+(jednostka-rPionka)/2; i< poczatekX+jednostka*13; i+=jednostka){
            for(int j = poczatekY+jednostka*5+(jednostka-rPionka)/2; j< poczatekY+jednostka*13; j+=jednostka){
                g2d.fillOval(i, j, rPionka, rPionka);
            }
        }
        
    }
    
}
