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
