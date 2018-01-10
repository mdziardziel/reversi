/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.menu;
import javax.swing.JComponent;
import reversi.settings.Ustawienia;

import javax.swing.JFrame;

/**
 *
 * @author michal
 * klasa tworząca okno menu
 */
public class Okno extends JFrame{
    private JComponent przyciski; //panel z przyciskami
    private JComponent naptlo; //panel z tłem
    public String txt = "Reversi"; //tekst na tle
    public Okno(){
        super("Reversi - Menu"); // nazwa okna, przy okazji wykonanie konstruktora klasy JFrame
        
        przyciski = new Przyciski();
        
        add(przyciski);
        naptlo = new reversi.koniec.Napis("Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi");
        add(naptlo);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setBackground(reversi.settings.Ustawienia.getKolorOkna());
        setResizable(false);
        
        setVisible(false);
    }
    
    public void changePanelBounds(){ //metoda zmieniająca położenie przycisków
        przyciski = new Przyciski();
        this.repaint();
    }

    
}
