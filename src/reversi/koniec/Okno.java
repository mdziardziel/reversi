/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 * Okno zakończenia rozgrywek
 */
public class Okno extends JFrame{
    private JComponent przyciski; //panel z przyciskami
    private JPanel napis; // panel z tłem
    public JLabel[] picLabel; // obrazki do animacji
    public Okno(){
        super("Reversi - Koniec gry");
        picLabel = new JLabel[Animacja.getIleO()]; 

        przyciski = new Przyciski();  // dodajemy do okna panel z przyciskami
        napis = new Napis(""); //tło z napisami
        
        setLayout(null);
        add(przyciski); 
        BufferedImage myPicture = null; //wczytujemy obrazek i w razie błędu wyłapujemy go
        try{
            myPicture = ImageIO.read(new File("coin.png"));
        }catch(IOException ee){
            System.out.println("Brak grafiki");
        }
        for(int i = 0; i < Animacja.getIleO(); i++){ // dodajemy obrazki do animacji
            picLabel[i] = new JLabel(new ImageIcon(myPicture));
            picLabel[i].setSize(Animacja.getWO(),Animacja.getHO());
            picLabel[i].setLocation(0,0);
            add(picLabel[i]);
        }

 
        add(napis);
            
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setBackground(reversi.settings.Ustawienia.getKolorOkna());
        setResizable(false);
        
        setVisible(false);
        repaint();
    }
    
//    public void changePanelBounds(){ // zmiana położenia przycisków
//        this.remove(przyciski);
//        this.repaint();
//        przyciski = new Przyciski();
//        this.add(przyciski);
//    }
    
    public void zmienNapis(){ // zmiana napisów w tle
        Koniec.okno = new Okno();
    }

    
}
