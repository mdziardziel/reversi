/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;


import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Okno extends JFrame{
    protected JComponent plansza;
    protected JComponent pionki;
    protected JComponent mysz;
    protected JComponent ruch;
    protected JComponent przyciski;
    protected JComponent napisy;
    
    protected JLabel wynik1;
    protected JLabel wynik2;
    protected JLabel stoper1;
    protected JLabel stoper2; 
    protected JLabel timer; 
    
    protected JComponent naptlo;
    
    protected int jednostka;
    protected int ile = 15;
    public Okno(){
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
        mysz = new Mysz();
        ruch = new Ruch();
        przyciski = new Przyciski();
        napisy = new Napisy();
        
        
        wynik1 = Napisy.dodajNapis(Silnik.ilePionkow(1)+"", 5,0,jednostka*2, jednostka , jednostka, reversi.settings.Ustawienia.getKolorCyfr());
        wynik2 = Napisy.dodajNapis(Silnik.ilePionkow(2)+"", jednostka*8,0,jednostka*2, jednostka , jednostka, reversi.settings.Ustawienia.getKolorCyfr());
        timer = Napisy.dodajNapis("00:00", jednostka*2,0,jednostka*6, jednostka*2-10 , jednostka*2-10, reversi.settings.Ustawienia.getKolorCyfr());
        stoper1 = Napisy.dodajNapis("00:00", 5,jednostka+5,jednostka*3, jednostka , jednostka/2, reversi.settings.Ustawienia.getKolorCyfr());
        stoper2 = Napisy.dodajNapis("00:00", jednostka*8,jednostka+5,jednostka*3, jednostka , jednostka/2, reversi.settings.Ustawienia.getKolorCyfr());
        
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
        naptlo = new reversi.koniec.Napis("Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi");
        add(naptlo);
        setResizable(false);
        setVisible(false);
    }

    public void changePanelBounds(){
        Multi.okno = new Okno();
    }
    
//    public void changeKolorRuch(int x){
//        if(x == 1)
//            ruch.setBackground(reversi.settings.Ustawienia.getKolor1());
//        else
//            ruch.setBackground(reversi.settings.Ustawienia.getKolor2());
//    }
    
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
        wynik1.setText(Silnik.ilePionkow(1)+"");
        wynik2.setText(Silnik.ilePionkow(2)+"");
        pionki = new Pionki();
        this.repaint();
    }
}
