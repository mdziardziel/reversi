/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Ruch extends JPanel{
    private int ile = 15;
    private int jednostka;
    private int poczatekX;
    private int poczatekY;
    Ruch(){
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        setLocation(poczatekX+jednostka, poczatekY+jednostka);
        setSize(jednostka*2,jednostka*2);
        setBackground(reversi.settings.Ustawienia.getKolor1());    
    }
}
