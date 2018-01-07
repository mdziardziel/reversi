/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Okno extends JFrame{
    //private JPanel przyciski;
    private JPanel plansza;
    private JComponent pionki;
    private JComponent mysz;
    private JPanel ruch;
    public Okno(){
        super("Reversi - Multiplayer");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        setResizable(false);
        
        plansza = new Plansza();
        pionki = new Pionki();
        mysz = new Mysz();
        ruch = new Ruch();
        
        add(mysz);
        add(ruch);
        add(pionki);
        add(plansza);
        
        setVisible(false);
    }

    public void changePanelBounds(){
        //this.remove(plansza);
        //this.repaint();
        plansza = new Plansza();
        //this.add(plansza);
        this.repaint();
    }
    
    public void changeKolorRuch(int x){
        if(x == 1)
            ruch.setBackground(reversi.settings.Ustawienia.getKolor1());
        else
            ruch.setBackground(reversi.settings.Ustawienia.getKolor2());
    }
    
    public void resetPionkow(){
        pionki = new Pionki();
        this.repaint();
    }
}
