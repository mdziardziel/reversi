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
public class Timer implements Runnable{
    public static long startTime;
    public static long time;
    public static long sec;
    public static long mins;
    public static long minsec;
    public static boolean stop = false;
    
    public static long timeS1;
    public static long timeS2;
    public static long last;


    public static boolean stoper1 = false;
    public static boolean stoper2 = false;
    

    
    public long getTime(){
        return time;
    }
    
    public Timer(){
        startTime = System.currentTimeMillis();
    }
    
    public static void reset(){
        startTime = System.currentTimeMillis();
        stoper1 = false;
        stoper2 = false;
        timeS1 = 0;
        timeS2 = 0;
    }
    
    public static void setStoper(long s){
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
    
    public static void changeStoper(){
        boolean pom = stoper1;
        stoper1 = stoper2;
        stoper2 = pom;
    }
    
    @Override
    public void run() {
        while(true){
        time = System.currentTimeMillis()-startTime;
        sec = time/1000;
        mins = sec/60;
        minsec = sec%60;
        //System.out.println(mins+" "+minsec);
        
        if(stoper1) {
            timeS1 = timeS1 - (System.currentTimeMillis()-last);
        }
        if(stoper2) {
            timeS2 = timeS2 - (System.currentTimeMillis()-last);
        }
       
        if(Silnik.ilePionkow(0)!=0 && Silnik.ilePionkow(1)!=0 && Silnik.ilePionkow(2)!=0){
            Multi.okno.setTimer((int)mins, (int)minsec);
            if((stoper1 || stoper2) && (timeS1 >0 && timeS2 > 0)){
                Multi.okno.setStoper1((int)timeS1/1000/60, (int)timeS1/1000%60);
                Multi.okno.setStoper2((int)timeS2/1000/60, (int)timeS2/1000%60);
            }
        }
         last = System.currentTimeMillis();
        //System.out.println(minsS+" "+minsecS);
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            System.out.println("Nie udało się zasnąć");
        }
        reversi.multi.Multi.okno.resetPionkow();
        }
    }
    
}
