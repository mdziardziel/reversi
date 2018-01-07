/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    private JComponent przyciski;
    private JComponent napisy;
    
    private JLabel wynik1;
    private JLabel wynik2;
    
    int jednostka;
    int ile = 15;
    public Okno(boolean multi){
        super("Reversi - Gra");
        
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        setResizable(false);
        
        plansza = new Plansza();
        pionki = new Pionki();
        mysz = new Mysz(multi);
        ruch = new Ruch();
        przyciski = new Przyciski(multi);
        napisy = new Napisy();
        
        
        wynik1 = Napisy.dodajNapis(Silnik.ilePionkow(1)+"", 5,0,jednostka*2, jednostka , jednostka, reversi.settings.Ustawienia.getKolor1());
        wynik2 = Napisy.dodajNapis(Silnik.ilePionkow(2)+"", jednostka*8 + 5,0,jednostka*2, jednostka , jednostka, reversi.settings.Ustawienia.getKolor2());
        
        napisy.add(wynik1);
        napisy.add(wynik2);
        
        add(mysz);
        
        add(ruch);
        add(napisy);
        add(przyciski);
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
        //remove(napisy);
        //napisy = new Napisy();
        wynik1.setText(Silnik.ilePionkow(1)+"");
        wynik2.setText(Silnik.ilePionkow(2)+"");
        //add(napisy);
        //pionki = new Pionki();
        this.repaint();
    }
}
