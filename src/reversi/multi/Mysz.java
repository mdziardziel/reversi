/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Mysz extends JComponent implements MouseListener{
    Mysz(){
        addMouseListener(this);
        setLocation(0, 0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = reversi.multi.Pionki.XToInt(e.getX());
        int y = reversi.multi.Pionki.YToInt(e.getY());
        //System.out.println(x + " " + y);
        //System.out.println(reversi.multi.Pionki.XToInt(x) + " " + reversi.multi.Pionki.YToInt(y));
        if(reversi.multi.Silnik.sprawdzRuch(x, y)) reversi.multi.Silnik.zmiana();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
