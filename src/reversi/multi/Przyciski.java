/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.multi;

import java.awt.Color;
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
 */
public class Przyciski extends JComponent implements ActionListener{
    private int jednostka;
    private int poczatekX;
    private int poczatekY;
    private int ile = 15;
    private final JButton button1= new JButton("Menu");
    private JButton button2 = new JButton("Poddaj ruch");
    private JButton button3 = new JButton("Od nowa");
    private JButton button4 = new JButton("Minutnik");
    private JTextField timeField = new JTextField();
    private boolean multi;
    
    public Przyciski(boolean m) {
        multi = m;
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
        //setBackground(Color.BLUE);
        
        timeField.setBounds(0, jednostka*8, jednostka*2, jednostka/2);
        add(timeField);
        addButton(button1,0,jednostka,jednostka*2,jednostka);
        addButton(button2,0,jednostka*3,jednostka*2,jednostka);
        button2.setFont(new Font("", Font.BOLD, (int)jednostka/5));
        addButton(button3,0,jednostka*5,jednostka*2,jednostka);
        addButton(button4,0,jednostka*7,jednostka*2,jednostka);
            
    }
    

    public void addButton(JButton button, int xL, int xY,int bW,int bH){
        button.setBounds(xL,xY,bW, bH);
        button.addActionListener(this);
        add(button);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        
        if(source == button1){
            Multi.okno.setVisible(false);
            reversi.menu.Menu.okno.setLocation(Multi.okno.getLocation());
            reversi.menu.Menu.okno.setVisible(true);
        }
        if(source == button2){
            Silnik.zmiana();
            if(!multi){
                Silnik.ruchKomputera();
                reversi.multi.Silnik.zmiana();
                Silnik.koniecGry();
            }
        }
        if(source == button3){
            Silnik.reset();
            Multi.okno.resetPionkow();
            Multi.okno.changeKolorRuch(Silnik.getRuch());              
        }
        if(source == button4){
            String text = timeField.getText();
            int sec;
            try{
                sec = Integer.parseInt(text);
            }catch(NumberFormatException ex){
                System.out.println("Źle wpisana wartość");
                sec = 60*5;
            }
            if(sec<30)sec=sec*60;
            Timer.setStoper(sec);
        }
        
    }


}

