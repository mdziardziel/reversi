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
        
        ruch = 1;
        przeciwnik = 2;
        
        Multi.okno.resetPionkow();
        Single.okno.resetPionkow();
        Timer.reset();
    }
    
    
    
    public static int ilePionkow(int p){
        int licznik = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(tabela[i][j] == p) licznik++;
            }
        }
        return licznik;
    }
    
    
    private static boolean zawiera(int p1, int p2, int pp){
        if(p1<=pp && pp<=p2)return true;
        if(p1>=pp && pp>=p2)return true;
        return false;
    }
    
    private static boolean zawieraSkos(int x1, int x2, int x3, int y1, int y2, int y3){
        while(x1!=x2 && y1!=y2){
            if(x1 == x3 && y1 == y3)return true;
            if(x1==x2 && y1==y2)return false;
            if(x1<x2)x1++;else x1--;
            if(y1<y2)y1++;else y1--;
        }
        return false;
    }
    
    private static void spij(int n){
        try{
            Thread.sleep(n);
        }catch(InterruptedException e){
            System.out.println("Nie udało się zasnąć");
        }    
    }
    
    public static void koloruj(int x, int y, int nx, int ny){
        //System.out.println(x + " "+ y + " "+ nx + " "+ ny);
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((x==nx || y==ny) && zawiera(x,nx,j) && zawiera(y,ny,i)) {
                    tabela[i][j] = ruch;
                    //System.out.println(j+ " " + i);
                }else if((x!=nx && y!=ny) && zawieraSkos(x,nx,j,y,ny,i)){
                    tabela[i][j] = ruch;
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
        reversi.multi.Single.okno.changeKolorRuch(ruch);
        reversi.multi.Single.okno.resetPionkow();
        Timer.changeStoper();
    }
    
    
    public static void koniecGry(){
        if(reversi.multi.Silnik.ilePionkow(0)==0 || 
                reversi.multi.Silnik.ilePionkow(1)==0 || 
                reversi.multi.Silnik.ilePionkow(2)==0){
            reversi.koniec.Koniec.okno.setLocation(Multi.okno.getLocation());
            reversi.koniec.Koniec.okno.zmienNapis();
            reversi.koniec.Koniec.okno.setVisible(true);
        } 
    }
    
    public static int ktoWygral(){
        if(ilePionkow(1)>ilePionkow(2))return 1;
        else if(ilePionkow(1)<ilePionkow(2)) return 2;
        else return 3;
    }
    
    
    public static boolean sprawdzRuch(int x, int y, boolean s){
        boolean ret = false;
        if(tabela[y][x] > 0 ) return false;
        
        //gora
        for(int i = y - 2; i >=0; i-- ){
            if(tabela[i+1][x]==0 || tabela[i+1][x]==ruch) break;
            if(tabela[i][x]== 0) break;
            if(tabela[i][x]== ruch){
                if(s)koloruj(x,y,x,i);
                ret = true;
                break;
            }
        }
        //dol
        for(int i = y + 2; i<8; i++ ){
            if(tabela[i-1][x]==0 || tabela[i-1][x]==ruch) break;
            if(tabela[i][x]== 0) break;
            if(tabela[i][x]== ruch){
                if(s)koloruj(x,y,x,i);
                ret = true;
                break;
            }
        }
        //prawo
        for(int i = x + 2; i<8; i++ ){
            if(tabela[y][i-1]==0 || tabela[y][i-1]==ruch) break;
            if(tabela[y][i]== 0) break;
            if(tabela[y][i]== ruch){
                if(s)koloruj(x,y,i,y);
                ret = true;
                break;
            }
        }
        //lewo
        for(int i = x - 2; i>=0; i-- ){
            if(tabela[y][i+1]==0 || tabela[y][i+1]==ruch) break;
            if(tabela[y][i]== 0) break;
            if(tabela[y][i]== ruch){
                if(s)koloruj(x,y,i,y);
                ret = true;
                break;
            }
        }
        
        //SKOSY
        int i = x, j = y;
        
        //lewo gora
        i= x -2; j= y - 2;
        while(i>=0 && j >=0){
            if(tabela[j+1][i+1]==0 || tabela[j+1][i+1]==ruch) break;
            if(tabela[j][i]== 0) break;
            if(tabela[j][i]== ruch){
                if(s)koloruj(x,y,i,j);
                ret = true;
                break;
            }
            i--;j--;
        }
        
        //lewo dol
        i = x -2; j = y + 2;
        while(i>=0 && j<8){
            if(tabela[j-1][i+1]==0 || tabela[j-1][i+1]==ruch) break;
            if(tabela[j][i]== 0) break;
            if(tabela[j][i]== ruch){
                if(s)koloruj(x,y,i,j);
                ret = true;
                break;
            }
            i--;j++;
        }
        
        //prawo gora
        i = x + 2; j = y - 2;
        while(i<8 && j >=0){
            if(tabela[j+1][i-1]==0 || tabela[j+1][i-1]==ruch) break;
            if(tabela[j][i]== 0) break;
            if(tabela[j][i]== ruch){
                if(s)koloruj(x,y,i,j);
                ret = true;
                break;
            }
            i++;j--;
        }
        
        //prawo dol
        i = x + 2; j = y + 2;
        while(i < 8 && j < 8){
            if(tabela[j-1][i-1]==0 || tabela[j-1][i-1]==ruch) break;
            if(tabela[j][i]== 0) break;
            if(tabela[j][i]== ruch){
                if(s)koloruj(x,y,i,j);
                ret = true;
                break;
            }
            i++;j++;
        }
        
        return ret;
    }
    
    
    
    public boolean jestRuch(){
        boolean bol = false;
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                bol = sprawdzRuch(j,i,false);
            }
        }
        return bol;
    }
    
    public static void ruchKomputera(){
        boolean z = false;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                z = sprawdzRuch(i,j,true);
                if(z==true) break;
            }
            if(z == true)break;
        }
        if(!z) zmiana();
    }
    
    
    public static int getRuch(){
        return ruch;
    }
    
    public static void setRuch(int x){
        ruch = x;
    }
    
    public static int getPrzeciwnik(){
        return przeciwnik;
    }
    
    public static void setPrzeciwnik(int x){
        przeciwnik = x;
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
