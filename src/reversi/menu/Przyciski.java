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
 * klasa z panelem zawierającym przyciski
 */
public class Przyciski extends JComponent implements ActionListener{ //dziedziczy z klasy zawierjącej panel oraz implementuje klasę, która nasłuchuje
    private int numberOfButtons = 4; // liczba przycisków
    private int buttonWidth = (int)(Ustawienia.getWidth()/3); //szerokość przycisku
    private int buttonHeight = (int)(Ustawienia.getHeight()/(numberOfButtons*2 + 1));//wysokość
    private int buttonSpace = buttonHeight; // przestrzeń pomiędzy przyciskami
    private int buttonXLocation = (Ustawienia.getWidth()-buttonWidth)/2;//położenie środkowe przycisku
    private int buttonYLocation = buttonSpace; // górne położenie przysku
    private JButton button1= new JButton("1 gracz"); // buttony z ich nazwami
    private JButton button2 = new JButton("2 graczy");
    private JButton button3 = new JButton("opcje");
    private JButton button4 = new JButton("wyjście");
    
    public Przyciski() {
        setLocation(0,0); //lokacja panelu
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());//wielkość panelu 
        setLayout(null);
        addButton(button1,buttonXLocation,buttonYLocation,buttonWidth,buttonHeight); // dodaję przycisku
        addButton(button2,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth,buttonHeight);
        addButton(button3,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        addButton(button4,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*3,buttonWidth,buttonHeight);
    }
    
    @Override
    protected void paintComponent(Graphics g) { // rysuję panel pod przyciskami
	super.paintComponent(g);
	//Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(Ustawienia.getKolorOkna());
        g.fill3DRect(buttonXLocation - buttonHeight,buttonYLocation-buttonSpace/2,buttonWidth+buttonHeight*2,buttonHeight*(numberOfButtons)*2,true);
    }

    public void addButton(JButton button, int xL, int xY,int bW,int bH){//metoda ułatwiająca dodawanie przycisków
        button.setBounds(xL,xY,bW, bH);
        button.addActionListener(this);//nasłuchuję przycisk
        button.setBackground(reversi.settings.Ustawienia.getButtonKolor());
        add(button);//dodaję do panelu
    }
    
    @Override
    public void actionPerformed(ActionEvent e){ //metoda nasłuchująca kliknanie w przyciski
        Object source = e.getSource();
        
        if(source == button1){ // gra z komputerem -
            reversi.multi.Silnik.reset();//resetuemy planszę
            Menu.okno.setVisible(false); //zakrywamy menu
            Multi.okno.setLocation(Menu.okno.getLocation()); // ustawiamy lokację nowego okna
            Multi.okno.setVisible(true); //odkrywamy okno gry
            Ustawienia.setMulti(false); //ustawiamy tryb jako single player
        }
        if(source == button2){ //gra multiplayer
            reversi.multi.Silnik.reset();
            Menu.okno.setVisible(false);
            Multi.okno.setLocation(Menu.okno.getLocation());
            Multi.okno.setVisible(true);
            Ustawienia.setMulti(true); // ustawiamy grę jako multiplayer
        }
        if(source == button3){
            Menu.okno.setVisible(false);
            Ustawienia.okno.setLocation(Menu.okno.getLocation());
            Ustawienia.okno.setVisible(true); //odsłaniamy okno ustawiń
        }
        if(source == button4){
            System.exit(0); // wychodzimy z programu
        }
        
    }
}
