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
public class Pionki extends JComponent{
    protected int jednostka;
    protected int poczatekX;
    protected int poczatekY;
    protected static int ile = 15;
    protected int rPionka;
    
    protected static int jeds;
    protected static int poXs;
    protected static int poYs;
    
    public Pionki(){
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        rPionka = (int)Math.floor(jednostka*0.8);
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        setLocation(0, 0);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight());  
        
        jeds = jednostka;
        poXs = poczatekX;
        poYs = poczatekY;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
        int tabela[][] = Silnik.getTabela();
        int q = -1;
        for(int i = poczatekY+jednostka*5+(jednostka-rPionka)/2; i< poczatekY+jednostka*13; i+=jednostka){
            q++;
            int z = -1;
            for(int j = poczatekX+jednostka*5+(jednostka-rPionka)/2; j< poczatekX+jednostka*13; j+=jednostka){
                z++;
                if(tabela[q][z] == 0) continue;
                else if(tabela[q][z] == 1){
                    g2d.setColor(reversi.settings.Ustawienia.getKolor1());
                    g2d.fillOval(j, i, rPionka, rPionka);
                    g2d.setColor(Color.BLACK);
                    g2d.drawOval(j, i, rPionka, rPionka);
                }else if(tabela[q][z] == 2){
                    g2d.setColor(reversi.settings.Ustawienia.getKolor2());
                    g2d.fillOval(j, i, rPionka, rPionka);
                    g2d.setColor(Color.BLACK);
                    g2d.drawOval(j, i, rPionka, rPionka);
                }else System.out.println("Zła wartość w tabeli"); 
            }
        }
        
    }
    
    public static int XToInt(int x){
        return (int)Math.floor(x/jeds);
    }
    public static int YToInt(int y){
        return (int)Math.floor(y/jeds);
    }
    
}
