/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.settings;

/**
 *
 * @author michal
 * klasa zawierająca przyciski
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import reversi.menu.Menu;

 class Przyciski extends JComponent implements ActionListener{
    private final int numberOfButtons = 7; // liczba przycisków
    private final int buttonWidth = (int)(Ustawienia.getWidth()/3); // szerokość przycisku
    private final int buttonHeight = (int)(Ustawienia.getHeight()/(numberOfButtons*2 + 1)); //wysokość
    private final int buttonSpace = buttonHeight; //przestrzeń pomiędzy
    private final int buttonXLocation = (Ustawienia.getWidth()-buttonWidth)/2; // lokalizacja x przycisku
    private final int buttonYLocation = buttonSpace; //y
    private final JButton button1 = new JButton("Zmień rozmiar okna"); //przyciski
    private JButton button2 = new JButton("Wybierz kolory pionków");
    private JButton button3 = new JButton("cofnij");
    private JTextField field1 = new JTextField(Integer.toString(Ustawienia.getWidth())); //pola tesktowe do zmiany rozdzielczości
    private JTextField field2 = new JTextField(Integer.toString(Ustawienia.getHeight()));
    JRadioButton radio1 = new JRadioButton(); //przyciski radio do wyboru kolorów
    JRadioButton radio2 = new JRadioButton();
    JRadioButton radio3 = new JRadioButton();
    
    public Przyciski() {
        setLocation(0, buttonSpace);
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); 
        setLayout(null);   
        addButton(button1,buttonXLocation,buttonYLocation,buttonWidth,buttonHeight);//dodawanie przycisków
        addButton(button2,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        addButton(button3,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*5,buttonWidth,buttonHeight);
        
        addField(field1,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth/3,buttonHeight);//dodawanie pól tekstowych
        addField(field2,buttonXLocation+(buttonWidth/3)*2,buttonYLocation+(buttonSpace+buttonHeight),buttonWidth/3,buttonHeight);
        
        ButtonGroup group = new ButtonGroup();//grpuwanie przycisków radio, żeby był tylko jeden wciśnięty
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        
        //dodawanie radio
        addRadio(radio1,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*3,buttonHeight,buttonHeight);
        addRadio(radio2,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*3+buttonHeight,buttonHeight,buttonHeight);
        addRadio(radio3,buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*3+buttonHeight*2,buttonHeight,buttonHeight);
        setBackground(reversi.settings.Ustawienia.getKolorOkna());
        
        JRadioButton radio1 = new JRadioButton();
        
    }
    
    @Override //rysowanie panelu i kolorów pionków
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
        
        g.setColor(Ustawienia.getKolorOkna());
        g.fill3DRect(buttonXLocation - buttonHeight,buttonYLocation-buttonSpace,buttonWidth+buttonHeight*2,buttonHeight*(numberOfButtons-1)*2+buttonSpace,true);

        g.setColor(Ustawienia.getkolorU1());
        g.fill3DRect(buttonXLocation + buttonHeight,buttonYLocation+(buttonSpace+buttonHeight)*3,buttonHeight,buttonHeight,true);
        g.setColor(Ustawienia.getkolorU2());
        g.fill3DRect(buttonXLocation + buttonHeight*3,buttonYLocation+(buttonSpace+buttonHeight)*3,buttonHeight,buttonHeight,true);
        
        g.setColor(Ustawienia.getkolorU3());
        g.fill3DRect(buttonXLocation + buttonHeight,buttonYLocation+(buttonSpace+buttonHeight)*3+buttonHeight,buttonHeight,buttonHeight,true);
        g.setColor(Ustawienia.getkolorU4());
        g.fill3DRect(buttonXLocation + buttonHeight*3,buttonYLocation+(buttonSpace+buttonHeight)*3+buttonHeight,buttonHeight,buttonHeight,true);
        
        g.setColor(Ustawienia.getkolorU5());
        g.fill3DRect(buttonXLocation + buttonHeight,buttonYLocation+(buttonSpace+buttonHeight)*3+buttonHeight*2,buttonHeight,buttonHeight,true);
        g.setColor(Ustawienia.getkolorU6());
        g.fill3DRect(buttonXLocation + buttonHeight*3,buttonYLocation+(buttonSpace+buttonHeight)*3+buttonHeight*2,buttonHeight,buttonHeight,true);
        
        
    }
    
    
    
    

    public void addButton(JButton button, int xL, int xY,int bW,int bH){//metoda ułatwiająca tworzenie przycisków
        button.setBounds(xL,xY,bW, bH);
        button.addActionListener(this);
        button.setBackground(reversi.settings.Ustawienia.getButtonKolor());
        add(button);
    }
    
    public void addRadio(JRadioButton radio, int xL, int xY,int bW,int bH){ // metoda ułatwiająca tworzenie przycisków radio
        radio.setBounds(xL,xY,bW, bH);
        radio.setBackground(null);
        radio.addActionListener(this);
        add(radio);
    }
    
    public void changeBounds(){ // zmiana położenia
        button1.setBounds(buttonXLocation,buttonYLocation,buttonWidth,buttonHeight);
        button2.setBounds(buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*2,buttonWidth,buttonHeight);
        button3.setBounds(buttonXLocation,buttonYLocation+(buttonSpace+buttonHeight)*4,buttonWidth,buttonHeight);
        
    }
    
    public void addField(JTextField field, int xL, int xY,int bW,int bH){ // dodawanie pól tekstowych
        field.setBounds(xL,xY,bW, bH);
        add(field);
    }
    
   
    
    @Override
    public void actionPerformed(ActionEvent e){ // nasłuchiwanie przycisków
        Object source = e.getSource();
        
        if(source == button1){// zmiena rozdzielczości 
            int x = Integer.parseInt(field1.getText());//pobieram łańcuchy, konwertuję na inty
            int y = Integer.parseInt(field2.getText());
            if(x!= Ustawienia.getWidth() || y != Ustawienia.getHeight())
                Ustawienia.okno.setVisible(false); 
                Ustawienia.zmienRozmiarOkien(x, y);//metoda zmieniająca rozmiary okien
                Ustawienia.okno.setVisible(true);
        }
        if(source == button2){
            //nic nie robi, tylko wygląda
        }
        if(source == button3){//cofanie do menu
            Ustawienia.okno.setVisible(false);
            Menu.okno.setLocation(Ustawienia.okno.getLocation());
            Menu.okno.setVisible(true);
        }
        if(source == radio1){//wybor kolorów 
            Ustawienia.setkolor1(Ustawienia.getkolorU1());
            Ustawienia.setkolor2(Ustawienia.getkolorU2());
        }
        if(source == radio2){//wybrrór innych
            Ustawienia.setkolor1(Ustawienia.getkolorU3());
            Ustawienia.setkolor2(Ustawienia.getkolorU4());
        }
        if(source == radio3){//jeszcze innych
            Ustawienia.setkolor1(Ustawienia.getkolorU5());
            Ustawienia.setkolor2(Ustawienia.getkolorU6());
        }
        
    }
}
