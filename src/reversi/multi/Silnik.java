/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import static reversi.multi.Timer.timeS1;
import static reversi.multi.Timer.timeS2;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 * serce całej gry, klasa z metodami liczącymi
 */
public class Silnik implements Runnable{
    protected static int[][] tabela = new int[8][8]; //tabela ze stanem pionków na planszy
    protected static int ruch = 1; // kto ma teraz ruch
    protected static int przeciwnik = 2; //kto ma ruch w następnej turze
    int xx,yy; //parametry zawierające numery kratek na planszy, potrzebne do odpalenia nowego wątku, pobirane w konstruktorze klasy
    boolean bb;
    Silnik(int xx, int yy, boolean bb){
        this.xx = xx;
        this.yy = yy;
        this.bb = bb;
    }
    public static void reset(){ // resetowanie stanu rozgrywki
        for(int i = 0; i < 8; i++){ //ustawianie pól na zero
            for(int j = 0; j < 8; j++){
                tabela[i][j] = 0;
            }
        }
        tabela[3][4] = 1; // ustawianie początkowych pionków na środku - po 2 dla każdego
        tabela[3][3] = 2;
        tabela[4][4] = 2;
        tabela[4][3] = 1;
        
        ruch = 1; // gracz z nr 1 będzie zaczynał
        przeciwnik = 2;
        
        Multi.okno.resetPionkow(); // resetuję widok pinonków na planszy
        Timer.reset(); // resetuję stoper
        Multi.okno.setStoper1(0, 0); //resetuję minutniki
        Multi.okno.setStoper2(0, 0);
    }
    
    
    
    public static int ilePionkow(int p){ // sprawdza ile jeszcze danych pionków znajduje się na planszy
        int licznik = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(tabela[i][j] == p) licznik++;
            }
        }
        return licznik;
    }
    
    
    protected static boolean zawiera(int p1, int p2, int pp){ // sprawdza czy dany pionek zawiera się między dwoma innymi w płaszczyznach x lub y
        if(p1<=pp && pp<=p2)return true;
        if(p1>=pp && pp>=p2)return true;
        return false;
    }
    
    protected static boolean zawieraSkos(int x1, int x2, int x3, int y1, int y2, int y3){ // sprawdza czy dany pionek zawiera się między pionkami po skosie
        while(x1!=x2 && y1!=y2){
            if(x1 == x3 && y1 == y3)return true;
            if(x1==x2 && y1==y2)return false;
            if(x1<x2)x1++;else x1--;
            if(y1<y2)y1++;else y1--;
        }
        return false;
    }
    
    protected static void spij(int n){ //usypia wątek na określony czas
        try{
            Thread.sleep(n);
        }catch(InterruptedException e){
            System.out.println("Nie udało się zasnąć");
        }    
    }
    
    public static void koloruj(int x, int y, int nx, int ny){ // koloruje pionki pomiędzy danymi pionkami na nowy kolor
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if((x==nx || y==ny) && zawiera(x,nx,j) && zawiera(y,ny,i)) { // to dla pionu/poziomu
                    spij(300); // dodatkowo usypia po każdym pokolorowaniu na 1/3 sekundy aby uzyskać widok animacji
                    tabela[i][j] = ruch;
                }else if((x!=nx && y!=ny) && zawieraSkos(x,nx,j,y,ny,i)){ // to dla skosów
                    spij(300);
                    tabela[i][j] = ruch;
                }
            }
        }
    }
    
    
    
    public static void zmiana(){ // zamienia graczy, teraz oczekujący może wykonać ruch
        Silnik.koniecGry(); // sprawdza czy spełniony jest warunek zakończenia rozgrywki
        int pom = ruch; // zamienia oczekującego na ruch z tym co ma ruch
        ruch = przeciwnik;
        przeciwnik = pom;
        reversi.multi.Multi.okno.resetPionkow(); // resetuje widok pionków
        Timer.changeStoper(); // stopuje minutnik temu co teraz oczekuje i włącza temu co ma ruch
        if(Ustawienia.getMulti()==false && ruch == 2) ruchKomputera(); // jeśli tryb single i ruch ma gracz 2, to rusza się komputer
    }
    
    
    public static void koniecGry(){ //wykrywa czy sełone są warunki końca gry
        if(ilePionkow(0)==0 || 
            ilePionkow(1)==0 || 
            ilePionkow(2)==0){//brak miejsca na planszy /jakiś pionków
            reversi.koniec.Koniec.okno.setLocation(Multi.okno.getLocation());
            reversi.koniec.Koniec.okno.zmienNapis(); //zmienia napis na wynik rozgrywki
            Runnable run = new reversi.koniec.Animacja(); //tworzy i włącza wątek dla animacji
            Thread watek = new Thread(run);
            reversi.koniec.Animacja.setAnim(true); // pozwala na działanie animacji
            watek.start();
            reversi.koniec.Koniec.okno.setVisible(true);
        } 
    }
    
    public static int ktoWygral(){ // metoda sprawdzjąca wynik rozgrywki
        if(ilePionkow(1)>ilePionkow(2))return 1;
        else if(ilePionkow(1)<ilePionkow(2)) return 2;
        else return 3; // jeśli jest na planszy tyle samo pionków to remis
    }
    
    
    public static boolean sprawdzRuch(int x, int y, boolean s){
        //sprawdza czy ruch jest możliwy w każdej płaszczyźnie, pion poziom i skosy
        //w zasadach jest tak, ze jeśli ruch jest możliwy w kilku płaszycznach na raz
        //to można zakolorować wszystkie pionki które się da, co też czynię
        //jeśli w żadnej pozycji ruch na dane pole nie jest możliwy
        //to początkowa wrtość ret false nie zmieni się na true
        // i metoda zwróci false, czyli, ze ten ruch jest nie możliwy
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
        
        if(ret)zmiana(); //jeśli ruch był możliwy to dokonujemy zmiany
        return ret;
    }
    
    
    
    public boolean jestRuch(){ // metoda nie wykorzystywana w tym programie, ale można nią sprawdzić czy jest jakikolwiek ruch możliwy
        boolean bol = false;   // i w razie gdyby był to zwróci true nie zmieniając układu na planszy
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                bol = sprawdzRuch(j,i,false);
            }
        }
        return bol;
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
    
    public static int[][] copyTabela(){ // metoda kopiująca głęboko tablicę
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
    
    public static void ruchKomputera(){ //symulowanie ruchu komputera - podstawowy algorytm, sprawdza od lewej góry pola i jeśli na jakimś jest możliwy ruch to go wykonuje
        spij(700);//symulacja czasu oczekiwania, żeby komputer nie wykonał ruchu w mgnieniu oka
        boolean z = false;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                z = sprawdzRuch(i,j,true);
                if(z==true) break;
            }
            if(z == true)break;
        }
        if(!z)zmiana();
    }

    @Override
    public void run() { // wszystkie obliczenia wykonywane w osobnym wątku
        sprawdzRuch(xx, yy, bb);
    }

}
