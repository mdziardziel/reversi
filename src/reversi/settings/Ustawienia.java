/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.settings;

/**
 *
 * @author michal
 */
public class Ustawienia { 
    private static int xLocation = 100;
    private static int yLocation = 100;
    private static int width = 800;
    private static int height = 600;
    

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
    
    
}
