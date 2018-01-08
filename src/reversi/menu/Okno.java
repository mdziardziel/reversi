/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.menu;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import reversi.settings.Ustawienia;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class Okno extends JFrame{
    private JComponent przyciski;
    private JComponent naptlo;
    public String txt = "Reversi";
    public Okno(){
        super("Reversi - Menu");
        
        przyciski = new Przyciski();
        
        //setLayout(new FlowLayout(FlowLayout.CENTER));
        add(przyciski);
        naptlo = new reversi.koniec.Napis("Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi Reversi");
        add(naptlo);
        //pack();
        

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setBackground(reversi.settings.Ustawienia.getKolorOkna());
        setResizable(false);
        
        setVisible(false);
    }
    
    public void changePanelBounds(){
        this.remove(przyciski);
        this.repaint();
        przyciski = new Przyciski();
        this.add(przyciski);
    }

    
}
