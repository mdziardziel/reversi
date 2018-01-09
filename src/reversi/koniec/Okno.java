/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Okno extends JFrame{
    private JComponent przyciski;
    private JPanel animacja;
    private JPanel napis;
    public Okno(){
        super("Reversi - Koniec gry");

        przyciski = new Przyciski(); 
        animacja = new Animacja();
        napis = new Napis("");
        //setLayout(new FlowLayout(FlowLayout.CENTER));
        
        setLayout(null);
        
        add(napis);
        add(animacja);
        add(przyciski);
        
        
        //setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setBackground(reversi.settings.Ustawienia.getKolorOkna());
        setResizable(false);
        
        setVisible(false);
        repaint();
        
    }
    
    public void changePanelBounds(){
        this.remove(przyciski);
        this.repaint();
        przyciski = new Przyciski();
        this.add(przyciski);
    }
    
    public void zmienNapis(){
        repaint();
    }

    
}
