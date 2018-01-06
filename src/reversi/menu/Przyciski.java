/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.menu;
import java.awt.Color;
import reversi.settings.Ustawienia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author michal
 */
public class Przyciski extends JPanel implements ActionListener{
    private final int numberOfButtons = 4;
    private final int buttonWidth = (int)(Ustawienia.getWidth()/3);
    private final int buttonHeight = (int)(Ustawienia.getHeight()/(numberOfButtons*2 + 1));
    private final int buttonSpace = buttonHeight;
    private final int buttonXLocation = (Ustawienia.getWidth()-buttonWidth)/2;
    private final int buttonYLocation = buttonSpace;
    private final JButton button1 = new JButton("1 gracz");
    private JButton button2 = new JButton("2 graczy");
    private JButton button3 = new JButton("opcje");
    private JButton button4 = new JButton("wyjście");
    
    public Przyciski() {
        addButton(button1,buttonXLocation,buttonYLocation,buttonWidth,buttonHeight);
        addButton(button2,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth,buttonHeight);
        addButton(button3,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        addButton(button4,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*3,buttonWidth,buttonHeight);
        
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
            setBackground(Color.GREEN);
        }
        if(source == button2){
            setBackground(Color.YELLOW);
        }
        if(source == button3){
            setBackground(Color.BLUE);
        }
        if(source == button4){
            setBackground(Color.RED);
        }
        
    }
}
