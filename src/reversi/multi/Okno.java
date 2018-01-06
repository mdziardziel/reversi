/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Okno extends JFrame{
    //private JPanel przyciski;
    private JPanel plansza;
    private JComponent pionki;
    public Okno(){
        super("Reversi - Multiplayer");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        setResizable(false);
        
        plansza = new Plansza();
        pionki = new Pionki();

        add(pionki);
        add(plansza);
        
        
        setVisible(false);
    }

    public void changePanelBounds(){
        this.remove(plansza);
        this.repaint();
        plansza = new Plansza();
        this.add(plansza);
    }   
}
