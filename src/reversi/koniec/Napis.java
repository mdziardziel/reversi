/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi.koniec;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import reversi.settings.Ustawienia;

/**
 *
 * @author michal
 * Klasa rozszerzająca klasę JPanel. Odpowida za tło i napis na tle
 */
public class Napis extends JPanel{
    private String text; // pole w którym będzie się znajdował tekst
    public Napis(String str){
        if(str!="")text = str; //dodajemy napis na tło, jeśli nie przekazaliśmy żadnego argumentu to wybieramy z napisaów po rozgrywce
        else
        if(reversi.multi.Silnik.ktoWygral() == 1 ) text = "Wygrał Gracz 1! Wygrał Gracz 1!Wygrał Gracz 1! Wygrał Gracz 1!";
        else if(reversi.multi.Silnik.ktoWygral() == 2 ) text = "Wygrał Gracz 2! Wygrał Gracz 2!Wygrał Gracz 2! Wygrał Gracz 2!";
        else if(reversi.multi.Silnik.ktoWygral() == 3 ) text = "Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!Remis!";
        else text = "Coś poszło nie tak!";

        setLayout(null);  
        for(int i = 0; i <= 10; i++){ // kilka napisów, żeby zajęły całe tło
            newLabel(i);
        }
        setBackground(Ustawienia.getKolorOkna()); //kolor panelu
        //add(label1);
        setLocation(0, 0); //lokacja panelu
        setSize(Ustawienia.getWidth(),Ustawienia.getHeight()); //rozmiar panelu
    }


    private void newLabel(int i){ //metoda dzięki której można łatwo stworzyć napisy
        JLabel x = new JLabel(text);
        x.setLocation(-i*50,  i*(Ustawienia.getHeight()/10+Ustawienia.getHeight()/60));
        x.setSize(Ustawienia.getWidth()*2,Ustawienia.getHeight()/10+Ustawienia.getHeight()/60);
        x.setFont(new Font("Serif", Font.BOLD, Ustawienia.getHeight()/10));
        add(x);
    }
    
}
