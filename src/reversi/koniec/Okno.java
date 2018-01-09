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
 */
public class Okno extends JFrame{
    private JComponent przyciski;
    private JPanel napis;
    public JComponent obraz = new Obraz();
    public JLabel[] picLabel = new JLabel[50];
    public Okno(){
        super("Reversi - Koniec gry");

        przyciski = new Przyciski(); 
        //animacja = new Animacja();
        napis = new Napis("");
        //setLayout(new FlowLayout(FlowLayout.CENTER));
        
        setLayout(null);
        //add(obraz);
        add(przyciski); 
        BufferedImage myPicture = null;
               try{
        myPicture = ImageIO.read(new File("coin.png"));
        }catch(IOException ee){
            System.out.println("Brak grafiki");
        }
        for(int i = 0; i < Animacja.getIleO(); i++){
            picLabel[i] = new JLabel(new ImageIcon(myPicture));
            picLabel[i].setSize(Animacja.getWO(),Animacja.getHO());
            picLabel[i].setLocation(0,0);
            add(picLabel[i]);
        }

        //add(obraz);
        //add(picLabel);
        
        add(napis);
        //add(animacja);
            
        
        //setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        setLocation(Ustawienia.getXLocation(), Ustawienia.getYLocation());
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setBackground(reversi.settings.Ustawienia.getKolorOkna());
        setResizable(false);
        
        setVisible(false);
        repaint();
    }
    
    public void changePanelBounds(){
        this.remove(przyciski);
        this.repaint();
        przyciski = new Przyciski();
        this.add(przyciski);
    }
    
    public void zmienNapis(){
        Koniec.okno = new Okno();
    }

    
}
