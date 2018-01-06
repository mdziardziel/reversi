/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.settings;
import reversi.menu.Menu;

/**
 *
 * @author michal
 */
public class Ustawienia { 
    
    private static int xLocation = 600;
    private static int yLocation = 100;
    private static int width = 800;
    private static int height = 600;
    
    public static Okno okno = new Okno();

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
        Ustawienia.okno.setSize(x,y);
        okno.changeButtonBounds();
        okno.removeAll();
        okno.repaint();
    }

}
