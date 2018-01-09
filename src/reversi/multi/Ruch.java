/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 */
public class Ruch extends JComponent{
    protected int ile = 15;
    protected int jednostka;
    protected int poczatekX;
    protected int poczatekY;
    protected Color kolorRamek = new Color(6,10,13);
    protected Color zmian = new Color(208,68,71);
    public Ruch(){
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        setLocation(poczatekX+jednostka*4, poczatekY);
        setSize(jednostka*10,jednostka);
           
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
        
	//Rectangle2D stol = new Rectangle2D.Double(poczatekX, poczatekY, ile*jednostka, ile*jednostka);
        g2d.setColor(zmian);
        if(Silnik.getRuch()==1){           
            g.fillRect(0, (int)(jednostka/2), 4*jednostka, (int)(jednostka/2));
            g.fill3DRect(jednostka*6, (int)(jednostka -jednostka/6), 4*jednostka, (int)(jednostka/6),true);
        }else{
            g.fill3DRect(0, (int)(jednostka - jednostka/6), 4*jednostka, (int)(jednostka/6),true);
            g.fill3DRect(jednostka*6, (int)(jednostka/2), 4*jednostka, (int)(jednostka/2),true);
        }
    }
}
