/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import reversi.settings.Ustawienia;
import java.awt.Color;
import javax.swing.JComponent;

/**
 *
 * @author michal
 * klasa zawierająca planszę do gry
 */
public class Plansza extends JComponent{
    protected int jednostka;
    protected int poczatekX;
    protected int poczatekY;
    protected int ile = 15;
    protected Color kolorStolu = Ustawienia.getKolorOkna();
    protected Color kolorLicznika = new Color(23,0,0); 
    protected Color kolorRamek = new Color(6,10,13);
    protected Color kolorPlanszy = new Color(214,188,111);
    protected Color kolorPodkladki = kolorPlanszy;
    
    
    
    public Plansza(){
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
    protected void paintComponent(Graphics g) { // rysowanie wszystkich elementów metodą 3d
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(kolorStolu);
        g.fill3DRect(poczatekX, poczatekY, ile*jednostka, ile*jednostka,true);
        
        //podkladka
        g.setColor(kolorPodkladki);
        g.fill3DRect(poczatekX+jednostka*4, poczatekY+jednostka*4, 10*jednostka, 10*jednostka,true);
        
        g.setColor(kolorPlanszy);
        g.fill3DRect(poczatekX+jednostka*5, poczatekY+jednostka*5, 8*jednostka, 8*jednostka,true);
        
        //licznik
        g.setColor(kolorLicznika);
        g.fill3DRect(poczatekX+jednostka*4, poczatekY+jednostka, 10*jednostka, 2*jednostka,true);
        g.setColor(reversi.settings.Ustawienia.getKolor1());
        g.fill3DRect(poczatekX+jednostka*4, poczatekY+jednostka, 2*jednostka, 2*jednostka,true);
        g.setColor(reversi.settings.Ustawienia.getKolor2());
        g.fill3DRect(poczatekX+jednostka*12, poczatekY+jednostka, 2*jednostka, 2*jednostka,true);
        
        //lewy panel
        g.setColor(kolorStolu);
        
        
        g2d.setColor(kolorRamek);
        
        for(int i = poczatekX+jednostka*5; i< poczatekX+jednostka*13; i+=jednostka){ // rysoanie kratek na planszy
            for(int j = poczatekY+jednostka*5; j< poczatekY+jednostka*13; j+=jednostka){
                g2d.drawRect(i, j, jednostka, jednostka);
            }
        }
        
    }
    
}
