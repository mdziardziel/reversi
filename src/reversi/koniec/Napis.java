/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import reversi.Reversi;
import reversi.multi.Multi;
import reversi.multi.Silnik;
import reversi.multi.Timer;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Napis extends JPanel{
    private String napis;
    private JLabel label1;
    public String text;
    public Napis(String str){
        if(str!="")text = str;
        else
        if(Silnik.ktoWygral() == 1 ) text = "Wygrał Gracz 1! Wygrał Gracz 1!Wygrał Gracz 1! Wygrał Gracz 1!";
        else if(Silnik.ktoWygral() == 2 ) text = "Wygrał Gracz 2! Wygrał Gracz 2!Wygrał Gracz 2! Wygrał Gracz 2!";
        else if(Silnik.ktoWygral() == 3 ) text = "Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!";
        else text = "Coś poszło nie tak!";
        setLayout(null);  
        for(int i = 0; i <= 10; i++){
            newLabel(i);
        }
        setBackground(Ustawienia.getKolorOkna());
        //add(label1);
        setLocation(0, 0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
    }


    private void newLabel(int i){
        JLabel x = new JLabel(text);
        x.setLocation(-i*50,  i*(Ustawienia.getHeight()/10+Ustawienia.getHeight()/60));
        x.setSize(Ustawienia.getWidth()*2,Ustawienia.getHeight()/10+Ustawienia.getHeight()/60);
        x.setFont(new Font("Serif", Font.BOLD, Ustawienia.getHeight()/10));
        add(x);
    }
    
}
