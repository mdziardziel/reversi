/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.settings;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author michal
 * klasa zawierjąca okno ustawiń
 */
public class Okno extends JFrame{
    private JComponent przyciski; // przyciski
    private JComponent naptlo; //tło
    public Okno(){
        super("Reversi - Ustwienia");
        
        przyciski = new Przyciski(); 
        add(przyciski);
        naptlo = new reversi.koniec.Napis("Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi");
        add(naptlo);
        
        //pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        setResizable(false);
        
        setVisible(false);
    }

    public void changePanelBounds(){ // zmianapołożeń przycisków
        this.remove(przyciski);
        this.repaint();
        przyciski = new Przyciski();
        this.add(przyciski);
    }
    
}