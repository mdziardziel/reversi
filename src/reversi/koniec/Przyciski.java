/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import reversi.multi.Multi;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Przyciski extends JPanel implements ActionListener{
    private final int numberOfButtons = 3;
    private final int buttonWidth = (int)(Ustawienia.getWidth()/3);
    private final int buttonHeight = (int)(Ustawienia.getHeight()/(numberOfButtons*2 + 1));
    private final int buttonSpace = buttonHeight;
    private final int buttonXLocation = (Ustawienia.getWidth()-buttonWidth)/2;
    private final int buttonYLocation = buttonSpace;
    private final JButton button1= new JButton("Zagraj od nowa");
    private JButton button2 = new JButton("Menu");
    private JButton button3 = new JButton("Wyjście");
    
    public Przyciski() {
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setLayout(null);
        addButton(button1,buttonXLocation,buttonYLocation,buttonWidth,buttonHeight);
        addButton(button2,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth,buttonHeight);
        addButton(button3,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        setBackground(reversi.settings.Ustawienia.getKolorOkna());       
    }
    

    public void addButton(JButton button, int xL, int xY,int bW,int bH){
        button.setBounds(xL,xY,bW, bH);
        button.addActionListener(this);
        add(button);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source == button1){
            Koniec.okno.setVisible(false);
            reversi.multi.Silnik.reset();
            reversi.multi.Multi.okno.setLocation(Koniec.okno.getLocation());
            reversi.multi.Multi.okno.setVisible(true);
        }
        if(source == button2){
            Koniec.okno.setVisible(false);
            reversi.settings.Ustawienia.okno.setLocation(Koniec.okno.getLocation());
            reversi.settings.Ustawienia.okno.setVisible(true);
        }
        if(source == button3){
            System.exit(0);
        }
        
    }

}