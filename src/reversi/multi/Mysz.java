/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Mysz extends JComponent implements MouseListener{
    private int jednostka;
    private int ile = 15;
    private int poczatekX, poczatekY;
    boolean multi;
    Mysz(boolean m){
        multi = m;
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
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
    public void mouseClicked(MouseEvent e) {
        //System.out.println(e.getX() + " " + e.getY());
        int x = (int)Math.floor(e.getX()/jednostka);
        int y = (int)Math.floor(e.getY()/jednostka);
        if((x>=0 && x <8)&& (y>=0 && y < 8)){
            if(reversi.multi.Silnik.sprawdzRuch(x, y, true)) {
                reversi.multi.Silnik.zmiana();
                Silnik.koniecGry();
                if(!multi) {
                    Silnik.ruchKomputera();
                    reversi.multi.Silnik.zmiana();
                    Silnik.koniecGry();
                }            
            }     
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
