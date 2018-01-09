/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Napisy extends JComponent{
    protected JLabel wynik1;
    protected JLabel wynik2;
    protected JLabel czas;
    
    protected int jednostka;
    protected int poczatekX;
    protected int poczatekY;
    protected int ile = 15;
    public Napisy(){
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        setLocation(poczatekX+jednostka*4, poczatekY+jednostka);
        setSize(jednostka*10,jednostka*2);  

        setVisible(true);
    }

    public static JLabel dodajNapis(String napis,int lx, int ly, int sx,int sy, int size, Color kolor){
        JLabel wynik1 = new JLabel(napis);
        wynik1.setLocation(lx,ly);       
        wynik1.setSize(sx, sy);
        wynik1.setFont(new Font("Serif", Font.BOLD, size));
        wynik1.setForeground(kolor); 
        return wynik1;
    }
}
