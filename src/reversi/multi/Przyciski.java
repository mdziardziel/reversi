/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 * klasa zawierająca przyciski
 */
public class Przyciski extends JComponent implements ActionListener{
   protected int jednostka;
   protected int poczatekX;
   protected int poczatekY;
   protected int ile = 15;
   protected JButton button1;
   protected JButton button2;
   protected JButton button3;
   protected JButton button4;
   protected JTextField timeField; // pole tekstowe pobierające ilość czasu do minutników
    
    public Przyciski() {
        if(Ustawienia.getWidth() < Ustawienia.getHeight()){
            jednostka = Ustawienia.getWidth()/(ile);
        }else{
            jednostka = Ustawienia.getHeight()/(ile);
        }
        poczatekX = (Ustawienia.getWidth()-jednostka*(ile))/2;
        poczatekY = (Ustawienia.getHeight()-jednostka*(ile))/2;
        setLocation(poczatekX+jednostka, poczatekY+jednostka*4);
        setSize(jednostka*2,jednostka*10); 
        setLayout(null);
        
        //tworzenie przycisków i nadawanie nazw
        button1= new JButton("Menu");
        button2 = new JButton("Poddaj ruch");
        button3 = new JButton("Od nowa");
        button4 = new JButton("Minutnik");
        timeField = new JTextField(); // pole tekstowe
        
        //nadawanie właściwości
        timeField.setBounds(0, jednostka*8, jednostka*2, jednostka/2);
        add(timeField);
        addButton(button1,0,jednostka,jednostka*2,jednostka);
        addButton(button2,0,jednostka*3,jednostka*2,jednostka);
        button2.setFont(new Font("", Font.BOLD, (int)jednostka/5));
        addButton(button3,0,jednostka*5,jednostka*2,jednostka);
        addButton(button4,0,jednostka*7,jednostka*2,jednostka);
            
    }
    

    public void addButton(JButton button, int xL, int xY,int bW,int bH){ // metoda ułatwiająca dodawanie przycisków
        button.setBounds(xL,xY,bW, bH);
        button.addActionListener(this);
        button.setBackground(reversi.settings.Ustawienia.getButtonKolor());
        add(button);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){ // nasłuchiwanie przycisków
        Object source = e.getSource();
        
        if(source == button1){ // powrót do menu
            Multi.okno.setVisible(false);
            reversi.menu.Menu.okno.setLocation(Multi.okno.getLocation());
            reversi.menu.Menu.okno.setVisible(true);
        }
        if(source == button2){ //oddanie ruchu przeciwnikowi
            Runnable run = new ZmianaWatek();
            Thread watek = new Thread(run);
            watek.start();
        }
        if(source == button3){
            Silnik.reset(); //gra od nowa
            Multi.okno.resetPionkow();            
        }
        if(source == button4){ // ustawienie minutników
            String text = timeField.getText();//pobieranie stringa z pola tekstowego
            int sec;
            try{
                sec = Integer.parseInt(text); //sprawdzamy czy można sparsować do inta, jeśli nie to łapiemy błąd
            }catch(NumberFormatException ex){
                System.out.println("Źle wpisana wartość");
                sec = 60*5; // jeśli będzie bład to ustawiamy domyślny czas 5 minut
            }
            if(sec<15)sec=sec*60; // jeśli ustaliliśmy czas mniejszy od 15, to program zakłada, że zostały podane minuty
            Timer.setStoper(sec); //ustawiamy minutniki na dny czas
        }
        
    }


}

