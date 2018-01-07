/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Napisy extends JComponent{
    private JLabel wynik1;
    private JLabel wynik2;
    private JLabel czas;
    
    private int jednostka;
    private int poczatekX;
    private int poczatekY;
    private int ile = 15;
    Napisy(){
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        //setBackground(Color.WHITE);
        setLocation(poczatekX+jednostka*4, poczatekY+jednostka);
        setSize(jednostka*10,jednostka*2);  
        //setLayout(new FlowLayout());
        
        
//        wynik1 = new JLabel(Silnik.ilePionkow(1)+"");
//        wynik2 = new JLabel(Silnik.ilePionkow(2)+"");
//        
//        wynik1.setLocation(10, 0);
//        wynik2.setLocation(jednostka*8 + 10,0);
//        
//        wynik1.setSize(jednostka*2, jednostka);
//        wynik2.setSize(jednostka*2, jednostka);
//        wynik1.setFont(new Font("Serif", Font.BOLD, jednostka));
//        wynik2.setFont(new Font("Serif", Font.BOLD, jednostka));
//        wynik1.setForeground(reversi.settings.Ustawienia.getKolor1());
//        wynik2.setForeground(reversi.settings.Ustawienia.getKolor2());
//
//        
//        add(wynik1);
//        add(wynik2);
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
