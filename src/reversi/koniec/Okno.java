/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import reversi.multi.Silnik;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Okno extends JFrame{
    private JComponent przyciski;
    private JLabel label1;
    public Okno(){
        super("Reversi - Koniec gry");

        przyciski = new Przyciski(); 
        //setLayout(new FlowLayout(FlowLayout.CENTER));
        
        if(Silnik.ktoWygral() == 1 ) label1 = new JLabel("Wygrał Gracz 1!",JLabel.CENTER);
        else if(Silnik.ktoWygral() == 2 ) label1 = new JLabel("Wygrał Gracz 2!",JLabel.CENTER);
        else if(Silnik.ktoWygral() == 3 ) label1 = new JLabel("Remis!",JLabel.CENTER);
        else label1 = new JLabel("Coś poszło nie tak!",JLabel.CENTER);
//        if(Silnik.ktoWygral() == 1 ) label1 = new JLabel("Wygrał Gracz 1!",JLabel.CENTER);
//        else if(Silnik.ktoWygral() == 2 ) label1 = new JLabel("Wygrał Gracz 2!",JLabel.CENTER);
//        else if(Silnik.ktoWygral() == 3 ) label1 = new JLabel("Remis!",JLabel.CENTER);
//        else label1 = new JLabel("Coś poszło nie tak!",JLabel.CENTER);
        
        add(przyciski);
        add(label1);
        //add(label1);
        //pack();
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        //setBackground(reversi.settings.Ustawienia.getKolorOkna());
        setResizable(false);
        
        setVisible(false);
    }
    
    public void changePanelBounds(){
        this.remove(przyciski);
        this.repaint();
        przyciski = new Przyciski();
        this.add(przyciski);
    }
    
    public void zmienNapis(){
        repaint();
//        label1 = new Napis();
//        repaint();
    }

    
}
