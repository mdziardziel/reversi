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
 * Okno zawierające okno z grą
 */
public class Okno extends JFrame{
    protected JComponent plansza; // panel z planszą
    protected JComponent pionki; // panel z pionkami
    protected JComponent mysz; // panel nasłuchujący mysz
    protected JComponent ruch; //panel z animacją licznika
    protected JComponent przyciski; // panel z przyciskami
    protected JComponent napisy; //panel z napisami
    
    protected JLabel wynik1; // napis z wynikiem gracza 1
    protected JLabel wynik2; // gracza 2
    protected JLabel stoper1; // czasem pozostałym gracza 1
    protected JLabel stoper2;  //czasem pozostałym gracza 2
    protected JLabel timer; //minutnik
    
    protected JComponent naptlo; // tło 
    
    protected int jednostka; // jednostka
    protected int ile = 15;
    public Okno(){
        super("Reversi - Gra"); // wykonanie konstruktora klasy dziedziczonej
        
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){ // ustawianie jednostki
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        setResizable(false);
        
        plansza = new Plansza(); // dodawanie elementów do okna
        pionki = new Pionki();
        mysz = new Mysz();
        ruch = new Ruch();
        przyciski = new Przyciski();
        napisy = new Napisy();
        
        //dodawanie napisów
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

    public void changePanelBounds(){ // zmiana rozmiarów okna
        Multi.okno = new Okno();
    }
    
    public void setTimer(int m, int s){ //ustawianie stera
        String mm=""+m, ss=""+s;
        if(m<10) mm = "0"+mm;
        if(s<10) ss = "0"+ss;
        timer.setText(mm+":"+ss);
    }
    
    public void setStoper1(int m, int s){ // minutnik gracza1 ustawianie
        String mm=""+m, ss=""+s;
        if(m<10) mm = "0"+mm;
        if(s<10) ss = "0"+ss;
        stoper1.setText(mm+":"+ss);
    }
        
    public void setStoper2(int m, int s){ // gracza2 ustawianie
        String mm=""+m, ss=""+s;
        if(m<10) mm = "0"+mm;
        if(s<10) ss = "0"+ss;
        stoper2.setText(mm+":"+ss);
    }
    
    public void resetPionkow(){ //reset wikoku pionków, tak aby wyświetlały się nowe lub zmienione
        wynik1.setText(Silnik.ilePionkow(1)+"");// ustawianie punktacji graczy
        wynik2.setText(Silnik.ilePionkow(2)+"");
        pionki = new Pionki();
        this.repaint();
    }
}
