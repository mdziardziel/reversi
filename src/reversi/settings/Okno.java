/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.settings;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class Okno extends JFrame{
    JPanel przyciski;
    public Okno(){
        super("Reversi - Ustwienia");
        
        przyciski = new Przyciski(); 
        add(przyciski);
        
        //pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        setResizable(false);
        
        setVisible(false);
    }

    public void changeButtonBounds(){
        przyciski.repaint();
        //przyciski = new Przyciski(); 
        //this.add(przyciski);
    }
    
}