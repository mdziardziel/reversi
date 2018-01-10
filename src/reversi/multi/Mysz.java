/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 * klasa obsługująca mysz
 */
public class Mysz extends JComponent implements MouseListener{ // dziedziczymy z panelu na którym mysz będzie nasłuchiwać dzięki implementacji MouseListener
    protected int jednostka;// podzieliłem okno gry na 15 równych jednostek
    protected int ile = 15; // na tyle
    protected int poczatekX, poczatekY; // początek kwadratu, który ma te 15x15 jednostek, w stosunku do początku okna
    public Mysz(){
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){ // ustawiam wielkośc jednostki, tak aby maksywmalnie wypełnić okno
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        addMouseListener(this);
        setLocation(0, 0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        setLocation(poczatekX+jednostka*5, poczatekY+jednostka*5);
        setSize(jednostka*8,jednostka*8); 
    }

    @Override
    public void mouseClicked(MouseEvent e) { // metoda nasłuchująca klikanie myszki
        int x = (int)Math.floor(e.getX()/jednostka); // pobieram wspolrzędne myszki i zamieniam na numer pola na planszy
        int y = (int)Math.floor(e.getY()/jednostka);
        if((x>=0 && x <8)&& (y>=0 && y < 8)){ // jeśli mysz mieści się w polu to rozpoczynam nowy wątek w którym    
            Runnable ss = new Silnik(x,y,true); //oblicza się czy jest możliwy ruch i jeśli tak to go wykonuje, a później z zmienia gracza
            Thread watek = new Thread(ss);
            watek.start();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
