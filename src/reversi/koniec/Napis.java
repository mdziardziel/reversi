/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import reversi.multi.Silnik;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Napis extends JComponent{
    private String napis;
    private JLabel label1;
    Napis(){
        setLocation(0, 0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()/2);
        if(Silnik.ktoWygral() == 1 ) label1 = new JLabel("Wygrał Gracz 1!",JLabel.CENTER);
        else if(Silnik.ktoWygral() == 2 ) label1 = new JLabel("Wygrał Gracz 2!",JLabel.CENTER);
        else if(Silnik.ktoWygral() == 3 ) label1 = new JLabel("Remis!",JLabel.CENTER);
        else label1 = new JLabel("Coś poszło nie tak!",JLabel.CENTER);
        add(label1);
        setBackground(Color.BLACK); 
    }
    
}
