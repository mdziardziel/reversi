/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
//import javafx.scene.paint.Color;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;
import java.awt.Color;

/**
 *
 * @author michal
 */
public class Plansza extends JPanel{
    private int jednostka;
    private int poczatekX;
    private int poczatekY;
    private int ile = 15;
    private Color kolorStolu = new Color(78,53,33);
    private Color kolorLicznika = new Color(23,0,0);
    private Color kolorRamek = new Color(6,10,13);
    private Color kolorPlanszy = new Color(214,188,111);
    private Color kolorPodkladki = kolorPlanszy;
    
    
    
    Plansza(){
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        setBackground(reversi.settings.Ustawienia.getKolorOkna());
        setLocation(0, 0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        setLayout(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
        
	//Rectangle2D stol = new Rectangle2D.Double(poczatekX, poczatekY, ile*jednostka, ile*jednostka);
        g2d.setColor(kolorStolu);
        g2d.fillRect(poczatekX, poczatekY, ile*jednostka, ile*jednostka);
        
        //podkladka
        g2d.setColor(kolorPodkladki);
        g2d.fillRect(poczatekX+jednostka*4, poczatekY+jednostka*4, 10*jednostka, 10*jednostka);
        
        //plansza
        g2d.setColor(kolorPlanszy);
        g2d.fillRect(poczatekX+jednostka*5, poczatekY+jednostka*5, 8*jednostka, 8*jednostka);
        
        //licznik
        g2d.setColor(kolorLicznika);
        g2d.fillRect(poczatekX+jednostka*4, poczatekY+jednostka, 10*jednostka, 2*jednostka);
        g2d.setColor(reversi.settings.Ustawienia.getKolor1());
        g2d.fillRect(poczatekX+jednostka*4, poczatekY+jednostka, 2*jednostka, 2*jednostka);
        g2d.setColor(reversi.settings.Ustawienia.getKolor2());
        g2d.fillRect(poczatekX+jednostka*12, poczatekY+jednostka, 2*jednostka, 2*jednostka);
        
        //lewy panel
        g2d.setColor(kolorStolu);
        g2d.fillRect(poczatekX+jednostka, poczatekY+jednostka*4, 2*jednostka, 10*jednostka);
        
        
        g2d.setColor(kolorRamek);
        g2d.drawRect(poczatekX+jednostka*4, poczatekY+jednostka, 10*jednostka, 2*jednostka);//licznik
        g2d.drawRect(poczatekX+jednostka*4, poczatekY+jednostka*4, 10*jednostka, 10*jednostka);//podkladka
        //g2d.drawRect(poczatekX+jednostka, poczatekY+jednostka*4, 2*jednostka, 10*jednostka);//panel
        
        for(int i = poczatekX+jednostka*5; i< poczatekX+jednostka*13; i+=jednostka){
            for(int j = poczatekY+jednostka*5; j< poczatekY+jednostka*13; j+=jednostka){
                g2d.drawRect(i, j, jednostka, jednostka);
            }
        }
        
    }
    
}
