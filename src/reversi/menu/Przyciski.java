/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.menu;
import java.awt.Graphics;
import java.awt.Graphics2D;
import reversi.settings.Ustawienia;
import reversi.multi.Multi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;

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
    private final JButton button1= new JButton("1 gracz");
    private JButton button2 = new JButton("2 graczy");
    private JButton button3 = new JButton("opcje");
    private JButton button4 = new JButton("wyjście");
    
    public Przyciski() {
        //setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setLocation(0,0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setLayout(null);
        addButton(button1,buttonXLocation,buttonYLocation,buttonWidth,buttonHeight);
        addButton(button2,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth,buttonHeight);
        addButton(button3,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        addButton(button4,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*3,buttonWidth,buttonHeight);
        //setBackground(reversi.settings.Ustawienia.getKolorOkna());
        
        
    }
        @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(Ustawienia.getKolorOkna());
        g.fill3DRect(buttonXLocation - buttonHeight,buttonYLocation-buttonSpace/2,buttonWidth+buttonHeight*2,buttonHeight*(numberOfButtons)*2,true);
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
        
        if(source == button1){
            reversi.multi.Silnik.reset();
            Menu.okno.setVisible(false);
            Multi.okno.setLocation(Menu.okno.getLocation());
            Multi.okno.setVisible(true);
            Ustawienia.setMulti(false);
        }
        if(source == button2){
            reversi.multi.Silnik.reset();
            Menu.okno.setVisible(false);
            Multi.okno.setLocation(Menu.okno.getLocation());
            Multi.okno.setVisible(true);
            Ustawienia.setMulti(true);
        }
        if(source == button3){
            Menu.okno.setVisible(false);
            Ustawienia.okno.setLocation(Menu.okno.getLocation());
            Ustawienia.okno.setVisible(true);
        }
        if(source == button4){
            System.exit(0);
        }
        
    }
}
