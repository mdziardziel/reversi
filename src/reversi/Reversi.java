/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;
import java.awt.Button;
import java.awt.Frame;
import reversi.koniec.Koniec;
import reversi.menu.Menu;
import reversi.settings.Ustawienia;
import reversi.multi.Multi;

/**
 *
 * @author michal
 */
public class Reversi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        Runnable timer = new reversi.multi.Timer();
        Thread watek1 = new Thread(timer);
        watek1.start();
        Menu.okno.setVisible(true);
        Ustawienia.okno.setVisible(false);
        Multi.okno.setVisible(false);
        Koniec.okno.setVisible(false);

    }
    
}
