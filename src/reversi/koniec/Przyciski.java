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
 * klasa zawierająca przycisk cofania
 */
public class Przyciski extends JComponent implements ActionListener{
    private final int numberOfButtons = 4; //teoretyczna liczba przycisków (tak na prawdę chodzi o rozmiar przycisku - im więkza wartość tym mniejszy)
    private final int buttonWidth = (int)(Ustawienia.getWidth()/3); // szerokość przycisku
    private final int buttonHeight = (int)(Ustawienia.getHeight()/(numberOfButtons*2 + 1)); // wysokość
    private final int buttonSpace = buttonHeight; // przestrzeń pomiędzy przyciskami
    private final int buttonXLocation = (Ustawienia.getWidth()-buttonWidth)/2; //środkowa lokacja dla przycisku
    private final int buttonYLocation = buttonSpace; //pocątkowa górna lokacja
    private JButton button3 = new JButton("OK, cofnij"); // przycisk cofania
    
    public Przyciski() {
        setLocation(Ustawienia.getWidth()/2-buttonWidth/2, Ustawienia.getHeight()-Ustawienia.getHeight()/4); // lokacja panelu
        setSize(buttonWidth,buttonHeight); //rozmiar panelu
        setLayout(null);
        addButton(button3,0,0,buttonWidth,buttonHeight); // dodaję przycisk
        setBackground(reversi.settings.Ustawienia.getKolorOkna());       
    }
    

    public void addButton(JButton button, int xL, int xY,int bW,int bH){ //metoda ułatwiająca dodawanie przycisków
        button.setBounds(xL,xY,bW, bH);
        button.addActionListener(this); // dodaję nasłuchiwanie do przycisku
        button.setBackground(reversi.settings.Ustawienia.getButtonKolor());
        add(button);
    }
    
    @Override // metoda nasłuchująca czy przycisk został naciśnięty, jeśli tak to wykonujemy pewną akcję
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == button3){
            Animacja.setAnim(false); //wyłączam animację
            Koniec.okno.setVisible(false); //wyłączam widoczność okna informującego o zwycięzcy
        }
        
    }

}
