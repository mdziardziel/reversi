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
 * klasa zawierająca ogólne ustawiania oraz statyczny obiekt okna ustawień
 */
public class Ustawienia{ 
    
    private static int xLocation = 200; // początkowa lokacja okna
    private static int yLocation = 100;
    private static int width = 1000; // początkowe wymiary okien
    private static int height = 800;
    private static Color kolor1 = new Color(45, 15, 191);//kolory pionków
    private static Color kolor2 = new Color(255, 205,0);
    
    private static Color kolorU1 = new Color(255, 24,0);//kolory pionków do wyboru
    private static Color kolorU2 = new Color(0, 205,45);
    private static Color kolorU3 = new Color(45, 15, 191);
    private static Color kolorU4 = new Color(255, 205,0);
    private static Color kolorU5 = new Color(0, 180,145);
    private static Color kolorU6 = new Color(255, 100,0);
    
    private static Color buttonKolor = new Color(255,226,138);//kolor przycisków
    
    private static Color kolorOkna = new Color(111,203,159);//kolor tła okien
    private static Color kolorCyfr = new Color(255,255,255);//kolor cyfr
    
    public static Okno okno = new Okno();//statyczny obiekt okna

    private static boolean multi; // zmienna która wyznacza czy gramy wtryb multi czy single
    
    public static boolean getMulti(){
        return multi;
    }
    public static void setMulti(boolean x){
        multi = x;
    }
    public static Color getButtonKolor(){
        return buttonKolor;
    }
    
    public static Color getkolorU1(){
        return kolorU1;
    }
    public static Color getkolorU2(){
        return kolorU2;
    }
    public static Color getkolorU3(){
        return kolorU3;
    }
    public static Color getkolorU4(){
        return kolorU4;
    }
    public static Color getkolorU5(){
        return kolorU5;
    }
    public static Color getkolorU6(){
        return kolorU6;
    }
    public static void setkolor1(Color color){
        kolor1 = color;
    }
    public static void setkolor2(Color color){
        kolor2 = color;
    }
    
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
    
    public static void zmienRozmiarOkien(int x, int y){//nadaje nowe wymiary okien i restartuje te już stworzone, zeby miary nowy rozmiar
        setWidth(x);
        setHeight(y);      
        Multi.okno = new reversi.multi.Okno();
        Menu.okno = new reversi.menu.Okno();
        okno = new Okno();

    }


}
