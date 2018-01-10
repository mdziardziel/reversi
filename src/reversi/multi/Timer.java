/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;



/**
 *
 * @author michal
 * stoper wykonywany w osobnym wątku
 */
public class Timer implements Runnable{
    public static long startTime; //czas startu rozgrywki
    public static long time; //aktualny czas rozgrywki
    public static long sec; //czas w sekundach
    public static long mins;//w minutach
    public static long minsec;//reszta sekund z pełnych minut
    public static boolean stop = false; // czy zatrzymać zegar
    
    public static long timeS1; // minutnik gracza 1
    public static long timeS2; // minutnik gracza 1;
    public static long last; // pomoc przy obliczaniu czasu minutników


    public static boolean stoper1 = false; // czy minutnik 1 włączony
    public static boolean stoper2 = false; // czy minutnik 2 włączony
    

    
    public long getTime(){
        return time;
    }
    
    public Timer(){
        startTime = System.currentTimeMillis();
    }
    
    public static void reset(){ // resetujemy stoper i minutniki
        startTime = System.currentTimeMillis();
        stoper1 = false;
        stoper2 = false;
        timeS1 = 0;
        timeS2 = 0;
    }
    
    public static void setStoper(long s){ // ustawiamy minutniki na określony czas
        if(Silnik.getRuch()==1){
            stoper1 = true;
            stoper2 = false;
        }else{
            stoper1 = false;
            stoper2 = true;
        }      
        timeS1 = s*1000;
        timeS2 = s*1000;
        last = System.currentTimeMillis();
    }
    
    public static void changeStoper(){//włączenie jednego stopera i wyłączanie drugieo
        boolean pom = stoper1;
        stoper1 = stoper2;
        stoper2 = pom;
    }
    
    @Override
    public void run() { //nowy wątek
        while(true){
        time = System.currentTimeMillis()-startTime; // liczymy czas
        sec = time/1000;
        mins = sec/60;
        minsec = sec%60;
        
        if(stoper1) {//wysyłamy odpowiedni minutnik, który jest włączony
            timeS1 = timeS1 - (System.currentTimeMillis()-last); //odliczamy czas który minął od ostatniego takstu
        }
        if(stoper2) {
            timeS2 = timeS2 - (System.currentTimeMillis()-last);
        }
       
        if(Silnik.ilePionkow(0)!=0 && Silnik.ilePionkow(1)!=0 && Silnik.ilePionkow(2)!=0){//jeśli rozgrywka nie jest zakończona
            Multi.okno.setTimer((int)mins, (int)minsec); // to wysyłamy stoper
            if((stoper1 || stoper2) && (timeS1 >0 && timeS2 > 0)){ //jeśli minutniki są > 0 i któryś jest włączony to też je wysyłamy
                Multi.okno.setStoper1((int)timeS1/1000/60, (int)timeS1/1000%60);
                Multi.okno.setStoper2((int)timeS2/1000/60, (int)timeS2/1000%60);
            }
        }
         last = System.currentTimeMillis(); // ostatni czas = aktualny
        try{//usypiamy, na 10ms żeby nie obciążać procesora
            Thread.sleep(10);
        }catch(InterruptedException e){
            System.out.println("Nie udało się zasnąć");
        }
        reversi.multi.Multi.okno.resetPionkow(); // resetujemy pionki co takt, przydatne przy ich animacji zmiany
        }
    }
    
}
