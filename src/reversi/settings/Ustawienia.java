/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.settings;
import java.awt.Color;
import reversi.menu.Menu;
import reversi.multi.Multi;

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
    private static Color kolorOkna = new Color(0, 255,155);
    
    public static Okno okno = new Okno();

    
    public static Color getKolorOkna(){
        return kolorOkna;
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
        Menu.okno.setSize(x, y);
        Menu.okno.changePanelBounds();
        Ustawienia.okno.setSize(x,y);
        Ustawienia.okno.changePanelBounds();
        Multi.okno.setSize(x,y);
        Multi.okno.changePanelBounds();
        //okno.removeAll();
        //okno.repaint();
    }

}
