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
public class ZmianaWatek implements Runnable{

    @Override //nowy wątek dla zamiany, umożliwia animację zmiany pionków podczas oddaniu tury komputerowi
    public void run() {
        Silnik.zmiana();
    }
    
}
