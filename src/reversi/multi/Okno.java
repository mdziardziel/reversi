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
    private JLabel stoper1;
    private JLabel stoper2; 
    private JLabel timer;
    
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
        wynik2 = Napisy.dodajNapis(Silnik.ilePionkow(2)+"", jednostka*8,0,jednostka*2, jednostka , jednostka, reversi.settings.Ustawienia.getKolor2());
        timer = Napisy.dodajNapis("", jednostka*2,0,jednostka*6, jednostka*2-10 , jednostka*2-10, Color.BLACK);
        stoper1 = Napisy.dodajNapis("00:00", 5,jednostka+5,jednostka*3, jednostka , jednostka/2, reversi.settings.Ustawienia.getKolor1());
        stoper2 = Napisy.dodajNapis("00:00", jednostka*8,jednostka+5,jednostka*3, jednostka , jednostka/2, reversi.settings.Ustawienia.getKolor2());
        
        napisy.add(stoper1);
        napisy.add(stoper2);
        napisy.add(timer);
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
    
    public void setTimer(int m, int s){
        String mm=""+m, ss=""+s;
        if(m<10) mm = "0"+mm;
        if(s<10) ss = "0"+ss;
        timer.setText(mm+":"+ss);
    }
    
    public void setStoper1(int m, int s){
        String mm=""+m, ss=""+s;
        if(m<10) mm = "0"+mm;
        if(s<10) ss = "0"+ss;
        stoper1.setText(mm+":"+ss);
    }
        
    public void setStoper2(int m, int s){
        String mm=""+m, ss=""+s;
        if(m<10) mm = "0"+mm;
        if(s<10) ss = "0"+ss;
        stoper2.setText(mm+":"+ss);
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
