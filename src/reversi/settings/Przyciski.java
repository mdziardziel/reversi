/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.settings;

/**
 *
 * @author michal
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import reversi.menu.Menu;

 class Przyciski extends JPanel implements ActionListener{
    private final int numberOfButtons = 5;
    private final int buttonWidth = (int)(Ustawienia.getWidth()/3);
    private final int buttonHeight = (int)(Ustawienia.getHeight()/(numberOfButtons*2 + 1));
    private final int buttonSpace = buttonHeight;
    private final int buttonXLocation = (Ustawienia.getWidth()-buttonWidth)/2;
    private final int buttonYLocation = buttonSpace;
    private final JButton button1 = new JButton("Zmień rozmiar okna");
    private JButton button2 = new JButton("Zmień początkowe położenie okna");
    private JButton button3 = new JButton("cofnij");
    private JTextField field1 = new JTextField(Integer.toString(Ustawienia.getWidth()));
    private JTextField field2 = new JTextField(Integer.toString(Ustawienia.getHeight()));
    private JTextField field3 = new JTextField(Integer.toString(Ustawienia.getXLocation()));
    private JTextField field4 = new JTextField(Integer.toString(Ustawienia.getYLocation()));
    
    public Przyciski() {
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setLayout(null);   
        addButton(button1,buttonXLocation,buttonYLocation,buttonWidth,buttonHeight);
        addButton(button2,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        addButton(button3,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*4,buttonWidth,buttonHeight);
        
        addField(field1,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth/3,buttonHeight);
        addField(field2,buttonXLocation+(buttonWidth/3)*2,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth/3,buttonHeight);
        
        addField(field3,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*3,buttonWidth/3,buttonHeight);
        addField(field4,buttonXLocation+(buttonWidth/3)*2,buttonYLocation+(buttonSpace+buttonHeight)*3,buttonWidth/3,buttonHeight);
        setBackground(reversi.settings.Ustawienia.getKolorOkna());
        
    }
    

    public void addButton(JButton button, int xL, int xY,int bW,int bH){
        button.setBounds(xL,xY,bW, bH);
        button.addActionListener(this);
        add(button);
    }
    
    public void changeBounds(){
        button1.setBounds(buttonXLocation,buttonYLocation,buttonWidth,buttonHeight);
        button2.setBounds(buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        button3.setBounds(buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*4,buttonWidth,buttonHeight);
        
    }
    
    public void addField(JTextField field, int xL, int xY,int bW,int bH){
        field.setBounds(xL,xY,bW, bH);
        add(field);
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source == button1){
            int x = Integer.parseInt(field1.getText());
            int y = Integer.parseInt(field2.getText());
            if(x!= Ustawienia.getWidth() || y != Ustawienia.getHeight())
                Ustawienia.zmienRozmiarOkien(x, y);
        }
        if(source == button2){
            setBackground(Color.YELLOW);
        }
        if(source == button3){
            Ustawienia.okno.setVisible(false);
            Menu.okno.setLocation(Ustawienia.okno.getLocation());
            Menu.okno.setVisible(true);
        }  
        
    }
}
