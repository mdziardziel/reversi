/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

/**
 *
 * @author michal
 */
public class Silnik {
    private static int[][] tabela = new int[8][8];
    private static int ruch = 1;
    private static int przeciwnik = 2;
    
    public static void reset(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tabela[i][j] = 0;
            }
        }
        tabela[3][4] = 1;
        tabela[3][3] = 2;
        tabela[4][4] = 2;
        tabela[4][3] = 1;
    }
    
    private static boolean zawiera(int p1, int p2, int pp){
        if(p1<=pp && pp<=p2)return true;
        if(p1>=pp && pp>=p2)return true;
        return false;
    }
    
    public static void koloruj(int x, int y, int nx, int ny){
        //System.out.println(x + " "+ y + " "+ nx + " "+ ny);
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(zawiera(x,nx,j) && zawiera(y,ny,i)) {
                    tabela[i][j] = ruch;
                    //System.out.println(j+ " " + i);
                }
            }
        }
    }
    
    public static void zmiana(){
        int pom = ruch;
        ruch = przeciwnik;
        przeciwnik = pom;
        reversi.multi.Multi.okno.changeKolorRuch(ruch);
        reversi.multi.Multi.okno.resetPionkow();
    }
    
    public static boolean sprawdzRuch(int x, int y){
        boolean ret = false;
        
        //gora
        for(int i = y - 2; i >=0; i-- ){
            if(tabela[i+1][x]==0 || tabela[i+1][x]==ruch) break;
            if(tabela[i][x]== 0) break;
            if(tabela[i][x]== ruch){
                koloruj(x,y,x,i+1);
                ret = true;
                break;
            }
        }
        //dol
        for(int i = y + 2; i<8; i++ ){
            if(tabela[i-1][x]==0 || tabela[i-1][x]==ruch) break;
            if(tabela[i][x]== 0) break;
            if(tabela[i][x]== ruch){
                koloruj(x,y,x,i-1);
                ret = true;
                break;
            }
        }
        //prawo
        for(int i = x + 2; i<8; i++ ){
            if(tabela[y][i-1]==0 || tabela[y][i-1]==ruch) break;
            if(tabela[y][i]== 0) break;
            if(tabela[y][i]== ruch){
                koloruj(x,y,i-1,y);
                ret = true;
                break;
            }
        }
        //lewo
        for(int i = x - 2; i>=0; i-- ){
            if(tabela[y][i+1]==0 || tabela[y][i+1]==ruch) break;
            if(tabela[y][i]== 0) break;
            if(tabela[y][i]== ruch){
                koloruj(x,y,i-1,y);
                ret = true;
                break;
            }
        }
        return ret;
    }
    
    public static int getRuch(){
        return ruch;
    }
    
    public static void setRuch(int x){
        ruch = x;
    }
    
    public static int[][] copyTabela(){
        int[][] copy = new int[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                copy[i][j] = tabela[i][j];
            }
        }
        return copy;
    }
    
    public static int[][] getTabela(){
        return copyTabela();
    }
    
}
