/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Obraz extends JComponent{
    private static long startTime;
    private BufferedImage myPicture;
    Obraz(){
        startTime = System.currentTimeMillis();
        setLocation(0,0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        //setBackground(reversi.settings.Ustawienia.getKolorOkna()); 
        
        try{
        myPicture = ImageIO.read(new File("coin.png"));
        }catch(IOException ee){
            System.out.println("Brak grafiki");
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setSize(300,300);
        picLabel.setLocation(20,20);
        //add(picLabel);
    }

}
