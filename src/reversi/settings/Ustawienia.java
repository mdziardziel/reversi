/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.settings;
import java.awt.Color;
import reversi.koniec.Koniec;
import reversi.menu.Menu;
import reversi.multi.Multi;
import reversi.multi.Single;

/**
 *
 * @author michal
 */
public class Ustawienia { 
    
    private static int xLocation = 200;
    private static int yLocation = 100;
    private static int width = 1000;
    private static int height = 800;
    private static Color kolor1 = new Color(18, 55,23);
    private static Color kolor2 = new Color(122, 55,155);
    private static Color kolorOkna = new Color(137,173,187);
    private static Color kolorCyfr = new Color(255,255,255);
    
    public static Okno okno = new Okno();

    
    public static Color getKolorOkna(){
        return kolorOkna;
    }
    public static Color getKolorCyfr(){
        return kolorCyfr;
    }
    public static Color getKolor1(){
        return kolor1;
    }
    
    public static Color getKolor2(){
        return kolor2;
    }
    
    public static int getXLocation(){
        return xLocation;
    }
    public static int getYLocation(){
        return yLocation;
    }
    public static int getWidth(){
        return width;
    }
    public static int getHeight(){
        return height;
    }
    
    public static void setXLocation(int x){
        xLocation = x;
    }
    public static void setYLocation(int x){
        yLocation = x;
    }
    public static void setWidth(int x){
        width = x;
    }
    public static void setHeight(int x){
        height = x;
    }
    
    public static void zmienRozmiarOkien(int x, int y){
        setWidth(x);
        setHeight(y);
        
        Multi.okno = new reversi.multi.Okno(true);
        Single.okno = new reversi.multi.Okno(false);
        
        Menu.okno.setSize(x, y);
        Menu.okno.changePanelBounds();
        Ustawienia.okno.setSize(x,y);
        Ustawienia.okno.changePanelBounds();
//        Multi.okno.setSize(x,y);
//        Multi.okno.changePanelBounds();
//        Single.okno.setSize(x,y);
//        Single.okno.changePanelBounds();
//        Koniec.okno.setSize(x,y);
//        Koniec.okno.changePanelBounds();
        //okno.removeAll();
        //okno.repaint();
    }

}
