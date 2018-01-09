/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Przyciski extends JComponent implements ActionListener{
    private final int numberOfButtons = 4;
    private final int buttonWidth = (int)(Ustawienia.getWidth()/3);
    private final int buttonHeight = (int)(Ustawienia.getHeight()/(numberOfButtons*2 + 1));
    private final int buttonSpace = buttonHeight;
    private final int buttonXLocation = (Ustawienia.getWidth()-buttonWidth)/2;
    private final int buttonYLocation = buttonSpace;
    private final JButton button1= new JButton("Zagraj od nowa");
    private JButton button2 = new JButton("Menu");
    private JButton button3 = new JButton("OK, cofnij");
    
    public Przyciski() {
        setLocation(Ustawienia.getWidth()/2-buttonWidth/2, Ustawienia.getHeight()-Ustawienia.getHeight()/4);
        setSize(buttonWidth,buttonHeight); 
        setLayout(null);
        //addButton(button1,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth,buttonHeight);
        //addButton(button2,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        addButton(button3,0,0,buttonWidth,buttonHeight);
        setBackground(reversi.settings.Ustawienia.getKolorOkna());       
    }
    

    public void addButton(JButton button, int xL, int xY,int bW,int bH){
        button.setBounds(xL,xY,bW, bH);
        button.addActionListener(this);
        button.setBackground(reversi.settings.Ustawienia.getButtonKolor());
        add(button);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == button3){
            Animacja.setAnim(false);
            Koniec.okno.setVisible(false);
        }
        
    }

}
