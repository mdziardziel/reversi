/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.menu;
import java.awt.FlowLayout;
import reversi.settings.Ustawienia;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class Okno extends JFrame{
    
    public Okno(){
        super("Reversi - Menu");
        
        JPanel przyciski = new Przyciski();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(przyciski);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        pack();
        setVisible(true);
    }

    
}
